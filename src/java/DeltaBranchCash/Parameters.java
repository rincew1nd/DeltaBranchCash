package DeltaBranchCash;

import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring;
import javax.xml.bind.JAXBElement;

public class Parameters {
    long tran_id;
    JAXBElement<ArrayOfKeyValueOfstringstring> JAXBAOKVOSS;
    
    public void setTranId(long tran_id) { tran_id = this.tran_id; }
    public long getTranId() { return tran_id; }
    
    /*
    String key;
    String value;
    
    
    public void setKey(String key) { key = this.key; }
    public String getKey() { return key; }
    
    public void setValue(String value) { value = this.value; }
    public String getValue() { return value; }
    */

    void setJAXB(ArrayOfKeyValueOfstringstring AOKVOSS) {
        JAXBAOKVOSS.setValue(AOKVOSS);
    }
}
