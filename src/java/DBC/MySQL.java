package DBC;

import java.sql.*;

public class MySQL {

    Connection conn = null;
    Statement stmn = null;
    ResultSet rs = null;
    String URI = "jdbc:mysql://localhost:3307/delta_stubs";
    String User = "root";
    String Password = "root";
    
    
    public ResultSet select(String query)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URI, User, Password);
            stmn = conn.createStatement();
            rs = stmn.executeQuery(query);
            stmn.close();
            conn.close();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            System.out.print(ex.getMessage());
        }
        return rs;
    }
    public boolean update(String query)
    {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URI, User, Password);
            stmn = conn.createStatement();
            
            stmn.executeUpdate(query);
            
            stmn.close();
            conn.close();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            System.out.print(ex.getMessage());
            return false;
        }
        return true;
    }
    public long maxTranId()
    {
        long tran_id = 0l;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URI, User, Password);
            stmn = conn.createStatement();
            
            rs = stmn.executeQuery("SELECT MAX(TRAN_ID)+1 FROM TRAN_TYPE");
            rs.next();
            tran_id = rs.getInt(1);
            
            stmn.close();
            conn.close();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            System.out.print(ex.getMessage());
            return tran_id;
        }
        return tran_id;
    }
    /*
    // Get parameters for response
    public Parameters GetParameters(long tran_id)
    {
        // Parameters array
        Parameters paramsPool = new Parameters();
        // Variables to create response type variables.
        // KeyValueOfstringstring ->
        // ArrayOfKeyValueOfstringstring ->
        // JAXBElement<ArrayOfKeyValueOfstringstring>
        KeyValueOfstringstring KVOSS;
        ArrayOfKeyValueOfstringstring AOKVOSS = new ArrayOfKeyValueOfstringstring();
      
        // Try to connect to DB and fill paramsPool
        try {
            // Connect variables
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URI, User, Password);
            stmn = conn.createStatement();
            rs = stmn.executeQuery("SELECT * FROM DATA WHERE tran_id = " + tran_id);
            
            // Cycle for getting all params from DB of specified transaction
            while (rs.next())
            {
                KVOSS = new KeyValueOfstringstring();
                // Fill KeyValueOfstringstring element
                KVOSS.setKey(rs.getString("key"));
                KVOSS.setValue(rs.getString("value"));
                // Add KeyValueOfstringstring to List
                AOKVOSS.add(KVOSS);
            }
            for (int i = 0; i<AOKVOSS.size(); i++)
            {
                KVOSS = AOKVOSS.getValue(i);
                System.out.print(i + KVOSS.getKey() + KVOSS.getValue());
            }
            // Create Parameter type variable that store transaction id and parameters to response
            paramsPool.setParameters(tran_id, AOKVOSS);
            
            // Close connection
            rs.close();
            stmn.close();
            conn.close();
        }
        catch (Exception ex) {
            System.err.println("Got an exception!" +ex.getMessage()+ " !");
        }
        
        // Return filled response
        return paramsPool;
    }
    
    // Get status of transaction
    public long getStatus(long tran_id)
    {
        // Default status
        long status = 404l;
        try {
            // DB connection
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URI, User, Password);
            stmn = conn.createStatement();
            rs = stmn.executeQuery("select * from tran_status where tran_id = "+tran_id);
            
            // Store first row value (tran_id in unique)
            rs.next();
            status = rs.getLong("status");
            
            // DB connection close
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
    
    // Store params of request in DB
    public long StoreParameters(long tran_id, JAXBElement<ArrayOfKeyValueOfstringstring> JAXBAOKVOSS)
    {
        //if (validator.RegisterRequest(JAXBAOKVOSS.getValue())){}
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URI, User, Password);
            stmn = conn.createStatement();
            
            ArrayOfKeyValueOfstringstring AOKVOSS = JAXBAOKVOSS.getValue();
            
            for (int i = 0; i<AOKVOSS.size(); i++) {
                stmn.executeUpdate("insert into data values ('"+tran_id+"','"+AOKVOSS.getValue(i).getKey()+"','"+AOKVOSS.getValue(i).getValue()+"')");
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
    */
}