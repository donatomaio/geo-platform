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
package org.geosdi.geoplatform.experimental.el.api.mapper;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.geosdi.geoplatform.experimental.el.api.model.Document;
import org.geosdi.geoplatform.support.jackson.JacksonSupport;
import org.geosdi.geoplatform.support.jackson.mapper.GPBaseJacksonMapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.xml.bind.annotation.XmlRootElement;

import static javax.annotation.meta.When.NEVER;
import static org.springframework.core.annotation.AnnotationUtils.findAnnotation;

/**
 * @param <D>
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public abstract class GPBaseMapper<D extends Document> extends GPBaseJacksonMapper<D> implements GPElasticSearchMapper<D> {

    private final String jsonRootName;

    /**
     * @param theDocumentClass
     * @param theReader
     */
    protected GPBaseMapper(@Nonnull(when = NEVER) Class<D> theDocumentClass, @Nullable JacksonSupport theReader) {
        super(theDocumentClass, theReader);
        this.jsonRootName = findJsonRootName();
    }

    @Override
    public String getDocumentClassName() {
        return this.entityClass.getSimpleName();
    }

    /**
     * @return {@link String}
     */
    @Override
    public String getJsonRootName() {
        return this.jsonRootName;
    }

    /**
     * @return {@link String}
     */
    protected String findJsonRootName() {
        XmlRootElement xmlRootElement = findAnnotation(this.entityClass, XmlRootElement.class);
        if ((xmlRootElement != null) && !(xmlRootElement.name().trim().isEmpty())) {
            return xmlRootElement.name().concat(".");
        }
        JsonRootName jsonRootName = findAnnotation(this.entityClass, JsonRootName.class);
        if ((jsonRootName != null) && !(jsonRootName.value().trim().isEmpty())) {
            return jsonRootName.value().concat(".");
        }
        return "";
    }
}