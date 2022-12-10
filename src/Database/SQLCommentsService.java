package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import Domain.Client;
import Domain.Comment;
import Domain.Product;

public class SQLCommentsService implements ISQLRead<Product>,ISQLDelete<Comment>{
	private static SQLCommentsService service = null;

    private SQLCommentsService(){}
	static public SQLCommentsService getSQLCommentsService() {
        if (service == null) {
            service = new SQLCommentsService();
        }
        return service;
    }
	@Override
	public ResultSet read(Product t) {
			try{  
	            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT * FROM comments WHERE product_id = ?");
	            statement.setInt(1,t.getId());
	            ResultSet response = statement.executeQuery();
	            return response;
	        }catch (SQLException e){
	            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
	        }
			return null;
	}
	@Override
	public void delete(Comment t) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("DELETE comments WHERE id = ?");
            statement.setInt(1,t.getId());
            statement.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
	
		
	}
	
	public void create(Comment t, Client c) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("insert into comments (id,rating,comment,product_id,user_rut) values (default,?,?,?,?)");
            statement.setFloat(1,t.getRating());
            statement.setString(2, t.getComment());
            statement.setInt(3, t.getId());
            statement.setString(4, c.getRut());
            statement.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		
	}
	
	
	public boolean purchased(Client c) {
		try{  
            ResultSet rs = SQLBuyService.getSQLBuyService().read(c);
            if(rs.next())return true;
            return false;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		return false;
		
	}
	
	
	
}
