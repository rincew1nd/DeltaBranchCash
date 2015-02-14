package DeltaBranchCash;

import javax.ejb.Stateless;
import javax.jws.WebService;

@WebService(serviceName = "BranchCashWebService", portName = "BasicHttpBinding_IBranchCashWebService", endpointInterface = "org.tempuri.IBranchCashWebService", targetNamespace = "http://tempuri.org/", wsdlLocation = "META-INF/wsdl/DeltaBranchCash/BranchCashWebService.wsdl")
@Stateless
public class DeltaBranchCash {
    ResponseGenerationLogic RGS = new ResponseGenerationLogic();
    
    // Register stub
    public org.tempuri.RegisterResponse register(org.tempuri.Register parameters) {
        return RGS.Register(parameters);
    }

    // Status stub
    public org.tempuri.StatusResponse status(org.tempuri.Status parameters) {
        return RGS.Status(parameters);
    }
    
    // Repeat stub
    public org.tempuri.RepeatResponse repeat(org.tempuri.Repeat parameters) {
        return RGS.Repeat(parameters);
    }
}
