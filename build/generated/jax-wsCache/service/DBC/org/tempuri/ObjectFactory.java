
package org.tempuri;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import com.microsoft.schemas._2003._10.serialization.arrays.OutputParams;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.tempuri package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RegisterInputParameters_QNAME = new QName("http://tempuri.org/", "inputParameters");
    private final static QName _StatusResponseOutputParams_QNAME = new QName("http://tempuri.org/", "outputParams");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.tempuri
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Status }
     * 
     */
    public Status createStatus() {
        return new Status();
    }

    /**
     * Create an instance of {@link RegisterResponse }
     * 
     */
    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    /**
     * Create an instance of {@link Register }
     * 
     */
    public Register createRegister() {
        return new Register();
    }

    /**
     * Create an instance of {@link Repeat }
     * 
     */
    public Repeat createRepeat() {
        return new Repeat();
    }

    /**
     * Create an instance of {@link RepeatResponse }
     * 
     */
    public RepeatResponse createRepeatResponse() {
        return new RepeatResponse();
    }

    /**
     * Create an instance of {@link StatusResponse }
     * 
     */
    public StatusResponse createStatusResponse() {
        return new StatusResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutputParams }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "inputParameters", scope = Register.class)
    public JAXBElement<OutputParams> createRegisterInputParameters(OutputParams value) {
        return new JAXBElement<OutputParams>(_RegisterInputParameters_QNAME, OutputParams.class, Register.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OutputParams }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "outputParams", scope = StatusResponse.class)
    public JAXBElement<OutputParams> createStatusResponseOutputParams(OutputParams value) {
        return new JAXBElement<OutputParams>(_StatusResponseOutputParams_QNAME, OutputParams.class, StatusResponse.class, value);
    }

}
