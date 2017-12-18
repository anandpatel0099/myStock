

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped



public class ClientController {

	private List<ClientReg> clients;
	private List<ClientReg> clients1;
	private List<ClientReg> clients3;
	//private List<LoginCheck> login;
	private ClientDbUtil clientDbUtil;
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	public ClientController() throws Exception {
		clients = new ArrayList<>();
		clients1 = new ArrayList<>();
		clients3 = new ArrayList<>();
		//login = new ArrayList<>();
		
		clientDbUtil = ClientDbUtil.getInstance();
	}
	
	public List<ClientReg> getClient() {
		return clients;
	}
	public List<ClientReg> getClient1() {
		return clients1;
	}
	public List<ClientReg> getClient3() {
		return clients3;
	}
	//public List<LoginCheck> getlogin() {
		//return login;
//	}
	
	
	
	public String loadClient() {
		//System.out.println(clientId);
		//logger.info("loading clients: " + clientId);
		
		try {
			
			clients = clientDbUtil.getClient();
			
			
			// get clients from database
			//ClientReg theClient = clientDbUtil.getClient();
			
			
			/*ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();		

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("clients", theClient);*/
			
		} catch (Exception exc) {
			// send this to server logs
			//logger.log(Level.SEVERE, "Error loading clients id:" + clientId, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
				
		return "approveManager.xhtml";
	}	
	
	public String showClient() {
		//System.out.println(clientId);
		//logger.info("loading clients: " + clientId);
		
		try {
			
			clients3 = clientDbUtil.showClient();
			
			
			// get clients from database
			//ClientReg theClient = clientDbUtil.getClient();
			
			
			/*ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();		

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("clients", theClient);*/
			
		} catch (Exception exc) {
			// send this to server logs
			//logger.log(Level.SEVERE, "Error loading clients id:" + clientId, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
				
		return "approveManager.xhtml";
	}	
	
	public String loadClient1(){
		//System.out.println(clientId);
		//logger.info("loading clients: " + clientId);
		clients1.clear();
		
		try {
			
			clients1 = clientDbUtil.getClient1();
			
			
			// get clients from database
			//ClientReg theClient = clientDbUtil.getClient();
			
			/*// put in the request attribute ... so we can use it on the form page
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();		

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("clients", theClient);*/
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();		

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("clients", clients1);
			
		} catch (Exception exc) {
			// send this to server logs
			//logger.log(Level.SEVERE, "Error loading clients id:" + clientId, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
				
		return "login.xhtml";
	}	
	
public String updateClient(int clientId) {
		System.out.println(clientId);
		logger.info("loading clients: " + clientId);
		
		try {
			
			//clients = clientDbUtil.getClient();
			System.out.println(clientId);
			
			// get clients from database
			//ClientReg theClient = clientDbUtil.getClient();
			ClientReg clients = clientDbUtil.updateClient(clientId);
			System.out.println(clientId);
			// put in the request attribute ... so we can use it on the form page
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();		

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("clients", clients);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading student id:" + clientId, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
		return "approveManager.xhtml";
}	
public String reqStock(Double bal, String cUsername) {

	//logger.info("updating clients: " + theClient);
	 System.out.println("controller" +bal);
	 System.out.println("controller" +cUsername);
	
	
	try {
		
		// update clients in the database
		ClientReg clients = clientDbUtil.reqStock(bal, cUsername);
		
	} catch (Exception exc) {
		// send this to server logs
		logger.log(Level.SEVERE, "Error loading client:" + bal, exc);
		
		// add error message for JSF page
		addErrorMessage(exc);
		
		return null;
	}
			
	return "clientHome.xhtml";
}	
		public String rejectClient(int clientId) {
			System.out.println(clientId);
			logger.info("loading clients: " + clientId);
			
			try {
				
				//clients = clientDbUtil.getClient();
				System.out.println(clientId);
				
				// get clients from database
				//ClientReg theClient = clientDbUtil.getClient();
				ClientReg clients = clientDbUtil.rejectClient(clientId);
				System.out.println(clientId);
				// put in the request attribute ... so we can use it on the form page
				ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();		

				Map<String, Object> requestMap = externalContext.getRequestMap();
				requestMap.put("clients", clients);
				
			} catch (Exception exc) {
				// send this to server logs
				logger.log(Level.SEVERE, "Error loading student id:" + clientId, exc);
				
				// add error message for JSF page
				addErrorMessage(exc);
				
				return null;
			}
				
		return "approveManager.xhtml";
	}	
public String selectManager(int mId, String cUsername) {
	System.out.println(mId);
	System.out.println(cUsername);
	logger.info("loading manager: " + mId);
	logger.info("loading manager: " + cUsername);
	
	
	try {
		
		//clients = clientDbUtil.getClient();
		System.out.println(mId);
		System.out.println(cUsername);
		
		// get student from database
		//ClientReg theClient = clientDbUtil.getClient();
		ClientReg clients = clientDbUtil.selectManager(mId, cUsername);
		//System.out.println(clientId);
		// put in the request attribute ... so we can use it on the form page
		//ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();		

		//Map<String, Object> requestMap = externalContext.getRequestMap();
	//	requestMap.put("clients", clients);
		
	} catch (Exception exc) {
		// send this to server logs
		logger.log(Level.SEVERE, "Error loading client:" + mId, exc);
		
		// add error message for JSF page
		addErrorMessage(exc);
		
		return null;
	}
			
	return "clientHome.xhtml";
}	

	public String regClient(ClientReg theClient) {

		logger.info("Adding Client: " + theClient);

		try {
			
			// add clients to the database
			clientDbUtil.regClient(theClient);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error Registering client", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);

			return null;
		}
		
		return "list-Client?faces-redirect=true";
	}
	
	public String loadClient3(ClientReg theClient) {
		logger.info("Adding Client: " + theClient);
		//System.out.println(clientName);
		try {
			// get clients from database
			clientDbUtil.getClient3(theClient);
			//ClientReg clients3 = (ClientReg) clientDbUtil.getClient3(clientName);
			
			// put in the request attribute ... so we can use it on the form page
			//ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();		

			//Map<String, Object> requestMap = externalContext.getRequestMap();
			//requestMap.put("clients", clients3);	
			
			//clients3 = clientDbUtil.getClient3(clientName);
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error Registering client", exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
			}
		return "historyAndAccount.xhtml";
		}
public String loadClient(String clientId) {
		
		logger.info("loading clients: " + clientId);
		System.out.println(clientId);
		try {
			// get student from database
			ClientReg theClient = clientDbUtil.getClient1(clientId);
			
			// put in the request attribute ... so we can use it on the form page
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();		

			Map<String, Object> requestMap = externalContext.getRequestMap();
			requestMap.put("client", theClient);	
			
		} catch (Exception exc) {
			// send this to server logs
			logger.log(Level.SEVERE, "Error loading clients id:" + clientId, exc);
			
			// add error message for JSF page
			addErrorMessage(exc);
			
			return null;
		}
				
		return "editProfile.xhtml";
	}	
	
public String editProfile(ClientReg theClient){

	logger.info("updating clients: " + theClient);
	 System.out.println(theClient.getUsername());
	try {
		
		// update clients in the database
		clientDbUtil.editProfile(theClient);
		
	} catch (Exception exc) {
		// send this to server logs
		logger.log(Level.SEVERE, "Error updating client: " + theClient, exc);
		
		// add error message for JSF page
		addErrorMessage(exc);
		
		return null;
	}
	
	return "clientHome?faces-redirect=true";		
}
		
	
		
	private void addErrorMessage(Exception exc) {
		FacesMessage message = new FacesMessage("Error: " + exc.getMessage());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	
	
}
