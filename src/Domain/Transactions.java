package Domain;

import java.util.ArrayList;

public class Transactions {
    private ArrayList<Product> shoppingCart;
    private ArrayList<Purchase> purchases;
    
    public Transactions() {
    	shoppingCart = null;
    	purchases = null;
    }
    
    

	public Transactions(ArrayList<Product> shoppingCart, ArrayList<Purchase> purchases) {
		super();
		this.shoppingCart = shoppingCart;
		this.purchases = purchases;
	}



	public ArrayList<Product> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ArrayList<Product> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public ArrayList<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(ArrayList<Purchase> purchases) {
		this.purchases = purchases;
	}
    
    
}
