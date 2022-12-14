import java.rmi.*;
public interface AddServerIntf extends Remote {
  //double add(double d1, double d2) throws RemoteException;
	double add(double d1, double d2) throws RemoteException;
  String listar_mesas(String time_of_day, String day) throws RemoteException;
   void registar_user(String email, String password)throws RemoteException;
   String cancelar(int id, String email, String day, String time_of_day)throws RemoteException;
   String reservar(int id, int day, String time_of_day, String email)throws RemoteException;
}
