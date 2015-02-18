package DBC;

import com.microsoft.schemas._2003._10.serialization.arrays.OutputParams;
import java.sql.ResultSet;

public class RegisterRequestValidation {
    
    ResultSet rs = null;
    
    // Validation of register request
    public boolean RegisterRequest(int typeIndex, OutputParams AOKVOSS)
    {
        /*
        <arr:Key>Type</arr:Key>
        */
        switch(typeIndex)
        {
            case 1:
                if(AuthorizationValidation(AOKVOSS) == false) return false;
                break;
            case 2:
                if(ReportValidation(AOKVOSS) == false) return false;
                break;
            case 3:
                if(CashIssueValidation(AOKVOSS) == false) return false;
                break;
            case 4:
                if(CashAcceptValidation(AOKVOSS) == false) return false;
                break;
            case 5:
                if(IncasationValidation(AOKVOSS) == false) return false;
                break;
            default:
                return false;
        }
        return true;
    }
    
    // Authorization request validation
    private boolean AuthorizationValidation(OutputParams AOKVOSS)
    {
        /*
        <arr:Key>Type</arr:Key>
        <arr:Key>WorkplaceId</arr:Key>
        <arr:Key>SafeId</arr:Key>
        <arr:Key>CashierId</arr:Key>
        <arr:Key>CashierName</arr:Key>
        <arr:Key>BranchId</arr:Key>
        */
        System.out.print("AuthorizationValidation");
        return true;
    }
    
    // Print report request validation. Switch case to other reports
    private boolean ReportValidation(OutputParams AOKVOSS)
    {
        /*
        <arr:Key>Type</arr:Key>
        <arr:Key>Name</arr:Key>
        .......................
        */
        System.out.print("ReportValidation");
        
        for (int i=0; i<AOKVOSS.size(); i++)
        {
            System.out.print("1 " + AOKVOSS.getValue(i).getKey() + " " + AOKVOSS.getValue(i).getValue());
            if(AOKVOSS.getValue(i).getKey().equals("Name"))
            {
                System.out.print("2 " + AOKVOSS.getValue(i).getKey() + " " + AOKVOSS.getValue(i).getValue());
                if(AOKVOSS.getValue(i).getValue().equals("REPL_LOAD") ||
                    AOKVOSS.getValue(i).getValue().equals("REPL_UNLOAD") ||
                    AOKVOSS.getValue(i).getValue().equals("SAFE_OPERATIONS") ||
                    AOKVOSS.getValue(i).getValue().equals("SAFE_TOTALS") ||
                    AOKVOSS.getValue(i).getValue().equals("SAFE_STATE")
                    )
                    return true;
                else return false;
            }
        }
        return true;
    }
    
    // Cash issue validation
    private boolean CashIssueValidation(OutputParams AOKVOSS)
    {
        /*
        <arr:Key>Type</arr:Key>
        <arr:Key>CashierId</arr:Key>
        <arr:Key>Currency</arr:Key>
        <arr:Key>Amount</arr:Key>
        <arr:Key>TempocashAmount</arr:Key>
        <arr:Key>ExternalId</arr:Key>
        */
        System.out.print("CashIssueValidation");
        
        for (int i=0; i<AOKVOSS.size(); i++)
        {
            if (AOKVOSS.getValue(i).getKey().equals("Amount"))
                return true;
        }
        return false;
    }
    
    // 
    private boolean CashAcceptValidation(OutputParams AOKVOSS)
    {
        /*
        <arr:Key>Type</arr:Key>
        <arr:Key>CashierId</arr:Key>
        <arr:Key>Currency</arr:Key>
        <arr:Key>Amount</arr:Key>
        <arr:Key>TempocashAmount</arr:Key>
        <arr:Key>ExternalId</arr:Key>
        */
        System.out.print("CashAcceptValidation");
        int result = 0;
        for (int i=1; i<AOKVOSS.size(); i++)
        {
            if (AOKVOSS.getValue(i).getKey().equals("Amount"))
                result++;
            if (AOKVOSS.getValue(i).getKey().equals("TempocashAmount"))
                result++;
        }
        return result == 2;
    }
    
    //IncasationValidation
    private boolean IncasationValidation(OutputParams AOKVOSS)
    {
        /*
        <arr:Key>Type</arr:Key>
        <arr:Key>CashierId</arr:Key>
        <arr:Key>SafeId</arr:Key>
        <arr:Key>ReplenishmentType</arr:Key>
        <arr:Key>UseDepositeCassette</arr:Key>
        <arr:Key>ExternalId</arr:Key>
        <arr:Key>AvailableAmount</arr:Key>
        <arr:Key>Currency</arr:Key>
        */
        System.out.print("IncasationValidation");
        int result = 0;
        for (int i=1; i<AOKVOSS.size(); i++)
        {
            if (AOKVOSS.getValue(i).getKey().equals("AvailableAmount1"))
                result++;
            if (AOKVOSS.getValue(i).getKey().equals("Currency1"))
                result++;
        }
        return result == 2;
    }
}
