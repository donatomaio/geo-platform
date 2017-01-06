/**
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2017 geoSDI Group (CNR IMAA - Potenza - ITALY).
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
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.18 at 12:36:36 PM CEST 
//
package org.geosdi.geoplatform.xml.csw.v202;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.geosdi.geoplatform.xml.filter.v110.SortByType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;

/**
 * Specifies a query to execute against instances of one or
 *          more object types. A set of ElementName elements may be included 
 *          to specify an adhoc view of the csw:Record instances in the result 
 *          set. Otherwise, use ElementSetName to specify a predefined view. 
 *          The Constraint element contains a query filter expressed in a 
 *          supported query language. A sorting criterion that specifies a 
 *          property to sort by may be included.
 * 
 *          typeNames - a list of object types to query.
 * 
 * <p>Java class for QueryType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/cat/csw/2.0.2}AbstractQueryType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="{http://www.opengis.net/cat/csw/2.0.2}ElementSetName"/>
 *           &lt;element name="ElementName" type="{http://www.w3.org/2001/XMLSchema}QName" maxOccurs="unbounded"/>
 *         &lt;/choice>
 *         &lt;element ref="{http://www.opengis.net/cat/csw/2.0.2}Constraint" minOccurs="0"/>
 *         &lt;element ref="{http://www.opengis.net/ogc}SortBy" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="typeNames" use="required" type="{http://www.opengis.net/cat/csw/2.0.2}TypeNameListType" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement(name = "Query")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryType", propOrder = {
    "elementSetName",
    "elementName",
    "constraint",
    "sortBy"
})
public class QueryType extends AbstractQueryType
        implements ToString {

    @XmlElement(name = "ElementSetName", defaultValue = "summary")
    protected ElementSetNameType elementSetName;
    @XmlElement(name = "ElementName")
    protected List<QName> elementName;
    @XmlElement(name = "Constraint")
    protected QueryConstraintType constraint;
    @XmlElement(name = "SortBy", namespace = "http://www.opengis.net/ogc")
    protected SortByType sortBy;
    @XmlAttribute(name = "typeNames", required = true)
    protected List<QName> typeNames;

    /**
     * Gets the value of the elementSetName property.
     * 
     * @return
     *     possible object is
     *     {@link ElementSetNameType }
     *     
     */
    public ElementSetNameType getElementSetName() {
        return elementSetName;
    }

    /**
     * Sets the value of the elementSetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElementSetNameType }
     *     
     */
    public void setElementSetName(ElementSetNameType value) {
        this.elementSetName = value;
    }

    public boolean isSetElementSetName() {
        return (this.elementSetName != null);
    }

    /**
     * Gets the value of the elementName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the elementName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElementName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QName }
     * 
     * 
     */
    public List<QName> getElementName() {
        if (elementName == null) {
            elementName = new ArrayList<QName>();
        }
        return this.elementName;
    }

    public boolean isSetElementName() {
        return ((this.elementName != null) && (!this.elementName.isEmpty()));
    }

    public void unsetElementName() {
        this.elementName = null;
    }

    /**
     * Gets the value of the constraint property.
     * 
     * @return
     *     possible object is
     *     {@link QueryConstraintType }
     *     
     */
    public QueryConstraintType getConstraint() {
        return constraint;
    }

    /**
     * Sets the value of the constraint property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueryConstraintType }
     *     
     */
    public void setConstraint(QueryConstraintType value) {
        this.constraint = value;
    }

    public boolean isSetConstraint() {
        return (this.constraint != null);
    }

    /**
     * Gets the value of the sortBy property.
     * 
     * @return
     *     possible object is
     *     {@link SortByType }
     *     
     */
    public SortByType getSortBy() {
        return sortBy;
    }

    /**
     * Sets the value of the sortBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link SortByType }
     *     
     */
    public void setSortBy(SortByType value) {
        this.sortBy = value;
    }

    public boolean isSetSortBy() {
        return (this.sortBy != null);
    }

    /**
     * Gets the value of the typeNames property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the typeNames property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypeNames().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QName }
     * 
     * 
     */
    public List<QName> getTypeNames() {
        if (typeNames == null) {
            typeNames = new ArrayList<QName>();
        }
        return this.typeNames;
    }

    public boolean isSetTypeNames() {
        return ((this.typeNames != null) && (!this.typeNames.isEmpty()));
    }

    public void unsetTypeNames() {
        this.typeNames = null;
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
        super.appendFields(locator, buffer, strategy);
        {
            ElementSetNameType theElementSetName;
            theElementSetName = this.getElementSetName();
            strategy.appendField(locator, this, "elementSetName", buffer,
                    theElementSetName);
        }
        {
            List<QName> theElementName;
            theElementName = (this.isSetElementName() ? this.getElementName() : null);
            strategy.appendField(locator, this, "elementName", buffer,
                    theElementName);
        }
        {
            QueryConstraintType theConstraint;
            theConstraint = this.getConstraint();
            strategy.appendField(locator, this, "constraint", buffer,
                    theConstraint);
        }
        {
            SortByType theSortBy;
            theSortBy = this.getSortBy();
            strategy.appendField(locator, this, "sortBy", buffer, theSortBy);
        }
        {
            List<QName> theTypeNames;
            theTypeNames = (this.isSetTypeNames() ? this.getTypeNames() : null);
            strategy.appendField(locator, this, "typeNames", buffer,
                    theTypeNames);
        }
        return buffer;
    }

    public void setElementName(List<QName> value) {
        this.elementName = null;
        List<QName> draftl = this.getElementName();
        draftl.addAll(value);
    }

    public void setTypeNames(List<QName> value) {
        this.typeNames = null;
        List<QName> draftl = this.getTypeNames();
        draftl.addAll(value);
    }
}
