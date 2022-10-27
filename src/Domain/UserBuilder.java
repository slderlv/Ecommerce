package Domain;

public class UserBuilder implements IUserBuilder {
    private String rut;
    private String name;
    private String password;
    private String mail;
    
    public void setRut(String rut){
        this.rut = rut;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setPassword(String password){
        this.password = password;
    }

    public void setMail(String mail){
        this.mail = mail;
    }

    public User getResult(){
        return new User(rut,  name,  password, mail);
    }
}
