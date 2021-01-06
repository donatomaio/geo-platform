/**
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2021 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
package org.geosdi.geoplatform.gml.api.jaxb.context;

import org.geosdi.geoplatform.gml.api.AbstractGeometry;
import org.geosdi.geoplatform.gml.api.PropertyType;
import org.geosdi.geoplatform.gml.api.parser.base.geometry.sextante.GMLBaseSextanteParser;
import org.geosdi.geoplatform.gml.api.parser.base.parameter.GMLBaseParametersRepo;
import org.geosdi.geoplatform.gml.api.parser.exception.ParserException;
import org.locationtech.jts.geom.Geometry;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBIntrospector;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public abstract class AbstractGMLUnmarshaller implements GMLUnmarshaller {

    protected GMLBaseSextanteParser sextanteParser = GMLBaseParametersRepo.getDefaultSextanteParser();

    /**
     * @param element
     * @return {@link Geometry}
     * @throws ParserException
     */
    protected Geometry parseElement(Object element) throws ParserException {
        Object value = JAXBIntrospector.getValue(element);

        if (value instanceof PropertyType) {
            return sextanteParser.parseGeometry((PropertyType) value);
        } else if (value instanceof AbstractGeometry) {
            return sextanteParser.parseGeometry((AbstractGeometry) value);
        }
        throw new ParserException("The Object must be an instance of PropertyType or AbstractGeometry Class.");
    }

    /**
     * @param element
     * @param type
     * @param <T>
     * @return {@link JAXBElement<T>}
     * @throws ParserException
     */
    protected <T> JAXBElement<T> parseElement(Object element, Class<T> type) throws ParserException {
        checkNotNull(element, "The Object Element must not be null.");
        if (element instanceof JAXBElement) {
            Geometry geom = parseElement(element);
            if (type.isAssignableFrom(geom.getClass())) {
                T value = (T) geom;
                return new JAXBElement<T>(((JAXBElement<?>) element).getName(),
                        type, value);
            } else {
                throw new ParserException("Geometry class " + geom.getClass().getName()
                        + " not match " + type.getName());
            }
        } else {
            throw new ParserException("The Object element is not an instance"
                    + " of JAXBElement class");
        }
    }
}
