

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.PreparedStatement;



@ManagedBean
@SessionScoped
public class StockApiBean {

    private static final long serialVersionUID = 1L;
    static final String API_KEY = "AF93E6L5I01EA39O";

    private String symbol;
    private double price;
    private int qty;
    private double amt;
    private String table1Markup;
    private String table2Markup;
    ResultSet myRs = null;
    PreparedStatement myStmt = null;

    private String selectedSymbol;
    private List<SelectItem> availableSymbols;
    Connection conn =null;
    public String getPurchaseSymbol() {
        if (getRequestParameter("symbol") != null) {
            symbol = getRequestParameter("symbol");
        }
        return symbol;
    }
    
    public void setPurchaseSymbol(String purchaseSymbol) {
        System.out.println("func setPurchaseSymbol()");  //check
    }

    public double getPurchasePrice() {
        if (getRequestParameter("price") != null) {
            price = Double.parseDouble(getRequestParameter("price"));
            System.out.println("price: " + price);
        }
        return price;
    }

    public void setPurchasePrice(double purchasePrice) {
        System.out.println("func setPurchasePrice()");  //check
    }
    
    private String getRequestParameter(String name) {
        return ((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).getParameter(name);
    }

    @PostConstruct
    public void init() {
        //initially populate stock list
        availableSymbols = new ArrayList<SelectItem>();
        availableSymbols.add(new SelectItem("AAPL", "Apple"));
        availableSymbols.add(new SelectItem("AMZN", "Amazon LLC"));
        availableSymbols.add(new SelectItem("AR", "Antero Resources"));
        availableSymbols.add(new SelectItem("EBAY", "Ebay"));
        availableSymbols.add(new SelectItem("FB", "Facebook, Inc."));
        availableSymbols.add(new SelectItem("GOLD", "Gold"));
        availableSymbols.add(new SelectItem("GOOGL", "Google"));
        availableSymbols.add(new SelectItem("MSFT", "Microsoft"));
        availableSymbols.add(new SelectItem("SLV", "Silver"));
        availableSymbols.add(new SelectItem("TWTR", "Twitter, Inc."));

        //initially populate intervals for stock api
        availableIntervals = new ArrayList<SelectItem>();
        availableIntervals.add(new SelectItem("1min", "1min"));
        availableIntervals.add(new SelectItem("5min", "5min"));
        availableIntervals.add(new SelectItem("15min", "15min"));
        availableIntervals.add(new SelectItem("30min", "30min"));
        availableIntervals.add(new SelectItem("60min", "60min"));
    }

    private String selectedInterval;
    private List<SelectItem> availableIntervals;

    public String getSelectedInterval() {
        return selectedInterval;
    }

    public void setSelectedInterval(String selectedInterval) {
        this.selectedInterval = selectedInterval;
    }

    public List<SelectItem> getAvailableIntervals() {
        return availableIntervals;
    }

    public void setAvailableIntervals(List<SelectItem> availableIntervals) {
        this.availableIntervals = availableIntervals;
    }

    public String getSelectedSymbol() {
        return selectedSymbol;
    }

    public void setSelectedSymbol(String selectedSymbol) {
        this.selectedSymbol = selectedSymbol;
    }

    public List<SelectItem> getAvailableSymbols() {
        return availableSymbols;
    }

    public void setAvailableSymbols(List<SelectItem> availableSymbols) {
        this.availableSymbols = availableSymbols;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    public String getTable1Markup() {
        return table1Markup;
    }

    public void setTable1Markup(String table1Markup) {
        this.table1Markup = table1Markup;
    }

    public String getTable2Markup() {
        return table2Markup;
    }

    public void setTable2Markup(String table2Markup) {
        this.table2Markup = table2Markup;
    }

    public String createDbRecord(String username, String symbol, double price, int qty, double amt) {
        try {
<<<<<<< HEAD
            //System.out.println("symbol: " + this.symbol + ", price: " + this.price + "\n");
            //System.out.println("qty: " + this.qty + ", amt: " + this.amt + "\n");
        	Connection myConn = null;
=======
            Connection myConn = null;
>>>>>>> new update commit
        	 conn = DataConnection.getConnection();
        	 System.out.println("in stock api");
           Statement statement = conn.createStatement();
           java.sql.PreparedStatement myStmt = null;
           java.sql.PreparedStatement myStmt2 = null;
           java.sql.PreparedStatement myStmt3 = null;
            myConn = DataConnection.getConnection();
           
            System.out.println("in stock api");
<<<<<<< HEAD
            
            //ClientReg client =new ClientReg();
        	//client.getId();
        	//client.getUsername();
        	//int id=client.getId();
            //String uname=client.getUsername();
          
           // System.out.println("in stock api user name is " +uname);
            
            //System.out.println(id);
           
			System.out.println("username:" +username);
=======
            System.out.println("username:" +username);
>>>>>>> new update commit
            System.out.println("symbol:" + symbol);
            System.out.println("price:" + price);
            System.out.println("qty:" + qty);
            System.out.println("amt:" + amt);
            myStmt = myConn.prepareStatement("select balance from login where user_name ='" + username + "'");
            
            ResultSet rs = myStmt.executeQuery();
            rs.next();
            Double balance = rs.getDouble(1);
            System.out.println("balance login " +balance);
            
<<<<<<< HEAD
            
            myStmt2 = myConn.prepareStatement("select user_name, stock_symbol from stock");
            
           ResultSet rs2 = myStmt2.executeQuery();
         rs2.next();
        	 
        	 
             
             System.out.println("balance login " +balance);
          String stockUser=rs2.getString(1);
          String stock_symbol2=rs2.getString(2);
          
          System.out.println("user name stock api" +stockUser);
          System.out.println("symbolstock api" +stock_symbol2);
=======
>>>>>>> new update commit
           System.out.println("balance of stock api" +balance);
           Double accountBalance=balance-amt;
           System.out.println("AccBalance of stock api" +accountBalance);
           
         
            
            if(balance>= amt){
            
<<<<<<< HEAD
            	statement.executeUpdate("INSERT INTO `stock` ( `user_name`, `stock_symbol`, `qty`, `price`, `amt`, `accountBalance`) "
                        + "VALUES ('" + username + "','" + symbol + "','" + qty + "','" + price + "','" + amt +"','" + accountBalance + "')");
           	statement.executeUpdate("update login "
					+ " set balance='" + accountBalance + "'"
					+ " where user_name='" + username + "'");
           	statement.executeUpdate("INSERT INTO `history` ( `user_name`, `stock_symbol`, `qty`, `price`, `amt`, `accountBalance`, `purchasedBy`) "
                    + "VALUES ('" + username + "','" + symbol + "','" + qty + "','" + price + "','" + amt +"','" + accountBalance + "','" + username + "')");
            }
            //statement.executeUpdate("update stock "
    				//	+ " stock_symbol='" + symbol +"', qty='" + qty +"', price='" + price +"', amt='" + amt +"'"
    					//+ " where user_name='" + username +"'";)
//            java.sql.PreparedStatement stmt=conn.prepareStatement( 
//            		"INSERT INTO stock (stock_symbol, qty, price, amt, user_name) VALUES ('?', '?', '?', '?', '?')");
//            
           // ("update `stock` (`id`, `uid`, `stock_symbol`, `qty`, `price`, `amt`) "
               //     + "VALUES (NULL,'" + uid + "','" + symbol + "','" + qty + "','" + price + "','" + amt +"')");
//            stmt.setString(1,symbol);    
//               
//            stmt.setInt(2,qty);
//            stmt.setDouble(3, price); 
//            stmt.setDouble(4,amt);    
//            stmt.setString(5,username);    
//            //stmt.setInt(6,u.getId());    
//            stmt.executeUpdate();
//    		
//    		//statement.executeUpdate(sql);
//             if(username!= null && !username.equals("")
         /*   }
           ?
        		   else if(balance>= amt && stockUser.equals(username) && stock_symbol2.equals(symbol))
            {
            	  myStmt3 = myConn.prepareStatement("select qty from stock where user_name='" + username + "' and stock_symbol='" + stock_symbol2 + "'");
            	  ResultSet rs3 = myStmt3.executeQuery();
                  rs3.next();
                 int oldQty = rs3.getInt(1);
                  System.out.println("old qty--"+oldQty);
                  int newQty = oldQty+qty;
                  System.out.println("new qyt "+newQty);
                  statement.executeUpdate("update stock "
      					+ " set qty='" + newQty + "'"
      					+ " where user_name='" + username + "' and stock_symbol='" + stock_symbol2 + "'");
                  statement.executeUpdate("update login "
      					+ " set balance='" + accountBalance + "'"
      					+ " where user_name='" + username + "'");
                  
                  statement.executeUpdate("INSERT INTO `history` ( `user_name`, `stock_symbol`, `qty`, `price`, `amt`, `accountBalance`, `purchasedBy`) "
                          + "VALUES ('" + username + "','" + symbol + "','" + qty + "','" + price + "','" + amt +"','" + accountBalance + "','" + username + "')");
                 	
                  
            }
            else if(balance>= amt && stockUser.equals(username) && !stock_symbol2.equals(symbol))
            {
            	
            	System.out.println("againin stock api symblo different");
            	statement.executeUpdate("INSERT INTO `stock` ( `user_name`, `stock_symbol`, `qty`, `price`, `amt`, `accountBalance`) "
                        + "VALUES ('" + username + "','" + symbol + "','" + qty + "','" + price + "','" + amt +"','" + accountBalance + "')");
           	statement.executeUpdate("update login "
=======
    			String sql = "select * from stock where user_name=? and stock_symbol=?";
    			PreparedStatement myStmt1 = (PreparedStatement) myConn.prepareStatement(sql);
    			myStmt1.setString(1, username);
    			myStmt1.setString(2, symbol);
    			ResultSet myRs1 = myStmt1.executeQuery();
    			if(myRs1.next()) {
    				
    				String sql1 = "update stock  set qty ='"+(qty+myRs1.getInt("qty"))+"' where user_name='"+username+"' and stock_symbol='"+symbol+"'";
    				System.out.println("before query....");
    				myStmt = myConn.prepareStatement(sql1);
    				
    				// set params
    				
    				
    				int i=myStmt.executeUpdate();
    				if(i>0)
    				{
    					System.out.println("updated.");
    				}
    				
    			}
    			
    			else	
    			{
            	
            	statement.executeUpdate("INSERT INTO `stock` ( `user_name`, `stock_symbol`, `qty`, `price`, `amt`, `accountBalance`) "
                        + "VALUES ('" + username + "','" + symbol + "','" + qty + "','" + price + "','" + amt +"','" + accountBalance + "')");
    			}
            	statement.executeUpdate("update login "
>>>>>>> new update commit
					+ " set balance='" + accountBalance + "'"
					+ " where user_name='" + username + "'");
           	statement.executeUpdate("INSERT INTO `history` ( `user_name`, `stock_symbol`, `qty`, `price`, `amt`, `accountBalance`, `purchasedBy`) "
                    + "VALUES ('" + username + "','" + symbol + "','" + qty + "','" + price + "','" + amt +"','" + accountBalance + "','" + username + "')");
<<<<<<< HEAD
                 	
                  
            } */
            else  {
=======
            }
                    else  {
>>>>>>> new update commit
            	 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "invalid operation",""));
            	//return "invalid.xhtml";
                        
			}
         
            statement.close();
            conn.close();
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully purchased stock",""));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "purchase";
    }

<<<<<<< HEAD
=======

    public String sellStock(String username, String symbol, double price, int qty, double amt) {
        try {
            Connection myConn = null;
        	 conn = DataConnection.getConnection();
        	 System.out.println("in stock api");
           Statement statement = conn.createStatement();
           java.sql.PreparedStatement myStmt = null;
           java.sql.PreparedStatement myStmt2 = null;
           java.sql.PreparedStatement myStmt3 = null;
            myConn = DataConnection.getConnection();
           
            System.out.println("in stock api");
            System.out.println("username:" +username);
            System.out.println("symbol:" + symbol);
            System.out.println("price:" + price);
            System.out.println("qty:" + qty);
            System.out.println("amt:" + amt);
            myStmt = myConn.prepareStatement("select * from stock where user_name ='" + username + "' and stock_symbol='"+symbol+"'");
            
            ResultSet rs = myStmt.executeQuery();
            rs.next();
            int stockqty = rs.getInt("qty");
            System.out.println("stock qty: " +stockqty);
           if(qty<=stockqty)
           {
    				String sql1 = "update stock  set qty ='"+(stockqty-qty)+"' where user_name='"+username+"' and stock_symbol='"+symbol+"'";
    				System.out.println("before query....");
    				myStmt = myConn.prepareStatement(sql1);
    				
    				// set params
    				
    				
    				int i=myStmt.executeUpdate();
    				if(i>0)
    				{
    					System.out.println("updated.");
    				}
    				 myStmt = myConn.prepareStatement("select balance from login where user_name ='" + username + "'");
    		            
    		            ResultSet rs1 = myStmt.executeQuery();
    		            rs1.next();
    		            Double userbalance = rs1.getDouble(1);
    		    
    		            statement.executeUpdate("update login set balance='" + (userbalance+amt) + "'"
					+ " where user_name='" + username + "'");
           	statement.executeUpdate("INSERT INTO `history` ( `user_name`, `stock_symbol`, `qty`, `price`, `amt`, `accountBalance`, `purchasedBy`) "
                    + "VALUES ('" + username + "','" + symbol + "','" + (-1*qty) + "','" + price + "','" + amt +"','" +(userbalance+amt) + "','" + username + "')");
            }
                    else  {
            	 FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "invalid operation",""));
            	//return "invalid.xhtml";
                        
			}
         
            statement.close();
            conn.close();
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully sell stock",""));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "sell";
    }

    
>>>>>>> new update commit
    public void installAllTrustingManager() {
        TrustManager[] trustAllCerts;
        trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) {
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) {
            }
        }};

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            System.out.println("Exception :" + e);
        }
        return;
    }

    public void timeseries() throws MalformedURLException, IOException {

        installAllTrustingManager();

        //System.out.println("selectedItem: " + this.selectedSymbol);
        //System.out.println("selectedInterval: " + this.selectedInterval);
        String symbol = this.selectedSymbol;
        String interval = this.selectedInterval;
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=" + symbol + "&interval=" + interval + "&apikey=" + API_KEY;

        this.table1Markup += "URL::: <a href='" + url + "'>Data Link</a><br>";
        InputStream inputStream = new URL(url).openStream();

        // convert the json string back to object
        JsonReader jsonReader = Json.createReader(inputStream);
        JsonObject mainJsonObj = jsonReader.readObject();
        for (String key : mainJsonObj.keySet()) {
            if (key.equals("Meta Data")) {
                this.table1Markup = null; // reset table 1 markup before repopulating
                JsonObject jsob = (JsonObject) mainJsonObj.get(key);
                this.table1Markup += "<style>#detail >tbody > tr > td{ text-align:center;}</style><b>Stock Details</b>:<br>";
                this.table1Markup += "<table>";
                this.table1Markup += "<tr><td>Information</td><td>" + jsob.getString("1. Information") + "</td></tr>";
                this.table1Markup += "<tr><td>Symbol</td><td>" + jsob.getString("2. Symbol") + "</td></tr>";
                this.table1Markup += "<tr><td>Last Refreshed</td><td>" + jsob.getString("3. Last Refreshed") + "</td></tr>";
                this.table1Markup += "<tr><td>Interval</td><td>" + jsob.getString("4. Interval") + "</td></tr>";
                this.table1Markup += "<tr><td>Output Size</td><td>" + jsob.getString("5. Output Size") + "</td></tr>";
                this.table1Markup += "<tr><td>Time Zone</td><td>" + jsob.getString("6. Time Zone") + "</td></tr>";
                this.table1Markup += "</table>";
            } else {
                this.table2Markup = null; // reset table 2 markup before repopulating
                JsonObject dataJsonObj = mainJsonObj.getJsonObject(key);
                this.table2Markup += "<table class='table table-hover'>";
                this.table2Markup += "<thead><tr><th>Timestamp</th><th>Open</th><th>High</th><th>Low</th><th>Close</th><th>Volume</th></tr></thead>";
                this.table2Markup += "<tbody>";
                int i = 0;
                for (String subKey : dataJsonObj.keySet()) {
                    JsonObject subJsonObj = dataJsonObj.getJsonObject(subKey);
                    this.table2Markup
                            += "<tr>"
                            + "<td>" + subKey + "</td>"
                            + "<td>" + subJsonObj.getString("1. open") + "</td>"
                            + "<td>" + subJsonObj.getString("2. high") + "</td>"
                            + "<td>" + subJsonObj.getString("3. low") + "</td>"
                            + "<td>" + subJsonObj.getString("4. close") + "</td>"
                            + "<td>" + subJsonObj.getString("5. volume") + "</td>";
                    if (i == 0) {
                        String path = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
                        this.table2Markup += "<td><a class='btn btn-success' href='" + path + "/faces/purchase.xhtml?symbol=" + symbol + "&price=" + subJsonObj.getString("4. close") + "'>Buy Stock</a></td>";
                    }
<<<<<<< HEAD
=======
                    if(i==1)
                    {
                    	   String path = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
                           this.table2Markup += "<td><a class='btn btn-success' href='" + path + "/faces/sell.xhtml?symbol=" + symbol + "&price=" + subJsonObj.getString("4. close") + "'>Sell Stock</a></td>";
                       	
                    }
>>>>>>> new update commit
                    this.table2Markup += "</tr>";
                    i++;
                }
                this.table2Markup += "</tbody></table>";
            }
        }
        return;
    }

    public void purchaseStock() {
        System.out.println("Calling function purchaseStock()");
        System.out.println("stockSymbol: " + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("stockSymbol"));
        System.out.println("stockPrice" + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("stockPrice"));
        return;
    }
}
