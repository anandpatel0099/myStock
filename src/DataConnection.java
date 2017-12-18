

import java.sql.Connection;
import java.sql.DriverManager;

public final class DataConnection {

    public static String host = "localhost";
    public static String port = "3306";
    public static String db = "mystock";
    public static String userName = "root";
    public static String password = "root";

    
    public static Connection getConnection() {
    
    	try {
        
    		
    		Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db, userName, password);
            return con;
        } 
    	catch (Exception ex) {
            System.out.println("Database.getConnection() Error -->" + ex.getMessage());
            return null;
       
        
        }
    
    }

    public static void close(Connection con) {
        try {
            con.close();
            
        } 
        catch (Exception ex) {
        }
    }
}
