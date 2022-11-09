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
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("INSERT INTO categorys(name) VALUES (?)");
            statement.setString(1,t);
            statement.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
	}

	@Override
	public void delete(String t) {
		try{  
			if(t.equals("NO-ASIGNADO"))return;
			PreparedStatement statementProducts = SQLConnection.getSQLConnection().connect().prepareStatement("UPDATE products SET category = 'NO-ASIGNADO' WHERE category = ?");
			statementProducts.setString(1, t);
			statementProducts.execute();
			
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("DELETE FROM categorys WHERE name = ?");
            statement.setString(1,t);
            statement.execute();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		
	}
	
	public ResultSet read() {
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT  * FROM categorys");
            ResultSet response = statement.executeQuery();
            return response;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
		return null;
	}
	
	public void update(String categoryName, String newCategoryName) {
		try{  
			create(newCategoryName);
			PreparedStatement statementProducts = SQLConnection.getSQLConnection().connect().prepareStatement("UPDATE products SET category = ? WHERE category = ?");
			statementProducts.setString(1, newCategoryName);
			statementProducts.setString(2, categoryName);
			statementProducts.execute();
			
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("DELETE FROM categorys WHERE name = ?");
            statement.setString(1, categoryName);
            statement.execute();
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
	}

}
