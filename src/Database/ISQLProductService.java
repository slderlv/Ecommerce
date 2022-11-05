package Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Domain.Product;

public class ISQLProductService {

	public void create(String category) {
		// TODO Auto-generated method stub
		try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("INSERT INTO products(id,name,price,description,stock,category,img_path) VALUES (default,null,null,null,null,?,null");
            statement.setString(1,category);
            statement.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
	}
	
}
