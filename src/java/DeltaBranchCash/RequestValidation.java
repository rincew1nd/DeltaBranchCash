package DeltaBranchCash;

import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring;

public class RequestValidation {
    
    // Validation of register request
    public boolean RegisterRequest(int typeIndex, ArrayOfKeyValueOfstringstring AOKVOSS)
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
    private boolean AuthorizationValidation(ArrayOfKeyValueOfstringstring AOKVOSS)
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
        String keys[] = {"Type","WorkplaceId","SafeId","SafeSide","CashierId","CashierName","BranchId","ExternalId"};
        if (AOKVOSS.size() == keys.length)
        {
            for (int i=1; i<AOKVOSS.size(); i++)
            {
                //System.out.print("for");
                if (!AOKVOSS.getValue(i).getKey().equals(keys[i]))
                    return false;
            }
        } else return false;
        return true;
    }
    
    // Print report request validation. Switch case to other reports
    private boolean ReportValidation(ArrayOfKeyValueOfstringstring AOKVOSS)
    {
        /*
        <arr:Key>Type</arr:Key>
        <arr:Key>Name</arr:Key>
        .......................
        */
        System.out.print("ReportValidation");
        if(AOKVOSS.getValue(1).getKey().equals("Name"))
        {
            switch(AOKVOSS.getValue(1).getValue())
            {
                case "REPL_LOAD":
                    if(LoadValidationVal(AOKVOSS) == false) return false;
                    break;
                case "REPL_UNLOAD":
                    if(UnLoadValidationVal(AOKVOSS) == false) return false;
                    break;
                case "SAFE_OPERATIONS":
                    if(OperationProtocoolVal(AOKVOSS) == false) return false;
                    break;
                case "SAFE_TOTALS":
                    if(TurnProtocoolVal(AOKVOSS) == false) return false;
                    break;
                case "SAFE_STATE":
                    if(ResidueVal(AOKVOSS) == false) return false;
                    break;
                default:
                    return false;
            }
        } else {
            return false;
        }
        return true;
    }
    // Drum load report
    private boolean LoadValidationVal(ArrayOfKeyValueOfstringstring AOKVOSS)
    {
        /*
        <arr:Key>Type</arr:Key>
        <arr:Key>Name</arr:Key>
        <arr:Key>ReplExternalId</arr:Key>
        */
        String keys[] = {"Type","Name","ReplExternalId"};
        if (AOKVOSS.size() == keys.length)
        {
            for (int i=1; i<AOKVOSS.size(); i++)
            {
                if (!AOKVOSS.getValue(i).getKey().equals(keys[i]))
                    return false;
            }
        } else return false;
        return true;  
    }
    // Drum unload report
    private boolean UnLoadValidationVal(ArrayOfKeyValueOfstringstring AOKVOSS)
    {
        /*
        <arr:Key>Type</arr:Key>
        <arr:Key>Name</arr:Key>
        <arr:Key>ReplExternalId</arr:Key>
        */
        String keys[] = {"Type","Name","ReplExternalId"};
        if (AOKVOSS.size() == keys.length)
        {
            for (int i=1; i<AOKVOSS.size(); i++)
            {
                if (!AOKVOSS.getValue(i).getKey().equals(keys[i]))
                    return false;
            }
        } else return false;
        return true; 
     }
    // TCD/TCR operation protocol
    private boolean OperationProtocoolVal(ArrayOfKeyValueOfstringstring AOKVOSS)
    {
        /*
        <arr:Key>Type</arr:Key>
        <arr:Key>Name</arr:Key>
        <arr:Key>DateBegin</arr:Key>
        <arr:Key>DateEnd</arr:Key>
        <arr:Key>BranchId</arr:Key>
        <arr:Key>SafeId</arr:Key>
        <arr:Key>CashierId</arr:Key>
        */
        String keys[] = {"Type","Name","DateBegin","DateEnd","BranchId","SafeId","CashierId"};
        if (AOKVOSS.size() == keys.length)
        {
            for (int i=1; i<AOKVOSS.size(); i++)
            {
                if (!AOKVOSS.getValue(i).getKey().equals(keys[i]))
                    return false;
            }
        } else return false;
        return true;  
    }
    // TCD/TCR turn protocool
    private boolean TurnProtocoolVal(ArrayOfKeyValueOfstringstring AOKVOSS)
    {
        /*
        <arr:Key>Type</arr:Key>
        <arr:Key>Name</arr:Key>
        <arr:Key>DateBegin</arr:Key>
        <arr:Key>DateEnd</arr:Key>
        <arr:Key>BranchId</arr:Key>
        <arr:Key>SafeId</arr:Key>
        */
        String keys[] = {"Type","Name","DateBegin","DateEnd","BranchId","SafeId"};
        if (AOKVOSS.size() == keys.length)
        {
            for (int i=1; i<AOKVOSS.size(); i++)
            {
                if (!AOKVOSS.getValue(i).getKey().equals(keys[i]))
                    return false;
            }
        } else return false;
        return true;  
    }
    // TCD/TCR residue statement
    private boolean ResidueVal(ArrayOfKeyValueOfstringstring AOKVOSS)
    {
        /*
        <arr:Key>Type</arr:Key>
        <arr:Key>Name</arr:Key>
        <arr:Key>SafeId</arr:Key>
        <arr:Key>Date</arr:Key>
        */
        String keys[] = {"Type","Name","SafeId","Date"};
        if (AOKVOSS.size() == keys.length)
        {
            for (int i=1; i<AOKVOSS.size(); i++)
            {
                if (!AOKVOSS.getValue(i).getKey().equals(keys[i]))
                    return false;
            }
        } else return false;
        return true;  
    }
    
    // Cash issue validation
    private boolean CashIssueValidation(ArrayOfKeyValueOfstringstring AOKVOSS)
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
        String keys[] = {"Type","CashierId","Currency","Amount","TempocashAmount","ExternalId"};
        if (AOKVOSS.size() == keys.length)
        {
            for (int i=1; i<AOKVOSS.size(); i++)
            {
                if (!AOKVOSS.getValue(i).getKey().equals(keys[i]))
                    return false;
            }
        } else return false;
        return true;
    }
    
    // 
    private boolean CashAcceptValidation(ArrayOfKeyValueOfstringstring AOKVOSS)
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
        String keys[] = {"Type","CashierId","Currency","Amount","TempocashAmount","ExternalId"};
        if (AOKVOSS.size() == keys.length)
        {
            for (int i=1; i<AOKVOSS.size(); i++)
            {
                if (!AOKVOSS.getValue(i).getKey().equals(keys[i]))
                    return false;
            }
        } else return false;
        return true;
    }
    
    //IncasationValidation
    private boolean IncasationValidation(ArrayOfKeyValueOfstringstring AOKVOSS)
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
        String keys[] = {"Type","CashierId","SafeId","ReplenishmentType","UseDepositCassette","ExternalId","AvailableAmount","Currency"};
        if (AOKVOSS.size() == keys.length)
        {
            for (int i=1; i<AOKVOSS.size(); i++)
            {
                if (!AOKVOSS.getValue(i).getKey().equals(keys[i]))
                    return false;
            }
        } else return false;
        return true;
    }
}
