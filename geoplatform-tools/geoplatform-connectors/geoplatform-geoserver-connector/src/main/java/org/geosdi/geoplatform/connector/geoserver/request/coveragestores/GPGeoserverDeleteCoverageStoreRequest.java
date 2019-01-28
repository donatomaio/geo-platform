package org.geosdi.geoplatform.connector.geoserver.request.coveragestores;

import com.google.common.io.CharStreams;
import net.jcip.annotations.ThreadSafe;
import org.geosdi.geoplatform.connector.geoserver.model.store.coverage.GPGeoserverPurgeParam;
import org.geosdi.geoplatform.connector.server.GPServerConnector;
import org.geosdi.geoplatform.connector.server.request.json.GPJsonDeleteConnectorRequest;
import org.geosdi.geoplatform.support.jackson.JacksonSupport;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.BufferedReader;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.lang.ThreadLocal.withInitial;
import static javax.annotation.meta.When.NEVER;
import static org.geosdi.geoplatform.connector.geoserver.model.store.coverage.GPGeoserverPurgeParam.NONE;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@ThreadSafe
public class GPGeoserverDeleteCoverageStoreRequest extends GPJsonDeleteConnectorRequest<Boolean> implements GeoserverDeleteCoverageStoreRequest {

    private final ThreadLocal<String> workspace;
    private final ThreadLocal<String> coverageStore;
    private final ThreadLocal<GPGeoserverPurgeParam> purge;
    private final ThreadLocal<Boolean> recurse;

    /**
     * @param theServerConnector
     * @param theJacksonSupport
     */
    public GPGeoserverDeleteCoverageStoreRequest(@Nonnull(when = NEVER) GPServerConnector theServerConnector, @Nonnull(when = NEVER) JacksonSupport theJacksonSupport) {
        super(theServerConnector, theJacksonSupport);
        this.workspace = withInitial(() -> null);
        this.coverageStore = withInitial(() -> null);
        this.purge = withInitial(() -> NONE);
        this.recurse = withInitial(() -> FALSE);
    }

    /**
     * @param theWorkspace The name of the worskpace containing the coverage stores.
     * @return {@link GeoserverDeleteCoverageStoreRequest}
     */
    @Override
    public GeoserverDeleteCoverageStoreRequest withWorkspace(@Nonnull(when = NEVER) String theWorkspace) {
        this.workspace.set(theWorkspace);
        return this;
    }

    /**
     * @param theCoverageStore The name of the store to be retrieved.
     * @return {@link GeoserverDeleteCoverageStoreRequest}
     */
    @Override
    public GeoserverDeleteCoverageStoreRequest withCoverageStore(@Nonnull(when = NEVER) String theCoverageStore) {
        this.coverageStore.set(theCoverageStore);
        return this;
    }

    /**
     * <p>
     * The purge parameter specifies if and how the underlying raster data source is deleted.
     * Allowable values for this parameter are {@link GPGeoserverPurgeParam#NONE}, {@link GPGeoserverPurgeParam#METADATA},
     * {@link GPGeoserverPurgeParam#ALL}. When set to {@link GPGeoserverPurgeParam#NONE}
     * data and auxiliary files are preserved. When set to {@link GPGeoserverPurgeParam#METADATA} delete only auxiliary files and metadata.
     * It’s recommended when data files (such as granules) should not be deleted from disk.
     * Finally, when set to {@link GPGeoserverPurgeParam#ALL} both data and auxiliary files are removed.
     * </p>
     *
     * @param thePurge
     * @return {@link GeoserverDeleteCoverageStoreRequest}
     */
    @Override
    public <Purge extends GPGeoserverPurgeParam> GeoserverDeleteCoverageStoreRequest withPurge(Purge thePurge) {
        this.purge.set((thePurge != null) ? thePurge : NONE);
        return this;
    }

    /**
     * <p>
     * The recurse controls recursive deletion. When set to true all resources contained in the store are also removed.
     * The default value is {@link Boolean#FALSE}.
     * </p>
     *
     * @param theRecurse
     * @return {@link GeoserverDeleteCoverageStoreRequest}
     */
    @Override
    public GeoserverDeleteCoverageStoreRequest withRecurse(@Nullable Boolean theRecurse) {
        this.recurse.set((theRecurse != null) ? theRecurse : FALSE);
        return this;
    }

    /**
     * @return {@link String}
     */
    @Override
    protected String createUriPath() throws Exception {
        String workspace = this.workspace.get();
        checkArgument((workspace != null) && !(workspace.trim().isEmpty()), "The Parameter workspace mut not be null or an Empty String.");
        String coverageStore = this.coverageStore.get();
        checkArgument((coverageStore != null) && !(coverageStore.trim().isEmpty()), "The Parameter coverageStore mut not be null or an Empty String.");
        GPGeoserverPurgeParam purgeParam = this.purge.get();
        String recurse = this.recurse.get().toString();
        String baseURI = this.serverURI.toString();
        return ((baseURI.endsWith("/") ? baseURI.concat("workspaces/").concat(workspace).concat("/coveragestores/")
                .concat(coverageStore).concat("?purge=").concat(purgeParam.toPurge()).concat("&recurse=").concat(recurse)
                : baseURI.concat("/workspaces/").concat(workspace).concat("/coveragestores/").concat(coverageStore)
                .concat("?purge=").concat(purgeParam.toPurge()).concat("&recurse=").concat(recurse)));
    }

    /**
     * @param reader
     * @return {@link Boolean}
     * @throws Exception
     */
    @Override
    protected Boolean readInternal(BufferedReader reader) throws Exception {
        String value = CharStreams.toString(reader);
        return ((value != null) && (value.trim().isEmpty()) ? TRUE : FALSE);
    }

    /**
     * @return {@link Class<Boolean>}
     */
    @Override
    protected Class<Boolean> forClass() {
        return Boolean.class;
    }
}