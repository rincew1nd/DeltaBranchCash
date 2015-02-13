package DeltaBranchCash;

import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring;
import com.microsoft.schemas._2003._10.serialization.arrays.ArrayOfKeyValueOfstringstring.KeyValueOfstringstring;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBElement;

public class MySQL {

    Connection conn = null;
    Statement stmn = null;
    ResultSet rs = null;
    String URI = "jdbc:mysql://localhost:5364/delta_stubs";
    String User = "java";
    String Password = "1234";
    
    public void MySQL()
    {
    }
    
    public Parameters GetParameters(long tran_id)
    {
        Parameters paramsPool = new Parameters();
        
        KeyValueOfstringstring KVOSS = new KeyValueOfstringstring();// = new KeyValueOfstringstring("asd", "sds");
        List<ArrayOfKeyValueOfstringstring.KeyValueOfstringstring> LAOKVOSS = new ArrayList<ArrayOfKeyValueOfstringstring.KeyValueOfstringstring>();
        ArrayOfKeyValueOfstringstring AOKVOSS = new ArrayOfKeyValueOfstringstring();
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URI, User, Password);
            stmn = conn.createStatement();
            rs = stmn.executeQuery("SELECT * FROM DATA WHERE tran_id = " + tran_id);

            while (rs.next())
            {
                System.out.print("\n"+rs.getInt("tran_id"));
                System.out.print("\n"+rs.getString("key"));
                System.out.print("\n"+rs.getString("value"));
                paramsPool.setTranId(rs.getInt("tran_id"));
                KVOSS.setKey(rs.getString("key"));
                KVOSS.setValue(rs.getString("value"));
                LAOKVOSS.add(KVOSS);
            }
            AOKVOSS.setKeyValueOfstringstring(LAOKVOSS);
            paramsPool.setJAXB(AOKVOSS);
            
            rs.close();
            stmn.close();
            conn.close();
        }
        catch (Exception ex) {
            System.err.println("Got an exception! ");
            System.err.println(ex.getMessage());
        }
        return paramsPool;
    }
    
    public long getStatus(long tran_id)
    {
        long status = 404l;
        try {            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URI, User, Password);
            stmn = conn.createStatement();
            rs = stmn.executeQuery("select * from tran_status where tran_id = "+tran_id);
            
            rs.next();
            status = rs.getLong("status");
            
            rs.close();
            stmn.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return status;
    }
    
    public long StoreParameters(long tran_id, JAXBElement<ArrayOfKeyValueOfstringstring> JAXBAOKVOSS)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URI, User, Password);
            stmn = conn.createStatement();
            
            ArrayOfKeyValueOfstringstring AOKVOSS = JAXBAOKVOSS.getValue();
            List<ArrayOfKeyValueOfstringstring.KeyValueOfstringstring> LKVOSS = AOKVOSS.getKeyValueOfstringstring();
            LKVOSS.size();
            
            for (KeyValueOfstringstring LKVOSSElement : LKVOSS) {
                stmn.executeUpdate("insert into data values ('"+tran_id+"','"+LKVOSSElement.getKey()+"','"+LKVOSSElement.getValue()+"')");
            }
            
            stmn.close();
            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
        return tran_id;
    }
}