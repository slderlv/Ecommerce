package Domain;

public class Client extends User{
    //ADD buy history, directions, cards
    private int number;
    private Transactions transactions;
    public Client(String rut, String name, String password, String mail, int number, Transactions transactions) {
        super(rut, name, password, mail);
        this.number = number;
        this.transactions = transactions;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public Transactions getTransactions() {
        return transactions;
    }
    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }

    
    
}
