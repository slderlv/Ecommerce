package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Domain.Card;
import Domain.Client;

public class SQLCardService implements ISQLRead<Client>, ISQLCreate<Card>{
	private static SQLCardService service = null;

    private SQLCardService(){}
	static public SQLCardService getSQLCardService() {
        if (service == null) {
            service = new SQLCardService();
        }
        return service;
    }
	@Override
	public ResultSet read(Client t) {
			try{  
	            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT * FROM cards INNER JOIN cards_users ON cards.id = cards_users.card_id  WHERE cards_users.user_rut=? ");
	            statement.setString(1,t.getRut());
	            ResultSet response = statement.executeQuery();
	            return response;
	        }catch (SQLException e){
	            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
	        }
			return null;
	}
	@Override
	public void create(Card t) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("INSERT INTO cards(id,cvv,card_number,expiration_month,expiration_year) VALUES (default,?,?,?,?)");
            statement.setInt(1,t.getCardInfo().getCvv());
            statement.setString(2,t.getCardInfo().getCardNumber());   
            statement.setInt(3,t.getCardInfo().getExpirationMonth()); 
            statement.setInt(4, t.getCardInfo().getExpirationYear());
            statement.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error");
        }
	}
}
