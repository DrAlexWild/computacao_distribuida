import java.rmi.*;
import javax.jws.WebService;
import java.net.MalformedURLException;

@WebService(targetNamespace = "http://default_package/", portName = "project_utility_port", serviceName = "project_utility_service")
public class ProjectUtility {
	String serverIP = "192.168.56.101";
	String serverURL = "rmi://" + serverIP + "/AddServer";
    
    public String listar_mesas(String time_of_day, String day) {
    	try {
    		AddServerIntf serverIntf = (AddServerIntf)Naming.lookup(serverURL);
    		
    		String result = serverIntf.listar_mesas(time_of_day, day);
    		return result;
    	}
    	catch(MalformedURLException | RemoteException | NotBoundException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
    
    public String reservar(int id, int day, String time_of_day, String email) {
    	try {
    		AddServerIntf serverIntf = (AddServerIntf)Naming.lookup(serverURL);
    		
    		String result = serverIntf.reservar(id, day, time_of_day, email);
    		return result;
    	}
    	catch(MalformedURLException | RemoteException | NotBoundException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
    
    public String cancelar(int id, String email, String day, String time_of_day) {
    	try {
    		AddServerIntf serverIntf = (AddServerIntf)Naming.lookup(serverURL);
    		
    		String result = serverIntf.cancelar(id,  email,  day,  time_of_day);
    		return result;
    	}
    	catch(MalformedURLException | RemoteException | NotBoundException e) {
    		e.printStackTrace();
    	}
    	
    	return null;
    }
    
    void registar_user(String email, String password) {
    	try {
    		AddServerIntf serverIntf = (AddServerIntf)Naming.lookup(serverURL);
    		
    		serverIntf.registar_user(email, password);
    		
    	}
    	catch(MalformedURLException | RemoteException | NotBoundException e) {
    		e.printStackTrace();
    	}
    	
    	return;
    }
}