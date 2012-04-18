//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.04.18 at 03:12:11 PM CEST 
//


package org.geosdi.geoplatform.xml.iso19139v20070417.gmd;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.geosdi.geoplatform.xml.iso19139v20070417.gco.BooleanPropertyType;
import org.geosdi.geoplatform.xml.iso19139v20070417.gco.IntegerPropertyType;
import org.geosdi.geoplatform.xml.iso19139v20070417.gco.RealPropertyType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * Information about an image's suitability for use
 * 
 * <p>Java class for MD_ImageDescription_Type complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MD_ImageDescription_Type">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.isotc211.org/2005/gmd}MD_CoverageDescription_Type">
 *       &lt;sequence>
 *         &lt;element name="illuminationElevationAngle" type="{http://www.isotc211.org/2005/gco}Real_PropertyType" minOccurs="0"/>
 *         &lt;element name="illuminationAzimuthAngle" type="{http://www.isotc211.org/2005/gco}Real_PropertyType" minOccurs="0"/>
 *         &lt;element name="imagingCondition" type="{http://www.isotc211.org/2005/gmd}MD_ImagingConditionCode_PropertyType" minOccurs="0"/>
 *         &lt;element name="imageQualityCode" type="{http://www.isotc211.org/2005/gmd}MD_Identifier_PropertyType" minOccurs="0"/>
 *         &lt;element name="cloudCoverPercentage" type="{http://www.isotc211.org/2005/gco}Real_PropertyType" minOccurs="0"/>
 *         &lt;element name="processingLevelCode" type="{http://www.isotc211.org/2005/gmd}MD_Identifier_PropertyType" minOccurs="0"/>
 *         &lt;element name="compressionGenerationQuantity" type="{http://www.isotc211.org/2005/gco}Integer_PropertyType" minOccurs="0"/>
 *         &lt;element name="triangulationIndicator" type="{http://www.isotc211.org/2005/gco}Boolean_PropertyType" minOccurs="0"/>
 *         &lt;element name="radiometricCalibrationDataAvailability" type="{http://www.isotc211.org/2005/gco}Boolean_PropertyType" minOccurs="0"/>
 *         &lt;element name="cameraCalibrationInformationAvailability" type="{http://www.isotc211.org/2005/gco}Boolean_PropertyType" minOccurs="0"/>
 *         &lt;element name="filmDistortionInformationAvailability" type="{http://www.isotc211.org/2005/gco}Boolean_PropertyType" minOccurs="0"/>
 *         &lt;element name="lensDistortionInformationAvailability" type="{http://www.isotc211.org/2005/gco}Boolean_PropertyType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MD_ImageDescription_Type", propOrder = {
    "illuminationElevationAngle",
    "illuminationAzimuthAngle",
    "imagingCondition",
    "imageQualityCode",
    "cloudCoverPercentage",
    "processingLevelCode",
    "compressionGenerationQuantity",
    "triangulationIndicator",
    "radiometricCalibrationDataAvailability",
    "cameraCalibrationInformationAvailability",
    "filmDistortionInformationAvailability",
    "lensDistortionInformationAvailability"
})
public class MDImageDescriptionType
    extends MDCoverageDescriptionType
    implements ToString
{

    protected RealPropertyType illuminationElevationAngle;
    protected RealPropertyType illuminationAzimuthAngle;
    protected MDImagingConditionCodePropertyType imagingCondition;
    protected MDIdentifierPropertyType imageQualityCode;
    protected RealPropertyType cloudCoverPercentage;
    protected MDIdentifierPropertyType processingLevelCode;
    protected IntegerPropertyType compressionGenerationQuantity;
    protected BooleanPropertyType triangulationIndicator;
    protected BooleanPropertyType radiometricCalibrationDataAvailability;
    protected BooleanPropertyType cameraCalibrationInformationAvailability;
    protected BooleanPropertyType filmDistortionInformationAvailability;
    protected BooleanPropertyType lensDistortionInformationAvailability;

    /**
     * Gets the value of the illuminationElevationAngle property.
     * 
     * @return
     *     possible object is
     *     {@link RealPropertyType }
     *     
     */
    public RealPropertyType getIlluminationElevationAngle() {
        return illuminationElevationAngle;
    }

    /**
     * Sets the value of the illuminationElevationAngle property.
     * 
     * @param value
     *     allowed object is
     *     {@link RealPropertyType }
     *     
     */
    public void setIlluminationElevationAngle(RealPropertyType value) {
        this.illuminationElevationAngle = value;
    }

    public boolean isSetIlluminationElevationAngle() {
        return (this.illuminationElevationAngle!= null);
    }

    /**
     * Gets the value of the illuminationAzimuthAngle property.
     * 
     * @return
     *     possible object is
     *     {@link RealPropertyType }
     *     
     */
    public RealPropertyType getIlluminationAzimuthAngle() {
        return illuminationAzimuthAngle;
    }

    /**
     * Sets the value of the illuminationAzimuthAngle property.
     * 
     * @param value
     *     allowed object is
     *     {@link RealPropertyType }
     *     
     */
    public void setIlluminationAzimuthAngle(RealPropertyType value) {
        this.illuminationAzimuthAngle = value;
    }

    public boolean isSetIlluminationAzimuthAngle() {
        return (this.illuminationAzimuthAngle!= null);
    }

    /**
     * Gets the value of the imagingCondition property.
     * 
     * @return
     *     possible object is
     *     {@link MDImagingConditionCodePropertyType }
     *     
     */
    public MDImagingConditionCodePropertyType getImagingCondition() {
        return imagingCondition;
    }

    /**
     * Sets the value of the imagingCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link MDImagingConditionCodePropertyType }
     *     
     */
    public void setImagingCondition(MDImagingConditionCodePropertyType value) {
        this.imagingCondition = value;
    }

    public boolean isSetImagingCondition() {
        return (this.imagingCondition!= null);
    }

    /**
     * Gets the value of the imageQualityCode property.
     * 
     * @return
     *     possible object is
     *     {@link MDIdentifierPropertyType }
     *     
     */
    public MDIdentifierPropertyType getImageQualityCode() {
        return imageQualityCode;
    }

    /**
     * Sets the value of the imageQualityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link MDIdentifierPropertyType }
     *     
     */
    public void setImageQualityCode(MDIdentifierPropertyType value) {
        this.imageQualityCode = value;
    }

    public boolean isSetImageQualityCode() {
        return (this.imageQualityCode!= null);
    }

    /**
     * Gets the value of the cloudCoverPercentage property.
     * 
     * @return
     *     possible object is
     *     {@link RealPropertyType }
     *     
     */
    public RealPropertyType getCloudCoverPercentage() {
        return cloudCoverPercentage;
    }

    /**
     * Sets the value of the cloudCoverPercentage property.
     * 
     * @param value
     *     allowed object is
     *     {@link RealPropertyType }
     *     
     */
    public void setCloudCoverPercentage(RealPropertyType value) {
        this.cloudCoverPercentage = value;
    }

    public boolean isSetCloudCoverPercentage() {
        return (this.cloudCoverPercentage!= null);
    }

    /**
     * Gets the value of the processingLevelCode property.
     * 
     * @return
     *     possible object is
     *     {@link MDIdentifierPropertyType }
     *     
     */
    public MDIdentifierPropertyType getProcessingLevelCode() {
        return processingLevelCode;
    }

    /**
     * Sets the value of the processingLevelCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link MDIdentifierPropertyType }
     *     
     */
    public void setProcessingLevelCode(MDIdentifierPropertyType value) {
        this.processingLevelCode = value;
    }

    public boolean isSetProcessingLevelCode() {
        return (this.processingLevelCode!= null);
    }

    /**
     * Gets the value of the compressionGenerationQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link IntegerPropertyType }
     *     
     */
    public IntegerPropertyType getCompressionGenerationQuantity() {
        return compressionGenerationQuantity;
    }

    /**
     * Sets the value of the compressionGenerationQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link IntegerPropertyType }
     *     
     */
    public void setCompressionGenerationQuantity(IntegerPropertyType value) {
        this.compressionGenerationQuantity = value;
    }

    public boolean isSetCompressionGenerationQuantity() {
        return (this.compressionGenerationQuantity!= null);
    }

    /**
     * Gets the value of the triangulationIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanPropertyType }
     *     
     */
    public BooleanPropertyType getTriangulationIndicator() {
        return triangulationIndicator;
    }

    /**
     * Sets the value of the triangulationIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanPropertyType }
     *     
     */
    public void setTriangulationIndicator(BooleanPropertyType value) {
        this.triangulationIndicator = value;
    }

    public boolean isSetTriangulationIndicator() {
        return (this.triangulationIndicator!= null);
    }

    /**
     * Gets the value of the radiometricCalibrationDataAvailability property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanPropertyType }
     *     
     */
    public BooleanPropertyType getRadiometricCalibrationDataAvailability() {
        return radiometricCalibrationDataAvailability;
    }

    /**
     * Sets the value of the radiometricCalibrationDataAvailability property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanPropertyType }
     *     
     */
    public void setRadiometricCalibrationDataAvailability(BooleanPropertyType value) {
        this.radiometricCalibrationDataAvailability = value;
    }

    public boolean isSetRadiometricCalibrationDataAvailability() {
        return (this.radiometricCalibrationDataAvailability!= null);
    }

    /**
     * Gets the value of the cameraCalibrationInformationAvailability property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanPropertyType }
     *     
     */
    public BooleanPropertyType getCameraCalibrationInformationAvailability() {
        return cameraCalibrationInformationAvailability;
    }

    /**
     * Sets the value of the cameraCalibrationInformationAvailability property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanPropertyType }
     *     
     */
    public void setCameraCalibrationInformationAvailability(BooleanPropertyType value) {
        this.cameraCalibrationInformationAvailability = value;
    }

    public boolean isSetCameraCalibrationInformationAvailability() {
        return (this.cameraCalibrationInformationAvailability!= null);
    }

    /**
     * Gets the value of the filmDistortionInformationAvailability property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanPropertyType }
     *     
     */
    public BooleanPropertyType getFilmDistortionInformationAvailability() {
        return filmDistortionInformationAvailability;
    }

    /**
     * Sets the value of the filmDistortionInformationAvailability property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanPropertyType }
     *     
     */
    public void setFilmDistortionInformationAvailability(BooleanPropertyType value) {
        this.filmDistortionInformationAvailability = value;
    }

    public boolean isSetFilmDistortionInformationAvailability() {
        return (this.filmDistortionInformationAvailability!= null);
    }

    /**
     * Gets the value of the lensDistortionInformationAvailability property.
     * 
     * @return
     *     possible object is
     *     {@link BooleanPropertyType }
     *     
     */
    public BooleanPropertyType getLensDistortionInformationAvailability() {
        return lensDistortionInformationAvailability;
    }

    /**
     * Sets the value of the lensDistortionInformationAvailability property.
     * 
     * @param value
     *     allowed object is
     *     {@link BooleanPropertyType }
     *     
     */
    public void setLensDistortionInformationAvailability(BooleanPropertyType value) {
        this.lensDistortionInformationAvailability = value;
    }

    public boolean isSetLensDistortionInformationAvailability() {
        return (this.lensDistortionInformationAvailability!= null);
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
            RealPropertyType theIlluminationElevationAngle;
            theIlluminationElevationAngle = this.getIlluminationElevationAngle();
            strategy.appendField(locator, this, "illuminationElevationAngle", buffer, theIlluminationElevationAngle);
        }
        {
            RealPropertyType theIlluminationAzimuthAngle;
            theIlluminationAzimuthAngle = this.getIlluminationAzimuthAngle();
            strategy.appendField(locator, this, "illuminationAzimuthAngle", buffer, theIlluminationAzimuthAngle);
        }
        {
            MDImagingConditionCodePropertyType theImagingCondition;
            theImagingCondition = this.getImagingCondition();
            strategy.appendField(locator, this, "imagingCondition", buffer, theImagingCondition);
        }
        {
            MDIdentifierPropertyType theImageQualityCode;
            theImageQualityCode = this.getImageQualityCode();
            strategy.appendField(locator, this, "imageQualityCode", buffer, theImageQualityCode);
        }
        {
            RealPropertyType theCloudCoverPercentage;
            theCloudCoverPercentage = this.getCloudCoverPercentage();
            strategy.appendField(locator, this, "cloudCoverPercentage", buffer, theCloudCoverPercentage);
        }
        {
            MDIdentifierPropertyType theProcessingLevelCode;
            theProcessingLevelCode = this.getProcessingLevelCode();
            strategy.appendField(locator, this, "processingLevelCode", buffer, theProcessingLevelCode);
        }
        {
            IntegerPropertyType theCompressionGenerationQuantity;
            theCompressionGenerationQuantity = this.getCompressionGenerationQuantity();
            strategy.appendField(locator, this, "compressionGenerationQuantity", buffer, theCompressionGenerationQuantity);
        }
        {
            BooleanPropertyType theTriangulationIndicator;
            theTriangulationIndicator = this.getTriangulationIndicator();
            strategy.appendField(locator, this, "triangulationIndicator", buffer, theTriangulationIndicator);
        }
        {
            BooleanPropertyType theRadiometricCalibrationDataAvailability;
            theRadiometricCalibrationDataAvailability = this.getRadiometricCalibrationDataAvailability();
            strategy.appendField(locator, this, "radiometricCalibrationDataAvailability", buffer, theRadiometricCalibrationDataAvailability);
        }
        {
            BooleanPropertyType theCameraCalibrationInformationAvailability;
            theCameraCalibrationInformationAvailability = this.getCameraCalibrationInformationAvailability();
            strategy.appendField(locator, this, "cameraCalibrationInformationAvailability", buffer, theCameraCalibrationInformationAvailability);
        }
        {
            BooleanPropertyType theFilmDistortionInformationAvailability;
            theFilmDistortionInformationAvailability = this.getFilmDistortionInformationAvailability();
            strategy.appendField(locator, this, "filmDistortionInformationAvailability", buffer, theFilmDistortionInformationAvailability);
        }
        {
            BooleanPropertyType theLensDistortionInformationAvailability;
            theLensDistortionInformationAvailability = this.getLensDistortionInformationAvailability();
            strategy.appendField(locator, this, "lensDistortionInformationAvailability", buffer, theLensDistortionInformationAvailability);
        }
        return buffer;
    }

}
