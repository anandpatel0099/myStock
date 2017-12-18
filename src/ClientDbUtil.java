

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@ManagedBean
@SessionScoped




public class ClientDbUtil {
@ManagedProperty( value="#{clientReg}")

	private static ClientDbUtil instance;
	private static DataSource dataSource;
	private String jndiName = "java:comp/env/jdbc/mystock";
	private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();  
	public static ClientDbUtil getInstance() throws Exception { 
		if (instance == null) {
			instance = new ClientDbUtil();
		}
		
		return instance;
	}
	
	private ClientDbUtil() throws Exception {		
		dataSource = getDataSource();
	}

	private DataSource getDataSource() throws NamingException {
		Context context = new InitialContext();
		
		DataSource theDataSource = (DataSource) context.lookup(jndiName);
		
		return theDataSource;
	}
		
	
	/*private void Client3g() {
	 
ClientReg client=new ClientReg();
System.out.println(client.getDbrole());;
}
*/
	
	

	public void regClient(ClientReg theClient) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "insert into login (id, first_name, last_name, email, user_name, password, role, flag, balance) values (NULL, ?, ?, ?, ?, ?, ?, 0, 100000)";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, theClient.getFirstName());
			myStmt.setString(2, theClient.getLastName());
			myStmt.setString(3, theClient.getEmail());
			myStmt.setString(4, theClient.getUsername());
			myStmt.setString(5, theClient.getPassword());
			myStmt.setString(6, theClient.getRole());
			
			//myStmt.setString(7, theClient.getFlag());
			
			
			System.out.println(theClient.getFirstName());
			System.out.println( theClient.getLastName());

			myStmt.execute();			
		}
		finally {
			close (myConn, myStmt);
		}
		
	}
	public void getClient3(ClientReg theClient)  throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			myConn = getConnection();

			String sql = "select * from history where user_name=?";

			myStmt = myConn.prepareStatement(sql);

			// set params
			myStmt.setString(1, theClient.getStockSymbol());
			myStmt.setString(2, theClient.getPurchasedBy());
			myStmt.setDouble(3, theClient.getPrice());
			myStmt.setDouble(4, theClient.getBalance());
			myStmt.setDate(5, theClient.getDate());
			myStmt.setInt(6, theClient.getQty());
			
			//myStmt.setString(7, theClient.getFlag());
			
			
			System.out.println(theClient.getFirstName());
			System.out.println( theClient.getLastName());

			myStmt.execute();	
		
		}
		finally {
			close (myConn, myStmt);
		}
		
	}
	/*public static boolean validateLogin(String username, String password, String role) throws Exception {
		
		Connection myCon = null;
		PreparedStatement myStmt1 = null;

		try {
			myCon = DataConnection.getConnection();
			myStmt1 = myCon.prepareStatement("Select user_name, password, role from login where user_name = ? and password = ?  ");
			myStmt1.setString(1, username);
			myStmt1.setString(2, password);
			myStmt1.setString(3, role);
			
			

            ResultSet rs = myStmt1.executeQuery();

            if (rs.next()) {
               FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("user_name", rs.getString("user_name"));
               
              
               
               // FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("uid", rs.getString("uid"));
                //System.out.println("uid: " + rs.getString("uid"));
                //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key,object);
                
                return true;
            }

        } catch (SQLException ex) {
            System.out.println("Login error -->" + ex.getMessage());
            return false;
        } finally {
        	close (myCon, myStmt1);
        }
        return false;
    }
		*/
	
	public List<ClientReg> getClient() throws Exception {

		List<ClientReg> clients = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		
		try {
			myConn = getConnection();

			String sql = "select * from login where role ='manager'";
			

			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);
			

			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String flag = myRs.getString("flag");

				// create new student object
				ClientReg tempClient = new ClientReg(id, firstName, lastName,
						email, flag);

				// add it to the list of client
				clients.add(tempClient);
			}
			
			return clients;		
		}
		finally {
			close (myConn, myStmt, myRs);
		}
	}
		public List<ClientReg> showClient() throws Exception {

			List<ClientReg> clients3 = new ArrayList<>();

			Connection myConn = null;
			Statement myStmt = null;
			ResultSet myRs = null;
			
			
			try {
				myConn = getConnection();

				String sql = "select * from history ";
				

				myStmt = myConn.createStatement();

				myRs = myStmt.executeQuery(sql);
				

				// process result set
				while (myRs.next()) {
					
					// retrieve data from result set row
					int qty = myRs.getInt("qty");
					
					System.out.println("in clinent 3 method db" +qty);
					
					String stockSymbol = myRs.getString("stock_symbol");
					System.out.println("in clinent 3 method db" +stockSymbol);
					
					Double price = myRs.getDouble("price");
					System.out.println("in clinent 3 method db" +price);
					
					Double bal = myRs.getDouble("accountBalance");
					String purchasedBy = myRs.getString("purchasedBy");
					//String purchaseBy1 = myRs.getString("purchasedBy");
					System.out.println("in clinent 3 method db" +purchasedBy);
					Date date = myRs.getDate("date");
					System.out.println("date is"+date);
					
					ClientReg tempClient = new ClientReg(qty, stockSymbol, price, bal, purchasedBy, date);

					// add it to the list of clients
					clients3.add(tempClient);
				}
				
				return clients3;		
			}
			finally {
				close (myConn, myStmt, myRs);
			}
	}
	
	public List<ClientReg> getClient1() throws Exception {

		List<ClientReg> clients1 = new ArrayList<>();

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		
		try {
			
			myConn = getConnection();

			String sql = "select * from login";
			

			myStmt = myConn.createStatement();

			myRs = myStmt.executeQuery(sql);
			

			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String flag = myRs.getString("flag");
				System.out.println("get client1");
				// create new student object
				ClientReg tempClient = new ClientReg(id, firstName, lastName,
						email, flag);

				// add it to the list of clients
				//clients1.add(tempClient);
				sessionMap.put("Clients1", tempClient);  
				System.out.println(tempClient.getFirstName());
			}
			
			return clients1;		
		}
		finally {
			close (myConn, myStmt, myRs);
		}
		
	
	}
	
	
	public ClientReg updateClient(int clientId) throws Exception {
		
		System.out.println(clientId);
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			//String sql = "update login "
				//	+ " set flag='1'"
					//+ " where id=?";
			
			//String sql = "update login set flag='1' where id='"+clientId+"'";
			//String sql = "update login set flag='1' where id= ?";
			System.out.println("before query....");
			String sql = "update login  set flag ='1' where id=?";
			System.out.println("before query....");
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, clientId);
			
			
			myStmt.executeUpdate();
			System.out.println(clientId + "after query ");
			ClientReg theClient = null;
			
			// retrieve data from result set row
			if (myRs.next()) {
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String flag = myRs.getString("flag");
				System.out.println(email);
				theClient = new ClientReg(id, firstName, lastName, email, flag);
			}
			else {
				throw new Exception("Could not find student id: " + clientId);
			}

			return theClient;
		}
		finally {
			close (myConn, myStmt, myRs);
		}
	}
