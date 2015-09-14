//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.7 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2015.08.25 alle 11:12:35 PM CEST 
//


package org.geosdi.geoplatform.xml.sld.v100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
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
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/sld}Name"/>
 *         &lt;element ref="{http://www.opengis.net/sld}LayerFeatureConstraints" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{http://www.opengis.net/sld}NamedStyle"/>
 *           &lt;element ref="{http://www.opengis.net/sld}UserStyle"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "name",
    "layerFeatureConstraints",
    "namedStyleOrUserStyle"
})
@XmlRootElement(name = "NamedLayer")
public class NamedLayerElement implements ToString
{

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "LayerFeatureConstraints")
    protected LayerFeatureConstraintsElement layerFeatureConstraints;
    @XmlElements({
        @XmlElement(name = "NamedStyle", type = NamedStyleElement.class),
        @XmlElement(name = "UserStyle", type = UserStyleElement.class)
    })
    protected List<Object> namedStyleOrUserStyle;

    /**
     * Recupera il valore della proprietà name.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Imposta il valore della proprietà name.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Recupera il valore della proprietà layerFeatureConstraints.
     * 
     * @return
     *     possible object is
     *     {@link LayerFeatureConstraintsElement }
     *     
     */
    public LayerFeatureConstraintsElement getLayerFeatureConstraints() {
        return layerFeatureConstraints;
    }

    /**
     * Imposta il valore della proprietà layerFeatureConstraints.
     * 
     * @param value
     *     allowed object is
     *     {@link LayerFeatureConstraintsElement }
     *     
     */
    public void setLayerFeatureConstraints(LayerFeatureConstraintsElement value) {
        this.layerFeatureConstraints = value;
    }

    public boolean isSetLayerFeatureConstraints() {
        return (this.layerFeatureConstraints!= null);
    }

    /**
     * Gets the value of the namedStyleOrUserStyle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the namedStyleOrUserStyle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNamedStyleOrUserStyle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NamedStyleElement }
     * {@link UserStyleElement }
     * 
     * 
     */
    public List<Object> getNamedStyleOrUserStyle() {
        if (namedStyleOrUserStyle == null) {
            namedStyleOrUserStyle = new ArrayList<Object>();
        }
        return this.namedStyleOrUserStyle;
    }

    public boolean isSetNamedStyleOrUserStyle() {
        return ((this.namedStyleOrUserStyle!= null)&&(!this.namedStyleOrUserStyle.isEmpty()));
    }

    public void unsetNamedStyleOrUserStyle() {
        this.namedStyleOrUserStyle = null;
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
            String theName;
            theName = this.getName();
            strategy.appendField(locator, this, "name", buffer, theName);
        }
        {
            LayerFeatureConstraintsElement theLayerFeatureConstraints;
            theLayerFeatureConstraints = this.getLayerFeatureConstraints();
            strategy.appendField(locator, this, "layerFeatureConstraints", buffer, theLayerFeatureConstraints);
        }
        {
            List<Object> theNamedStyleOrUserStyle;
            theNamedStyleOrUserStyle = (this.isSetNamedStyleOrUserStyle()?this.getNamedStyleOrUserStyle():null);
            strategy.appendField(locator, this, "namedStyleOrUserStyle", buffer, theNamedStyleOrUserStyle);
        }
        return buffer;
    }

    public void setNamedStyleOrUserStyle(List<Object> value) {
        this.namedStyleOrUserStyle = null;
        List<Object> draftl = this.getNamedStyleOrUserStyle();
        draftl.addAll(value);
    }

}