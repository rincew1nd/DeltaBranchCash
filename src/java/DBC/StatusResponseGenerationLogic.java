/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBC;

import com.microsoft.schemas._2003._10.serialization.arrays.OutputParams;
import com.microsoft.schemas._2003._10.serialization.arrays.OutputParams.KeyValueOfstringstring;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import org.tempuri.StatusResponse;

/**
 *
 * @author lttester10
 */
public class StatusResponseGenerationLogic {
    int typeIndex=-1;
    
    Connection conn = null;
    Statement stmn = null;
    ResultSet rs = null;
    String URI = "jdbc:mysql://localhost:3307/delta_stubs";
    String User = "root";
    String Password = "root";
    
    public StatusResponse Status(org.tempuri.Status regParams)
    {
        StatusResponse respParams = new StatusResponse();
        respParams.setStatusResult(0l);
        
        ResultSet rs = null;
        
        JAXBElement<OutputParams> JAXBAOKVOSS;
        OutputParams AOKVOSS = new OutputParams();
        KeyValueOfstringstring KVOSS;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URI, User, Password);
            stmn = conn.createStatement();
            
            rs = stmn.executeQuery("SELECT TYPE FROM TRAN_TYPE WHERE TRAN_ID="+regParams.getTranId()+";");
            while(rs.next())
            {
                typeIndex = rs.getInt("type");
            }
            rs.close();
            
