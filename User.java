public class User{
    public String email;
    public String password;
    public int reservation  = 0;

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, int reservation){
        this.email = email;
        this.password = password;
        this.reservation = reservation;
    }

    public String toString(){
        return "" + this.email + " " + this.password + " " + this.reservation + '\n';
    }

}