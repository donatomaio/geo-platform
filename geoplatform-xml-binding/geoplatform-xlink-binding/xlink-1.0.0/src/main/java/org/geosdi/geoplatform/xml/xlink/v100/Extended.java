//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.11 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2017.11.30 alle 03:34:58 PM CET 
//


package org.geosdi.geoplatform.xml.xlink.v100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * 
 *                 Intended for use as the type of user-declared elements to make them extended links. Note that the
 *                 elements referenced in the content model are all abstract. The intention is that by simply declaring
 *                 elements with these as their substitutionGroup, all the right things will happen.
 *             
 * 
 * <p>Classe Java per extended complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="extended"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;group ref="{http://www.w3.org/1999/xlink}extendedModel" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;attGroup ref="{http://www.w3.org/1999/xlink}extendedAttrs"/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "extended", propOrder = {
    "extendedModel"
})
public class Extended implements ToString2
{

    @XmlElements({
        @XmlElement(name = "title", type = TitleEltType.class),
        @XmlElement(name = "resource", type = ResourceType.class),
        @XmlElement(name = "locator", type = LocatorType.class),
        @XmlElement(name = "arc", type = ArcType.class)
    })
    protected List<Object> extendedModel;
    /**
     * 
     * 
     */
    @XmlAttribute(name = "type", namespace = "http://www.w3.org/1999/xlink", required = true)
    public final static TypeType TYPE = TypeType.EXTENDED;
    @XmlAttribute(name = "role", namespace = "http://www.w3.org/1999/xlink")
    protected String role;
    @XmlAttribute(name = "title", namespace = "http://www.w3.org/1999/xlink")
    protected String title;

    /**
     * Gets the value of the extendedModel property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extendedModel property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtendedModel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TitleEltType }
     * {@link ResourceType }
     * {@link LocatorType }
     * {@link ArcType }
     * 
     * 
     */
    public List<Object> getExtendedModel() {
        if (extendedModel == null) {
            extendedModel = new ArrayList<Object>();
        }
        return this.extendedModel;
    }

    public boolean isSetExtendedModel() {
        return ((this.extendedModel!= null)&&(!this.extendedModel.isEmpty()));
    }

    public void unsetExtendedModel() {
        this.extendedModel = null;
    }

    /**
     * Recupera il valore della proprietà role.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRole() {
        return role;
    }

    /**
     * Imposta il valore della proprietà role.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole(String value) {
        this.role = value;
    }

    public boolean isSetRole() {
        return (this.role!= null);
    }

    /**
     * Recupera il valore della proprietà title.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Imposta il valore della proprietà title.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    public boolean isSetTitle() {
        return (this.title!= null);
    }

    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        {
            List<Object> theExtendedModel;
            theExtendedModel = (this.isSetExtendedModel()?this.getExtendedModel():null);
            strategy.appendField(locator, this, "extendedModel", buffer, theExtendedModel, this.isSetExtendedModel());
        }
        {
            TypeType theTYPE;
            theTYPE = Extended.TYPE;
            strategy.appendField(locator, this, "type", buffer, theTYPE, true);
        }
        {
            String theRole;
            theRole = this.getRole();
            strategy.appendField(locator, this, "role", buffer, theRole, this.isSetRole());
        }
        {
            String theTitle;
            theTitle = this.getTitle();
            strategy.appendField(locator, this, "title", buffer, theTitle, this.isSetTitle());
        }
        return buffer;
    }

    public void setExtendedModel(List<Object> value) {
        this.extendedModel = null;
        if (value!= null) {
            List<Object> draftl = this.getExtendedModel();
            draftl.addAll(value);
        }
    }

}