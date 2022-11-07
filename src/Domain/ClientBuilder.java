package Domain;

public class ClientBuilder implements IUserBuilder{
    private String rut;
    private String name;
    private String password;
    private int number;
    private String mail;
    private Transactions transactions;
    private String address;

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

    @Override
    public void setMail(String mail) {
        // TODO Auto-generated method stub
        this.mail = mail;
    }

    public void setNumber(int number){
        this.number = number;
    }
    
    public void setTransactions(Transactions transactions){
        this.transactions = transactions;
    }
    
    public void setAddress(String address){
    	this.address = address;
    }

    public Client getResult(){
        return new Client (rut, name, password, mail, number, transactions, address);
    }
    //setNumber
    //get --> llama al constructor
    //new Client(x,y,z,a,b,c,d,e);
}
