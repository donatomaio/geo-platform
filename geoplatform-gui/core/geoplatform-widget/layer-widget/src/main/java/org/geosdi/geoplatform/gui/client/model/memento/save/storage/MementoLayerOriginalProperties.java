/*
 *  geo-platform
 *  Rich webgis framework
 *  http://geo-platform.org
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
package org.geosdi.geoplatform.gui.client.model.memento.save.storage;

import java.util.ArrayList;
import org.geosdi.geoplatform.gui.action.ISave;
import org.geosdi.geoplatform.gui.client.model.RasterTreeNode;
import org.geosdi.geoplatform.gui.client.model.memento.save.bean.AbstractMementoSave;
import org.geosdi.geoplatform.gui.model.tree.GPLayerTreeModel;
import org.geosdi.geoplatform.gui.model.tree.GPStyleStringBeanModel;

/**
 * @author Nazzareno Sileno - CNR IMAA geoSDI Group
 * @email nazzareno.sileno@geosdi.org
 */
public class MementoLayerOriginalProperties
        extends AbstractMementoSave<GPLayerTreeModel> {

    private static final long serialVersionUID = 5408762639577399920L;
    //
    private String alias;
    private float opacity;
    private boolean checked;
    private ArrayList<GPStyleStringBeanModel> styleList;

    public MementoLayerOriginalProperties() {
    }

    public MementoLayerOriginalProperties(ISave saveAction) {
        super(saveAction);
    }

    @Override
    public void convertMementoToWs() {
        super.convertMementoToWs();
        alias = super.getRefBaseElement().getAlias();
        checked = super.getRefBaseElement().isChecked();
        if (super.getRefBaseElement() instanceof RasterTreeNode) {
            opacity = ((RasterTreeNode) super.getRefBaseElement()).getOpacity();
        }
    }

    /**
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * @return the opacity
     */
    public float getOpacity() {
        return opacity;
    }

    /**
     * @param opacity the opacity to set
     */
    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }

    /**
     * @return the checked
     */
    public boolean isChecked() {
        return checked;
    }

    /**
     * @param checked the checked to set
     */
    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    /**
     * @return the styleList
     */
    public ArrayList<GPStyleStringBeanModel> getStyleList() {
        return styleList;
    }

    /**
     * @param styleList the styleList to set
     */
    public void setStyleList(ArrayList<GPStyleStringBeanModel> styleList) {
        this.styleList = styleList;
    }
}
