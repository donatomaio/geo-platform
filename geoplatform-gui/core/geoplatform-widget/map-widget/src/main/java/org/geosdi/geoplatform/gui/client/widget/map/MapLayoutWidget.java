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
package org.geosdi.geoplatform.gui.client.widget.map;

import com.extjs.gxt.ui.client.Registry;
import com.extjs.gxt.ui.client.widget.Info;
import com.google.common.collect.Lists;
import com.google.gwt.user.client.Timer;
import org.geosdi.geoplatform.gui.client.event.IChangeBaseLayerHandler;
import org.geosdi.geoplatform.gui.client.widget.MapToolbar;
import org.geosdi.geoplatform.gui.client.widget.baselayer.factory.GPMapBaseLayerFactory;
import org.geosdi.geoplatform.gui.client.widget.baselayer.model.GPBaseLayer;
import org.geosdi.geoplatform.gui.client.widget.map.control.history.NavigationHistoryControl;
import org.geosdi.geoplatform.gui.client.widget.map.routing.GPRoutingManagerWidget;
import org.geosdi.geoplatform.gui.client.widget.scale.GPScaleWidget;
import org.geosdi.geoplatform.gui.client.widget.viewport.ViewportUtility;
import org.geosdi.geoplatform.gui.configuration.map.client.GPClientViewport;
import org.geosdi.geoplatform.gui.configuration.map.client.GPCoordinateReferenceSystem;
import org.geosdi.geoplatform.gui.configuration.map.client.geometry.BBoxClientInfo;
import org.geosdi.geoplatform.gui.configuration.map.puregwt.MapHandlerManager;
import org.geosdi.geoplatform.gui.configuration.message.GeoPlatformMessage;
import org.geosdi.geoplatform.gui.configuration.users.options.member.UserSessionEnum;
import org.geosdi.geoplatform.gui.factory.map.GPApplicationMap;
import org.geosdi.geoplatform.gui.global.enumeration.BaseLayerValue;
import org.geosdi.geoplatform.gui.global.security.IGPAccountDetail;
import org.geosdi.geoplatform.gui.impl.map.GeoPlatformMap;
import org.geosdi.geoplatform.gui.impl.map.event.ChangeBaseLayerMapEvent;
import org.geosdi.geoplatform.gui.impl.view.LayoutManager;
import org.geosdi.geoplatform.gui.puregwt.GPHandlerManager;
import org.geosdi.geoplatform.gui.puregwt.featureinfo.event.FeatureInfoAddModifyLayer;
import org.geosdi.geoplatform.gui.puregwt.featureinfo.event.FeatureInfoRemoveLayer;
import org.geosdi.geoplatform.gui.puregwt.featureinfo.event.GPFeatureInfoEvent;
import org.gwtopenmaps.openlayers.client.*;
import org.gwtopenmaps.openlayers.client.control.*;
import org.gwtopenmaps.openlayers.client.event.MapLayerAddedListener;
import org.gwtopenmaps.openlayers.client.event.MapLayerAddedListener.MapLayerAddedEvent;
import org.gwtopenmaps.openlayers.client.event.MapLayerChangedListener;
import org.gwtopenmaps.openlayers.client.event.MapLayerChangedListener.MapLayerChangedEvent;
import org.gwtopenmaps.openlayers.client.event.MapLayerRemovedListener;
import org.gwtopenmaps.openlayers.client.event.MapLayerRemovedListener.MapLayerRemovedEvent;
import org.gwtopenmaps.openlayers.client.event.MeasureEvent;
import org.gwtopenmaps.openlayers.client.event.MeasureListener;
import org.gwtopenmaps.openlayers.client.feature.VectorFeature;
import org.gwtopenmaps.openlayers.client.handler.PathHandler;
import org.gwtopenmaps.openlayers.client.handler.PolygonHandler;
import org.gwtopenmaps.openlayers.client.layer.Layer;

/**
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 *
 */
public class MapLayoutWidget implements GeoPlatformMap, IChangeBaseLayerHandler {

