public class Table{
    public int id;
    public int capacity;
    public String email_almoco = "Empty";
    public String email_jantar = "Empty";

    public Table(int id, int capacity){
        this.id = id;
        this.capacity = capacity;
    }

    public Table(int id, int capacity, String email_almoco, String email_jantar){
        this.id = id;
        this.capacity = capacity;
        this.email_almoco = email_almoco;
        this.email_jantar = email_jantar;
    }

    public String toString(){
        return "" + this.id + " " + this.capacity + " " + this.email_almoco + " " + this.email_jantar + '\n';
    }

    public Boolean reservar(String email, String time_of_day){
        if(time_of_day.equals("Almoço") && this.email_almoco.equals("Empty")){
            this.email_almoco = email;
            return true;
        }
        if(time_of_day.equals("Jantar") && this.email_jantar.equals("Empty")){
            this.email_jantar= email;
            return true;
        }
        return false;
    }

    public void cancelar(String email, String time_of_day){
        if(time_of_day.equals("Almoço")){
            this.email_almoco = "Empty";
        }
        if(time_of_day.equals("Jantar")){
            this.email_jantar= "Empty";
        }
    }
}