package Domain;

public class Card {
	private CardInfo cardInfo;
	private Client client;
	public Card(CardInfo cardInfo, Client client) {
		super();
		this.cardInfo = cardInfo;
		this.client = client;
	}
	public CardInfo getCardInfo() {
		return cardInfo;
	}
	public void setCardInfo(CardInfo cardInfo) {
		this.cardInfo = cardInfo;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}
