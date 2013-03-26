/*
 *  geo-platform
 *  Rich webgis framework
 *  http:geo-platform.org
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
 * Public License along with this program. If not, see http:www.gnu.org/licenses/ 
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
package org.geosdi.geoplatform.gui.client.config;

import com.google.gwt.inject.client.AbstractGinModule;
import javax.inject.Singleton;
import org.geosdi.geoplatform.gui.client.config.provider.DropTargetProvider;
import org.geosdi.geoplatform.gui.client.config.provider.GPLayerTreeDecoratorProvider;
import org.geosdi.geoplatform.gui.client.config.provider.GPRootTreeNodeProvider;
import org.geosdi.geoplatform.gui.client.config.provider.GPTreeHandlerManagerProvider;
import org.geosdi.geoplatform.gui.client.config.provider.GPTreeStoreWidgetProvider;
import org.geosdi.geoplatform.gui.client.config.provider.LayerTreeBasicMenuProvider;
import org.geosdi.geoplatform.gui.client.model.GPRootTreeNode;
import org.geosdi.geoplatform.gui.client.widget.GPLegendPanel;
import org.geosdi.geoplatform.gui.client.widget.GPTreePanelDropTarget;
import org.geosdi.geoplatform.gui.client.widget.LayerTreePanel;
import org.geosdi.geoplatform.gui.client.widget.LayerTreeWidget;
import org.geosdi.geoplatform.gui.client.widget.decorator.GPLayerTreeDecorator;
import org.geosdi.geoplatform.gui.client.widget.store.GPTreeStoreWidget;
import org.geosdi.geoplatform.gui.client.widget.toolbar.LayerTreeToolbar;
import org.geosdi.geoplatform.gui.client.widget.tree.properties.basic.menu.LayerTreeBasicMenu;
import org.geosdi.geoplatform.gui.client.widget.tree.properties.handler.GPTreeHandlerManager;
import org.geosdi.geoplatform.gui.impl.tree.menu.store.TreeMenuStoreRepository;
import org.geosdi.geoplatform.gui.puregwt.GPEventBus;
import org.geosdi.geoplatform.gui.puregwt.GPEventBusImpl;
import org.geosdi.geoplatform.gui.puregwt.layers.event.LegendLayerHandler;

/**
 *
 * @author Giuseppe La Scaleia - CNR IMAA geoSDI Group
 * @email giuseppe.lascaleia@geosdi.org
 */
public class LayerTreeGinConfigurator extends AbstractGinModule {

    @Override
    protected void configure() {
        bind(GPEventBus.class).to(GPEventBusImpl.class).in(Singleton.class);

        bind(LayerTreePanel.class).in(Singleton.class);
        bind(LayerTreeWidget.class).in(Singleton.class);
        bind(LayerTreeToolbar.class).in(Singleton.class);
        bind(LegendLayerHandler.class).to(GPLegendPanel.class).in(
                Singleton.class);

        bind(GPTreeStoreWidget.class).toProvider(GPTreeStoreWidgetProvider.class);

        bind(GPLayerTreeDecorator.class).toProvider(
                GPLayerTreeDecoratorProvider.class);

        bind(GPRootTreeNode.class).toProvider(GPRootTreeNodeProvider.class);

        bind(GPTreePanelDropTarget.class).toProvider(DropTargetProvider.class);

        bind(GPTreeHandlerManager.class).toProvider(
                GPTreeHandlerManagerProvider.class);

        bind(LayerTreeBasicMenu.class).toProvider(
                LayerTreeBasicMenuProvider.class).in(Singleton.class);

        bind(TreeMenuStoreRepository.class).in(Singleton.class);
    }

}