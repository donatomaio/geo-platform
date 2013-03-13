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
package org.geosdi.geoplatform.gui.client.widget;

import org.geosdi.geoplatform.gui.client.widget.form.GPMapPreviewWidget;
import org.geosdi.geoplatform.gui.configuration.map.client.GPCoordinateReferenceSystem;
import org.geosdi.geoplatform.gui.factory.baselayer.GPBaseLayerFactory;
import org.geosdi.geoplatform.gui.global.enumeration.BaseLayerValue;
import org.gwtopenmaps.openlayers.client.Bounds;
import org.gwtopenmaps.openlayers.client.MapOptions;
import org.gwtopenmaps.openlayers.client.MapUnits;
import org.gwtopenmaps.openlayers.client.Projection;

/**
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group
 * @email nazzareno.sileno@geosdi.org
 */
public class PreviewWidget extends GPMapPreviewWidget {

    private final static int NUM_ZOOM_LEVEL = 30;

    @Override
    public MapOptions createMapPreviewOption() {
        MapOptions defaultMapOptions = new MapOptions();
        defaultMapOptions.setNumZoomLevels(NUM_ZOOM_LEVEL);
        defaultMapOptions.setDisplayProjection(new Projection(GPCoordinateReferenceSystem.WGS_84.getCode()));
        super.baseLayer = GPBaseLayerFactory.getBaseLayer(BaseLayerValue.OFFLINE_BASE_LAYER);
        if (super.baseLayer.getProjection().getProjectionCode().equals(GPCoordinateReferenceSystem.WGS_84.getCode())) {
            set4326MapOptions(defaultMapOptions);
        } else {
            set3857MapOptions(defaultMapOptions);
        }
//        MapOptions defaultMapOptions = new MapOptions();
//        defaultMapOptions.setNumZoomLevels(18);
//        defaultMapOptions.setProjection(GPCoordinateReferenceSystem.GOOGLE_MERCATOR.getCode());
//        defaultMapOptions.setDisplayProjection(new Projection(GPCoordinateReferenceSystem.WGS_84.getCode()));
//        defaultMapOptions.setUnits(MapUnits.METERS);
//        defaultMapOptions.setMaxExtent(new Bounds(-20037508, -20037508,
//                20037508, 20037508.34));
//        defaultMapOptions.setMaxResolution(new Double(156543.0339).floatValue());
        return defaultMapOptions;
    }

    @Override
    public void createBaseLayer() {
        super.baseLayer = GPBaseLayerFactory.getBaseLayer(
                BaseLayerValue.OFFLINE_BASE_LAYER);
        super.mapWidget.getMap().addLayer(baseLayer);
    }

    private void set4326MapOptions(MapOptions defaultMapOptions) {
        defaultMapOptions.setUnits(MapUnits.DEGREES);
        defaultMapOptions.setMaxExtent(new Bounds(-180, -90,
                180, 83.623));
        defaultMapOptions.setMaxResolution(1.40625F);
    }

    private void set3857MapOptions(MapOptions defaultMapOptions) {
        defaultMapOptions.setUnits(MapUnits.METERS);
        defaultMapOptions.setMaxExtent(new Bounds(-20037508, -20037508,
                20037508, 20037508.34));
        defaultMapOptions.setMaxResolution(156543.0339F);
    }
}
