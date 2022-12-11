package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SQLConnection {
	// URL --> jdbc:postgresql://localhost/CAMBIAR_POR_EL_NOMBRE_DE_LA_BASE_DE_DATOS
	// USER --> postgres
	// password --> PASSWORD INGRESADA EN PGADMIN
	
	private static final String url = "jdbc:postgresql://localhost/PPAV";
	private static final String user = "postgres";
	private static final String password = "123"; //anashe123
	
	
	private static Connection connection =  null;
	private static SQLConnection sqlConnection = null;
    
	private SQLConnection(){}
	static public SQLConnection getSQLConnection() {
 
        if (sqlConnection == null) {
            sqlConnection = new SQLConnection();
        }
        return sqlConnection;
    }

	public Connection connect() {
		try {
			connection = DriverManager.getConnection(url,user,password);
			if(connection != null)return connection;
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "La base de datos, creo muchos clientes de conexion. Por favor reinicie la aplicacion");
			e.printStackTrace();
		}
		return null;
	}

	public void close(){
		connection = null;
	}
}
