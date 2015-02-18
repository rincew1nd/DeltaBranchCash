package DBC;

import com.microsoft.schemas._2003._10.serialization.arrays.OutputParams;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class Parameters {
    // transaction id
    long tran_id;
    // JAXBElement to store response/request
    JAXBElement<OutputParams> JAXBAOKVOSS;
    
    Parameters(){}
    
    void setParameters(long tran_id, OutputParams AOKVOSS)
    {
        this.tran_id = tran_id;
        JAXBAOKVOSS = JAXBElementOperations(AOKVOSS);
    }
    private JAXBElement<OutputParams> JAXBElementOperations(OutputParams AOKVOSS)
    {
        QName qname = new QName("http://tempuri.org/", "outputParams");
        return new JAXBElement(qname, OutputParams.class, AOKVOSS);
    }
    
    // Get/set transaction id
    public void setTranId(long tran_id) { this.tran_id = tran_id; }
    public long getTranId() { return tran_id; }
    
    /*
    String key;
    String value;
    
    public void setKey(String key) { key = this.key; }
    public String getKey() { return key; }
    
    public void setValue(String value) { value = this.value; }
    public String getValue() { return value; }
    */

}
