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
// Generated on: 2012.04.17 at 10:27:36 PM CEST 
//
package org.geosdi.geoplatform.xml.gml.v311;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import org.geosdi.geoplatform.gml.api.Coordinates;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;

/**
 * Tables or arrays of tuples. May be used for text-encoding of values from a
 * table. Actually just a string, but allows the user to indicate which
 * characters are used as separators. The value of the 'cs' attribute is the
 * separator for coordinate values, and the value of the 'ts' attribute gives
 * the tuple separator (a single space by default); the default values may be
 * changed to reflect local usage. Defaults to CSV within a tuple, space between
 * tuples. However, any string content will be schema-valid.
 *
 * <p>Java class for CoordinatesType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained
 * within this class.
 *
 * <pre>
 * &lt;complexType name="CoordinatesType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="decimal" type="{http://www.w3.org/2001/XMLSchema}string" default="." />
 *       &lt;attribute name="cs" type="{http://www.w3.org/2001/XMLSchema}string" default="," />
 *       &lt;attribute name="ts" type="{http://www.w3.org/2001/XMLSchema}string" default=" " />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CoordinatesType", propOrder = {
    "value"
})
public class CoordinatesType implements ToString, Coordinates {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "decimal")
    protected String decimal;
    @XmlAttribute(name = "cs")
    protected String cs;
    @XmlAttribute(name = "ts")
    protected String ts;

    /**
     * Gets the value of the value property.
     *
     * @return possible object is {@link String }
     *
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setValue(String value) {
        this.value = value;
    }

    public boolean isSetValue() {
        return (this.value != null);
    }

    /**
     * Gets the value of the decimal property.
     *
     * @return possible object is {@link String }
     *
     */
    @Override
    public String getDecimal() {
        if (decimal == null) {
            return ".";
        } else {
            return decimal;
        }
    }

    /**
     * Sets the value of the decimal property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setDecimal(String value) {
        this.decimal = value;
    }

    @Override
    public boolean isSetDecimal() {
        return (this.decimal != null);
    }

    /**
     * Gets the value of the cs property.
     *
     * @return possible object is {@link String }
     *
     */
    @Override
    public String getCs() {
        if (cs == null) {
            return ",";
        } else {
            return cs;
        }
    }

    /**
     * Sets the value of the cs property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setCs(String value) {
        this.cs = value;
    }

    public boolean isSetCs() {
        return (this.cs != null);
    }

    /**
     * Gets the value of the ts property.
     *
     * @return possible object is {@link String }
     *
     */
    @Override
    public String getTs() {
        if (ts == null) {
            return " ";
        } else {
            return ts;
        }
    }

    /**
     * Sets the value of the ts property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setTs(String value) {
        this.ts = value;
    }

    public boolean isSetTs() {
        return (this.ts != null);
    }

    public String toString() {
        final ToStringStrategy strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator,
            StringBuilder buffer,
            ToStringStrategy strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator,
            StringBuilder buffer,
            ToStringStrategy strategy) {
        {
            String theValue;
            theValue = this.getValue();
            strategy.appendField(locator, this, "value", buffer, theValue);
        }
        {
            String theDecimal;
            theDecimal = this.getDecimal();
            strategy.appendField(locator, this, "decimal", buffer, theDecimal);
        }
        {
            String theCs;
            theCs = this.getCs();
            strategy.appendField(locator, this, "cs", buffer, theCs);
        }
        {
            String theTs;
            theTs = this.getTs();
            strategy.appendField(locator, this, "ts", buffer, theTs);
        }
        return buffer;
    }
}
