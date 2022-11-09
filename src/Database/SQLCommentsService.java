package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Domain.Product;

public class SQLCommentsService implements ISQLRead<Product>{
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
	
	
}
