/*
 *  geo-platform
 *  Rich webgis framework
 *  http://geo-platform.org
 * ====================================================================
 *
 * Copyright (C) 2008-2012 geoSDI Group (CNR IMAA - Potenza - ITALY).
 *
 * This program is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or 
 * (at your option) any later version. This program is distributed in the 
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without 
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR 
 * A PARTICULAR PURPOSE. See the GNU General Public License 
 * for more details. You should have received a copy of the GNU General 
 * Public License along with this program. If not, see http://www.gnu.org/licenses/ 
 *
 * ====================================================================
 *
 * Linking this library statically or dynamically with other modules is 
 * making a combined work based on this library. Thus, the terms and 
 * conditions of the GNU General Public License cover the whole combination. 
 * 
 * As a special exception, the copyright holders of this library give you permission 
 * to link this library with independent modules to produce an executable, regardless 
 * of the license terms of these independent modules, and to copy and distribute 
 * the resulting executable under terms of your choice, provided that you also meet, 
 * for each linked independent module, the terms and conditions of the license of 
 * that module. An independent module is a module which is not derived from or 
 * based on this library. If you modify this library, you may extend this exception 
 * to your version of the library, but you are not obligated to do so. If you do not 
 * wish to do so, delete this exception statement from your version. 
 *
 */
package org.geosdi.geoplatform.connector.wfs;

import java.math.BigInteger;
import javax.xml.namespace.QName;
import junit.framework.Assert;
import org.geosdi.geoplatform.configurator.category.WFSTest;
import org.geosdi.geoplatform.connector.server.request.WFSGetFeatureRequest;
import org.geosdi.geoplatform.xml.gml.v311.FeatureArrayPropertyType;
import org.geosdi.geoplatform.xml.wfs.v110.FeatureCollectionType;
import org.geosdi.geoplatform.xml.wfs.v110.ResultTypeType;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

/**
 *
 * @author Vincenzo Monteverde <vincenzo.monteverde@geosdi.org>
 */
@Category(WFSTest.class)
public class WFSGetFeatureTest extends WFSTestConfigurator {

    private QName statesName = new QName("topp:states");

    @Test
    public void statesHits() throws Exception {
        WFSGetFeatureRequest<FeatureCollectionType> request =
                super.serverConnector.createGetFeatureRequest();

        request.setResultType(ResultTypeType.HITS.value());
        request.setTypeName(statesName);

        FeatureCollectionType response = request.getResponse();
        Assert.assertEquals(49, response.getNumberOfFeatures().intValue());
    }

//    @Ignore("WFS")
    @Test
    public void statesResults() throws Exception {
        WFSGetFeatureRequest<FeatureCollectionType> request =
                super.serverConnector.createGetFeatureRequest();

        request.setResultType(ResultTypeType.RESULTS.value());
        request.setTypeName(statesName);
        request.setMaxFeatures(BigInteger.ONE);

        logger.info("RESPONSE @@@@@@@@@@@@@@@@@@@@@@@@@@@@@ {}",
                    request.getResponseAsString());

        FeatureCollectionType response = request.getResponse();
        logger.info("xxxxxxxxxxx {}", response.getNumberOfFeatures());
        logger.info("xxxxxxxxxxx {}", response.getTimeStamp());

        FeatureArrayPropertyType featureMembers = response.getFeatureMembers();
        logger.info("----------- {}", featureMembers.isSetFeature());
        logger.info("----------- {}", featureMembers.getFeature());
        logger.info("----------- {}", featureMembers.getFeature().size());
        logger.info("+++++++++++ {}", response.getFeatureMember());
        logger.info("+++++++++++ {}", response.getFeatureMember().size());
    }
}
