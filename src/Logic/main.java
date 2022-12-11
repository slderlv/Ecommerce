package Logic;
import javax.swing.SwingUtilities;
import Assets.*;
import Database.SQLConnection;
import Panels.*;
import Domain.Client;

public class main {
	public static void main(String[] args) {	
		SystemService system = SystemService.getSystem();
		system.refreshLists();
		system.start();
		
		//ANOTAR BUGS ACA
		// Se buggea shopping cart mas de un item en 0
	}

}

