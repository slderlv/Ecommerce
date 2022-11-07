package Domain;

import java.util.ArrayList;

public class Product {
	private int id;
	private int buy_quantity;
	private ProductInfo info;
	private ArrayList<Comment> comments;
	private ArrayList<String> specifications;
	public Product(ProductInfo info, int id, ArrayList<Comment> comments, int buy_quantity, ArrayList<String> specifications) {
		super();
		this.info = info;
		this.id = id;
		this.comments = comments;
		this.buy_quantity = buy_quantity;
		this.specifications = specifications;
	}
	public ProductInfo getInfo() {
		return info;
	}
	public void setInfo(ProductInfo info) {
		this.info = info;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Comment> getComments() {
		return comments;
	}
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}

	public ArrayList<String> getSpecifications() {
		return specifications;
	}
	public void setSpecifications(ArrayList<String> specifications) {
		this.specifications = specifications;
	}
	public int getBuy_quantity() {
		return buy_quantity;
	}
	public void setBuy_quantity(int buy_quantity) {
		this.buy_quantity = buy_quantity;
	}
	
	
}
