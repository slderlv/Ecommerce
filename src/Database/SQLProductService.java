package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Domain.Product;
import Domain.ProductInfo;

public class SQLProductService implements ISQLCreate<String> , ISQLUpdate<Product>, ISQLDelete<Product>, ISQLRead<String>{

	private static SQLProductService service = null;

    private SQLProductService(){}
	static public SQLProductService getSQLProductService() {
        if (service == null) {
            service = new SQLProductService();
        }
        return service;
    }	
	
	public void create(String category) {
		// TODO Auto-generated method stub
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("INSERT INTO products(id,name,price,description,stock,category,img_path,blocked) VALUES (default,'',0,'',0,?,'',false)");
            statement.setString(1,category);
            statement.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
	}

	@Override
	public ResultSet read(String t) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT * FROM products WHERE category=? AND blocked = false");
            statement.setString(1,t);
            
            ResultSet response = statement.executeQuery();
            return response;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		return null;
	}
	
	public ResultSet read() {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT * FROM products WHERE blocked = false");
            ResultSet response = statement.executeQuery();
            return response;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
        return null;
	}
		
	@Override
	public void delete(Product t) {
		//BORRAR TODO DESPUES (si se elimina el producto)
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("UPDATE products SET blocked = true WHERE id = ?");
            statement.setInt(1, t.getId());
            statement.execute();            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
        
		
	}

	@Override
	public void update(Product t) {
		String sql = "UPDATE products SET name = ?, price = ?, description = ?, stock = ?, img_path = ?, category = ? WHERE id = ?";
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement(sql);
            ProductInfo product = t.getInfo();
            statement.setString(1, product.getName().toLowerCase());
            statement.setInt(2, product.getPrice());
            statement.setString(3, product.getDescription());
            statement.setInt(4, product.getStock());
            statement.setString(5,product.getImg_path());
            statement.setString(6, product.getCategory());
            statement.setInt(7, t.getId());
            statement.execute();            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		
	}
	
	public ResultSet read2(String name) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT * FROM products WHERE name Like ? AND blocked = false");
            statement.setString(1, "%" + name + "%");
            ResultSet response = statement.executeQuery();
            return response;            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		return null;
	}
	
	public ResultSet lastId() {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT * FROM products order by id desc LIMIT 1");
            ResultSet response = statement.executeQuery();
            return response;            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		return null;
	}

	public ResultSet readById(int id ) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT * FROM products WHERE id = ?");
            statement.setInt(1, id);
            ResultSet response = statement.executeQuery();
            return response;            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		return null;
	}
	
	public void updateStock(Product p, int subtraction) {
		String sql = "UPDATE products SET stock = ? where id = ?";
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement(sql);
            ProductInfo product = p.getInfo();
            statement.setInt(1, (product.getStock() - subtraction));
            statement.setInt(2, p.getId());

            
            
            statement.execute();            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
	}
	
	public void sumStock(Product p, int sum) {
		String sql = "UPDATE products SET stock = ? where id = ?";
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement(sql);
            ProductInfo product = p.getInfo();
            statement.setInt(1, (product.getStock() + sum));
            statement.setInt(2, p.getId());
            
            
            
            statement.execute();            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
	}
}
