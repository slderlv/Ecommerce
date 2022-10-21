package Utils;

public class RutFormat {
    public static boolean isValid(String rut){
        String formatRut =  formatToDatabase(rut);
        int length = formatRut.length();
        int sum = getSumOfRut(formatRut);
        if (11- sum % 11 == 11 && formatRut.substring(length-1, length).equals("0")) return true;
        if (11- sum % 11 == 10 && formatRut.substring(length-1, length).equals("K")) return true;
        if (11- sum % 11 == Integer.parseInt(formatRut.substring(length-1, length))) return true;        	
        return false;
    }

    public static int getSumOfRut(String rut) {
    	String formatRut = formatToDatabase(rut);
    	int counter = 2;
        int sum = 0;
        for (int i = formatRut.length()-2; i > 0; i--){
            if(counter == 8) counter = 2;
            sum += Integer.parseInt(formatRut.substring(i-1, i)) * counter;
            counter++;   
        }
        return sum;
    }
    
    public static String formatToDatabase(String rut){
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        if (rut.substring(rut.length()-1,rut.length()).equals("k"))rut = rut.substring(0,rut.length()-1) + "-K";
        else rut = rut.substring(0,rut.length()-1) + "-" + rut.substring(rut.length()-1, rut.length());
        return rut;
    } 
}
