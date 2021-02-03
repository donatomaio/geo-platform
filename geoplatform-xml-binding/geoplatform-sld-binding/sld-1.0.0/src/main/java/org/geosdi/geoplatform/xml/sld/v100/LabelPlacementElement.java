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
//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.7 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2015.08.25 alle 11:12:35 PM CEST 
//


package org.geosdi.geoplatform.xml.sld.v100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.opengis.net/sld}PointPlacement"/>
 *         &lt;element ref="{http://www.opengis.net/sld}LinePlacement"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pointPlacement",
    "linePlacement"
})
@XmlRootElement(name = "LabelPlacement")
public class LabelPlacementElement
    implements ToString
{

    @XmlElement(name = "PointPlacement")
    protected PointPlacementElement pointPlacement;
    @XmlElement(name = "LinePlacement")
    protected LinePlacementElement linePlacement;

    /**
     * Recupera il valore della proprietà pointPlacement.
     * 
     * @return
     *     possible object is
     *     {@link PointPlacementElement }
     *     
     */
    public PointPlacementElement getPointPlacement() {
        return pointPlacement;
    }

    /**
     * Imposta il valore della proprietà pointPlacement.
     * 
     * @param value
     *     allowed object is
     *     {@link PointPlacementElement }
     *     
     */
    public void setPointPlacement(PointPlacementElement value) {
        this.pointPlacement = value;
    }

    public boolean isSetPointPlacement() {
        return (this.pointPlacement!= null);
    }

    /**
     * Recupera il valore della proprietà linePlacement.
     * 
     * @return
     *     possible object is
     *     {@link LinePlacementElement }
     *     
     */
    public LinePlacementElement getLinePlacement() {
        return linePlacement;
    }

    /**
     * Imposta il valore della proprietà linePlacement.
     * 
     * @param value
     *     allowed object is
     *     {@link LinePlacementElement }
     *     
     */
    public void setLinePlacement(LinePlacementElement value) {
        this.linePlacement = value;
    }

    public boolean isSetLinePlacement() {
        return (this.linePlacement!= null);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy strategy) {
        {
            PointPlacementElement thePointPlacement;
            thePointPlacement = this.getPointPlacement();
            strategy.appendField(locator, this, "pointPlacement", buffer, thePointPlacement);
        }
        {
            LinePlacementElement theLinePlacement;
            theLinePlacement = this.getLinePlacement();
            strategy.appendField(locator, this, "linePlacement", buffer, theLinePlacement);
        }
        return buffer;
    }

}