    public final static int NUM_ZOOM_LEVEL = 30;
    private MapWidget mapWidget;
    private MapOptions mapOptions;
    private MapControlManager mapControl;
    private Map map;
    private GPRoutingManagerWidget routingWidget;
    private MapModel mapModel;
    private MapToolbar buttonBar;
    private Measure measure;
    private Measure measureArea;
    private boolean infoActive;
    private boolean measureActive;
    private boolean measureAreaActive;
    private ChangeBaseLayerMapEvent changeBaseLayerMapEvent;
    private MapLayerAddedListener featureInfoLayerAddedListener;
    private MapLayerChangedListener featureInfoLayerChangedListener;
    private MapLayerRemovedListener featureInfoLayerRemovedListener;

    public MapLayoutWidget() {
        super();
        GPApplicationMap.getInstance().setApplicationMap(this);
        this.setBaseMapOptions();
        this.initMapWidget();
        this.mapModel = new MapModel(this);
        this.routingWidget = new GPRoutingManagerWidget(this);
        this.mapModel.addLayerChangedHandler();
        MapHandlerManager.addHandler(IChangeBaseLayerHandler.TYPE, this);
    }

    private void setBaseMapOptions() {
        this.mapOptions = new MapOptions();
        this.mapOptions.setNumZoomLevels(MapLayoutWidget.NUM_ZOOM_LEVEL);
        this.mapOptions.setDisplayProjection(new Projection(GPCoordinateReferenceSystem.WGS_84.getCode()));
        IGPAccountDetail accountDetail = Registry.get(UserSessionEnum.ACCOUNT_DETAIL_IN_SESSION.name());
        String baseLayerKey = accountDetail.getBaseLayer();
        GPBaseLayer baseLayer;
        if (baseLayerKey != null) {
            baseLayer = GPMapBaseLayerFactory.getGPBaseLayer(BaseLayerValue.valueOf(baseLayerKey));
        } else {
            baseLayer = GPMapBaseLayerFactory.getGPBaseLayer(BaseLayerValue.OFFLINE_BASE_LAYER);
            accountDetail.setBaseLayer(baseLayer.getBaseLayerEnumName().toString());
//            Registry.register(GlobalRegistryEnum.BASE_LAYER.getValue(), baseLayer.getBaseLayerEnumName().toString());
        }
        if (baseLayer.getProjection().getProjectionCode().equals(GPCoordinateReferenceSystem.WGS_84.getCode())) {
            set4326MapOptions();
        } else {
            set3857MapOptions();

        }

    }

    private void set4326MapOptions() {
        this.mapOptions.setUnits(MapUnits.DEGREES);
        this.mapOptions.setMaxExtent(new Bounds(-180, -90,
                180, 83.623));
        this.mapOptions.setMaxResolution(1.40625F);
    }

    private void set3857MapOptions() {
        this.mapOptions.setUnits(MapUnits.METERS);
        this.mapOptions.setMaxExtent(new Bounds(-20037508, -20037508,
                20037508, 20037508.34));
        this.mapOptions.setMaxResolution(156543.0339F);
    }

    private void initMapWidget() {
        this.mapWidget = new MapWidget("100%", "100%", mapOptions);
        this.map = mapWidget.getMap();
        this.mapWidget.getElement().getFirstChildElement().getStyle().setZIndex(0);
        this.map.addControl(new ScaleLine());
        this.map.addControl(new MousePosition());
        this.addMeasureControl();
        this.addMeasureAreaControl();
        IGPAccountDetail accountDetail = Registry.get(UserSessionEnum.ACCOUNT_DETAIL_IN_SESSION.name());
        String baseLayerKey = accountDetail.getBaseLayer();
        GPBaseLayer baseLayer = GPMapBaseLayerFactory.getGPBaseLayer(BaseLayerValue.valueOf(baseLayerKey));
        if (baseLayer == null) {
            baseLayer = GPMapBaseLayerFactory.getGPBaseLayer(BaseLayerValue.OFFLINE_BASE_LAYER);
        }

//        System.out.println("Base layer projection: " + baseLayer.getProjection().getProjectionCode());
        this.map.addLayer(baseLayer.getGwtOlBaseLayer());
        baseLayer.getGwtOlBaseLayer().setZIndex(-1);
        this.mapControl = new MapControlManager(this.map);

        this.map.setOptions(this.mapOptions);
//        System.out.println("Map Projection " + this.map.getProjection());
        this.featureInfoLayerAddedListener = new MapLayerAddedListener() {
            @Override
            public void onLayerAdded(MapLayerAddedEvent eventObject) {
                MapHandlerManager.fireEvent(new FeatureInfoAddModifyLayer(eventObject.getLayer()));
            }
        };
        this.featureInfoLayerRemovedListener = new MapLayerRemovedListener() {
            @Override
            public void onLayerRemoved(MapLayerRemovedEvent eventObject) {
                MapHandlerManager.fireEvent(new FeatureInfoRemoveLayer(eventObject.getLayer()));
            }
        };
        this.featureInfoLayerChangedListener = new MapLayerChangedListener() {
            @Override
            public void onLayerChanged(MapLayerChangedEvent eventObject) {
                MapHandlerManager.fireEvent(new FeatureInfoAddModifyLayer(eventObject.getLayer()));
            }
        };
    }