public ClientReg rejectClient(int clientId) throws Exception {
		
		System.out.println(clientId);
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			//String sql = "update login "
				//	+ " set flag='1'"
					//+ " where id=?";
			
			//String sql = "update login set flag='1' where id='"+clientId+"'";
			//String sql = "update login set flag='1' where id= ?";
			System.out.println("before query....");
			String sql = "update login  set flag ='0' where id=?";
			System.out.println("before query....");
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, clientId);
			
			
			myStmt.executeUpdate();
			System.out.println(clientId + "after query ");
			ClientReg theClient = null;
			
			// retrieve data from result set row
			if (myRs.next()) {
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String flag = myRs.getString("flag");
				System.out.println(email);
				theClient = new ClientReg(id, firstName, lastName, email, flag);
			}
			else {
				throw new Exception("Could not find student id: " + clientId);
			}

			return theClient;
		}
		finally {
			close (myConn, myStmt, myRs);
		}
	}
	
	
public ClientReg selectManager(int mId, String cUsername) throws Exception {
		
		System.out.println("select mana db" +mId);
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			//String sql = "update login "
				//	+ " set flag='1'"
					//+ " where id=?";
			
			//String sql = "update login set flag='1' where id='"+clientId+"'";
			//String sql = "update login set flag='1' where id= ?";
			System.out.println("before query....");
			String sql="UPDATE login AS t1 INNER JOIN (SELECT user_name FROM login WHERE id ='"+mId+"' ) AS t2 SET t1.manager = t2.user_name WHERE t1.user_name='"+cUsername+"'";

			//String sql = "update login  set manager =? where user_name=?";
			System.out.println("before query....");
			myStmt = myConn.createStatement();
			
			// set params
			//myStmt.setInt(1, mId);;
			//myStmt.setString(2, cUsername);
			
			
			 myStmt.executeUpdate(sql);
			System.out.println(cUsername + "after query ");
			ClientReg theClient = null;
			
			// retrieve data from result set row
			/*if (myRs.next()) {
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String flag = myRs.getString("flag");
				System.out.println(email);
				theClient = new ClientReg(id, firstName, lastName, email, flag);
			/*else {
				throw new Exception("Could not find client id: " + cUsername);
			}*/

			return theClient;
		}
		finally {
			close (myConn, myStmt, myRs);
		}
	}
	
public ClientReg getClient(int clientId) throws Exception {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = getConnection();

			String sql = "select * from login where role ='manager'";
			
					
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setInt(1, clientId);
			
			myRs = myStmt.executeQuery();

			ClientReg theClient = null;
			
			// retrieve data from result set row
			if (myRs.next()) {
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				String flag = myRs.getString("flag");

				theClient = new ClientReg(id, firstName, lastName, email, flag);
			}
			else {
				throw new Exception("Could not find client id: " + clientId);
			}

			return theClient;
		}
		finally {
			close (myConn, myStmt, myRs);
		}
	}
	
	
