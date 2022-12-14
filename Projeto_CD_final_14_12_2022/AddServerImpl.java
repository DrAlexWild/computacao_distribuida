import java.rmi.*;
import java.rmi.server.*;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.FileNotFoundException;  // Import this class to handle errors

import java.util.ArrayList;

public class AddServerImpl extends UnicastRemoteObject
  implements AddServerIntf {

  public AddServerImpl() throws RemoteException {}


  public double add(double d1, double d2) throws RemoteException {
    return d1 + d2;
  }


  public String reservar(int id, int day, String time_of_day, String email){

    ArrayList<Table> tables = read_file_tables(String.valueOf(day));

    Boolean found_table = false;

        for(Table table: tables){
            if(table.id == id){
                boolean sucesso = table.reservar(email, time_of_day);
                if(sucesso){
                  found_table = true;
                  write_to_file_tables(tables, String.valueOf(day));
                }
                else{
                  return "Mesa já reservada por outro user";
                }
            }
        }
        
        if(!found_table){
          return "Mesa nao existe";
        }

        return "Reservar bem sucedido";
    }
    
    public String cancelar(int id, String email, String day, String time_of_day){

        ArrayList<Table> tables = read_file_tables(day);
        Boolean found_table = false;

        for(Table table: tables){
            if(table.id == id){
                table.cancelar(email, time_of_day);
                found_table = true;
            }
        }
        write_to_file_tables(tables, day);
        if(!found_table){
          return "Mesa nao existe";
        }

        return "Cancelar bem sucedido";
    }

public ArrayList<Table> read_file_tables(String day){
    ArrayList<Table> tables = new ArrayList<Table>();
    try {
    File myObj = new File(day+".txt");
    Scanner myReader = new Scanner(myObj);
    while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] data_splited = data.split(" ");
        Table table = new Table(
            Integer.valueOf(data_splited[0]),  
            Integer.valueOf(data_splited[1]),
            data_splited[2],
            data_splited[3]
            );
        tables.add(table);
        //System.out.println(table);
    }
    myReader.close();
    } catch (FileNotFoundException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
    }
return tables;
}

public static ArrayList<User> read_file_users(){
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


public static void write_to_file_tables(ArrayList<Table> tables, String filename){
    try {
      FileWriter myWriter = new FileWriter(filename+".txt");
      for(Table table: tables){
        myWriter.write(table.toString());
      }
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }


  public static void write_to_file_users(ArrayList<User> users, String filename){
    try {
      FileWriter myWriter = new FileWriter(filename + ".txt");
      for(User user: users){
        myWriter.write(user.toString());
      }
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public void registar_user(String email, String password){
    ArrayList<User> users = read_file_users();
    User new_user = new User(email, password, 0);
    users.add(new_user);
    try {
      FileWriter myWriter = new FileWriter("Users.txt");
      for(User user: users){
        myWriter.write(user.toString());
      }
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }


    public static void create_file(){
            try {
        File myObj = new File("filename.txt");
        if (myObj.createNewFile()) {
            System.out.println("File created: " + myObj.getName());
        } else {
            System.out.println("File already exists.");
        }
        } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
    }

    /*4.3 Listarmesas
    Lista as mesas não reservadas na data proposta sendo almoço ou jantar e estando o utilizador
    autenticado.*/
  public String listar_mesas(String time_of_day, String day){
      ArrayList<Table> tables = read_file_tables(day);
      String out = "";

      for(Table table: tables){
        if(time_of_day.equals("Almoço")){
          if(table.email_almoco.equals("Empty")){
            out += table.toString();
          }
        }
        if(time_of_day.equals("Jantar")){
          if(table.email_jantar.equals("Empty")){
            out += table.toString();
          }
        }      
      }
      return out;
  }

  public static void main(String[] args) {
       
       /*
        User user0 = new User("useremail", "1020120");
        System.out.println(user0.email);
        System.out.println(user0.password);
        */

        /*
        ArrayList<Table> tables = new ArrayList<Table>();
        //gerar mesas capacidade 2
        for(int id=1; id <= 10; id++){
        Table table = new Table(id, 2);
        tables.add(table);
        }
        //gerar mesas capacidade 4
        for(int id=11; id <= 15; id++){
        Table table = new Table(id, 4);
        tables.add(table);
        }
        //gerar mesas capacidade 8
        for(int id=16; id <= 20; id++){
        Table table = new Table(id, 8);
        tables.add(table);
        }
        //gerar mesas capacidade 12
        for(int id=21; id <= 25; id++){
        Table table = new Table(id, 12);
        tables.add(table);
        }

        for(Table table: tables){
            System.out.println("id:"+ table.id + " capacity: "+ table.capacity);
        }

        for(int i = 2; i<=30; i++){
        write_to_file_tables(tables, String.valueOf(i));
        }

        read_file_tables("1");

        */
        
        /*
        System.out.println(listar_mesas("Almoço", "1"));
        //reservar(int id, int day, String time_of_day, String email)
        reservar(1, 1, "Almoço", "test");
        System.out.println(listar_mesas("Almoço", "1"));
        //cancelar(int id, String email, String day, String time_of_day)
        System.out.println(cancelar(1, "test", "1", "Almoço"));
        System.out.println(listar_mesas("Almoço", "1"));
        /*
        User user0 = new User("useremail", "1020120");
        System.out.println(user0.email);
        System.out.println(user0.password);
        */

        /*
        User user1 = new User("useremail", "999999");
        System.out.println(user0.email);
        System.out.println(user0.password);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user0);
        users.add(user1);
        write_to_file_users(users);
        */

        //registar_user("useremail2", "1111111");

        /* 

        ArrayList<User> users = read_file_users();

        
        for(User user: users){
            System.out.println(user);
        }
        

        ArrayList<Table> tables = read_file_tables();
        

        
        for(Table table: tables){
            System.out.println(table);
        }

        */
        

        //registar_user(String email, String password)
        //tables = reservar(25, 1, "Night", tables, user0);
        

        //reservar(int id, int day, String time_of_day, String email, ArrayList<User> users)
        //reservar(23, 10, "Almoço", "useremail2");
        //reservar(22, 10, "Almoço", "useremail0");
        //reservar(22, 11, "Almoço", "useremail1");
        //cancelar(int id, String email, String day)

        //public String cancelar(int id, String email, String day)
        //print(cancelar(23, "useremail2", "10"));

        //listar_mesas(String time_of_day, String day){
        //System.out.print(listar_mesas("Almoço", "10"));

    }

}
