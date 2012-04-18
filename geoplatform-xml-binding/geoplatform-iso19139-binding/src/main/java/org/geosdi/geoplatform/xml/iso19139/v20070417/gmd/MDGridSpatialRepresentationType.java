//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.18 at 03:12:11 PM CEST 
//


package org.geosdi.geoplatform.xml.iso19139v20070417.gmd;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.geosdi.geoplatform.xml.iso19139v20070417.gco.BooleanPropertyType;
import org.geosdi.geoplatform.xml.iso19139v20070417.gco.IntegerPropertyType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * Types and numbers of raster spatial objects in the dataset
 * 
 * <p>Java class for MD_GridSpatialRepresentation_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MD_GridSpatialRepresentation_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.isotc211.org/2005/gmd}AbstractMD_SpatialRepresentation_Type">
 *       &lt;sequence>
 *         &lt;element name="numberOfDimensions" type="{http://www.isotc211.org/2005/gco}Integer_PropertyType"/>
 *         &lt;element name="axisDimensionProperties" type="{http://www.isotc211.org/2005/gmd}MD_Dimension_PropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cellGeometry" type="{http://www.isotc211.org/2005/gmd}MD_CellGeometryCode_PropertyType"/>
 *         &lt;element name="transformationParameterAvailability" type="{http://www.isotc211.org/2005/gco}Boolean_PropertyType"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MD_GridSpatialRepresentation_Type", propOrder = {
    "numberOfDimensions",
    "axisDimensionProperties",
    "cellGeometry",
    "transformationParameterAvailability"
})
@XmlSeeAlso({
    MDGeorectifiedType.class,
    MDGeoreferenceableType.class
})
public class MDGridSpatialRepresentationType
    extends AbstractMDSpatialRepresentationType
    implements ToString
{

    @XmlElement(required = true)
    protected IntegerPropertyType numberOfDimensions;
    protected List<MDDimensionPropertyType> axisDimensionProperties;
    @XmlElement(required = true)
    protected MDCellGeometryCodePropertyType cellGeometry;
    @XmlElement(required = true)
    protected BooleanPropertyType transformationParameterAvailability;

    /**
     * Gets the value of the numberOfDimensions property.
     * 
     * @return
     *     possible object is
     *     {@link IntegerPropertyType }
     *     
     */
    public IntegerPropertyType getNumberOfDimensions() {
        return numberOfDimensions;
    }

    /**
     * Sets the value of the numberOfDimensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegerPropertyType }
     *     
     */
    public void setNumberOfDimensions(IntegerPropertyType value) {
        this.numberOfDimensions = value;
    }

    public boolean isSetNumberOfDimensions() {
        return (this.numberOfDimensions!= null);
    }

    /**
     * Gets the value of the axisDimensionProperties property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the axisDimensionProperties property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAxisDimensionProperties().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MDDimensionPropertyType }
     * 
     * 
     */
    public List<MDDimensionPropertyType> getAxisDimensionProperties() {
        if (axisDimensionProperties == null) {
            axisDimensionProperties = new ArrayList<MDDimensionPropertyType>();
        }
        return this.axisDimensionProperties;
    }

    public boolean isSetAxisDimensionProperties() {
        return ((this.axisDimensionProperties!= null)&&(!this.axisDimensionProperties.isEmpty()));
    }

    public void unsetAxisDimensionProperties() {
        this.axisDimensionProperties = null;
    }

    /**
     * Gets the value of the cellGeometry property.
     * 
     * @return
     *     possible object is
     *     {@link MDCellGeometryCodePropertyType }
     *     
     */
    public MDCellGeometryCodePropertyType getCellGeometry() {
        return cellGeometry;
    }

    /**
     * Sets the value of the cellGeometry property.
     * 
     * @param value
     *     allowed object is
     *     {@link MDCellGeometryCodePropertyType }
     *     
     */
    public void setCellGeometry(MDCellGeometryCodePropertyType value) {
        this.cellGeometry = value;
    }

    public boolean isSetCellGeometry() {
        return (this.cellGeometry!= null);
    }

    /**
     * Gets the value of the transformationParameterAvailability property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanPropertyType }
     *     
     */
    public BooleanPropertyType getTransformationParameterAvailability() {
        return transformationParameterAvailability;
    }

    /**
     * Sets the value of the transformationParameterAvailability property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanPropertyType }
     *     
     */
    public void setTransformationParameterAvailability(BooleanPropertyType value) {
        this.transformationParameterAvailability = value;
    }

    public boolean isSetTransformationParameterAvailability() {
        return (this.transformationParameterAvailability!= null);
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
            IntegerPropertyType theNumberOfDimensions;
            theNumberOfDimensions = this.getNumberOfDimensions();
            strategy.appendField(locator, this, "numberOfDimensions", buffer, theNumberOfDimensions);
        }
        {
            List<MDDimensionPropertyType> theAxisDimensionProperties;
            theAxisDimensionProperties = (this.isSetAxisDimensionProperties()?this.getAxisDimensionProperties():null);
            strategy.appendField(locator, this, "axisDimensionProperties", buffer, theAxisDimensionProperties);
        }
        {
            MDCellGeometryCodePropertyType theCellGeometry;
            theCellGeometry = this.getCellGeometry();
            strategy.appendField(locator, this, "cellGeometry", buffer, theCellGeometry);
        }
        {
            BooleanPropertyType theTransformationParameterAvailability;
            theTransformationParameterAvailability = this.getTransformationParameterAvailability();
            strategy.appendField(locator, this, "transformationParameterAvailability", buffer, theTransformationParameterAvailability);
        }
        return buffer;
    }

    public void setAxisDimensionProperties(List<MDDimensionPropertyType> value) {
        this.axisDimensionProperties = null;
        List<MDDimensionPropertyType> draftl = this.getAxisDimensionProperties();
        draftl.addAll(value);
    }

}
