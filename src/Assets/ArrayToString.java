package Assets;

import java.util.ArrayList;
import java.util.LinkedList;

import Domain.Card;
import Domain.Product;
import Domain.Purchase;

public class ArrayToString {
	
	
    public static String[] getStringLinked(LinkedList<String> categoriesList) {
		// TODO Auto-generated method stub
    	String[] array = new String[categoriesList.size()];
    	for(int i=0; i<categoriesList.size(); i++) {
    		array[i] = categoriesList.get(i);
    	}
		return array;
	}
    
    
    public static String[] getStringArray(ArrayList<String> categoriesList) {
		// TODO Auto-generated method stub
    	String[] array = new String[categoriesList.size()];
    	for(int i=0; i<categoriesList.size(); i++) {
    		array[i] = categoriesList.get(i);
    	}
		return array;
	}
    
    public static String[] getStringArrayFromProducts(ArrayList<Product> products) {
		// TODO Auto-generated method stub
    	String[] array = new String[products.size()];
    	for(int i=0; i<products.size(); i++) {
    		array[i] = products.get(i).getInfo().getName();
    	}
		return array;
	}
    
    public static String[] getStringArrayFromCards(ArrayList<Card> cards) {
		// TODO Auto-generated method stub
    	String[] array = new String[cards.size()];
    	for(int i=0; i<cards.size(); i++) {
    		array[i] = cards.get(i).getCardInfo().getCardNumber();
    	}
		return array;
	}
    
    public static String[] getStringArrayFromPurchases(ArrayList<Purchase> purchaseList) {
		// TODO Auto-generated method stub
    	int counter = 1;
    	String[] array = new String[purchaseList.size()];
    	for(int i=0; i<purchaseList.size(); i++) {
    		array[i] = "ID:" + purchaseList.get(i).getId()+ ") Compra N: " + counter;
    		
    		counter ++;
    	}
		return array;
	}

}
