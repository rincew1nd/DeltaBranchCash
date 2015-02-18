package DBC;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class handler implements SOAPHandler<SOAPMessageContext> {

    static final String DESIRED_NS_PREFIX = "a";
    static final String DESIRED_NS_URI = "http://test/";
    static final String UNWANTED_NS_PREFIX = "ns2";
    
    @Override
    public Set<QName> getHeaders() {
       return null;
    }
    
    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        if ((boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)) { //Check here that the message being intercepted is an outbound message from your service, otherwise ignore.
            try {
                // Заносим всё в переменные
                SOAPEnvelope msg = context.getMessage().getSOAPPart().getEnvelope(); //get the SOAP Message envelope
                SOAPBody body = msg.getBody();
                
                // Удаляем соап хидер!
                SOAPHeader header = msg.getHeader();
                msg.removeChild(header);
                
                // Удаляем ненужный атрибуты из S:Envelope
                msg.removeAttribute("xmlns:SOAP-ENV");
                
                // Берем S:Body и выбераем StatusResult и outputParams
                Iterator iter = body.getChildElements();
                Object object = iter.next();
                SOAPElement element = (SOAPElement) object;
                
                // Удаляем атрибуты из StatusResult
                element.removeAttribute("xmlns:ns2");
                element.removeAttribute("xmlns:ns3");
                
                // Углубляемся в outputParams
                Iterator iter1 = element.getChildElements();
                while (iter1.hasNext()) {
                    Object object1 = iter1.next();
                    if (object1 instanceof SOAPElement) {
                        SOAPElement element1 = (SOAPElement) object1;
                        
                        // Меняем <OutputParams> на <a:outputParams xmlns:a="http://schemas.microsoft.com/2003/10/Serialization/Arrays">
                        if(element1.toString().equals("[OutputParams: null]"))
                        {
                            QName OutputParams = new QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "outputParams", "a");
                            element1.setElementQName(OutputParams);
                        }
                        
                        // В KeyValueOfstringstring и ставим всем деткам префикс a
                        Iterator iter2 = element1.getChildElements();
                        while (iter2.hasNext()) {
                            Object object2 = iter2.next();
                            if (object2 instanceof SOAPElement) {
                                SOAPElement element2 = (SOAPElement) object2;
                                element2.setPrefix("a");
                                Iterator iter3 = element2.getChildElements();
                                while (iter3.hasNext()) {
                                    Object object3 = iter3.next();
                                    if (object3 instanceof SOAPElement) {
                                        SOAPElement element3 = (SOAPElement) object3;
                                        element3.setPrefix("a");
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (SOAPException ex) {
                Logger.getLogger(handler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true; //indicates to the context to proceed with (normal)message processing
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
          //do nothing
       return true;
    }

    @Override
    public void close(MessageContext context) {
          //do nothing

    }
}