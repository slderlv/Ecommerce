package Domain;

public class ClientBuilder implements IUserBuilder{
    private String rut;
    private String name;
    private String password;
    private int number;
    private String mail;

    // + LISTAS
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
    
    public void setNumber(int number) {
        // TODO Auto-generated method stub
    	this.number = number;
    }

    @Override
    public void setMail(String string) {
        // TODO Auto-generated method stub
    	this.rut = rut;
    }

    //setNumber
    //get --> llama al constructor
}
