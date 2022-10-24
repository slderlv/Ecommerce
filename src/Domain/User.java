package Domain;

public class User {
    private String rut;
    private String name;
    private String password;
    private int number;
    private String mail;
    public User (){}
    public User(String rut, String name, String password, int number, String mail) {
        this.rut = rut;
        this.name = name;
        this.password = password;
        this.number = number;
        this.mail = mail;
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
