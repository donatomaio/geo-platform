//<editor-fold defaultstate="collapsed" desc="License">
/*
 *  geo-platform
 *  Rich webgis framework
 *  http://geo-plartform.org
 * ====================================================================
 *
 * Copyright (C) 2008-2011 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
//</editor-fold>
package org.geosdi.geoplatform;

import java.util.Iterator;
import junit.framework.Assert;
import org.geosdi.geoplatform.core.model.GPFolder;
import org.geosdi.geoplatform.core.model.GPLayerType;
import org.geosdi.geoplatform.core.model.GPRasterLayer;
import org.geosdi.geoplatform.core.model.GPVectorLayer;
import org.geosdi.geoplatform.exception.IllegalParameterFault;
import org.geosdi.geoplatform.exception.ResourceNotFoundFault;
import org.geosdi.geoplatform.request.RequestById;
import org.geosdi.geoplatform.request.SearchRequest;
import org.geosdi.geoplatform.responce.FolderDTO;
import org.geosdi.geoplatform.responce.ShortLayerDTO;
import org.geosdi.geoplatform.responce.collection.FolderList;
import org.geosdi.geoplatform.responce.collection.LayerList;
import org.geosdi.geoplatform.responce.collection.TreeFolderElements;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email  giuseppe.lascaleia@geosdi.org
 */
public class WSFolderLayerTest extends ServiceTest {

    // Folder
    private final String nameFolder1 = "folder1";
    private GPFolder folder1 = null;
    private long idFolder1 = -1;
    private final String nameFolder2 = "folder2";
    private GPFolder folder2 = null;
    private long idFolder2 = -1;
    private final String nameFolder3 = "folder3";
    private GPFolder folder3 = null;
    private long idFolder3 = -1;
    private final String nameFolder4 = "folder4";
    private GPFolder folder4 = null;
    private long idFolder4 = -1;
    private final String nameFolder5 = "folder5";
    private GPFolder folder5 = null;
    private long idFolder5 = -1;
    
    
    private final String urlServer = "http://www.geosdi.org/test";
    private final String spatialReferenceSystem = "Geographic coordinate system";
    
    // Raster Layer 1
    private final String abstractTextRasterLayer1 = "abstractTextRasterLayer1";
    private final String nameRasterLayer1 = "rasterLayer1";
    private final String titleRasterLayer1 = "Raster Layer 1";
    private GPRasterLayer rasterLayer1 = null;
    private long idRasterLayer1 = -1;
    
    // Vector Layer 1
    private final String abstractTextVectorLayer1 = "abstractTextVectorLayer1";
    private final String nameVectorLayer1 = "vectorLayer1";
    private final String titleVectorLayer1 = "Vector Layer 1";
    private GPVectorLayer vectorLayer1 = null;
    private long idVectorLayer1 = -1;
    
    // Raster Layer 2
    private final String abstractTextRasterLayer2 = "abstractTextRasterLayer2";
    private final String nameRasterLayer2 = "rasterLayer2";
    private final String titleRasterLayer2 = "Raster Layer 2";
    private GPRasterLayer rasterLayer2 = null;
    private long idRasterLayer2 = -1;
    
    // Vector Layer 2
    private final String abstractTextVectorLayer2 = "abstractTextVectorLayer2";
    private final String nameVectorLayer2 = "vectorLayer2";
    private final String titleVectorLayer2 = "Vector Layer 2";
    private GPVectorLayer vectorLayer2 = null;
    private long idVectorLayer2 = -1;

    @Before
    // "position" will be set without application logic, but only to have different values
    public void setUp() throws Exception {
        super.setUp();
        logger.info("WSFolderLayerTest - SetUp --------------------------------> " + this.getClass().getName());

        findUser = geoPlatformService.getUserDetailByName(new SearchRequest(username));

        // "rootFolderA" ---> "rasterLayer1"
        idRasterLayer1 = createAndInsertRasterLayer(abstractTextRasterLayer1, rootFolderA, nameRasterLayer1, 3, false, spatialReferenceSystem,
                                                    titleRasterLayer1, urlServer);

        // "rootFolderA" ---> "vectorLayer1"
        idVectorLayer1 = createAndInsertVectorLayer(abstractTextVectorLayer1, rootFolderA, nameVectorLayer1, 4, false, spatialReferenceSystem,
                                                    titleVectorLayer1, urlServer);

        // "rootFolderB" ---> "rasterLayer2"
        idRasterLayer2 = createAndInsertRasterLayer(abstractTextRasterLayer2, rootFolderB, nameRasterLayer2, 3, false, spatialReferenceSystem,
                                                    titleRasterLayer2, urlServer);

        // "rootFolderB" ---> "vectorLayer2"
        idVectorLayer2 = createAndInsertVectorLayer(abstractTextVectorLayer2, rootFolderB, nameVectorLayer2, 4, false, spatialReferenceSystem,
                                                    titleVectorLayer2, urlServer);
    }

