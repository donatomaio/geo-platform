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
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.06.17 at 04:41:23 PM CEST 
//


package org.geosdi.geoplatform.xml.iso19139.v20060504.src;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for SV_PlatformNeutralServiceSpecification_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SV_PlatformNeutralServiceSpecification_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.isotc211.org/2005/srv}SV_ServiceSpecification_Type">
 *       &lt;sequence>
 *         &lt;element name="serviceType" type="{http://www.isotc211.org/2005/srv}SV_ServiceType_PropertyType"/>
 *         &lt;element name="implSpec" type="{http://www.isotc211.org/2005/srv}SV_PlatformSpecificServiceSpecification_PropertyType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SV_PlatformNeutralServiceSpecification_Type", propOrder = {
    "serviceType",
    "implSpec"
})
@XmlSeeAlso({
    SVPlatformSpecificServiceSpecificationType.class
})
public class SVPlatformNeutralServiceSpecificationType
    extends SVServiceSpecificationType
    implements ToString
{

    @XmlElement(required = true)
    protected SVServiceTypePropertyType serviceType;
    @XmlElement(required = true)
    protected SVPlatformSpecificServiceSpecificationPropertyType implSpec;

    /**
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link SVServiceTypePropertyType }
     *     
     */
    public SVServiceTypePropertyType getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link SVServiceTypePropertyType }
     *     
     */
    public void setServiceType(SVServiceTypePropertyType value) {
        this.serviceType = value;
    }

    public boolean isSetServiceType() {
        return (this.serviceType!= null);
    }

    /**
     * Gets the value of the implSpec property.
     * 
     * @return
     *     possible object is
     *     {@link SVPlatformSpecificServiceSpecificationPropertyType }
     *     
     */
    public SVPlatformSpecificServiceSpecificationPropertyType getImplSpec() {
        return implSpec;
    }

    /**
     * Sets the value of the implSpec property.
     * 
     * @param value
     *     allowed object is
     *     {@link SVPlatformSpecificServiceSpecificationPropertyType }
     *     
     */
    public void setImplSpec(SVPlatformSpecificServiceSpecificationPropertyType value) {
        this.implSpec = value;
    }

    public boolean isSetImplSpec() {
        return (this.implSpec!= null);
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
            SVServiceTypePropertyType theServiceType;
            theServiceType = this.getServiceType();
            strategy.appendField(locator, this, "serviceType", buffer, theServiceType);
        }
        {
            SVPlatformSpecificServiceSpecificationPropertyType theImplSpec;
            theImplSpec = this.getImplSpec();
            strategy.appendField(locator, this, "implSpec", buffer, theImplSpec);
        }
        return buffer;
    }

}
