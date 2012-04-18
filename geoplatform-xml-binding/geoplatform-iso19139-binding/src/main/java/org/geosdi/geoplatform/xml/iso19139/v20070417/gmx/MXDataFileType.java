//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.18 at 03:12:11 PM CEST 
//


package org.geosdi.geoplatform.xml.iso19139v20070417.gmx;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.geosdi.geoplatform.xml.iso19139v20070417.gco.GenericNamePropertyType;
import org.geosdi.geoplatform.xml.iso19139v20070417.gmd.MDFormatPropertyType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for MX_DataFile_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MX_DataFile_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.isotc211.org/2005/gmx}AbstractMX_File_Type">
 *       &lt;sequence>
 *         &lt;element name="featureTypes" type="{http://www.isotc211.org/2005/gco}GenericName_PropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fileFormat" type="{http://www.isotc211.org/2005/gmd}MD_Format_PropertyType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MX_DataFile_Type", propOrder = {
    "featureTypes",
    "fileFormat"
})
public class MXDataFileType
    extends AbstractMXFileType
    implements ToString
{

    protected List<GenericNamePropertyType> featureTypes;
    @XmlElement(required = true)
    protected MDFormatPropertyType fileFormat;

    /**
     * Gets the value of the featureTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the featureTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFeatureTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericNamePropertyType }
     * 
     * 
     */
    public List<GenericNamePropertyType> getFeatureTypes() {
        if (featureTypes == null) {
            featureTypes = new ArrayList<GenericNamePropertyType>();
        }
        return this.featureTypes;
    }

    public boolean isSetFeatureTypes() {
        return ((this.featureTypes!= null)&&(!this.featureTypes.isEmpty()));
    }

    public void unsetFeatureTypes() {
        this.featureTypes = null;
    }

    /**
     * Gets the value of the fileFormat property.
     * 
     * @return
     *     possible object is
     *     {@link MDFormatPropertyType }
     *     
     */
    public MDFormatPropertyType getFileFormat() {
        return fileFormat;
    }

    /**
     * Sets the value of the fileFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link MDFormatPropertyType }
     *     
     */
    public void setFileFormat(MDFormatPropertyType value) {
        this.fileFormat = value;
    }

    public boolean isSetFileFormat() {
        return (this.fileFormat!= null);
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
            List<GenericNamePropertyType> theFeatureTypes;
            theFeatureTypes = (this.isSetFeatureTypes()?this.getFeatureTypes():null);
            strategy.appendField(locator, this, "featureTypes", buffer, theFeatureTypes);
        }
        {
            MDFormatPropertyType theFileFormat;
            theFileFormat = this.getFileFormat();
            strategy.appendField(locator, this, "fileFormat", buffer, theFileFormat);
        }
        return buffer;
    }

    public void setFeatureTypes(List<GenericNamePropertyType> value) {
        this.featureTypes = null;
        List<GenericNamePropertyType> draftl = this.getFeatureTypes();
        draftl.addAll(value);
    }

}
