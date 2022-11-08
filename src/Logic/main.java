package Logic;
import javax.swing.SwingUtilities;
import Assets.*;
import Database.SQLConnection;
import Panels.*;

public class main {
	public static void main(String[] args) {	
		
		SystemService system = SystemService.getSystem();
		system.refreshLists();
		System.out.println(system.getCategorys());
		system.start();
		//system.refreshLists();
		//system.start();
		
		// Client Frame example
		//Domain.Client client = new Domain.Client("15234156-8", "Pedro", "123123", "correo@algo.com", 949314109, null, "La Florida #153",null, null);
		//ClientFrame cf = new ClientFrame(client);
		//cf.setVisible(true);
		
		//DEV WORKING AGAIN
	}

}

