package Domain;

import java.util.ArrayList;

public class Transactions {
    private ArrayList<Product> shoppingCart;
    private ArrayList<Buy> buys;
    
    public Transactions() {
    	shoppingCart = null;
    	buys = null;
    }

	public ArrayList<Product> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ArrayList<Product> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public ArrayList<Buy> getBuys() {
		return buys;
	}

	public void setBuys(ArrayList<Buy> buys) {
		this.buys = buys;
	}
    
    
}
