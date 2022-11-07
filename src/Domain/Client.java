package Domain;

import java.util.ArrayList;

public class Client extends User{
    //ADD buy history, directions, cards
    private int number;
    private Transactions transactions;
    private String address;
<<<<<<< HEAD
    
    public Client(String rut, String name, String password, String mail, int number, Transactions transactions, String address) {
=======
    private ArrayList<Card> card;
    public Client(String rut, String name, String password, String mail, int number, Transactions transactions, String address, ArrayList<Card> card) {
>>>>>>> 72ebe9df982ab099ce5f1663339a07211cbbd998
        super(rut, name, password, mail);
        this.number = number;
        this.transactions = transactions;
        this.address = address;
        this.card = card;
    }
    
<<<<<<< HEAD
    public int getNumber() {
=======
    public ArrayList<Card> getCard() {
		return card;
	}

	public void setCard(ArrayList<Card> card) {
		this.card = card;
	}

	public int getNumber() {
>>>>>>> 72ebe9df982ab099ce5f1663339a07211cbbd998
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
