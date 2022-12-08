package Logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.SQLCardService;
import Database.SQLCategoryService;
import Database.SQLCommentsService;
import Database.SQLProductService;
import Database.SQLShoppingCart;
import Domain.Card;
import Domain.CardInfo;
import Domain.Client;
import Domain.Comment;
import Domain.Product;
import Domain.ProductInfo;
import Domain.Purchase;
import Domain.Transactions;
import Panels.LoginFrame;

public class SystemService {
	private ArrayList<Product> products;
	private ArrayList<String> categorys;
	private static SystemService service = null;
	private SystemService() {
		products = new ArrayList<Product>();
		categorys =  new ArrayList<String>();
	}

	static public SystemService getSystem() {
        if (service == null) {
            service = new SystemService();
        }
        return service;
    }	
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	public ArrayList<String> getCategorys() {
		return categorys;
	}
	public void setCategorys(ArrayList<String> categorys) {
		this.categorys = categorys;
	}
	
	
	public void refreshCategory() {
		try {
			categorys = null;
			categorys = new ArrayList<String>();
			ResultSet response = SQLCategoryService.getSQLCategoryService().read();
			while (response.next()) {
				String name = response.getString("name");
				categorys.add(name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void refreshProducts() {
		ResultSet response = SQLProductService.getSQLProductService().read();
		products = null;
		products = new ArrayList<Product>();
		try {
			
			while(response.next()) {
				int id = response.getInt("id");
				int price = response.getInt("price");
				int stock = response.getInt("stock");
				String name = response.getString("name");
				String description = response.getString("description");
				String category = response.getString("category");
				String img_path = response.getString("img_path");
				ProductInfo info = new ProductInfo(name, price, description, stock, category, img_path);
				Product product = new Product(info, id, null, 0);
				products.add(product);
				
				ResultSet rs = SQLCommentsService.getSQLCommentsService().read(product);
				ArrayList<Comment> comments = new ArrayList<Comment>();
    			while (rs.next()) {
    				Comment comment = new Comment(rs.getInt("id"),rs.getFloat("rating"),rs.getString("comment"),product,rs.getString("user_rut"));
    				comments.add(comment);    				
    			}
    			product.setComments(comments);
				//Boolean blocked = response.getBoolean("blocked");
				//System.out.print(id + " ");
				//System.out.println(blocked);
				// faltan los comments 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	public void refreshProducts(String categoryFilter, String filter) {
		if (filter.equals("")) {
			ResultSet response = SQLProductService.getSQLProductService().read();
			products = null;
			products = new ArrayList<Product>();
			try {
				
				while(response.next()) {
					int id = response.getInt("id");
					int price = response.getInt("price");
					int stock = response.getInt("stock");
					String name = response.getString("name");
					String description = response.getString("description");
					String category = response.getString("category");
					String img_path = response.getString("img_path");
					ProductInfo info = new ProductInfo(name, price, description, stock, category, img_path);
					Product product = new Product(info, id, null, 0);
					if(category.equals(categoryFilter))products.add(product);
					// faltan los comments 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}else {
			ResultSet response = SQLProductService.getSQLProductService().read2(filter);
			products = null;
			products = new ArrayList<Product>();
			try {
				
				while(response.next()) {
					int id = response.getInt("id");
					int price = response.getInt("price");
					int stock = response.getInt("stock");
					String name = response.getString("name");
					String description = response.getString("description");
					String category = response.getString("category");
					String img_path = response.getString("img_path");
					ProductInfo info = new ProductInfo(name, price, description, stock, category, img_path);
					Product product = new Product(info, id, null, 0);
					if(category.equals(categoryFilter))products.add(product);
					// faltan los comments 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}

	}
	
	public void getCards(Client client) {
		ResultSet rs = SQLCardService.getSQLCardService().read(client);
		ArrayList<Card> cards = new ArrayList<Card>();
		try {
			while(rs.next()) {
				CardInfo ci = new CardInfo(rs.getInt("cvv"),rs.getString("card_number"),rs.getInt("expiration_month"),rs.getInt("expiration_year"));
				Card card = new Card(ci,client);
				cards.add(card);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.setCards(cards);
	}
	
	public ArrayList<Product> getShoppingCart(Client client) {
		ResultSet rs = SQLShoppingCart.getSQLShoppingCart().read(client);
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			while (rs.next()) {
				int id = rs.getInt("product_id");
				Product p = null;
				for(int i =0; i < products.size(); i++) {
					p = products.get(i);
					if (p.getId() == id) break;
				}
				p.setBuy_quantity(rs.getInt("quantity"));
				products.add(p);
				//public Product(ProductInfo info, int id, ArrayList<Comment> comments, int buy_quantity)
				//public ProductInfo(String name, int price, String description, int stock, String category, String img_path) 
			}
			return products;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Purchase> getPurchases(Client client) {
		ResultSet rs = SQLShoppingCart.getSQLShoppingCart().read(client);
		ArrayList<Purchase> purchases = new ArrayList<Purchase>();
		try {
			int id = 0;
			int counter = -1;
			Purchase purchase;
			ArrayList<Product> products;
			while (rs.next()) {
				int buy_id = rs.getInt("id");
				
				if (id == 0 || id != buy_id){
					//Nueva compra
					counter++;
					id = buy_id;
					products = = new ArrayList<Product>();
					purchase = new Purchase(buy_id,products);
					purchases.add(purchase);
				} else {
					purchase = purchases.get(counter);
					products = purchase.getProducts();
					Product p;
					int product_id = rs.getInt("product_id");
					for(int i =0; i < this.products.size(); i++) {
						p = products.get(i);
						if (p.getId() == id) break;
					}
					p.setBuy_quantity(rs.getInt("quantity"));
					products.add(p);
				}
				
				//public Purchase(int id, ArrayList<Product> products) {
				//public Product(ProductInfo info, int id, ArrayList<Comment> comments, int buy_quantity)
				//public ProductInfo(String name, int price, String description, int stock, String category, String img_path) 
			}
			return purchases;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void getTransactions(Client client) {
		getCards(client);
		//private ArrayList<Product> shoppingCart;
	   // private ArrayList<Purchase> purchases;
		Transactions t = new Transactions(getShoppingCart(client),getPurchases(client));
		client.setTransactions(t);
	}
	
	public void refreshLists() {
		refreshCategory();
		refreshProducts();
	}
	
	public void start() {
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setVisible(true);
	}
	
}	
