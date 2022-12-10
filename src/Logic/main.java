package Logic;
import javax.swing.SwingUtilities;
import Assets.*;
import Database.SQLConnection;
import Panels.*;
import Domain.Client;

public class main {
	public static void main(String[] args) {	
		/*
		SystemService system = SystemService.getSystem();
		system.refreshLists();
		System.out.println(system.getCategorys());
		system.start();
		*/
		//system.refreshLists();
		//system.start();
		SystemService system = SystemService.getSystem();
		system.refreshLists();
		system.start();
		//ProductListFrame pf = new ProductListFrame();
		//pf.setVisible(true);
		
		//MenuAdminEdit mae = new MenuAdminEdit();
		//mae.setVisible(true);
		
		//DEV WORKING AGAIN
		
		//ANOTAR BUGS ACA
		// PRODUCT FRAME -> al volver bota el programa
		// Al abrir desde admin un producto crea una ventana y no la borra
		// LISTA DE PRODUCTO NO DEVUELVE A USER LUEGO DE METERSE A UN PRODUCTO
		// TARJETAS TE MANDA PA ADMIN
		// SE CAYO AL HACER -> CLIENTE -> SHOPPING CART -> LISTA DE PRODUCTOS -> PRODUCTO
		//PRODUCT LIST A USURARIO SE CAYO
		// VA CREANDO NUEVAS BUY_ID AL QUITAR PRODUCTOS y PONERLOS
		// NO AGREGA DE NEVO EN SHOPPING CART
	}

}

