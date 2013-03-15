/*
 *  geo-platform
 *  Rich webgis framework
 *  http://geo-platform.org
 * ====================================================================
 *
 * Copyright (C) 2008-2013 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
package org.geosdi.geoplatform.connector;

import java.math.BigInteger;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.bind.JAXBElement;
import org.geosdi.geoplatform.connector.server.request.CatalogGetRecordsRequest;
import org.geosdi.geoplatform.connector.server.security.BasicPreemptiveSecurityConnector;
import org.geosdi.geoplatform.xml.csw.ConstraintLanguage;
import org.geosdi.geoplatform.xml.csw.ConstraintLanguageVersion;
import org.geosdi.geoplatform.xml.csw.OutputSchema;
import org.geosdi.geoplatform.xml.csw.TypeName;
import org.geosdi.geoplatform.xml.csw.v202.*;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 * @author Vincenzo Monteverde <vincenzo.monteverde@geosdi.org>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-Test.xml"})
public class CatalogGetRecordsTest {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * geoSDI Catalog.
     */
    private @Value("configurator{geosdi_catalog_url}")
    String geosdiUrl;
    /**
     * SNIPC Catalog.
     */
    private @Value("configurator{snipc_catalog_url}")
    String snipcUrl;
    private @Value("configurator{snipc_catalog_username}")
    String snipcUsername;
    private @Value("configurator{snipc_catalog_password}")
    String snipcPassword;

    @Test
    public void testSummaryRecord() throws Exception {
        URL url = new URL(geosdiUrl);
        GPCatalogConnectorStore serverConnector = GPCSWConnectorBuilder.newConnector().withServerUrl(
                url).build();

        CatalogGetRecordsRequest<GetRecordsResponseType> request = serverConnector.createGetRecordsRequest();

        request.setTypeName(TypeName.METADATA);

        request.setOutputSchema(OutputSchema.CSW_V202);
        request.setElementSetName(ElementSetType.SUMMARY.toString());
        request.setResultType(ResultType.RESULTS.toString());

        request.setStartPosition(BigInteger.ONE);
        request.setMaxRecords(BigInteger.valueOf(25));

        GetRecordsResponseType response = request.getResponse();

        SearchResultsType result = response.getSearchResults();
        logger.info("RECORD MATCHES @@@@@@@@@@@@@@@@@@@@@ {}",
                result.getNumberOfRecordsMatched());
        logger.info("RECORDS FOUND @@@@@@@@@@@@@@@@@@@@@@ {}",
                result.getNumberOfRecordsReturned());
        logger.info("NEXT RECORD @@@@@@@@@@@@@@@@@@@@@@ {}",
                result.getNextRecord());

        List<JAXBElement<? extends AbstractRecordType>> metadata = result.getAbstractRecord();
        if (!metadata.isEmpty()) {
            logger.info("FIRST FULL METADATA @@@@@@@@@@@@@@@@@@@@@ {}",
                    (SummaryRecordType) (metadata.get(0).getValue()));
        }
    }

    @Test
    public void testFullRecord() throws Exception {
        URL url = new URL(geosdiUrl);
        GPCatalogConnectorStore serverConnector = GPCSWConnectorBuilder.newConnector().withServerUrl(
                url).build();

        CatalogGetRecordsRequest<GetRecordsResponseType> request = serverConnector.createGetRecordsRequest();

        request.setTypeName(TypeName.METADATA);

        request.setOutputSchema(OutputSchema.CSW_V202);
        request.setElementSetName(ElementSetType.FULL.toString());
        request.setResultType(ResultType.RESULTS.toString());

        request.setStartPosition(BigInteger.ONE);
        request.setMaxRecords(BigInteger.valueOf(25));

        GetRecordsResponseType response = request.getResponse();

        SearchResultsType result = response.getSearchResults();
        List<JAXBElement<? extends AbstractRecordType>> metadata = result.getAbstractRecord();

        Assert.assertEquals("The Result not contains 25 elements", 25,
                metadata.size());

        for (JAXBElement<? extends AbstractRecordType> element : metadata) {
            logger.info(
                    "FULL RECORD @@@@@@@@@@@@@@@@@@@@@@@@@ " + element.getValue());
        }
    }

    @Ignore("Catalog is down")
    @Test
    public void testCQLTemporalFilterGeomatys() throws Exception {
        URL url = new URL("http://demo.geomatys.com/mdweb-cnes-labs/WS/csw/default");
        GPCatalogConnectorStore serverConnector = GPCSWConnectorBuilder.newConnector().
                withServerUrl(url).build();

        CatalogGetRecordsRequest<GetRecordsResponseType> request = serverConnector.createGetRecordsRequest();

        request.setTypeName(TypeName.RECORD_V202);

        request.setConstraintLanguage(ConstraintLanguage.CQL_TEXT);
        request.setConstraintLanguageVersion(ConstraintLanguageVersion.V110);

        // Text filter
        StringBuilder str = new StringBuilder();
        str.append("AnyText LIKE '%%'");

        // Time filter
        Calendar startCalendar = new GregorianCalendar(2000, Calendar.JANUARY, 1);
        Calendar endCalendar = new GregorianCalendar(2012, Calendar.JANUARY, 1);

        SimpleDateFormat formatter = new SimpleDateFormat(
                "yyyy-MM-dd'T'HH:mm:ss'Z'");

        str.append(" AND ");
        str.append("TempExtent_begin AFTER ").append(
                formatter.format(startCalendar.getTime()));
        str.append(" AND ");
        str.append("TempExtent_end BEFORE ").append(
                formatter.format(endCalendar.getTime()));

        request.setConstraint(str.toString());
        logger.debug("\n@@@@@@@@@@@@@@@@ Geomatys ### Constraint: {}",
                request.getConstraint());

        GetRecordsResponseType response = request.getResponse();

        SearchResultsType searchResult = response.getSearchResults();

        logger.info("\n@@@@@@@@@@@@@@@@ Geomatys ### RECORD MATCHES {} ###",
                searchResult.getNumberOfRecordsMatched());
    }

    @Ignore("Require to add the SNIPC certificate into default keystore")
    @Test
    public void testSecureGetRecords() throws Exception {
        GPCatalogConnectorStore serverConnector = GPCSWConnectorBuilder.newConnector().withServerUrl(new URL(
                snipcUrl)).withClientSecurity(new BasicPreemptiveSecurityConnector(
                snipcUsername, snipcPassword)).build();

        CatalogGetRecordsRequest<GetRecordsResponseType> request = serverConnector.createGetRecordsRequest();

        request.setTypeName(TypeName.RECORD_V202);

        request.setOutputSchema(OutputSchema.CSW_V202);
        request.setElementSetName(ElementSetType.FULL.toString());
        request.setResultType(ResultType.RESULTS.toString());

        request.setStartPosition(BigInteger.ONE);
        request.setMaxRecords(BigInteger.valueOf(25));

        GetRecordsResponseType response = request.getResponse();

        SearchResultsType result = response.getSearchResults();
        logger.info("RECORD MATCHES @@@@@@@@@@@@@@@@@@@@@ {}",
                result.getNumberOfRecordsMatched());
        logger.info("RECORDS FOUND @@@@@@@@@@@@@@@@@@@@@@ {}",
                result.getNumberOfRecordsReturned());
        logger.info("NEXT RECORD @@@@@@@@@@@@@@@@@@@@@@ {}",
                result.getNextRecord());

        List<JAXBElement<? extends AbstractRecordType>> metadata = result.getAbstractRecord();

        if (!metadata.isEmpty()) {
            logger.info("FIRST SECURE METADATA @@@@@@@@@@@@@@@@@@@@@ {}",
                    (RecordType) (metadata.get(0).getValue()));
        }
    }
}
