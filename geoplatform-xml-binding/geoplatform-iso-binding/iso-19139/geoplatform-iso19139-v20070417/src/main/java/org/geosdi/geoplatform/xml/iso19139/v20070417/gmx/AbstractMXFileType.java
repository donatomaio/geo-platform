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
// Generated on: 2012.04.18 at 03:12:11 PM CEST 
//


package org.geosdi.geoplatform.xml.iso19139.v20070417.gmx;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.geosdi.geoplatform.xml.iso19139.v20070417.gco.AbstractObjectType;
import org.geosdi.geoplatform.xml.iso19139.v20070417.gco.CharacterStringPropertyType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for AbstractMX_File_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AbstractMX_File_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.isotc211.org/2005/gco}AbstractObject_Type">
 *       &lt;sequence>
 *         &lt;element name="fileName" type="{http://www.isotc211.org/2005/gmx}FileName_PropertyType"/>
 *         &lt;element name="fileDescription" type="{http://www.isotc211.org/2005/gco}CharacterString_PropertyType"/>
 *         &lt;element name="fileType" type="{http://www.isotc211.org/2005/gmx}MimeFileType_PropertyType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AbstractMX_File_Type", propOrder = {
    "fileName",
    "fileDescription",
    "fileType"
})
@XmlSeeAlso({
    MXSupportFileType.class,
    MXDataFileType.class
})
public abstract class AbstractMXFileType
    extends AbstractObjectType
    implements ToString
{

    @XmlElement(required = true)
    protected FileNamePropertyType fileName;
    @XmlElement(required = true)
    protected CharacterStringPropertyType fileDescription;
    @XmlElement(required = true)
    protected MimeFileTypePropertyType fileType;

    /**
     * Gets the value of the fileName property.
     * 
     * @return
     *     possible object is
     *     {@link FileNamePropertyType }
     *     
     */
    public FileNamePropertyType getFileName() {
        return fileName;
    }

    /**
     * Sets the value of the fileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link FileNamePropertyType }
     *     
     */
    public void setFileName(FileNamePropertyType value) {
        this.fileName = value;
    }

    public boolean isSetFileName() {
        return (this.fileName!= null);
    }

    /**
     * Gets the value of the fileDescription property.
     * 
     * @return
     *     possible object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public CharacterStringPropertyType getFileDescription() {
        return fileDescription;
    }

    /**
     * Sets the value of the fileDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link CharacterStringPropertyType }
     *     
     */
    public void setFileDescription(CharacterStringPropertyType value) {
        this.fileDescription = value;
    }

    public boolean isSetFileDescription() {
        return (this.fileDescription!= null);
    }

    /**
     * Gets the value of the fileType property.
     * 
     * @return
     *     possible object is
     *     {@link MimeFileTypePropertyType }
     *     
     */
    public MimeFileTypePropertyType getFileType() {
        return fileType;
    }

    /**
     * Sets the value of the fileType property.
     * 
     * @param value
     *     allowed object is
     *     {@link MimeFileTypePropertyType }
     *     
     */
    public void setFileType(MimeFileTypePropertyType value) {
        this.fileType = value;
    }

    public boolean isSetFileType() {
        return (this.fileType!= null);
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
            FileNamePropertyType theFileName;
            theFileName = this.getFileName();
            strategy.appendField(locator, this, "fileName", buffer, theFileName);
        }
        {
            CharacterStringPropertyType theFileDescription;
            theFileDescription = this.getFileDescription();
            strategy.appendField(locator, this, "fileDescription", buffer, theFileDescription);
        }
        {
            MimeFileTypePropertyType theFileType;
            theFileType = this.getFileType();
            strategy.appendField(locator, this, "fileType", buffer, theFileType);
        }
        return buffer;
    }

}
