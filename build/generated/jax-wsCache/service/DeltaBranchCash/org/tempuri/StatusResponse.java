
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="StatusResult" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="outputParams" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfKeyValueOfstringstring" minOccurs="0"/>
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
    "statusResult",
    "outputParams"
})
@XmlRootElement(name = "StatusResponse")
public class StatusResponse {

    @XmlElement(name = "StatusResult")
    protected Long statusResult;
    @XmlElementRef(name = "outputParams", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfKeyValueOfstringstring> outputParams;

    /**
     * Gets the value of the statusResult property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStatusResult() {
        return statusResult;
    }

    /**
     * Sets the value of the statusResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStatusResult(Long value) {
        this.statusResult = value;
    }

    /**
     * Gets the value of the outputParams property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfstringstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfKeyValueOfstringstring> getOutputParams() {
        return outputParams;
    }

    /**
     * Sets the value of the outputParams property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfKeyValueOfstringstring }{@code >}
     *     
     */
    public void setOutputParams(JAXBElement<ArrayOfKeyValueOfstringstring> value) {
        this.outputParams = value;
    }

}
