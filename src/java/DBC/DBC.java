/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBC;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.HandlerChain;

/**
 *
 * @author koryato
 */
@WebService(serviceName = "BranchCashWebService", portName = "BasicHttpBinding_IBranchCashWebService", endpointInterface = "org.tempuri.IBranchCashWebService", targetNamespace = "http://tempuri.org/", wsdlLocation = "META-INF/wsdl/DBC/BranchCashWebService.wsdl")
@Stateless
@HandlerChain(file="handler-chain.xml")
public class DBC {
    RegisterResponseGenerationLogic RGS = new RegisterResponseGenerationLogic();
    StatusResponseGenerationLogic SRGS = new StatusResponseGenerationLogic();

    public org.tempuri.RegisterResponse register(org.tempuri.Register parameters) {
        return RGS.Register(parameters);
    }

    // Status stub
    public org.tempuri.StatusResponse status(org.tempuri.Status parameters) {
        return SRGS.Status(parameters);
    }
    
    // Repeat stub
    public org.tempuri.RepeatResponse repeat(org.tempuri.Repeat parameters) {
        return RGS.Repeat(parameters);
    }
    
}
