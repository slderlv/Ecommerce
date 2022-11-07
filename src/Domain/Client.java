package Domain;

import java.util.ArrayList;

public class Client extends User{
    //ADD buy history, directions, cards
    private int number;
    private Transactions transactions;
    private String address;
    private ArrayList<Card> card;
    public Client(String rut, String name, String password, String mail, int number, Transactions transactions, String address, ArrayList<Card> card) {
        super(rut, name, password, mail);
        this.number = number;
        this.transactions = transactions;
        this.address = address;
        this.card = card;
    }
    
    public ArrayList<Card> getCard() {
		return card;
	}

	public void setCard(ArrayList<Card> card) {
		this.card = card;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
