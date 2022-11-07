package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Domain.Client;

public class SQLBuyService implements ISQLRead<Client> {
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
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT * FROM buys INNER JOIN products_buys ON buys.id = products_buys.buy_id  WHERE user_rut=? AND state = 'COMPRADO'");
            statement.setString(1,t.getRut());
            ResultSet response = statement.executeQuery();
            return response;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		return null;
	}
	
}