    public void addMeasureControl() {
        MeasureOptions measOpts = new MeasureOptions();
        measOpts.setPersist(Boolean.TRUE);
        measOpts.setGeodesic(Boolean.TRUE);
        this.measure = new Measure(new PathHandler(), measOpts);
        this.map.addControl(measure);
        this.measure.addMeasureListener(new MeasureListener() {
            @Override
            public void onMeasure(MeasureEvent eventObject) {
                Info.display("Distance is: ", eventObject.getMeasure() + " "
                        + eventObject.getUnits());
            }
        });
    }

    public void addMeasureAreaControl() {
        MeasureOptions measOpts = new MeasureOptions();
        measOpts.setPersist(Boolean.TRUE);
        measOpts.setGeodesic(Boolean.TRUE);
        this.measureArea = new Measure(new PolygonHandler(), measOpts);
        this.map.addControl(measureArea);
        this.measureArea.addMeasureListener(new MeasureListener() {
            @Override
            public void onMeasure(MeasureEvent eventObject) {
                Info.display("Area is: ", eventObject.getMeasure() + " "
                        + eventObject.getUnits());
            }
        });
    }

    @Override
    public void activateInfo() {
        this.infoActive = Boolean.TRUE;
//        System.out.println("Activate info");
        this.map.addMapLayerAddedListener(this.featureInfoLayerAddedListener);
        this.map.addMapLayerChangedListener(this.featureInfoLayerChangedListener);
        this.map.addMapLayerRemovedListener(this.featureInfoLayerRemovedListener);
        MapHandlerManager.fireEvent(new GPFeatureInfoEvent(infoActive,
                Lists.newArrayList(map.getLayers())));
    }

    @Override
    public void deactivateInfo() {
        this.infoActive = Boolean.FALSE;
//        System.out.println("De-Activate info");
        this.map.removeListener(this.featureInfoLayerAddedListener);
        this.map.removeListener(this.featureInfoLayerChangedListener);
        this.map.removeListener(this.featureInfoLayerRemovedListener);
        MapHandlerManager.fireEvent(new GPFeatureInfoEvent(infoActive));
    }

    @Override
    public void activateMeasure() {
        measure.activate();
        this.measureActive = Boolean.TRUE;
    }

    @Override
    public void deactivateMeasure() {
        measure.deactivate();
        this.measureActive = Boolean.FALSE;
    }

    @Override
    public void activateMeasureArea() {
        measureArea.activate();
        this.measureAreaActive = Boolean.TRUE;
    }

    @Override
    public void deactivateMeasureArea() {
        measureArea.deactivate();
        this.measureAreaActive = Boolean.FALSE;
    }

    /**
     * Add Map to the ContentPanel passed from Dispatcher
     *
     * @param center
     */
    public void onAddToCenterPanel() {
        LayoutManager.addComponentToCenter(mapWidget);

        this.setMapCenter();

        /**
         * OPEN SCALE WIDGET *
         */
        if (!GPScaleWidget.isScaleWidgetEnabled()) {
            showScaleWidget();
        }
    }

    /**
     * Set center of the Map on Italy
     */
    public void setMapCenter() {
        IGPAccountDetail accountDetail = Registry.get(UserSessionEnum.ACCOUNT_DETAIL_IN_SESSION.name());
        GPClientViewport viewport = accountDetail.getViewport();
        if (viewport != null) {
            ViewportUtility.gotoViewportLocation(map, viewport);
        } else {
            LonLat center = new LonLat(13.375, 42.329);
            if (map.getProjection().equals(GPCoordinateReferenceSystem.GOOGLE_MERCATOR.getCode())) {
                center.transform(GPCoordinateReferenceSystem.WGS_84.getCode(),
                        GPCoordinateReferenceSystem.EPSG_GOOGLE.getCode());
            }
            float zoomLevel = 5;
            this.map.setCenter(center, (int) zoomLevel);
        }
        this.mapControl.clearNavigationHistory();
    }

