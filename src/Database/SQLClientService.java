package Database;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Domain.User;

public class SQLClientService implements ISQLGenericRepository<User>{
    //All user querys, from admin and client
    private static SQLClientService service = null;

    private SQLClientService(){}
	static public SQLClientService getSQLLoginService() {
        if (service == null) {
            service = new SQLClientService();
        }
        return service;
    }

    @Override
    public void create(User t) {
        // Register
        try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("INSERT INTO users(rut,admin,name,password,phone_number,mail,img_path) VALUES (?,false,?,?,null,?,null)");
            statement.setString(1,t.getRut());
            statement.setString(2,t.getName());  
            statement.setString(3,t.getPassword());   
            statement.setString(4,t.getMail()); 
            statement.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
    }

    @Override
    public ResultSet read(User t) {
        // login
        try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("SELECT * FROM users WHERE rut=? and password=?");
            statement.setString(1,t.getRut());
            statement.setString(2,t.getPassword());
            ResultSet response = statement.executeQuery();
            return response;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
        return null;
    }

    @Override
    public void update(User t) {
        // EDIT
        try{  
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("UPDATE users SET mail = ?, password = ?, phone_number = ? WHERE rut = ?");
            statement.setString(1,t.getMail());
            statement.setString(2,t.getPassword());
            //statement.setString(3, t.getNumber());
            statement.setString(4, t.getRut());
            statement.execute();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
    }

    @Override
    public void delete(User t) {
        // Admin/USER Delete
        try{
            PreparedStatement statement = SQLConnection.getSQLConnection().connect().prepareStatement("DELETE FROM users WHERE rut = ?");
            //+ borrar todo lo relacionado a EL USUARIO
            statement.setString(1, t.getRut());
            statement.execute();
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error con la consulta" + e);
        }
        
    }
    
}
