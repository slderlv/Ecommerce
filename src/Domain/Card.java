package Domain;

public class Card {
	private CardsInfo cardInfo;
	private Client client;
	
	
	public Card(CardsInfo cardInfo, Client client) {
		this.cardInfo = cardInfo;
		this.client = client;
	}


	public CardsInfo getCardInfo() {
		return cardInfo;
	}


	public void setCardInfo(CardsInfo cardInfo) {
		this.cardInfo = cardInfo;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}
	
	
	
	
}