    /**
     * Draw Feature on the Map
     *
     * @param wkt
     */
    public void drawFeatureOnMap(String wkt) {
        this.mapControl.drawFeatureOnMap(wkt);
    }

    /**
     * Erase all Features added to Vector Layer
     */
    public void eraseFeatures() {
        this.mapControl.eraseFeatures();
    }

    /**
     * Erase Single Feature from the Map
     *
     * @param vf
     */
    public void eraseFeature(VectorFeature vf) {
        this.mapControl.eraseFeature(vf);
    }

    /**
     * @return the map
     */
    @Override
    public Map getMap() {
        return map;
    }

    /**
     * @return the mapWidget
     */
    @Override
    public MapWidget getMapWidget() {
        return mapWidget;
    }

    /**
     * @return the mapControl
     */
    public MapControlManager getMapControl() {
        return mapControl;
    }

    /**
     * Update Map Size
     */
    public void updateMapSize() {
        this.map.updateSize();
        LayoutManager.getInstance().getCenter().layout();
    }

    /**
     * activate draw feature control on the map
     */
    @Override
    public void activateDrawFeature() {
        this.mapControl.activateDrawFeature();
    }

    /**
     * deactivate draw feature control on the map
     */
    @Override
    public void deactivateDrawFeature() {
        this.mapControl.deactivateDrawFeature();
    }

    @Override
    public void activateDrawPointFeature() {
        this.mapControl.activateDrawPointFeature();
    }

    @Override
    public void deactivateDrawPointFeature() {
        this.mapControl.deactivateDrawPointFeature();
    }

    public void redrawVectorLayer() {
        this.mapControl.redrawVectorLayer();
    }

    /**
     * @return the buttonBar
     */
    @Override
    public MapToolbar getButtonBar() {
        return buttonBar;
    }

    /**
     * @param buttonBar the buttonBar to set
     */
    public void setButtonBar(MapToolbar buttonBar) {
        this.buttonBar = buttonBar;
    }

    public DrawFeature getDrawPolygonFeature() {
        return this.mapControl.getDrawFeatureControl();
    }

    public DrawFeature getDrawPointFeature() {
        return this.mapControl.getDrawPointFeaureControl();
    }

    public DrawFeature getDrawLineFeature() {
        return this.mapControl.getDrawLineFeature().getControl();
    }

    @Override
    public void activateModifyFeature() {
        this.mapControl.activateModifyFeature();
    }

    @Override
    public void deactivateModifyFeature() {
        this.mapControl.deactivateModifyFeature();
    }

    public void activateFeatureOperation() {
        this.mapControl.activateFeatureOperation();
    }

    @Override
    public void deactivateFeatureOperation() {
        this.mapControl.deactivateFeatureOperation();
    }

    @Override
    public boolean isFeatureOperationEnable() {
        return this.mapControl.isFeatureOperationEnable();
    }

    @Override
    public boolean isModifyFeatureEnable() {
        return this.mapControl.isModifyFeatureEnable();
    }

    public int getFeaturesNumber() {
        return this.mapControl.getFeaturesNumber();
    }

    public void drawFeature(VectorFeature feature) {
        this.mapControl.drawFeature(feature);
    }

    /**
     * @return the Navigation History Control
     */
    public NavigationHistoryControl getNavigationHistory() {
        return this.mapControl.getNavigationHistory();
    }

    /**
     * Clear Map and Remove All Features
     */
    public void clearMap() {
        this.mapControl.eraseFeatures();
    }

    /**
     * @return the measure
     */
    public Measure getMeasure() {
        return measure;
    }

    /**
     * @return the measureArea
     */
    public Measure getMeasureArea() {
        return measureArea;
    }

    /**
     * @return the infoActive
     */
    @Override
    public boolean isInfoActive() {
        return infoActive;
    }

    /**
     * @return the measureActive
     */
    @Override
    public boolean isMeasureActive() {
        return measureActive;
    }

