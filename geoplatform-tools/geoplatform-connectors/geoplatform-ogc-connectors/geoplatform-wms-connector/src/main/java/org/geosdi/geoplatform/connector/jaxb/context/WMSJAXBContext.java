package org.geosdi.geoplatform.connector.jaxb.context;

import lombok.Getter;
import org.geosdi.geoplatform.connector.WMSVersion;
import org.geosdi.geoplatform.jaxb.GeoPlatformJAXBContext;
import org.geosdi.geoplatform.jaxb.provider.GeoPlatformJAXBContextProvider;
import org.geosdi.geoplatform.jaxb.repository.GeoPlatformJAXBContextRepository.GeoPlatformJAXBContextKey;

import javax.annotation.Nonnull;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;
import static javax.annotation.meta.When.NEVER;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class WMSJAXBContext extends GeoPlatformJAXBContext {

    @Getter
    private final WMSVersion version;

    /**
     * <p/>
     * Create a new instance of a <tt>GeoPlatformJAXBContext</tt> class.
     *
     * @param contextPath
     * @throws JAXBException if an error was encountered while creating the
     *                       <tt>JAXBContext</tt> such as
     *                       <ol>
     *                       <li>failure to locate either ObjectFactory.class or jaxb.index in the packages</li>
     *                       <li>an ambiguity among global elements contained in the contextPath</li>
     *                       <li>failure to locate a value for the context factory provider property</li>
     *                       <li>mixing schema derived packages from different providers on the same contextPath</li>
     *                       </ol>
     */
    public WMSJAXBContext(String contextPath, @Nonnull(when = NEVER) WMSVersion theVersion) throws JAXBException {
        super(contextPath);
        checkArgument(theVersion != null, "The Parameter version must not be null.");
        this.version = theVersion;
    }

    /**
     * <p>
     * Obtain a new instance of a <tt>GeoPlatformJAXBContext</tt> class.
     * <p/>
     * </p>
     * The context path which is a list of  colon (':', \u005Cu003A) separated
     * java package names that contain schema-derived classes and/or fully
     * qualified JAXB-annotated classes.
     *
     * @param contextPath
     * @param classLoader
     * @throws JAXBException if an error was encountered while creating the
     *                       <tt>JAXBContext</tt> such as
     *                       <ol>
     *                       <li>failure to locate either ObjectFactory.class or jaxb.index in the packages</li>
     *                       <li>an ambiguity among global elements contained in the contextPath</li>
     *                       <li>failure to locate a value for the context factory provider property</li>
     *                       <li>mixing schema derived packages from different providers on the same contextPath</li>
     *                       </ol>
     */
    public WMSJAXBContext(String contextPath, ClassLoader classLoader, @Nonnull(when = NEVER) WMSVersion theVersion) throws JAXBException {
        super(contextPath, classLoader);
        checkArgument(theVersion != null, "The Parameter version must not be null.");
        this.version = theVersion;
    }

    /**
     * <p/>
     * Obtain a new instance of a <tt>GeoPlatformJAXBContext</tt> class.
     * <p/>
     * <p/>
     *
     * @param contextPath list of java package names that contain schema derived classes
     * @param classLoader This class loader will be used to locate the implementation classes.
     * @param properties  provider-specific properties. Can be null, which means the same thing as passing
     *                    in an empty map.
     * @throws JAXBException if an error was encountered while creating the
     *                       <tt>JAXBContext</tt> such as
     *                       <ol>
     *                       <li>failure to locate either ObjectFactory.class or jaxb.index in the packages</li>
     *                       <li>an ambiguity among global elements contained in the contextPath</li>
     *                       <li>failure to locate a value for the context factory provider property</li>
     *                       <li>mixing schema derived packages from different providers on the same contextPath</li>
     *                       </ol>
     */
    public WMSJAXBContext(String contextPath, ClassLoader classLoader, Map<String, ?> properties, @Nonnull(when = NEVER) WMSVersion theVersion) throws JAXBException {
        super(contextPath, classLoader, properties);
        checkArgument(theVersion != null, "The Parameter version must not be null.");
        this.version = theVersion;
    }

    /**
     * @param classToBeBound list of java classes to be recognized by the new {@link JAXBContext}.
     *                       Can be empty, in which case a {@link JAXBContext} that only knows about
     *                       spec-defined classes will be returned.
     * @throws JAXBException            if an error was encountered while creating the
     *                                  <tt>JAXBContext</tt>, such as (but not limited to):
     *                                  <ol>
     *                                  <li>No JAXB implementation was discovered</li>
     *                                  <li>Classes use JAXB annotations incorrectly</li>
     *                                  <li>Classes have colliding annotations (i.e., two classes with the same type name)</li>
     *                                  <li>The JAXB implementation was unable to locate
     *                                  provider-specific out-of-band information (such as additional
     *                                  files generated at the development time.)</li>
     *                                  </ol>
     * @throws IllegalArgumentException if the parameter contains {@code null} (i.e., {@code GeoPlatformJAXBContext(null);})
     */
    public WMSJAXBContext(@Nonnull(when = NEVER) WMSVersion theVersion, Class... classToBeBound) throws JAXBException {
        super(classToBeBound);
        checkArgument(theVersion != null, "The Parameter version must not be null.");
        this.version = theVersion;
    }

    /**
     * @param theJaxbContext
     */
    public WMSJAXBContext(JAXBContext theJaxbContext, @Nonnull(when = NEVER) WMSVersion theVersion) {
        super(theJaxbContext);
        checkArgument(theVersion != null, "The Parameter version must not be null.");
        this.version = theVersion;
    }

    /**
     * @return {@link Marshaller}
     * @throws Exception
     */
    @Override
    public Marshaller acquireMarshaller() throws Exception {
        return super.createMarshaller();
    }

    /**
     * @return {@link Unmarshaller}
     * @throws Exception
     */
    @Override
    public Unmarshaller acquireUnmarshaller() throws Exception {
        return super.createUnmarshaller();
    }

    public static class WMSJAXBContextKey extends GeoPlatformJAXBContextKey {

        /**
         * @param thejaxbContextClass
         */
        public WMSJAXBContextKey(@Nonnull(when = NEVER) Class<? extends GeoPlatformJAXBContextProvider> thejaxbContextClass) {
            super(thejaxbContextClass);
        }

        @Override
        public boolean isCompatibleValue(Object o) {
            return o instanceof WMSJAXBContext;
        }
    }
}