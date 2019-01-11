

import java.io.IOException;
import java.sql.Connection;
<<<<<<< HEAD
=======
import java.sql.Connection;
>>>>>>> new update commit
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> new update commit
import java.util.Map;

import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import session.SessionUtils;

@ManagedBean(name="clientReg",eager=true)
@SessionScoped
public class ClientReg {
<<<<<<< HEAD
=======
	private static Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap(); 
>>>>>>> new update commit

	private int id;
	private String firstName;
	private String lastName;
	private String email;
<<<<<<< HEAD
	private String username;
=======
	private static String username;
>>>>>>> new update commit
	private String password;
	private String role;
	private  String dbuserName;
	private String dbpassword;
	private String dbflag;
	private Double balance;
	private int qty;
	private String stockSymbol;
	private Double price;
	private Double bal;
	private String purchasedBy;
	private Date date;
<<<<<<< HEAD
	


	


=======
	public ArrayList<ClientReg> client3;
	
	
	



public ArrayList getClient3() throws Exception {
	client3=getClient_333();
		return client3;
	}



	public void setClient3(ArrayList client3) {
		this.client3 = client3;
	}



//public ArrayList<> Client333(){
//		
//		Connection myConn = null;
//		Statement myStmt = null;
//		ResultSet myRs = null;
//		try{
//			demo= new ArrayList<clientReg>(); 
//			ClientReg clientReg = new ClientReg();
//			myConn = DataConnection.getConnection();
//    System.out.println("username in client3="+username);
//			String sql = "select stock_symbol, purchasedBy, price, accountBalance, date, qty from history where user_name='"+ username + "'";
//
//			myStmt = myConn.createStatement();
//			myRs = myStmt.executeQuery(sql);
//			while(myRs.next())
//			{
//				clientReg.setStockSymbol(myRs.getString("stock_symbol"));
//				
//				demo.add(clientReg);
//			}
//		}catch (Exception e) {
//			// TODO: handle exception
//		}
//		return demo;
//		}
//
//	

>>>>>>> new update commit
	public String getStockSymbol() {
		return stockSymbol;
	}


	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}


	public int getQty() {
		return qty;
	}


	public void setQty(int qty) {
		this.qty = qty;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Double getBal() {
		return bal;
	}


	public void setBal(Double bal) {
		this.bal = bal;
	}




	public String getPurchasedBy() {
		return purchasedBy;
	}


	public void setPurchasedBy(String purchasedBy) {
		this.purchasedBy = purchasedBy;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public String getDbflag() {
		return dbflag;
	}


	public void setDbflag(String dbflag) {
		this.dbflag = dbflag;
	}

	private String dbrole;
	private String flag;
	
	
	
	public ClientReg() {
	}
	
	
	public ClientReg(int id, String firstName, String lastName, String email, String username, String password, String role, String flag) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
		this.flag = flag;
		
	}
	

	

	

	

	//public ClientReg(int id2, String firstName2, String lastName2, String email2) {
		// TODO Auto-generated constructor stub
	//}

	public ClientReg(int id2, String firstName2, String lastName2, String email2, String flag2) {
		// TODO Auto-generated constructor stub
		this.id = id2;
		this.firstName = firstName2;
		this.lastName = lastName2;
		this.email = email2;
		//this.username = username2;
		//this.password = password2;
		this.flag = flag2;
		//this.role = role2;
	}

	public ClientReg(int qty, String stockSymbol, Double price, Double bal, String purchasedBy, Date date) {
		// TODO Auto-generated constructor stub
	}

	
	
<<<<<<< HEAD
=======
	public ClientReg(String stockSymbol2, String purchasedBy2, Double price2, Double balance2, Date date2, int qty2) {
		// TODO Auto-generated constructor stub
	}


>>>>>>> new update commit
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDbrole() {
		return dbrole;
	}

	public void setDbrole(String dbrole) {
		this.dbrole = dbrole;
	}

	

	

	

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getDbuserName() {
        return dbuserName;
    }
 
    public void setDbuserName(String dbuserName) {
        this.dbuserName = dbuserName;
    }
 
    public String getDbpassword() {
        return dbpassword;
    }
 
    public void setDbpassword(String dbpassword) {
        this.dbpassword = dbpassword;
    }
	@Override
	public String toString() {
		return "ClientReg [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", username=" + username + ", password=" + password + " role=" + role +" flag=" + flag + " balance=" + balance + "]";
	}
	
	
public void validateLogin(String username, String password, String role, String flag, String email,String first_name,String last_name, int id) throws Exception {
		System.out.println("validate" + username);
		//System.out.println(role);
		//System.out.println(flag);
		Connection myCon = null;
		PreparedStatement myStmt1 = null;

		try {
			myCon = DataConnection.getConnection();
			myStmt1 = myCon.prepareStatement("Select user_name, password, role, flag, email,  first_name, last_name, id from login where user_name like ('" + username +"') and password like ('" + password +"') ");
			ResultSet rs = myStmt1.executeQuery();
            rs.next();
            
            dbuserName = rs.getString(1).toString();
            dbpassword = rs.getString(2).toString();
            dbrole = rs.getString(3).toString();
            dbflag = rs.getString(4).toString();
            setUsername(dbuserName);
            setPassword(dbpassword);
            setDbrole(dbrole);
            setFlag(dbflag);
            
            
            setEmail(rs.getString(5).toString());  
            setFirstName(rs.getString(6).toString());
            setLastName(rs.getString(7).toString());
            System.out.println(getEmail());
            int id1 = rs.getInt("id");
         
            setId(id1);
            
            //String dbid = rs.getString(5).toString();
            //dbid = rs.getString(5).toString();
			//myStmt1.setString(1, username);
			//myStmt1.setString(2, password);
			//myStmt1.setString(3, role);
			//int id = rs.getInt("id");
            System.out.println("dbusername: " +dbuserName );
            
           // FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("email", email);
           //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("id",id);
          // System.out.println("after faces" + username1);
//            ResultSet rs = myStmt1.executeQuery();


        } catch (SQLException ex) {
            //System.out.println("Login error -->" + ex.getMessage());
            
        }
        
    }