public ClientReg getClient1(String clientId) throws Exception {
	
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs = null;
	
	try {
		myConn = getConnection();

		String sql = "select * from login where user_name=?";

		myStmt = myConn.prepareStatement(sql);
		
		// set params
		
		myStmt.setString(1, clientId);
		
		myRs = myStmt.executeQuery();

		ClientReg theClient= null;
		
		// retrieve data from result set row
		if (myRs.next()) {
			int id = myRs.getInt("id");
			String firstName = myRs.getString("first_name");
			String lastName = myRs.getString("last_name");
			String email = myRs.getString("email");
			String flag = myRs.getString("flag");

			theClient = new ClientReg(id, firstName, lastName,
					email, flag);
		}
		else {
			throw new Exception("Could not find client id: " + clientId);
		}

		return theClient;
	}
	finally {
		close (myConn, myStmt, myRs);
	}
}
public void editProfile(ClientReg theClient) throws Exception {

	System.out.println("edit profile" + theClient.getUsername());
	Connection myConn = null;
	PreparedStatement myStmt = null;

	try {
		myConn = getConnection();

		String sql = "update login "
					+ " set first_name=?, last_name=?, email=?"
					+ " where user_name=?";

		myStmt = myConn.prepareStatement(sql);

		// set params
		myStmt.setString(1, theClient.getFirstName());
		myStmt.setString(2, theClient.getLastName());
		myStmt.setString(3, theClient.getEmail());
		myStmt.setString(4, theClient.getUsername());
		
		myStmt.execute();
	}
	finally {
		close (myConn, myStmt);
	}
	
}
public ClientReg reqStock (Double bal, String cUsername) throws Exception {

	System.out.println("show balance" +bal);
	System.out.println("show user---" +cUsername);
	Connection myConn = null;
	Connection conn = null;
	conn = DataConnection.getConnection();
	Statement statement = conn.createStatement();
	PreparedStatement myStmt = null;
	PreparedStatement myStmt2 = null;

	try {
		myConn = getConnection();
		myStmt = myConn.prepareStatement("select balance, manager from login where user_name ='" + cUsername + "'");
		ResultSet rs = myStmt.executeQuery();
	      rs.next();
	      Double oldBal=rs.getDouble(1);
	      String manager=rs.getString(2);
	      Double newbal=oldBal-bal;
	      System.out.println("show balance" +newbal);
	      System.out.println("show balance" +manager);
	      
	      statement.executeUpdate("update login "
					+ " set balance='" + newbal + "'"
					+ " where user_name='" + cUsername + "'");
	      
	      statement.executeUpdate("INSERT INTO `history` ( `user_name`, `accountBalance`, `transferToManager`, `manName`) "
                  + "VALUES ('" + cUsername + "','" + newbal + "','" + bal + "','" + manager + "')");
	      
	      
	      myStmt2 = myConn.prepareStatement("select balance from login where user_name ='" + manager + "'");
	      ResultSet rs2 = myStmt2.executeQuery();
	      rs2.next();
	      Double ManageroldBal=rs.getDouble(1);
	      Double mangerNewBal=ManageroldBal+bal;
	      
	      System.out.println("show balance manger" +mangerNewBal);
	      statement.executeUpdate("update login "
					+ " set balance='" + mangerNewBal + "'"
					+ " where user_name='" + manager + "'");
	      
	     
	      
	      
	      statement.executeUpdate("INSERT INTO `history` ( `user_name`, `accountBalance`, `transferByClient`, `clientName`) "
                  + "VALUES ('" + manager + "','" + mangerNewBal + "','" + bal + "','" + cUsername + "')");
          
	      
		/*String sql2 = "update login "
					+ " set first_name=?, last_name=?, email=?"
					+ " where user_name=?";

		myStmt3 = myConn.prepareStatement(sql1);
		Double req = myStmt3.get("id");
		
        
        ResultSet rs2 = myStmt2.executeQuery();
      rs2.next();
		// set params
		myStmt.setString(1, theClient.getFirstName());
		myStmt.setString(2, theClient.getLastName());
		myStmt.setString(3, theClient.getEmail());
		myStmt.setString(4, theClient.getUsername());
		*/
		myStmt.execute();
	}
	finally {
		close (myConn, myStmt);
	}
	return null;
	
}
	
	
	private static Connection getConnection() throws Exception {

		Connection theConn = dataSource.getConnection();
		
		return theConn;
	}
	
	private static void close(Connection theConn, Statement theStmt) {
		close(theConn, theStmt, null);
	}
	
	private static void close(Connection theConn, Statement theStmt, ResultSet theRs) {

		try {
			if (theRs != null) {
				theRs.close();
			}

			if (theStmt != null) {
				theStmt.close();
			}

			if (theConn != null) {
				theConn.close();
			}
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	

	
}
