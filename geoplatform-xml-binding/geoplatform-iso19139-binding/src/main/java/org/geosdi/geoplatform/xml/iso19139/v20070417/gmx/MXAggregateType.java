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
import javax.xml.bind.annotation.XmlType;
import org.geosdi.geoplatform.xml.iso19139v20070417.gmd.AbstractDSAggregateType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for MX_Aggregate_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MX_Aggregate_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.isotc211.org/2005/gmd}AbstractDS_Aggregate_Type">
 *       &lt;sequence>
 *         &lt;element name="aggregateCatalogue" type="{http://www.isotc211.org/2005/gmx}CT_Catalogue_PropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="aggregateFile" type="{http://www.isotc211.org/2005/gmx}MX_SupportFile_PropertyType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MX_Aggregate_Type", propOrder = {
    "aggregateCatalogue",
    "aggregateFile"
})
public class MXAggregateType
    extends AbstractDSAggregateType
    implements ToString
{

    protected List<CTCataloguePropertyType> aggregateCatalogue;
    protected List<MXSupportFilePropertyType> aggregateFile;

    /**
     * Gets the value of the aggregateCatalogue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aggregateCatalogue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAggregateCatalogue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CTCataloguePropertyType }
     * 
     * 
     */
    public List<CTCataloguePropertyType> getAggregateCatalogue() {
        if (aggregateCatalogue == null) {
            aggregateCatalogue = new ArrayList<CTCataloguePropertyType>();
        }
        return this.aggregateCatalogue;
    }

    public boolean isSetAggregateCatalogue() {
        return ((this.aggregateCatalogue!= null)&&(!this.aggregateCatalogue.isEmpty()));
    }

    public void unsetAggregateCatalogue() {
        this.aggregateCatalogue = null;
    }

    /**
     * Gets the value of the aggregateFile property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the aggregateFile property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAggregateFile().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MXSupportFilePropertyType }
     * 
     * 
     */
    public List<MXSupportFilePropertyType> getAggregateFile() {
        if (aggregateFile == null) {
            aggregateFile = new ArrayList<MXSupportFilePropertyType>();
        }
        return this.aggregateFile;
    }

    public boolean isSetAggregateFile() {
        return ((this.aggregateFile!= null)&&(!this.aggregateFile.isEmpty()));
    }

    public void unsetAggregateFile() {
        this.aggregateFile = null;
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
            List<CTCataloguePropertyType> theAggregateCatalogue;
            theAggregateCatalogue = (this.isSetAggregateCatalogue()?this.getAggregateCatalogue():null);
            strategy.appendField(locator, this, "aggregateCatalogue", buffer, theAggregateCatalogue);
        }
        {
            List<MXSupportFilePropertyType> theAggregateFile;
            theAggregateFile = (this.isSetAggregateFile()?this.getAggregateFile():null);
            strategy.appendField(locator, this, "aggregateFile", buffer, theAggregateFile);
        }
        return buffer;
    }

    public void setAggregateCatalogue(List<CTCataloguePropertyType> value) {
        this.aggregateCatalogue = null;
        List<CTCataloguePropertyType> draftl = this.getAggregateCatalogue();
        draftl.addAll(value);
    }

    public void setAggregateFile(List<MXSupportFilePropertyType> value) {
        this.aggregateFile = null;
        List<MXSupportFilePropertyType> draftl = this.getAggregateFile();
        draftl.addAll(value);
    }

}
