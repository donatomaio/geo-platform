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
package org.geosdi.geoplatform.gui.client.action.menu;

import com.extjs.gxt.ui.client.event.MenuEvent;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import org.geosdi.geoplatform.gui.client.LayerResources;
import org.geosdi.geoplatform.gui.client.model.FolderTreeNode;
import org.geosdi.geoplatform.gui.client.widget.tree.panel.GinTreePanel;
import org.geosdi.geoplatform.gui.client.widget.tree.store.puregwt.event.AddLayersFromCopyMenuEvent;
import org.geosdi.geoplatform.gui.model.tree.GPBeanTreeModel;
import org.geosdi.geoplatform.gui.puregwt.layers.LayerHandlerManager;

import javax.inject.Inject;

/**
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group
 * @email nazzareno.sileno@geosdi.org
 */
public class PasteLayerAction extends PasteLayerBaseAction {

    /**
     * @param ginTreePanel
     */
    @Inject
    public PasteLayerAction(GinTreePanel ginTreePanel) {
        super("PasteLayers", AbstractImagePrototype.create(LayerResources.ICONS.paste()), ginTreePanel.get());
    }

    @Override
    public void componentSelected(MenuEvent ce) {
        GPBeanTreeModel itemSelected = this.tree.getSelectionModel().getSelectedItem();
        if ((!(itemSelected instanceof FolderTreeNode)) || this.layersToCopy == null) {
            throw new IllegalArgumentException("It is possible to past only copied layers into a Folder");
        }
        if (!this.tree.isExpanded(itemSelected)) {
            this.folderExpander.checkNodeState();
        } else {
            this.executePaste();
        }
    }

    @Override
    protected void executePaste() {
        LayerHandlerManager.fireEvent(new AddLayersFromCopyMenuEvent(layersToCopy));
    }
}
