package Domain;

public class AdminBuilder implements IUserBuilder{
    private String rut;
    private String name;
    private String password;
    private String mail;

    @Override
    public void setRut(String rut) {
        // TODO Auto-generated method stub
    	this.rut = rut;
        
    }

    @Override
    public void setName(String name) {
        // TODO Auto-generated method stub
    	this.name = name;
    }

    @Override
    public void setPassword(String password) {
        // TODO Auto-generated method stub
    	this.password = password;
    }

    @Override
    public void setMail(String mail) {
        // TODO Auto-generated method stub
    	this.mail = mail;
    }
    
    public Admin getResult(){
        return new Admin(rut,  name,  password, mail);
    }
    
}
