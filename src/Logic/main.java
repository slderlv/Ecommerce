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
		// BUG AL ELIMINAR NO-ASIGNADO -> TIRA UN ERROR RARO DEBERIA TIRAR UN NO SE PUEDE BORRAR NO ASIGNADO (tal vez esta mal desde code)
		// COMPRE UNA CUESTION Y SE CAYO (teniendo un producto con 0)
		// DEL SHOPPING ME SACO AL LOGIN
	}

}

