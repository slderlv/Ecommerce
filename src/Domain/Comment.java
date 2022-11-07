package Domain;

public class Comment {
	private int id;
	private float rating;
	private String comment;
	private Product product;
	private Client client;
	public Comment(int id, float rating, String comment, Product product,Client client) {
		super();
		this.id = id;
		this.rating = rating;
		this.comment = comment;
		this.product = product;
		this.client = client;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