    /**
     * @return the measureAreaActive
     */
    @Override
    public boolean isMeasureAreaActive() {
        return measureAreaActive;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.geosdi.geoplatform.gui.impl.map.GeoPlatformEditor#activateDrawLineFeature()
     */
    @Override
    public void activateDrawLineFeature() {
        this.mapControl.activateDrawLineFeature();
    }

    /*
     * (non-Javadoc)
     * @see
     * org.geosdi.geoplatform.gui.impl.map.GeoPlatformEditor#deactivateDrawLineFeature()
     */
    @Override
    public void deactivateDrawLineFeature() {
        this.mapControl.deactivateDrawLineFeature();
    }

    /**
     *
     * @param bbox
     */
    @Override
    public void zoomToMaxExtend(BBoxClientInfo bbox, String crs) {
        System.out.println("BboxClientInfo" + bbox);
        System.out.println("CRS" + crs);
        Bounds b = ViewportUtility.generateBoundsFromBBOX(bbox);
        if (!map.getProjection().equals(crs)) {
            System.out.println(">> Changed projection from: " + crs
                    + ", to: " + map.getProjection());
            if (map.getProjection().equals(GPCoordinateReferenceSystem.GOOGLE_MERCATOR.getCode())) {
                b.transform(new Projection(crs),
                        new Projection(GPCoordinateReferenceSystem.EPSG_GOOGLE.getCode()));
            }
        }

        this.map.zoomToExtent(b);
    }

    private void showScaleWidget() {

        Timer t = new Timer() {
            @Override
            public void run() {
                GPScaleWidget.display("Scale");
            }
        };
        t.schedule(3000);
    }

    public double getScaleForZoom(double zoom) {
        String units = this.map.getCurrentUnits();
        return this.map.getScaleForZoom(zoom, units);
    }

    @Override
    public void changeBaseLayer(GPBaseLayer gpBaseLayer) {
        if (!gpBaseLayer.getGwtOlBaseLayer().getName().equals(map.getBaseLayer().getName())) {
            int zoomLevel = this.map.getZoom();
            double scale = this.map.getScale();

            Bounds bounds = this.map.getExtent();
            boolean projectionChanged = Boolean.FALSE;
            if (gpBaseLayer.getProjection().getProjectionCode().equals(
                    GPCoordinateReferenceSystem.WGS_84.getCode())
                    && !this.map.getProjection().equals(GPCoordinateReferenceSystem.WGS_84.getCode())) {
                this.set4326MapOptions();
                bounds.transform(new Projection(GPCoordinateReferenceSystem.EPSG_GOOGLE.getCode()),
                        new Projection(GPCoordinateReferenceSystem.WGS_84.getCode()));
                projectionChanged = Boolean.TRUE;
            } else if (gpBaseLayer.getProjection().getProjectionCode().equals(
                    GPCoordinateReferenceSystem.GOOGLE_MERCATOR.getCode())
                    && !this.map.getProjection().equals(GPCoordinateReferenceSystem.GOOGLE_MERCATOR.getCode())) {
                this.set3857MapOptions();
                bounds.transform(new Projection(GPCoordinateReferenceSystem.WGS_84.getCode()),
                        new Projection(GPCoordinateReferenceSystem.EPSG_GOOGLE.getCode()));
                projectionChanged = Boolean.TRUE;
            }
            Layer newBaseLayer = gpBaseLayer.getGwtOlBaseLayer();
            Layer oldBaseLayer = this.map.getBaseLayer();
            this.map.setBaseLayer(newBaseLayer);
            this.map.addLayer(newBaseLayer);
            this.map.removeLayer(oldBaseLayer);
            newBaseLayer.setZIndex(-1);
            this.map.setOptions(this.mapOptions);
            if (projectionChanged) {
                this.map.zoomToMaxExtent();
                this.map.zoomToScale((float) scale, Boolean.TRUE);
                this.map.zoomTo(zoomLevel);
                this.map.zoomToExtent(bounds);
            }
            this.changeBaseLayerMapEvent = new ChangeBaseLayerMapEvent(gpBaseLayer.getProjection());

            System.out.println("Map Projection " + this.map.getProjection());

            GPHandlerManager.fireEvent(this.changeBaseLayerMapEvent);
        } else {
            GeoPlatformMessage.infoMessage("Base Layer", "The selected base layer is already displayed");
        }
    }
}
