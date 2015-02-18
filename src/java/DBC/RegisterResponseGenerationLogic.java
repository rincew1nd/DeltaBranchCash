package DBC;

import com.microsoft.schemas._2003._10.serialization.arrays.OutputParams;
import org.tempuri.RegisterResponse;
import org.tempuri.RepeatResponse;

public class RegisterResponseGenerationLogic {
    
    RegisterRequestValidation validator = new RegisterRequestValidation();
    MySQL sqlOperations = new MySQL();
    int typeIndex=-1;
    
    public long TransactionId(int type)
    {
        long tran_id = sqlOperations.maxTranId();
        sqlOperations.update("INSERT INTO TRAN_TYPE VALUES ('"+tran_id+"','"+type+"');");
        return tran_id;
    }
    
    // Register response formation logic
    public RegisterResponse Register(org.tempuri.Register regParams)
    {   
        // Response variable
        RegisterResponse respParams = new RegisterResponse();
        // Array of key-value pars
        OutputParams AOKVOSS = regParams.getInputParameters().getValue();
        // Index of 'Type'
        // Generate transaction id
        long tran_id = 0l;
        // Variables to register response
        int AcceptedAmount = 0;
        int DispensedAmount = 0;
        String Name = "";
        
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
            tran_id = TransactionId(typeIndex);
            switch (typeIndex)
            {
                case 1:
                    System.out.print("Autorization");
                    break;
                case 2:
                    System.out.print("Report");
                    for (int i=0; i<AOKVOSS.size(); i++)
                        if (AOKVOSS.getValue(i).getKey().equals("Name"))
                            Name=AOKVOSS.getValue(i).getValue();
                    sqlOperations.update("INSERT INTO TRAN_DATA VALUES"
                                        + " ('"+tran_id+"','Name','"+Name+"');");
                    break;
                case 3:
                    System.out.print("Cash Issue");
                    for (int i=0; i<AOKVOSS.size(); i++)
                        if (AOKVOSS.getValue(i).getKey().equals("Amount"))
                            DispensedAmount=Integer.parseInt(AOKVOSS.getValue(i).getValue());
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
                    sqlOperations.update("INSERT INTO TRAN_DATA VALUES"
                                        + " ('"+tran_id+"','AcceptedAmount','"+AcceptedAmount+"'),"
                                        + " ('"+tran_id+"','DispensedAmount','"+DispensedAmount+"');");
                    break;
                case 5:
                    System.out.print("Incasation Validation");
                    int AvailableAmountCount = 1;
                    int CurrencyCount = 1;
                    for (int i=0; i<AOKVOSS.size(); i++)
                    {
                        System.out.print("i");
                        if (AOKVOSS.getValue(i).getKey().equals("AvailableAmount"+AvailableAmountCount))
                        {
                            sqlOperations.update("INSERT INTO TRAN_DATA VALUES"
                                + " ('"+tran_id+"','DispensedAmount"+AvailableAmountCount+"','"+AOKVOSS.getValue(i).getValue()+"'),"
                                + " ('"+tran_id+"','AcceptedAmount"+AvailableAmountCount+"','"+AOKVOSS.getValue(i).getValue()+"');");
                            AvailableAmountCount++;
                        }
                        if (AOKVOSS.getValue(i).getKey().equals("Currency"+CurrencyCount))
                        {
                            sqlOperations.update("INSERT INTO TRAN_DATA VALUES"
                                + " ('"+tran_id+"','DispensedCurrency"+CurrencyCount+"','"+AOKVOSS.getValue(i).getValue()+"'),"
                                + " ('"+tran_id+"','AcceptedCurrency"+CurrencyCount+"','"+AOKVOSS.getValue(i).getValue()+"');");
                            CurrencyCount++;
                        }
                    }
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
    
    // Repeat response formation logic
    public RepeatResponse Repeat(org.tempuri.Repeat regParams)
    {
        RepeatResponse respParams = new RepeatResponse();
        
        return respParams;
    }
}
