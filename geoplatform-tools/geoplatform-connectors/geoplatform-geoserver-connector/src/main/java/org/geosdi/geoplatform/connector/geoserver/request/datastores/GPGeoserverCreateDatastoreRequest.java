/**
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2019 geoSDI Group (CNR IMAA - Potenza - ITALY).
 *
 *   This program is free software: you can redistribute it and/or modify it
 *   under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version. This program is distributed in the
 *   hope that it will be useful, but WITHOUT ANY WARRANTY; without
 *   even the implied warranty of MERCHANTABILITY or FITNESS FOR
 *   A PARTICULAR PURPOSE. See the GNU General Public License
 *   for more details. You should have received a copy of the GNU General
 *   Public License along with this program. If not, see http://www.gnu.org/licenses/
 *
 *   ====================================================================
 *
 *   Linking this library statically or dynamically with other modules is
 *   making a combined work based on this library. Thus, the terms and
 *   conditions of the GNU General Public License cover the whole combination.
 *
 *   As a special exception, the copyright holders of this library give you permission
 *   to link this library with independent modules to produce an executable, regardless
 *   of the license terms of these independent modules, and to copy and distribute
 *   the resulting executable under terms of your choice, provided that you also meet,
 *   for each linked independent module, the terms and conditions of the license of
 *   that module. An independent module is a module which is not derived from or
 *   based on this library. If you modify this library, you may extend this exception
 *   to your version of the library, but you are not obligated to do so. If you do not
 *   wish to do so, delete this exception statement from your version.
 */
package org.geosdi.geoplatform.connector.geoserver.request.datastores;

import net.jcip.annotations.ThreadSafe;
import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.geosdi.geoplatform.connector.geoserver.model.datastores.GPGeoserverCreateDatastoreResponse;
import org.geosdi.geoplatform.connector.geoserver.model.datastores.IGPGeoserverCreateDatastoreBody;
import org.geosdi.geoplatform.connector.geoserver.model.datastores.IGPGeoserverCreateDatastoreResponse;
import org.geosdi.geoplatform.connector.server.GPServerConnector;
import org.geosdi.geoplatform.connector.server.request.json.GPJsonPostConnectorRequest;
import org.geosdi.geoplatform.support.jackson.JacksonSupport;

import javax.annotation.Nonnull;
import java.io.BufferedReader;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.ThreadLocal.withInitial;
import static java.util.stream.Collectors.joining;
import static javax.annotation.meta.When.NEVER;
import static org.apache.http.entity.ContentType.APPLICATION_JSON;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
@ThreadSafe
public class GPGeoserverCreateDatastoreRequest extends GPJsonPostConnectorRequest<IGPGeoserverCreateDatastoreResponse> implements GeoserverCreateDatastoreRequest {

    private final ThreadLocal<String> workspaceName;
    private final ThreadLocal<IGPGeoserverCreateDatastoreBody> datastoreBody;

    /**
     * @param theServerConnector
     * @param theJacksonSupport
     */
    public GPGeoserverCreateDatastoreRequest(@Nonnull(when = NEVER) GPServerConnector theServerConnector, @Nonnull(when = NEVER) JacksonSupport theJacksonSupport) {
        super(theServerConnector, theJacksonSupport);
        this.workspaceName = withInitial(() -> null);
        this.datastoreBody = withInitial(() -> null);
    }


    /**
     * @param theWorkspaceName
     */
    @Override
    public GeoserverCreateDatastoreRequest withWorkspaceName(@Nonnull(when = NEVER) String theWorkspaceName) {
        this.workspaceName.set(theWorkspaceName);
        return this;
    }


    /**
     * @param theDatastoreBody
     */
    @Override
    public GeoserverCreateDatastoreRequest withDatastoreBody(@Nonnull(when = NEVER) IGPGeoserverCreateDatastoreBody theDatastoreBody) {
        this.datastoreBody.set(theDatastoreBody);
        return this;
    }

    /**
     * @return {@link HttpEntity}
     */
    @Override
    protected HttpEntity prepareHttpEntity() throws Exception {
        IGPGeoserverCreateDatastoreBody datastoreBody = this.datastoreBody.get();
        checkArgument(datastoreBody != null, "The datastoreBody must not be null.");
        String datastoreBodyString = jacksonSupport.getDefaultMapper().writeValueAsString(datastoreBody);
        logger.debug("#############################DATASTORE_BODY : \n{}\n", datastoreBodyString);
        return new StringEntity(datastoreBodyString, APPLICATION_JSON);
    }

    /**
     * @param reader
     * @return {@link IGPGeoserverCreateDatastoreResponse}
     * @throws Exception
     */
    @Override
    protected IGPGeoserverCreateDatastoreResponse readInternal(BufferedReader reader) throws Exception {
        return GPGeoserverCreateDatastoreResponse.builder()
                .datastoreName(reader.lines().collect(joining()))
                .build();
    }

    /**
     * @return {@link String}
     */
    @Override
    protected String createUriPath() throws Exception {
        String workspaceName = this.workspaceName.get();
        checkArgument((workspaceName != null) && !(workspaceName.trim().isEmpty()),
                "The Parameter workspaceName must not be null or an empty string.");
        String baseURI = this.serverURI.toString();
        return ((baseURI.endsWith("/") ? baseURI.concat("workspaces/").concat(workspaceName).concat("/datastores")
                : baseURI.concat("/workspaces/").concat(workspaceName).concat("/datastores")));
    }

    /**
     * @return {@link Class<IGPGeoserverCreateDatastoreResponse>}
     */
    @Override
    protected Class<IGPGeoserverCreateDatastoreResponse> forClass() {
        return IGPGeoserverCreateDatastoreResponse.class;
    }
}