package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Domain.Client;
import Domain.Product;

public class SQLBuyService implements ISQLRead<Client>, ISQLUpdate<Client>, ISQLCreate<Client>{
	private static SQLBuyService service = null;

    private SQLBuyService(){}
	static public SQLBuyService getSQLBuyService() {
        if (service == null) {
            service = new SQLBuyService();
        }
        return service;
    }
	@Override
	public ResultSet read(Client t) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT * FROM buys INNER JOIN products_buys ON buys.id = products_buys.buy_id  WHERE user_rut=? AND state = 'COMPRADO' and quantity > 0 ");
            statement.setString(1,t.getRut());
            ResultSet response = statement.executeQuery();
            return response;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		return null;
	}
	@Override
	public void update(Client t) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("update buys set state = 'COMPRADO' where user_rut = ?");
            statement.setString(1,t.getRut());
            statement.execute();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		
	}
	@Override
	public void create(Client t) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("insert into buys(id,state,user_rut) values (default,'CARRITO',?)");
            statement.setString(1,t.getRut());
            statement.execute();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		
	}
	
	public ResultSet verifyBuy(Client t,Product p) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT * FROM buys INNER JOIN products_buys ON buys.id = products_buys.buy_id  WHERE user_rut=? AND product_id = ? AND state = 'COMPRADO'");
            statement.setString(1,t.getRut());
            statement.setInt(2, p.getId());
            ResultSet response = statement.executeQuery();
            return response;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		return null;
	}
	
}