    @Test
    public void testGetLayer() {
        try {
            ShortLayerDTO shortRasterLayer1 = geoPlatformService.getShortLayer(idRasterLayer1);
            Assert.assertNotNull("assertNotNull shortRasterLayer1",shortRasterLayer1);
            Assert.assertEquals("assertEquals shortRasterLayer1.getName()",shortRasterLayer1.getName(),nameRasterLayer1);
            Assert.assertEquals("assertEquals shortRasterLayer1.getPosition()",shortRasterLayer1.getPosition(),3);
            Assert.assertEquals("assertEquals shortRasterLayer1.getSrs()",shortRasterLayer1.getSrs(),spatialReferenceSystem);
            Assert.assertEquals("assertEquals shortRasterLayer1.getUrlServer()",shortRasterLayer1.getUrlServer(),urlServer);
            Assert.assertEquals("assertEquals shortRasterLayer1.getLayerType()",shortRasterLayer1.getLayerType(),GPLayerType.RASTER);
            
            ShortLayerDTO shortVectorLayer1 = geoPlatformService.getShortLayer(idVectorLayer1);
            Assert.assertNotNull("assertNotNull shortVectorLayer1",shortVectorLayer1);
            Assert.assertEquals("assertEquals shortVectorLayer1.getName()",shortVectorLayer1.getName(),nameVectorLayer1);
            Assert.assertEquals("assertEquals shortVectorLayer1.getPosition()",shortVectorLayer1.getPosition(),4);
            Assert.assertEquals("assertEquals shortVectorLayer1.getSrs()",shortVectorLayer1.getSrs(),spatialReferenceSystem);
            Assert.assertEquals("assertEquals shortVectorLayer1.getUrlServer()",shortVectorLayer1.getUrlServer(),urlServer);
            Assert.assertEquals("assertEquals shortVectorLayer1.getLayerType()",shortVectorLayer1.getLayerType(),GPLayerType.POLYGON);
        } catch (ResourceNotFoundFault ex) {
            logger.info("\n***** Layer with id \"" + idRasterLayer1 + "\" not found");
        }
    }

    @Test
    public void testDeleteLayer() {
        FolderDTO folderToCheck = null;
        ShortLayerDTO layerToCheck = null;
        try {
            // Assert total number of folders stored into DB before delete
            LayerList allLayersBeforeDelete = geoPlatformService.getLayers();
            Assert.assertEquals("assertEquals allLayersBeforeDelete.getList().size()",allLayersBeforeDelete.getList().size(), 260);
            
            // Delete "rasterLayer1" from "rootFolderA"
            geoPlatformService.deleteLayer(new RequestById(idRasterLayer1));

            // Get root folders for user
            FolderList folderList = geoPlatformService.getUserFoldersByUserId(idUser);

            // Assert on the structure of user's folders
            Assert.assertEquals("assertEquals folderList.getList().size()",folderList.getList().size(), 2);

            // Assert on the structure of the subfolders of "rootFolderA"
            TreeFolderElements childrenRootFolderA = geoPlatformService.getChildrenElements(idRootFolderA);
            logger.info("\n************************ childrenRootFolderA:\n" + childrenRootFolderA + "\n*****");
            Assert.assertNotNull("assertNotNull childrenRootFolderA",childrenRootFolderA);
            Assert.assertEquals("assertEquals childrenRootFolderA.size()",childrenRootFolderA.size(), 1);
            ShortLayerDTO shortVectorLayerRootFolderA = (ShortLayerDTO)childrenRootFolderA.iterator().next();
            Assert.assertEquals("assertEquals shortVectorLayerRootFolderA.getName()",shortVectorLayerRootFolderA.getName(), nameVectorLayer1);
            
            // Assert on "rootFolderB" (deleted)
            TreeFolderElements childrenRootFolderB = geoPlatformService.getChildrenElements(idRootFolderB);
            Assert.assertNotNull("assertNotNull childrenRootFolderB",childrenRootFolderB);
            Assert.assertEquals("assertEquals childrenRootFolderB.size()",childrenRootFolderB.size(), 2);
            
            Iterator iterator = childrenRootFolderB.iterator();
            ShortLayerDTO shortRasterLayerRootFolderB = (ShortLayerDTO)iterator.next();
            Assert.assertEquals("assertEquals shortRasterLayerRootFolderB.getName()",shortRasterLayerRootFolderB.getName(), nameVectorLayer2);
            ShortLayerDTO shortVectorLayerRootFolderB = (ShortLayerDTO)iterator.next();
            Assert.assertEquals("assertEquals shortVectorLayerRootFolderB.getName()",shortVectorLayerRootFolderB.getName(), nameRasterLayer2);

            // Assert total number of layers stored into DB after delete
            LayerList allLayersAfterDelete = geoPlatformService.getLayers();
            Assert.assertEquals("assertEquals allLayersAfterDelete.getList().size()",allLayersAfterDelete.getList().size(), 259);
        } catch (IllegalParameterFault ipf) {
            Assert.fail("Folder has an illegal parameter");
        } catch (ResourceNotFoundFault rnff) {
            Assert.fail("Folder with id \"" + idRootFolderB + "\" not found");
        } catch (Exception e) {
            Assert.fail("Exception: " + e.getClass());
        }

        // Check ON DELETE CASCADE of the subforders of "rootFolderB"
        checkLayerDeleted(idRasterLayer1);
    }

    // Check if a folder was eliminated
    private void checkLayerDeleted(long idLayer) {
        try {
            RequestById request = new RequestById(idLayer);
            ShortLayerDTO layer = geoPlatformService.getShortLayer(idLayer);
            Assert.fail("Layer with id \"" + idLayer + "\" was NOT deleted");
        } catch (Exception e) {
            logger.info("\n***** Layer with id \"" + idLayer + "\" was deleted");
        }
    }
    
//    @Test
//    public void testGetFolderAndLayer() {
//    }
}
