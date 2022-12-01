package Domain;

import java.util.ArrayList;

public class Purchase {
	private int id;
	private ArrayList<Product> products;
	public Purchase(int id, ArrayList<Product> products) {
		this.id = id;
		this.products = products;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
}
