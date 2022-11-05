package Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SQLCategoryService implements ISQLCreate<String>, ISQLDelete<String>{

	@Override
	public void create(String t) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("INSERT INTO category(name) VALUES (?)");
            statement.setString(1,t);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
	}

	@Override
	public void delete(String t) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("DELETE FROM category WHERE name = ?");
            statement.setString(1,t);
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		
	}
	
	

}
