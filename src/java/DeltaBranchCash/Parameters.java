package DeltaBranchCash;

import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

public class Parameters {
    // transaction id
    long tran_id;
    // JAXBElement to store response/request
    JAXBElement<ArrayOfKeyValueOfstringstring> JAXBAOKVOSS;
    
    Parameters(){}
    
    void setParameters(long tran_id, ArrayOfKeyValueOfstringstring AOKVOSS)
    {
        this.tran_id = tran_id;
        JAXBAOKVOSS = JAXBElementOperations(AOKVOSS);
    }
    private JAXBElement<ArrayOfKeyValueOfstringstring> JAXBElementOperations(ArrayOfKeyValueOfstringstring AOKVOSS)
    {
        QName qname = new QName("http://tempuri.org/", "ArrayOfKeyValueOfstringstring");
        return new JAXBElement(qname, ArrayOfKeyValueOfstringstring.class, AOKVOSS);
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
