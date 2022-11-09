package Assets;

import java.util.ArrayList;
import java.util.LinkedList;

import Domain.Product;

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

}
