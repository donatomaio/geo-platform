//
// Questo file è stato generato dall'architettura JavaTM per XML Binding (JAXB) Reference Implementation, v2.2.7 
// Vedere <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2015.06.18 alle 12:52:42 AM CEST 
//


package org.geosdi.geoplatform.xml.gml.v320;

import java.util.Collection;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.jvnet.jaxb2_commons.lang.CopyStrategy;
import org.jvnet.jaxb2_commons.lang.CopyTo;
import org.jvnet.jaxb2_commons.lang.Equals;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy;
import org.jvnet.jaxb2_commons.lang.HashCode;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBCopyStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBMergeStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.MergeFrom;
import org.jvnet.jaxb2_commons.lang.MergeStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Classe Java per ImageDatumType complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType name="ImageDatumType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/gml}AbstractDatumType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/gml}pixelInCell"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ImageDatumType", propOrder = {
    "pixelInCell"
})
public class ImageDatumType
    extends AbstractDatumType
    implements Cloneable, CopyTo, Equals, HashCode, MergeFrom, ToString
{

    @XmlElement(required = true)
    protected CodeWithAuthorityType pixelInCell;

    /**
     * Recupera il valore della proprietà pixelInCell.
     * 
     * @return
     *     possible object is
     *     {@link CodeWithAuthorityType }
     *     
     */
    public CodeWithAuthorityType getPixelInCell() {
        return pixelInCell;
    }

    /**
     * Imposta il valore della proprietà pixelInCell.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeWithAuthorityType }
     *     
     */
    public void setPixelInCell(CodeWithAuthorityType value) {
        this.pixelInCell = value;
    }

    public boolean isSetPixelInCell() {
        return (this.pixelInCell!= null);
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
            CodeWithAuthorityType thePixelInCell;
            thePixelInCell = this.getPixelInCell();
            strategy.appendField(locator, this, "pixelInCell", buffer, thePixelInCell);
        }
        return buffer;
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy strategy) {
        if (!(object instanceof ImageDatumType)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!super.equals(thisLocator, thatLocator, object, strategy)) {
            return false;
        }
        final ImageDatumType that = ((ImageDatumType) object);
        {
            CodeWithAuthorityType lhsPixelInCell;
            lhsPixelInCell = this.getPixelInCell();
            CodeWithAuthorityType rhsPixelInCell;
            rhsPixelInCell = that.getPixelInCell();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "pixelInCell", lhsPixelInCell), LocatorUtils.property(thatLocator, "pixelInCell", rhsPixelInCell), lhsPixelInCell, rhsPixelInCell)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public int hashCode(ObjectLocator locator, HashCodeStrategy strategy) {
        int currentHashCode = super.hashCode(locator, strategy);
        {
            CodeWithAuthorityType thePixelInCell;
            thePixelInCell = this.getPixelInCell();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "pixelInCell", thePixelInCell), currentHashCode, thePixelInCell);
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public Object clone() {
        return copyTo(createNewInstance());
    }

    public Object copyTo(Object target) {
        final CopyStrategy strategy = JAXBCopyStrategy.INSTANCE;
        return copyTo(null, target, strategy);
    }

    public Object copyTo(ObjectLocator locator, Object target, CopyStrategy strategy) {
        final Object draftCopy = ((target == null)?createNewInstance():target);
        super.copyTo(locator, draftCopy, strategy);
        if (draftCopy instanceof ImageDatumType) {
            final ImageDatumType copy = ((ImageDatumType) draftCopy);
            if (this.isSetPixelInCell()) {
                CodeWithAuthorityType sourcePixelInCell;
                sourcePixelInCell = this.getPixelInCell();
                CodeWithAuthorityType copyPixelInCell = ((CodeWithAuthorityType) strategy.copy(LocatorUtils.property(locator, "pixelInCell", sourcePixelInCell), sourcePixelInCell));
                copy.setPixelInCell(copyPixelInCell);
            } else {
                copy.pixelInCell = null;
            }
        }
        return draftCopy;
    }

    public Object createNewInstance() {
        return new ImageDatumType();
    }

    public void mergeFrom(Object left, Object right) {
        final MergeStrategy strategy = JAXBMergeStrategy.INSTANCE;
        mergeFrom(null, null, left, right, strategy);
    }

    public void mergeFrom(ObjectLocator leftLocator, ObjectLocator rightLocator, Object left, Object right, MergeStrategy strategy) {
        super.mergeFrom(leftLocator, rightLocator, left, right, strategy);
        if (right instanceof ImageDatumType) {
            final ImageDatumType target = this;
            final ImageDatumType leftObject = ((ImageDatumType) left);
            final ImageDatumType rightObject = ((ImageDatumType) right);
            {
                CodeWithAuthorityType lhsPixelInCell;
                lhsPixelInCell = leftObject.getPixelInCell();
                CodeWithAuthorityType rhsPixelInCell;
                rhsPixelInCell = rightObject.getPixelInCell();
                target.setPixelInCell(((CodeWithAuthorityType) strategy.merge(LocatorUtils.property(leftLocator, "pixelInCell", lhsPixelInCell), LocatorUtils.property(rightLocator, "pixelInCell", rhsPixelInCell), lhsPixelInCell, rhsPixelInCell)));
            }
        }
    }

    public ImageDatumType withPixelInCell(CodeWithAuthorityType value) {
        setPixelInCell(value);
        return this;
    }

    @Override
    public ImageDatumType withDomainOfValidity(DomainOfValidityElement value) {
        setDomainOfValidity(value);
        return this;
    }

    @Override
    public ImageDatumType withScope(String... values) {
        if (values!= null) {
            for (String value: values) {
                getScope().add(value);
            }
        }
        return this;
    }

    @Override
    public ImageDatumType withScope(Collection<String> values) {
        if (values!= null) {
            getScope().addAll(values);
        }
        return this;
    }

    @Override
    public ImageDatumType withAnchorDefinition(JAXBElement<CodeType> value) {
        setAnchorDefinition(value);
        return this;
    }

    @Override
    public ImageDatumType withRealizationEpoch(XMLGregorianCalendar value) {
        setRealizationEpoch(value);
        return this;
    }

    @Override
    public ImageDatumType withScope(List<String> value) {
        setScope(value);
        return this;
    }

    @Override
    public ImageDatumType withRemarks(String value) {
        setRemarks(value);
        return this;
    }

    @Override
    public ImageDatumType withMetaDataProperty(MetaDataPropertyType... values) {
        if (values!= null) {
            for (MetaDataPropertyType value: values) {
                getMetaDataProperty().add(value);
            }
        }
        return this;
    }

    @Override
    public ImageDatumType withMetaDataProperty(Collection<MetaDataPropertyType> values) {
        if (values!= null) {
            getMetaDataProperty().addAll(values);
        }
        return this;
    }

    @Override
    public ImageDatumType withDescription(StringOrRefType value) {
        setDescription(value);
        return this;
    }

    @Override
    public ImageDatumType withDescriptionReference(ReferenceType value) {
        setDescriptionReference(value);
        return this;
    }

    @Override
    public ImageDatumType withIdentifier(CodeWithAuthorityType value) {
        setIdentifier(value);
        return this;
    }

    @Override
    public ImageDatumType withName(CodeType... values) {
        if (values!= null) {
            for (CodeType value: values) {
                getName().add(value);
            }
        }
        return this;
    }

    @Override
    public ImageDatumType withName(Collection<CodeType> values) {
        if (values!= null) {
            getName().addAll(values);
        }
        return this;
    }

    @Override
    public ImageDatumType withId(String value) {
        setId(value);
        return this;
    }

    @Override
    public ImageDatumType withMetaDataProperty(List<MetaDataPropertyType> value) {
        setMetaDataProperty(value);
        return this;
    }

    @Override
    public ImageDatumType withName(List<CodeType> value) {
        setName(value);
        return this;
    }

}