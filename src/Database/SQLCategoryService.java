package Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SQLCategoryService implements ISQLCreate<String>, ISQLDelete<String>{
	private static SQLCategoryService service = null;

    private SQLCategoryService(){}
	static public SQLCategoryService getSQLCategoryService() {
        if (service == null) {
            service = new SQLCategoryService();
        }
        return service;
    }
	@Override
	public void create(String t) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("INSERT INTO category(name) VALUES (?)");
            statement.setString(1,t);
            statement.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
	}

	@Override
	public void delete(String t) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("DELETE FROM category WHERE name = ?");
            statement.setString(1,t);
            statement.execute();
            
            PreparedStatement statementProducts = SQLConnection.getSQLConnection().connect().prepareStatement("UPDATE products SET category = 'NO-ASIGNADO' WHERE category = ?");
            statementProducts.setString(1, t);
            statementProducts.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		
	}
	
	public ResultSet read() {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT  * FROM category");
            ResultSet response = statement.executeQuery();
            return response;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		return null;
	}
	
	public void update(String categoryName, String newCategoryName) {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("UPDATE category SET name = ? WHERE name = ?");
            statement.setString(1, newCategoryName);
            statement.setString(2, categoryName);
            statement.execute();
            
            PreparedStatement statementProducts = SQLConnection.getSQLConnection().connect().prepareStatement("UPDATE products SET category = ? WHERE category = ?");
            statementProducts.setString(1, newCategoryName);
            statementProducts.setString(2, categoryName);
            statementProducts.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
	}

}
