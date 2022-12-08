package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Domain.Card;
import Domain.Client;

public class SQLCardService implements ISQLRead<Client>{
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
	            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT * FROM cards inner join cards_users on cards.card_number = cards_users.card_number WHERE user_rut = ? ");
	            statement.setString(1,t.getRut());
	            ResultSet response = statement.executeQuery();
	            return response;
	        }catch (SQLException e){
	            JOptionPane.showMessageDialog(null, "Error con la consulta (aca)" + e);
	        }
			return null;
	}
	public void create(Card t,Client client) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("INSERT INTO cards(cvv,card_number,expiration_month,expiration_year) VALUES (?,?,?,?)");
            statement.setInt(1,t.getCardInfo().getCvv());
            statement.setString(2,t.getCardInfo().getCardNumber());   
            statement.setInt(3,t.getCardInfo().getExpirationMonth()); 
            statement.setInt(4, t.getCardInfo().getExpirationYear());
            statement.execute();
            
            PreparedStatement statement2 = SQLConnection.getSQLConnection().connect().prepareStatement("INSERT INTO cards_users(id,user_rut,card_number) VALUES (default,?,?)");
            statement2.setString(1,client.getRut());
            statement2.setString(2,t.getCardInfo().getCardNumber());   
            statement2.execute();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error");
        }
	}
	
	public ResultSet checkIfExists(Card c) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT * FROM cards where card_number=? ");
            statement.setString(1,c.getCardInfo().getCardNumber());
            ResultSet response = statement.executeQuery();
            return response;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		return null;
	}
	
	public void linkCard(Card card,Client client) {
		PreparedStatement statement;
		try {
			statement = SQLConnection.getSQLConnection().connect().prepareStatement("INSERT INTO cards_users(id,user_rut,card_number) VALUES (default,?,?)");
			statement.setString(2,card.getCardInfo().getCardNumber());   
			statement.setString(1,client.getRut());
			statement.execute();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
		}
	}
	
	
}
