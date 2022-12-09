package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Domain.Client;
import Domain.Product;

public class SQLShoppingCart implements ISQLRead<Client>{
	private static SQLShoppingCart service = null;

    private SQLShoppingCart(){}
	static public SQLShoppingCart getSQLShoppingCart() {
        if (service == null) {
            service = new SQLShoppingCart();
        }
        return service;
    }
	@Override
	public ResultSet read(Client t) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT * FROM buys INNER JOIN products_buys ON buys.id = products_buys.buy_id  WHERE user_rut=? AND state = 'CARRITO'");
            statement.setString(1,t.getRut());
            ResultSet response = statement.executeQuery();
            return response;
        }catch (SQLException e){ 
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		return null;
	}
	public void create(Product t, int id) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("insert into products_buys(id,buy_id,product_id,quantity) values (default,?,?,?)");
            statement.setInt(1,id);
            statement.setInt(2,t.getId());
            statement.setInt(3,t.getBuy_quantity());
            statement.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		
	}
	
	public void update(Product t, int id) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("update products_buys set quantity = ? where buy_id = id and product_id = ?");
            statement.setInt(1,t.getBuy_quantity());
            statement.setInt(2,id);
            statement.setInt(3,t.getId());
            statement.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		
	}
	
	public int get_id( Client c) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT * FROM buys WHERE user_rut=? AND state = 'CARRITO' order by id desc limit 1");
            statement.setString(1,c.getRut());
            ResultSet response = statement.executeQuery();
            return response.getInt("id");
        }catch (SQLException e){ 
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		return 0;
	}
}
