/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeltaBranchCash;

import javax.ejb.Stateless;
import javax.jws.WebService;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring;
import java.util.Random;
import javax.xml.bind.JAXBElement;
import org.tempuri.RepeatResponse;
import org.tempuri.StatusResponse;

/**
 *
 * @author koryato
 */
@WebService(serviceName = "BranchCashWebService", portName = "BasicHttpBinding_IBranchCashWebService", endpointInterface = "org.tempuri.IBranchCashWebService", targetNamespace = "http://tempuri.org/", wsdlLocation = "META-INF/wsdl/DeltaBranchCash/BranchCashWebService.wsdl")
@Stateless
public class DeltaBranchCash {
    // Some helofull variables
    JAXBElement<ArrayOfKeyValueOfstringstring> JAXB_array;
    MySQL mysql_stmn = new MySQL();
    Random rnd = new Random();
    
    // Register stub
    public org.tempuri.RegisterResponse register(org.tempuri.Register parameters) {
        //Create a variable that store request parameters
        JAXB_array = parameters.getInputParameters();
        //Generate transaction id
        long tran_id = rnd.nextInt(999999);
        
        //Create and fill response
        org.tempuri.RegisterResponse response = new org.tempuri.RegisterResponse();
        response.setTranId(mysql_stmn.StoreParameters(tran_id, JAXB_array));
        response.setRegisterResult(0l);
        
        return response;
    }

    // Status stub
    public org.tempuri.StatusResponse status(org.tempuri.Status parameters) {
        // Create and fill response
        StatusResponse response = new StatusResponse();
        // Create params variable that store transaction id and response parameters
        Parameters params = mysql_stmn.GetParameters(parameters.getTranId());
        JAXB_array = params.JAXBAOKVOSS;
        response.setOutputParams(JAXB_array);
        response.setStatusResult(params.getTranId());
        
        return response;
    }
    
    // Repeat stub
    public org.tempuri.RepeatResponse repeat(org.tempuri.Repeat parameters) {
        // Create and fill response
        RepeatResponse response = new RepeatResponse();
        response.setRepeatResult(mysql_stmn.getStatus(parameters.getTranId()));
        
        return response;
    }

    /* Some not needed stuff. Store just for example
    private Long SaveParams(Register dParameters) {
        JAXBElement<ArrayOfKeyValueOfstringstring> params_JAXB_array;
        params_JAXB_array = dParameters.getInputParameters();
        ArrayOfKeyValueOfstringstring params_array;
        params_array = params_JAXB_array.getValue();
        List<ArrayOfKeyValueOfstringstring.KeyValueOfstringstring> params_list;
        params_list = params_array.getKeyValueOfstringstring();
        for (ArrayOfKeyValueOfstringstring.KeyValueOfstringstring params : params_list) {
            params.getKey();
            params.getValue();
        }
        
        return 120l;
    }
        
    private long GetStatus(Repeat transaction_id) {
        long RepeatResult = 0;
        if (transaction_id.getTranId() == 0)
            RepeatResult = 1;
        return RepeatResult;
    }
    */
}
