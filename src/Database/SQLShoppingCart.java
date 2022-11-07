package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Domain.Client;

public class SQLShoppingCart implements ISQLRead<Client> {
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
}
