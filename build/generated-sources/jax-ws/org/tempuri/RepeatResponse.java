
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="RepeatResult" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
    "repeatResult"
})
@XmlRootElement(name = "RepeatResponse")
public class RepeatResponse {

    @XmlElement(name = "RepeatResult")
    protected Long repeatResult;

    /**
     * Gets the value of the repeatResult property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRepeatResult() {
        return repeatResult;
    }

    /**
     * Sets the value of the repeatResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRepeatResult(Long value) {
        this.repeatResult = value;
    }

}
