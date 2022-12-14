//package default_package.math_rmi_consumer_27_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import default_package.ProjectUtility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class MathConsumer {
	
	public static void menu() {
		System.out.println("Opções");
		System.out.println("a - Listar Mesas");
		System.out.println("b - Reservar Mesa");
		System.out.println("c - Cancelar Mesa");
		System.out.println("d - Registar Utilizador");
	}

	public static void ListarMesas(String time_of_day, String day) {  
		try {
	        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	        factory.setAddress("http://localhost:8080/project_rmi4/services/project_utility_port"); 
	        factory.setServiceClass(ProjectUtility.class);        
	        Object client = factory.create();
	        String response = ((ProjectUtility)client).listarMesas(time_of_day, day);
	        System.out.println(response);
	        
	    } catch (SecurityException e) {
	        e.printStackTrace();
	    } catch (IllegalArgumentException e) {
	        e.printStackTrace();
	    }
	}
	
	private static void Reservar(int id, int day, String time_of_day, String email) {  
		try {
	        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	        factory.setAddress("http://localhost:8080/project_rmi4/services/project_utility_port"); 
	        factory.setServiceClass(ProjectUtility.class);        
	        Object client = factory.create();
	        String response = ((ProjectUtility)client).reservar(id, day, time_of_day, email);
	        System.out.println(response);
	        
	    } catch (SecurityException e) {
	        e.printStackTrace();
	    } catch (IllegalArgumentException e) {
	        e.printStackTrace();
	    }
	}
	
	private static void cancelar(int id, String email, String day, String time_of_day) {  
		try {
	        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
	        factory.setAddress("http://localhost:8080/project_rmi4/services/project_utility_port"); 
	        factory.setServiceClass(ProjectUtility.class);        
	        Object client = factory.create();
	        String response = ((ProjectUtility)client).cancelar(id, email, day, time_of_day);
	        System.out.println(response);
	        
	    } catch (SecurityException e) {
	        e.printStackTrace();
	    } catch (IllegalArgumentException e) {
	        e.printStackTrace();
	    }
	}
	
	
    public static String getMd5(String input)
    {
        try {
 
            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
 
            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());
 
            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);
 
            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }
 
        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    
    public static ArrayList<User> read_file_users_client(){
        ArrayList<User> users = new ArrayList<User>();
        try {
        File myObj = new File("Users.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] data_splited = data.split(" ");
            User user = new User(
                data_splited[0],
                data_splited[1],
                Integer.valueOf(data_splited[2])
                );
            users.add(user);
            //System.out.println(table);
        }
        myReader.close();
        } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
    return users;
    }
    
    public static void registar_user_client(String email, String password){
        ArrayList<User> users = read_file_users_client();
        User new_user = new User(email, getMd5(password), 0);
        
        for(User user_db: users){
            if(user_db.email.equals(new_user.email)) {
            	System.out.println("Email já foi utilizado, operacao cancelada");
            	return;
            }
        }
        
        users.add(new_user);
        try {
          FileWriter myWriter = new FileWriter("Users.txt");
          for(User user: users){
            myWriter.write(user.toString());
          }
          myWriter.close();
          System.out.println("Registo com sucesso");
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }
      }
    
    public static boolean login(String email, String password) {
    	ArrayList<User> users = read_file_users_client();
        
        for(User user_db: users){
            if(user_db.email.equals(email) && user_db.password.equals(getMd5(password))) {
            	System.out.println("Login com successo");
            	return true;
            }
        }
        System.out.println("Login falhado, operacao cancelada");
        return false;
    }

    public static void main(String[] args) {
    	System.out.println("Bem-vindo ao Restaurante!");
        System.out.println("Versão: SOAP Webservices");
        
        //Reservar(int id, int day, String time_of_day, String email)
        //Reservar(3, 1, "Almoço", "test");
        ListarMesas("Almoço", "1");
        //cancelar(int id, String email, String day, String time_of_day)
        cancelar(3, "test", "1", "Almoço");
        ListarMesas("Almoço", "1");
        
        Scanner in = new Scanner(System.in);
        String line;
        /*do {
            System.out.print("Operação: ");
            line = in.nextLine().toUpperCase();
            execute(line);
        } while (line != null && !line.equals("SAIR"));
        in.close();*/
        
        /*
        System.out.println("Adeus.");
        registar_user_client("test@gmail.com", "test");
        
        ArrayList<User> users = read_file_users_client();
        login("test@gmail.com", "test");
        
        for(User user: users){
            System.out.println(user);
        }
        */
        
        //cancelar(1, "1", "Almoço", "test");
        
        while(true) {
            menu();
            System.out.print("Operação: ");
            line = in.nextLine().toUpperCase();
            switch(line) {
	            case "A":{
	            	System.out.print("Hora do dia (Almoço/Jantar): ");
	            	String hora = in.nextLine();
	            	System.out.print("Dia (1..30): ");
	            	String dia = in.nextLine();
	            	ListarMesas(hora, dia);
	            	break;
	            }
	            case "B":{
	            	System.out.print("Efetuar login");
	            	System.out.print("Email: ");
	            	String email = in.nextLine();
	            	System.out.print("password: ");
	            	String password = in.nextLine();
	            	if(login(email, password)) {
	            		System.out.print("Numero da mesa: ");
		            	String id = in.nextLine();
		            	System.out.print("Hora do dia: ");
		            	String time_of_day = in.nextLine();
		            	System.out.print("Dia: ");
		            	String day = in.nextLine();
	            		Reservar(Integer.parseInt(id), Integer.parseInt(day), time_of_day, email);
	            		break;
	            	}
	            }
	            case "C":{
	            	System.out.print("Efetuar login");
	            	System.out.print("Email: ");
	            	String email = in.nextLine();
	            	System.out.print("password: ");
	            	String password = in.nextLine();
	            	if(login(email, password)) {
	            		System.out.print("Numero da mesa: ");
		            	String id = in.nextLine();
		            	System.out.print("Hora do dia: ");
		            	String time_of_day = in.nextLine();
		            	System.out.print("Dia: ");
		            	String day = in.nextLine();
	            		cancelar(Integer.parseInt(id), email, day, time_of_day);
	            		break;
	            	}
	            }
	            case "D":{
	            	System.out.print("Email: ");
	            	String email = in.nextLine();
	            	System.out.print("password: ");
	            	String password = in.nextLine();
	            	registar_user_client(email, password);
	            	break;
	            }
	            
            }
        }
        
    }
}