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
// Generated on: 2015.06.17 at 04:41:23 PM CEST 
//


package org.geosdi.geoplatform.xml.iso19139.v20060504.gmd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.geosdi.geoplatform.xml.iso19139.v20060504.gco.CharacterStringPropertyType;
import org.geosdi.geoplatform.xml.iso19139.v20060504.gco.RecordPropertyType;
import org.geosdi.geoplatform.xml.iso19139.v20060504.gco.RecordTypePropertyType;
import org.geosdi.geoplatform.xml.iso19139.v20060504.gco.UnitOfMeasurePropertyType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * Quantitative_conformance_measure from Quality Procedures.  -  - Renamed to remove implied use limitation -  - OCL - -- result is type specified by valueDomain - result.tupleType = valueDomain
 * 
 * <p>Java class for DQ_QuantitativeResult_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DQ_QuantitativeResult_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.isotc211.org/2005/gmd}AbstractDQ_Result_Type">
 *       &lt;sequence>
 *         &lt;element name="valueType" type="{http://www.isotc211.org/2005/gco}RecordType_PropertyType" minOccurs="0"/>
 *         &lt;element name="valueUnit" type="{http://www.isotc211.org/2005/gco}UnitOfMeasure_PropertyType"/>
 *         &lt;element name="errorStatistic" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" minOccurs="0"/>
 *         &lt;element name="value" type="{http://www.isotc211.org/2005/gco}Record_PropertyType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DQ_QuantitativeResult_Type", propOrder = {
    "valueType",
    "valueUnit",
    "errorStatistic",
    "value"
})
public class DQQuantitativeResultType
    extends AbstractDQResultType
    implements ToString
{

    protected RecordTypePropertyType valueType;
    @XmlElement(required = true)
    protected UnitOfMeasurePropertyType valueUnit;
    protected CharacterStringPropertyType errorStatistic;
    @XmlElement(required = true)
    protected List<RecordPropertyType> value;

    /**
     * Gets the value of the valueType property.
     * 
     * @return
     *     possible object is
     *     {@link RecordTypePropertyType }
     *     
     */
    public RecordTypePropertyType getValueType() {
        return valueType;
    }

    /**
     * Sets the value of the valueType property.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordTypePropertyType }
     *     
     */
    public void setValueType(RecordTypePropertyType value) {
        this.valueType = value;
    }

    public boolean isSetValueType() {
        return (this.valueType!= null);
    }

    /**
     * Gets the value of the valueUnit property.
     * 
     * @return
     *     possible object is
     *     {@link UnitOfMeasurePropertyType }
     *     
     */
    public UnitOfMeasurePropertyType getValueUnit() {
        return valueUnit;
    }

    /**
     * Sets the value of the valueUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link UnitOfMeasurePropertyType }
     *     
     */
    public void setValueUnit(UnitOfMeasurePropertyType value) {
        this.valueUnit = value;
    }

    public boolean isSetValueUnit() {
        return (this.valueUnit!= null);
    }

    /**
     * Gets the value of the errorStatistic property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getErrorStatistic() {
        return errorStatistic;
    }

    /**
     * Sets the value of the errorStatistic property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setErrorStatistic(CharacterStringPropertyType value) {
        this.errorStatistic = value;
    }

    public boolean isSetErrorStatistic() {
        return (this.errorStatistic!= null);
    }

    /**
     * Gets the value of the value property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the value property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RecordPropertyType }
     * 
     * 
     */
    public List<RecordPropertyType> getValue() {
        if (value == null) {
            value = new ArrayList<RecordPropertyType>();
        }
        return this.value;
    }

    public boolean isSetValue() {
        return ((this.value!= null)&&(!this.value.isEmpty()));
    }

    public void unsetValue() {
        this.value = null;
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
            RecordTypePropertyType theValueType;
            theValueType = this.getValueType();
            strategy.appendField(locator, this, "valueType", buffer, theValueType);
        }
        {
            UnitOfMeasurePropertyType theValueUnit;
            theValueUnit = this.getValueUnit();
            strategy.appendField(locator, this, "valueUnit", buffer, theValueUnit);
        }
        {
            CharacterStringPropertyType theErrorStatistic;
            theErrorStatistic = this.getErrorStatistic();
            strategy.appendField(locator, this, "errorStatistic", buffer, theErrorStatistic);
        }
        {
            List<RecordPropertyType> theValue;
            theValue = (this.isSetValue()?this.getValue():null);
            strategy.appendField(locator, this, "value", buffer, theValue);
        }
        return buffer;
    }

    public void setValue(List<RecordPropertyType> value) {
        this.value = null;
        List<RecordPropertyType> draftl = this.getValue();
        draftl.addAll(value);
    }

}
