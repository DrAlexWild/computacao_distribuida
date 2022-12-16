//package default_package.math_rmi_consumer_27_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
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
			
	        //http://localhost:8080/project_rest/rest?_wadl
			URL url = new URL("http://localhost:8080/project_rest/rest/listar_mesas");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json");

                    String input = time_of_day + " " + day;

                    OutputStream os = conn.getOutputStream();
                    os.write(input.getBytes());
                    os.flush();

                    Scanner scanner;
                    String response;
                    if (conn.getResponseCode() != 200) {
                        scanner = new Scanner(conn.getErrorStream());
                        response = "Error From Server \n\n";
                    } else {
                        scanner = new Scanner(conn.getInputStream());
                        response = "Response From Server \n\n";
                    }
                    scanner.useDelimiter("\\Z");
                    System.out.println(response + scanner.next());
                    scanner.close();
                    conn.disconnect();
			
	        //String response = ((ProjectUtility)client).listarMesas(time_of_day, day);
	        //System.out.println(response);
	        
	    } catch (SecurityException e) {
	        e.printStackTrace();
	    } catch (IllegalArgumentException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private static void Reservar(int id, int day, String time_of_day, String email) {  
		try {
			//http://localhost:8080/project_rest/rest?_wadl
			URL url = new URL("http://localhost:8080/project_rest/rest/reservar");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json");

                    String input = id + " " + day + " " + time_of_day + " " + email;

                    OutputStream os = conn.getOutputStream();
                    os.write(input.getBytes());
                    os.flush();

                    Scanner scanner;
                    String response;
                    if (conn.getResponseCode() != 200) {
                        scanner = new Scanner(conn.getErrorStream());
                        response = "Error From Server \n\n";
                    } else {
                        scanner = new Scanner(conn.getInputStream());
                        response = "Response From Server \n\n";
                    }
                    scanner.useDelimiter("\\Z");
                    System.out.println(response + scanner.next());
                    scanner.close();
                    conn.disconnect();
			
	        //String response = ((ProjectUtility)client).listarMesas(time_of_day, day);
	        //System.out.println(response);
	        
	    } catch (SecurityException e) {
	        e.printStackTrace();
	    } catch (IllegalArgumentException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private static void cancelar(int id, String email, String day, String time_of_day) {  
		try {
			//http://localhost:8080/project_rest/rest?_wadl
			URL url = new URL("http://localhost:8080/project_rest/rest/cancelar");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Type", "application/json");

                    String input = id + " " + email + " " + day + " " + time_of_day;

                    OutputStream os = conn.getOutputStream();
                    os.write(input.getBytes());
                    os.flush();

                    Scanner scanner;
                    String response;
                    if (conn.getResponseCode() != 200) {
                        scanner = new Scanner(conn.getErrorStream());
                        response = "Error From Server \n\n";
                    } else {
                        scanner = new Scanner(conn.getInputStream());
                        response = "Response From Server \n\n";
                    }
                    scanner.useDelimiter("\\Z");
                    System.out.println(response + scanner.next());
                    scanner.close();
                    conn.disconnect();
			
	        //String response = ((ProjectUtility)client).listarMesas(time_of_day, day);
	        //System.out.println(response);
	        
	    } catch (SecurityException e) {
	        e.printStackTrace();
	    } catch (IllegalArgumentException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
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
        System.out.println("Versão: REST Webservices");
        
        
        Scanner in = new Scanner(System.in);
        String line;
        
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