public String checkValidUser() throws Exception
{
	validateLogin( this.username, this.password, this.role, this.flag, this.email,this.firstName, this.lastName, this.id);
	System.out.println(this.username);
 //System.out.println(dbuserName);
// System.out.println(dbrole);
 //System.out.println(dbflag);
    if(this.username.equalsIgnoreCase(dbuserName) && dbrole.equalsIgnoreCase("client") )
    {

        if(this.password.equals(dbpassword)){
        	//FacesContext context = FacesContext.getCurrentInstance();
        	//context.getExternalContext().getSessionMap().put("username", this.dbuserName);
//        	HttpSession session = SessionUtils.getSession();
//		    session.setAttribute("username",username);
//		    session.setAttribute("id",id);
        	 //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", dbuserName);
        	HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", this.username);
			session.setAttribute("id",this.id);
        	return "clientHome?faces-redirect=true";
            //return "clientHome";
            }
        else
        {
        	System.out.println("invalid");
    		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Enter valid username or password",""));
    		return "login.xhtml";  
        }
        //return "login?faces-redirect=true";
    }
    else if(this.username.equalsIgnoreCase(dbuserName) && dbrole.equalsIgnoreCase("manager") && this.password.equals(dbpassword)  )
    {
    	
    	if(dbflag.equalsIgnoreCase("1")){
    	//if(this.password.equals(dbpassword)){
    	//	HttpSession session = SessionUtils.getSession();
		  //  session.setAttribute("username",username);
    		HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", this.username);
			session.setAttribute("id",this.id);
            return "managerHome?faces-redirect=true";
            }
    	else{
    		System.out.println("inactive");
    		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Your application is still in process",""));
    		return "login.xhtml";
    		// return "login?faces-redirect=true";
            }
        
    	
    }
    else if(dbuserName.equalsIgnoreCase("admin") && dbpassword.equals("admin") )
    {
    	//HttpSession session = SessionUtils.getSession();
	    //session.setAttribute("username",username);
    	HttpSession session = SessionUtils.getSession();
		session.setAttribute("username", this.username);
		session.setAttribute("id",this.id);
    	
        return "adminHome?faces-redirect=true";
    }
    else
    {
    	
    	System.out.println("invalid");
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Enter valid username or password",""));
		return "login.xhtml";  
    }
   
	  
}
		
	 
<<<<<<< HEAD
/*	public String validateUser() throws Exception {
		// boolean valid = ClientDbUtil.validateLogin(username, password);
		validateLogin(username, password, role);
			if (username.equals(username)) {
				HttpSession session = SessionUtils.getSession();
				session.setAttribute("username", username);
				return "reg-Client";
			} else {
				 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN, "Incorrect Username and Passowrd. Please enter correct username and Password",""));
		            return "login";
	    }} */
=======
>>>>>>> new update commit
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
		}}
	
	/*public void logout() throws IOException {
       FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
       FacesContext.getCurrentInstance().getExternalContext().redirect("login");
	
       

}*/
	public String logout() {
		
		System.out.println("logout method");
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login.xhtml";
	}
	/*public String logout() {
	      HttpSession session = SessionUtils.getSession();
	      session.invalidate();
	      return "login.xhtml";
	}*/
<<<<<<< HEAD
=======


	public static ClientReg getInstance() {
		// TODO Auto-generated method stub
		return null;
	}



	ArrayList demo;

	public ArrayList getClient_333()  throws Exception {
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		System.out.println("get client 3 method----->>" +username);
		try {
			this.client3 = new ArrayList<ClientReg>(); 
			//ClientReg clientReg = new ClientReg();
			myConn = DataConnection.getConnection();

			String sql = "select stock_symbol, purchasedBy, price, accountBalance, date, qty from history where user_name='"+ username+"'";
        	myStmt = myConn.createStatement();
			myRs = myStmt.executeQuery(sql);
			while (myRs.next()) {
			// set params
				//int id = myRs.getInt("id");
			    ClientReg cr=new ClientReg();
				
				String stockSymbol = myRs.getString(1);
				System.out.println("1:" +stockSymbol);
				//myStmt.setString(1, theClient.getFirstName());
				cr.setStockSymbol(myRs.getString("stock_symbol"));
				cr.setQty(myRs.getInt("qty"));
				cr.setPrice(myRs.getDouble("price"));
				cr.setPurchasedBy(myRs.getString("purchasedBy"));
				cr.setBal(myRs.getDouble("accountBalance"));
				cr.setDate(myRs.getDate("date"));
				
				String PurchasedBy = myRs.getString(2);
				System.out.println("2:" +PurchasedBy);
				
			Double Price = myRs.getDouble(3);
				System.out.println("3:" +PurchasedBy);
				
				Double Balance = myRs.getDouble(4);
				System.out.println("4:" +Balance);
				
				Date Date = myRs.getDate(5);
				System.out.println("5:" +Date);
				
				int Qty = myRs.getInt(6);
				System.out.println("6:" +Qty);
				
			//myStmt.setString(7, theClient.getFlag());
			
			
				
				//clientReg = new ClientReg(stockSymbol, PurchasedBy, Price,
						//Balance, Date, Qty);
				client3.add(cr);
		
			}
			
			return this.client3;		
		}
		finally {
			close (myConn, myStmt, myRs);
		}
		


	}

	

>>>>>>> new update commit
}
