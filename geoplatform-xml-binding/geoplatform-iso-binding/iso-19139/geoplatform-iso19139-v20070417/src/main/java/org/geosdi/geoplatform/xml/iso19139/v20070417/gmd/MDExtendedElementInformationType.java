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
// Generated on: 2012.04.18 at 03:12:11 PM CEST 
//


package org.geosdi.geoplatform.xml.iso19139.v20070417.gmd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.geosdi.geoplatform.xml.iso19139.v20070417.gco.AbstractObjectType;
import org.geosdi.geoplatform.xml.iso19139.v20070417.gco.CharacterStringPropertyType;
import org.geosdi.geoplatform.xml.iso19139.v20070417.gco.IntegerPropertyType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * New metadata element, not found in ISO 19115, which is required to describe geographic data
 * 
 * <p>Java class for MD_ExtendedElementInformation_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MD_ExtendedElementInformation_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.isotc211.org/2005/gco}AbstractObject_Type">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType"/>
 *         &lt;element name="shortName" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" minOccurs="0"/>
 *         &lt;element name="domainCode" type="{http://www.isotc211.org/2005/gco}Integer_PropertyType" minOccurs="0"/>
 *         &lt;element name="definition" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType"/>
 *         &lt;element name="obligation" type="{http://www.isotc211.org/2005/gmd}MD_ObligationCode_PropertyType" minOccurs="0"/>
 *         &lt;element name="condition" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" minOccurs="0"/>
 *         &lt;element name="dataType" type="{http://www.isotc211.org/2005/gmd}MD_DatatypeCode_PropertyType"/>
 *         &lt;element name="maximumOccurrence" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" minOccurs="0"/>
 *         &lt;element name="domainValue" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" minOccurs="0"/>
 *         &lt;element name="parentEntity" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" maxOccurs="unbounded"/>
 *         &lt;element name="rule" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType"/>
 *         &lt;element name="rationale" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="source" type="{http://www.isotc211.org/2005/gmd}CI_ResponsibleParty_PropertyType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MD_ExtendedElementInformation_Type", propOrder = {
    "name",
    "shortName",
    "domainCode",
    "definition",
    "obligation",
    "condition",
    "dataType",
    "maximumOccurrence",
    "domainValue",
    "parentEntity",
    "rule",
    "rationale",
    "source"
})
public class MDExtendedElementInformationType
    extends AbstractObjectType
    implements ToString
{

    @XmlElement(required = true)
    protected CharacterStringPropertyType name;
    protected CharacterStringPropertyType shortName;
    protected IntegerPropertyType domainCode;
    @XmlElement(required = true)
    protected CharacterStringPropertyType definition;
    protected MDObligationCodePropertyType obligation;
    protected CharacterStringPropertyType condition;
    @XmlElement(required = true)
    protected MDDatatypeCodePropertyType dataType;
    protected CharacterStringPropertyType maximumOccurrence;
    protected CharacterStringPropertyType domainValue;
    @XmlElement(required = true)
    protected List<CharacterStringPropertyType> parentEntity;
    @XmlElement(required = true)
    protected CharacterStringPropertyType rule;
    protected List<CharacterStringPropertyType> rationale;
    @XmlElement(required = true)
    protected List<CIResponsiblePartyPropertyType> source;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setName(CharacterStringPropertyType value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Gets the value of the shortName property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getShortName() {
        return shortName;
    }

    /**
     * Sets the value of the shortName property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setShortName(CharacterStringPropertyType value) {
        this.shortName = value;
    }

    public boolean isSetShortName() {
        return (this.shortName!= null);
    }

    /**
     * Gets the value of the domainCode property.
     * 
     * @return
     *     possible object is
     *     {@link IntegerPropertyType }
     *     
     */
    public IntegerPropertyType getDomainCode() {
        return domainCode;
    }

    /**
     * Sets the value of the domainCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegerPropertyType }
     *     
     */
    public void setDomainCode(IntegerPropertyType value) {
        this.domainCode = value;
    }

    public boolean isSetDomainCode() {
        return (this.domainCode!= null);
    }

    /**
     * Gets the value of the definition property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getDefinition() {
        return definition;
    }

    /**
     * Sets the value of the definition property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setDefinition(CharacterStringPropertyType value) {
        this.definition = value;
    }

    public boolean isSetDefinition() {
        return (this.definition!= null);
    }

    /**
     * Gets the value of the obligation property.
     * 
     * @return
     *     possible object is
     *     {@link MDObligationCodePropertyType }
     *     
     */
    public MDObligationCodePropertyType getObligation() {
        return obligation;
    }

    /**
     * Sets the value of the obligation property.
     * 
     * @param value
     *     allowed object is
     *     {@link MDObligationCodePropertyType }
     *     
     */
    public void setObligation(MDObligationCodePropertyType value) {
        this.obligation = value;
    }

    public boolean isSetObligation() {
        return (this.obligation!= null);
    }

    /**
     * Gets the value of the condition property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getCondition() {
        return condition;
    }

    /**
     * Sets the value of the condition property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setCondition(CharacterStringPropertyType value) {
        this.condition = value;
    }

    public boolean isSetCondition() {
        return (this.condition!= null);
    }

    /**
     * Gets the value of the dataType property.
     * 
     * @return
     *     possible object is
     *     {@link MDDatatypeCodePropertyType }
     *     
     */
    public MDDatatypeCodePropertyType getDataType() {
        return dataType;
    }

    /**
     * Sets the value of the dataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MDDatatypeCodePropertyType }
     *     
     */
    public void setDataType(MDDatatypeCodePropertyType value) {
        this.dataType = value;
    }

    public boolean isSetDataType() {
        return (this.dataType!= null);
    }

    /**
     * Gets the value of the maximumOccurrence property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getMaximumOccurrence() {
        return maximumOccurrence;
    }

    /**
     * Sets the value of the maximumOccurrence property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setMaximumOccurrence(CharacterStringPropertyType value) {
        this.maximumOccurrence = value;
    }

    public boolean isSetMaximumOccurrence() {
        return (this.maximumOccurrence!= null);
    }

    /**
     * Gets the value of the domainValue property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getDomainValue() {
        return domainValue;
    }

    /**
     * Sets the value of the domainValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setDomainValue(CharacterStringPropertyType value) {
        this.domainValue = value;
    }

    public boolean isSetDomainValue() {
        return (this.domainValue!= null);
    }

    /**
     * Gets the value of the parentEntity property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parentEntity property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParentEntity().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CharacterStringPropertyType }
     * 
     * 
     */
    public List<CharacterStringPropertyType> getParentEntity() {
        if (parentEntity == null) {
            parentEntity = new ArrayList<CharacterStringPropertyType>();
        }
        return this.parentEntity;
    }

    public boolean isSetParentEntity() {
        return ((this.parentEntity!= null)&&(!this.parentEntity.isEmpty()));
    }

    public void unsetParentEntity() {
        this.parentEntity = null;
    }

    /**
     * Gets the value of the rule property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getRule() {
        return rule;
    }

    /**
     * Sets the value of the rule property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setRule(CharacterStringPropertyType value) {
        this.rule = value;
    }

    public boolean isSetRule() {
        return (this.rule!= null);
    }

    /**
     * Gets the value of the rationale property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rationale property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRationale().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CharacterStringPropertyType }
     * 
     * 
     */
    public List<CharacterStringPropertyType> getRationale() {
        if (rationale == null) {
            rationale = new ArrayList<CharacterStringPropertyType>();
        }
        return this.rationale;
    }

    public boolean isSetRationale() {
        return ((this.rationale!= null)&&(!this.rationale.isEmpty()));
    }

    public void unsetRationale() {
        this.rationale = null;
    }

    /**
     * Gets the value of the source property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the source property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSource().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CIResponsiblePartyPropertyType }
     * 
     * 
     */
    public List<CIResponsiblePartyPropertyType> getSource() {
        if (source == null) {
            source = new ArrayList<CIResponsiblePartyPropertyType>();
        }
        return this.source;
    }

    public boolean isSetSource() {
        return ((this.source!= null)&&(!this.source.isEmpty()));
    }

    public void unsetSource() {
        this.source = null;
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
            CharacterStringPropertyType theName;
            theName = this.getName();
            strategy.appendField(locator, this, "name", buffer, theName);
        }
        {
            CharacterStringPropertyType theShortName;
            theShortName = this.getShortName();
            strategy.appendField(locator, this, "shortName", buffer, theShortName);
        }
        {
            IntegerPropertyType theDomainCode;
            theDomainCode = this.getDomainCode();
            strategy.appendField(locator, this, "domainCode", buffer, theDomainCode);
        }
        {
            CharacterStringPropertyType theDefinition;
            theDefinition = this.getDefinition();
            strategy.appendField(locator, this, "definition", buffer, theDefinition);
        }
        {
            MDObligationCodePropertyType theObligation;
            theObligation = this.getObligation();
            strategy.appendField(locator, this, "obligation", buffer, theObligation);
        }
        {
            CharacterStringPropertyType theCondition;
            theCondition = this.getCondition();
            strategy.appendField(locator, this, "condition", buffer, theCondition);
        }
        {
            MDDatatypeCodePropertyType theDataType;
            theDataType = this.getDataType();
            strategy.appendField(locator, this, "dataType", buffer, theDataType);
        }
        {
            CharacterStringPropertyType theMaximumOccurrence;
            theMaximumOccurrence = this.getMaximumOccurrence();
            strategy.appendField(locator, this, "maximumOccurrence", buffer, theMaximumOccurrence);
        }
        {
            CharacterStringPropertyType theDomainValue;
            theDomainValue = this.getDomainValue();
            strategy.appendField(locator, this, "domainValue", buffer, theDomainValue);
        }
        {
            List<CharacterStringPropertyType> theParentEntity;
            theParentEntity = (this.isSetParentEntity()?this.getParentEntity():null);
            strategy.appendField(locator, this, "parentEntity", buffer, theParentEntity);
        }
        {
            CharacterStringPropertyType theRule;
            theRule = this.getRule();
            strategy.appendField(locator, this, "rule", buffer, theRule);
        }
        {
            List<CharacterStringPropertyType> theRationale;
            theRationale = (this.isSetRationale()?this.getRationale():null);
            strategy.appendField(locator, this, "rationale", buffer, theRationale);
        }
        {
            List<CIResponsiblePartyPropertyType> theSource;
            theSource = (this.isSetSource()?this.getSource():null);
            strategy.appendField(locator, this, "source", buffer, theSource);
        }
        return buffer;
    }

    public void setParentEntity(List<CharacterStringPropertyType> value) {
        this.parentEntity = null;
        List<CharacterStringPropertyType> draftl = this.getParentEntity();
        draftl.addAll(value);
    }

    public void setRationale(List<CharacterStringPropertyType> value) {
        this.rationale = null;
        List<CharacterStringPropertyType> draftl = this.getRationale();
        draftl.addAll(value);
    }

    public void setSource(List<CIResponsiblePartyPropertyType> value) {
        this.source = null;
        List<CIResponsiblePartyPropertyType> draftl = this.getSource();
        draftl.addAll(value);
    }

}