            if (typeIndex != 0)
            {
                switch(typeIndex)
                {
                    case 1:
                        /*
                        <StatusResult>0</StatusResult>
                        */
                        break;
                    case 2:
                        /*
                        <StatusResult>0</StatusResult>
                        <outputParams xmlns:a="http://schemas.microsoft.com/2003/10/Serialization/Arrays" xmlns:i="http://www.w3.org/2001/XMLSchema-instance">
                            <a:KeyValueOfstringstring>
                                <a:Key>ReportPath</a:Key>
                                <a:Value>SAFE_OPERATIONS_20150211112030_25E4.pdf</a:Value>
                            </a:KeyValueOfstringstring>
                        </outputParams>
                        */
                        KVOSS = new KeyValueOfstringstring();
                        rs = stmn.executeQuery("SELECT * FROM TRAN_DATA"
                                + " WHERE TRAN_ID = "+ regParams.getTranId() +";");
                        rs.next();
                        
                        KVOSS.setKey("ReportPath");
                        
                        switch (rs.getString("value"))
                        {
                            case "REPL_LOAD":
                                KVOSS.setValue("REPL_LOAD_20141118152850_4CC.pdf");
                                break;
                            case "REPL_UNLOAD":
                                KVOSS.setValue("REPL_UNLOAD_20141119110347_4CC.pdf");
                                break;
                            case "SAFE_OPERATIONS":
                                KVOSS.setValue("SAFE_OPERATIONS_20141120133203_4CC.pdf");
                                break;
                            case "SAFE_TOTALS":
                                KVOSS.setValue("SAFE_TOTALS_20141120141902_4CC.pdf");
                                break;
                            case "SAFE_STATE":
                                KVOSS.setValue("SAFE_STATE_20141119144311_4CC.pdf");
                                break;
                            default:
                                break;
                        }
                
                        AOKVOSS.add(KVOSS);
                        break;
                    case 3:
                        /*
                        <StatusResult>0</StatusResult>
                        <outputParams xmlns:a="http://schemas.microsoft.com/2003/10/Serialization/Arrays" xmlns:i="http://www.w3.org/2001/XMLSchema-instance">
                            <a:KeyValueOfstringstring>
                                <a:Key>DispensedAmount</a:Key>
                                <a:Value>1630000</a:Value>
                            </a:KeyValueOfstringstring>
                        </outputParams>
                        */
                        KVOSS = new KeyValueOfstringstring();
                        KVOSS.setKey("DispensedAmount");
                        
                        rs = stmn.executeQuery("SELECT * FROM TRAN_DATA"
                                + " WHERE TRAN_ID = "+ regParams.getTranId() +";");
                        
                        while (rs.next())
                        {
                            if (rs.getString("key").equals("DispensedAmount"))
                            {
                                KVOSS.setValue(rs.getString("value"));
                                break;
                            }
                        }
                        AOKVOSS.add(KVOSS);
                        break;
                    case 4:
                        /*
                        <StatusResult>0</StatusResult>
                        <outputParams xmlns:a="http://schemas.microsoft.com/2003/10/Serialization/Arrays" xmlns:i="http://www.w3.org/2001/XMLSchema-instance">
                            <a:KeyValueOfstringstring>
                                <a:Key>AcceptedAmount</a:Key>
                                <a:Value>1630000</a:Value>
                            </a:KeyValueOfstringstring>
                            <a:KeyValueOfstringstring>
                                <a:Key>DispensedAmount</a:Key>
                                <a:Value>0</a:Value>
                            </a:KeyValueOfstringstring>
                        </outputParams>
                        */
                        
                        rs = stmn.executeQuery("SELECT * FROM TRAN_DATA"
                                + " WHERE TRAN_ID = "+ regParams.getTranId() +";");
                        while (rs.next())
                        {
                            if (rs.getString("key").equals("DispensedAmount"))
                            {
                                KVOSS = new KeyValueOfstringstring();
                                KVOSS.setKey("DispensedAmount");
                                KVOSS.setValue(rs.getString("value"));
                                AOKVOSS.add(KVOSS);
                            }
                            if (rs.getString("key").equals("AcceptedAmount"))
                            {
                                KVOSS = new KeyValueOfstringstring();
                                KVOSS.setKey("AcceptedAmount");
                                KVOSS.setValue(rs.getString("value"));
                                AOKVOSS.add(KVOSS);
                            }
                        }
                        
                        break;
                    case 5:
                        /*
                        <StatusResult>0</StatusResult>
                        <outputParams xmlns:a="http://schemas.microsoft.com/2003/10/Serialization/Arrays" xmlns:i="http://www.w3.org/2001/XMLSchema-instance">
                            <a:KeyValueOfstringstring>
                                <a:Key>AcceptedAmount</a:Key>
                                <a:Value>1630000</a:Value>
                            </a:KeyValueOfstringstring>
                            <a:KeyValueOfstringstring>
                                <a:Key>AcceptedCurrency</a:Key>
                                <a:Value>RUB</a:Value>
                            </a:KeyValueOfstringstring>
                            <a:KeyValueOfstringstring>
                                <a:Key>DispensedAmount</a:Key>
                                <a:Value>0</a:Value>
                            </a:KeyValueOfstringstring>
                            <a:KeyValueOfstringstring>
                                <a:Key>DispensedCurrency</a:Key>
                                <a:Value>RUB</a:Value>
                            </a:KeyValueOfstringstring>
                        </outputParams>
                        */
                        int AvailableAmountCount = 1;
                        int DispensedAmountCount = 1;
                        int AcceptedCurrencyCount = 1;
                        int DispensedCurrencyCount = 1;
                        
                        rs = stmn.executeQuery("SELECT * FROM TRAN_DATA"
                                + " WHERE TRAN_ID = "+ regParams.getTranId() +";");
                        
                        while (rs.next())
                        {
                            if (rs.getString("key").equals("AcceptedAmount"+AvailableAmountCount))
                            {
                                KVOSS = new KeyValueOfstringstring();
                                KVOSS.setKey(rs.getString("key"));
                                KVOSS.setValue(rs.getString("value"));
                                AOKVOSS.add(KVOSS);
                                AvailableAmountCount++;
                            } else if (rs.getString("key").equals("AcceptedCurrency"+AcceptedCurrencyCount))
                            {
                                KVOSS = new KeyValueOfstringstring();
                                KVOSS.setKey(rs.getString("key"));
                                KVOSS.setValue(rs.getString("value"));
                                AOKVOSS.add(KVOSS);
                                AcceptedCurrencyCount++;
                            } else if (rs.getString("key").equals("DispensedAmount"+DispensedAmountCount))
                            {
                                KVOSS = new KeyValueOfstringstring();
                                KVOSS.setKey(rs.getString("key"));
                                KVOSS.setValue(rs.getString("value"));
                                AOKVOSS.add(KVOSS);
                                DispensedAmountCount++;
                            } else if (rs.getString("key").equals("DispensedCurrency"+DispensedCurrencyCount))
                            {
                                KVOSS = new KeyValueOfstringstring();
                                KVOSS.setKey(rs.getString("key"));
                                KVOSS.setValue(rs.getString("value"));
                                AOKVOSS.add(KVOSS);
                                DispensedCurrencyCount++;
                            }
                        }
                        break;
                    default:
                        respParams.setStatusResult(404l);
                        break;
                }
                //System.out.print(AOKVOSS.getValue(0).getKey() + "" + AOKVOSS.getValue(0).getValue());
                
                JAXBAOKVOSS = JAXBElementOperations(AOKVOSS);
                respParams.setOutputParams(JAXBAOKVOSS);
            } else {
                respParams.setStatusResult(1001l);
            }
            
            stmn.close();
            conn.close();
        }
        catch(Exception ex)
        {
            System.out.print("Error in generating Status response: "+ex.getMessage()+"!");
            respParams.setStatusResult(501l);
        }
        
        return respParams;
    }
    
    private JAXBElement<OutputParams> JAXBElementOperations(OutputParams AOKVOSS)
    {
        QName qname = new QName("http://tempuri.org/", "OutputParams");
        return new JAXBElement(qname, OutputParams.class, AOKVOSS);
    }
}
