package User;

public class User {
    private String rut;
    private String name;
    private String password;
    private boolean isAdmin;
    private int number;
    private String mail;
    public User (){}
    public User(String rut, String name, String password, boolean isAdmin, int number, String mail) {
        this.rut = rut;
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
        this.number = number;
        this.mail = mail;
        //List directions-cards
        
    }
    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isAdmin() {
        return isAdmin;
    }
    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }

    
    
}
