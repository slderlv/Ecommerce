package Domain;

import java.util.ArrayList;

public class Client extends User{
    //ADD buy history, directions, cards
    private int number;
    private Transactions transactions;
    private String address;    
    private ArrayList<Card> cards;
    private String img_path;
   
	public Client(String rut, String name, String password, String mail,int number, Transactions transactions, String address, ArrayList<Card> cards, String img_path) {
		super(rut, name, password, mail);
		this.number = number;
		this.transactions = transactions;
		this.address = address;
		this.cards = cards;
		this.img_path = img_path;
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
	public ArrayList<Card> getCards() {
		return cards;
	}
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
    
    
   
}