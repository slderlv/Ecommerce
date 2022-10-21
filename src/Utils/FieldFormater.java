package Utils;

public class FieldFormater {
    public static int getCommas(String text){
        int counter = 0;
        for (int i = 0; i < text.length(); i++){
            if(text.substring(i, i+1).equals(','))counter++;
        }
        return counter;
    }
    
    public static String[] fillArrayValues(String text){
        int commasQuantity = getCommas(text);
        String parts[] = new String[commasQuantity + 1];
        parts = text.split(",");
        return parts;
    }
    
}
