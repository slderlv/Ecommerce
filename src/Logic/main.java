package Logic;
import javax.swing.SwingUtilities;

import Database.SQLConnection;
import Panels.*;

public class main {
	public static void main(String[] args) {
		SQLConnection.getSQLConnection().connect();
		new RegisterPanel().setVisible(true);
	}

}

