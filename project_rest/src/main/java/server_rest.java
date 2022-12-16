
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Consumes("application/json")
@Produces("application/json")
public class server_rest {

	String serverIP = "192.168.56.101";
	String serverURL = "rmi://" + serverIP + "/AddServer";

	@POST
	@Path("/listar_mesas")
	public String listar_mesas(String param) {
		try {
			AddServerIntf serverIntf = (AddServerIntf) Naming.lookup(serverURL);
			String[] param_split = param.split(" ");
			String param_split_0 = param_split[0];
			String param_split_1 = param_split[1];
			String result = serverIntf.listar_mesas(param_split_0, param_split_1);
			return result;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	@POST
	@Path("/reservar")
	public String reservar(String param) {
		/*
		 * try { AddServerIntf serverIntf = (AddServerIntf) Naming.lookup(serverURL);
		 * 
		 * String result = serverIntf.reservar(id, day, time_of_day, email); return
		 * result; } catch (MalformedURLException | RemoteException | NotBoundException
		 * e) { e.printStackTrace(); }
		 * 
		 * return null;
		 */

		try {
			AddServerIntf serverIntf = (AddServerIntf) Naming.lookup(serverURL);
			String[] param_split = param.split(" ");
			String param_split_0 = param_split[0];
			String param_split_1 = param_split[1];
			String param_split_2 = param_split[2];
			String param_split_3 = param_split[3];
			// String input = id + " " + day + " " + time_of_day + " " + email;
			String result = serverIntf.reservar(Integer.parseInt(param_split_0), Integer.parseInt(param_split_1), param_split_2, param_split_3);
			return result;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}

		return null;
	}


	@POST
	@Path("/cancelar")
	public String cancelar(String param) {
		
		/*
		try {
			AddServerIntf serverIntf = (AddServerIntf) Naming.lookup(serverURL);

			String result = serverIntf.cancelar(id, email, day, time_of_day);
			return result;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}

		return null;
		*/
		
		try {
			AddServerIntf serverIntf = (AddServerIntf) Naming.lookup(serverURL);
			String[] param_split = param.split(" ");
			String param_split_0 = param_split[0];
			String param_split_1 = param_split[1];
			String param_split_2 = param_split[2];
			String param_split_3 = param_split[3];
			// String input = id + " " + day + " " + time_of_day + " " + email;
			String result = serverIntf.cancelar(Integer.parseInt(param_split_0), param_split_1, param_split_2, param_split_3);
			return result;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	@POST
	@Path("/registar_user")
	void registar_user(String email, String password) {
		try {
			AddServerIntf serverIntf = (AddServerIntf) Naming.lookup(serverURL);

			serverIntf.registar_user(email, password);

		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		}

		return;
	}
}