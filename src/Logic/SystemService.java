package Logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Database.SQLCategoryService;
import Database.SQLProductService;
import Domain.Product;
import Domain.ProductInfo;
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
	
	public void refreshLists() {
		refreshCategory();
		refreshProducts();
	}
	
	public void start() {
		LoginFrame loginFrame = new LoginFrame();
		loginFrame.setVisible(true);
	}
	
}	
