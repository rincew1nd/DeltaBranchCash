/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DeltaBranchCash;

import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring.KeyValueOfstringstring;
import java.util.Random;
import org.tempuri.RegisterResponse;
import org.tempuri.RepeatResponse;
import org.tempuri.StatusResponse;

/**
 *
 * @author koryato
 */
public class ResponseGenerationLogic {
    RequestValidation validator = new RequestValidation();
    MySQL sqlOperations = new MySQL();
    Random rnd = new Random();
        
    // Register response formation logic
    public RegisterResponse Register(org.tempuri.Register regParams)
    {   
        // Response variable
        RegisterResponse respParams = new RegisterResponse();
        // Array of key-value pars
        ArrayOfKeyValueOfstringstring AOKVOSS = regParams.getInputParameters().getValue();
        // Index of 'Type'
        int typeIndex=-1;
        // Generate transaction id
        long tran_id = rnd.nextInt(999999);
        // Variables to register response
        int AcceptedAmount = 0;
        int DispensedAmount = 0;
        String AcceptedCurrency = "";
        String DispensedCurrency = "";
        
        for (int i=0; i<AOKVOSS.size(); i++)
        {
            if (AOKVOSS.getValue(i).getKey().equals("Type"))
            {
                //System.out.print(i + " " + Integer.parseInt(AOKVOSS.getValue(i).getValue()) + " " + AOKVOSS.getValue(i).getValue());
                typeIndex=Integer.parseInt(AOKVOSS.getValue(i).getValue());
            }
        }
        
        if (typeIndex!=-1 && validator.RegisterRequest(typeIndex, AOKVOSS))
        {
            switch (typeIndex)
            {
                case 1:
                    System.out.print("Autorization");
                    sqlOperations.update("INSERT INTO TRAN_TYPE VALUES ('"+tran_id+"','1');");
                    break;
                case 2:
                    System.out.print("Report");
                    sqlOperations.update("INSERT INTO TRAN_TYPE VALUES ('"+tran_id+"','2');");
                    break;
                case 3:
                    System.out.print("Cash Issue");
                    for (int i=0; i<AOKVOSS.size(); i++)
                        if (AOKVOSS.getValue(i).getKey().equals("Amount"))
                            DispensedAmount=Integer.parseInt(AOKVOSS.getValue(i).getValue());
                    sqlOperations.update("INSERT INTO TRAN_TYPE VALUES ('"+tran_id+"','3');");
                    sqlOperations.update("INSERT INTO TRAN_DATA VALUES ('"+tran_id+"','DispensedAmount','"+DispensedAmount+"');");
                    break;
                case 4:
                    System.out.print("Cash Accept");
                    for (int i=0; i<AOKVOSS.size(); i++)
                    {
                        if (AOKVOSS.getValue(i).getKey().equals("Amount"))
                            AcceptedAmount=Integer.parseInt(AOKVOSS.getValue(i).getValue());
                        if (AOKVOSS.getValue(i).getKey().equals("TempocashAmount"))
                            DispensedAmount=Integer.parseInt(AOKVOSS.getValue(i).getValue());
                    }
                    sqlOperations.update("INSERT INTO TRAN_TYPE VALUES"
                                        + " ('"+tran_id+"','3');");
                    sqlOperations.update("INSERT INTO TRAN_DATA VALUES"
                                        + " ('"+tran_id+"','AcceptedAmount','"+AcceptedAmount+"'),"
                                        + " ('"+tran_id+"','DispensedAmount','"+DispensedAmount+"');");
                    break;
                case 5:
                    System.out.print("Incasation Validation");
                    for (int i=0; i<AOKVOSS.size(); i++)
                    {
                        if (AOKVOSS.getValue(i).getKey().equals("AvailableAmount"))
                            DispensedAmount=Integer.parseInt(AOKVOSS.getValue(i).getValue());
                        if (AOKVOSS.getValue(i).getKey().equals("Currency"))
                            DispensedCurrency=AOKVOSS.getValue(i).getValue();
                        if (AOKVOSS.getValue(i).getKey().equals("AvailableAmount"))
                            AcceptedAmount=Integer.parseInt(AOKVOSS.getValue(i).getValue());
                        if (AOKVOSS.getValue(i).getKey().equals("Currency"))
                            AcceptedCurrency=AOKVOSS.getValue(i).getValue();
                    }
                    sqlOperations.update("INSERT INTO TRAN_TYPE VALUES"
                                        + " ('"+tran_id+"','3');");
                    sqlOperations.update("INSERT INTO TRAN_DATA VALUES"
                                        + " ('"+tran_id+"','DispensedAmount','"+DispensedAmount+"'),"
                                        + " ('"+tran_id+"','DispensedCurrency','"+DispensedCurrency+"'),"
                                        + " ('"+tran_id+"','AcceptedAmount','"+AcceptedAmount+"'),"
                                        + " ('"+tran_id+"','AcceptedCurrency','"+AcceptedCurrency+"');");
                    break;
                default:
                    break;
            }
        } else {
            if(typeIndex==-1)
                respParams.setRegisterResult(501l);
            else
                respParams.setRegisterResult(1001l);
            return respParams;
        }
        respParams.setTranId(tran_id);
        respParams.setRegisterResult(0l);
        return respParams;
    }
    
    // Status response formation logic
    public StatusResponse Status(org.tempuri.Status regParams)
    {
        StatusResponse respParams = new StatusResponse();
        
        return respParams;
    }
    
    // Repeat response formation logic
    public RepeatResponse Repeat(org.tempuri.Repeat regParams)
    {
        RepeatResponse respParams = new RepeatResponse();
        
        return respParams;
    }
}
