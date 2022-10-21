package Database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import Utils.FieldFormater;

public class SQLService {
    static private SQLService sqlService = null;
    private SQLService(){}
    static public SQLService getSQLService() {
 
        if (sqlService == null) {
            sqlService = new SQLService();
        }
        return sqlService;
    }
    public ResultSet loginQuery(String values){
        try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT * FROM usuario WHERE rut=? and password=?");
            String parts[] = FieldFormater.fillArrayValues(values);
            for (int i = 0; i < parts.length; i++)statement.setString(i+1,parts[i]);
            ResultSet response = statement.executeQuery();
            return response;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
        return null;
    }

    public ResultSet productsQuery(){
        try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT * FROM producto");
            ResultSet response = statement.executeQuery();
            return response;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
        return null;
    }

    public ResultSet productsCategoryQuery(String category){
        try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT * FROM producto WHERE categoria=?");
            statement.setString(1,category);
            ResultSet response = statement.executeQuery();
            return response;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
        return null;
    }

    public void registerQuery(){
        
    }

}
