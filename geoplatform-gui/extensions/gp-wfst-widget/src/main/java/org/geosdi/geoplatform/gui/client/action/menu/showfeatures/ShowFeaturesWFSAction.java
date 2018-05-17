/**
 * geo-platform
 * Rich webgis framework
 * http://geo-platform.org
 * ====================================================================
 * <p>
 * Copyright (C) 2008-2018 geoSDI Group (CNR IMAA - Potenza - ITALY).
 * <p>
 * This program is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version. This program is distributed in the
 * hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details. You should have received a copy of the GNU General
 * Public License along with this program. If not, see http://www.gnu.org/licenses/
 * <p>
 * ====================================================================
 * <p>
 * Linking this library statically or dynamically with other modules is
 * making a combined work based on this library. Thus, the terms and
 * conditions of the GNU General Public License cover the whole combination.
 * <p>
 * As a special exception, the copyright holders of this library give you permission
 * to link this library with independent modules to produce an executable, regardless
 * of the license terms of these independent modules, and to copy and distribute
 * the resulting executable under terms of your choice, provided that you also meet,
 * for each linked independent module, the terms and conditions of the license of
 * that module. An independent module is a module which is not derived from or
 * based on this library. If you modify this library, you may extend this exception
 * to your version of the library, but you are not obligated to do so. If you do not
 * wish to do so, delete this exception statement from your version.
 */
package org.geosdi.geoplatform.gui.client.action.menu.showfeatures;

import com.extjs.gxt.ui.client.event.ComponentEvent;
import com.extjs.gxt.ui.client.event.MenuEvent;
import com.extjs.gxt.ui.client.event.SelectionListener;
import com.extjs.gxt.ui.client.widget.treepanel.TreePanel;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import org.geosdi.geoplatform.gui.action.menu.MenuBaseAction;
import org.geosdi.geoplatform.gui.client.BasicWidgetResources;
import org.geosdi.geoplatform.gui.client.action.menu.edit.responsibility.LayerTypeHandlerManager;
import org.geosdi.geoplatform.gui.client.action.menu.strategy.IActionStrategy;
import org.geosdi.geoplatform.gui.client.config.FeatureInjector;
import org.geosdi.geoplatform.gui.client.i18n.WFSTWidgetConstants;
import org.geosdi.geoplatform.gui.client.widget.wfs.ShowFeaturesWidget;
import org.geosdi.geoplatform.gui.model.GPLayerBean;
import org.geosdi.geoplatform.gui.model.tree.GPBeanTreeModel;
import org.geosdi.geoplatform.gui.puregwt.GPEventBus;

/**
 * @author Vito Salvia - CNR IMAA geoSDI Group
 * @email vito.salvia@gmail.com
 */
public class ShowFeaturesWFSAction extends MenuBaseAction {

    private final TreePanel<GPBeanTreeModel> treePanel;
    private final GPEventBus bus;
    private final LayerTypeHandlerManager layerTypeHandlerManager;
    private IActionStrategy actionStrategy;
    private ShowFeaturesWidget showFeaturesWidget;

    public ShowFeaturesWFSAction(TreePanel<GPBeanTreeModel> treePanel) {
        super(WFSTWidgetConstants.INSTANCE.showFeaturesTitleText(),
                AbstractImagePrototype.create(BasicWidgetResources.ICONS.vector()));
        this.treePanel = treePanel;
        this.bus = FeatureInjector.MainInjector.getInstance().getEventBus();
        this.showFeaturesWidget = FeatureInjector.MainInjector.getInstance().getShowElementsWidget();
        this.layerTypeHandlerManager = FeatureInjector.MainInjector.getInstance().getLayerTypeHandlerManager();
        this.actionStrategy = FeatureInjector.MainInjector.getInstance().getActionStrategy();
    }

    /**
     * (non-Javadoc)
     *
     * @param e
     * @see SelectionListener#componentSelected(ComponentEvent)
     */
    @Override
    public void componentSelected(MenuEvent e) {
        this.actionStrategy.setWidgetType(IActionStrategy.WidgetType.SHOW_FEATURES);
        final GPLayerBean layer = (GPLayerBean) this.treePanel.getSelectionModel().getSelectedItem();
        this.layerTypeHandlerManager.forwardLayerType(layer);
    }


}