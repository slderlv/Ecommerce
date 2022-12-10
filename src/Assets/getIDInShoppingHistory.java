package Assets;

public class getIDInShoppingHistory {
	public static int getId(String txt) {
		String stringId = "";
		for (int i = 3; i < txt.length(); i ++) {
			//System.out.println(txt.substring(i,i+1));
			if(!txt.substring(i,i+1).equals(")")) {
				stringId += txt.substring(i,i+1);
				
			}else {
				break;
			}
		}
		
		return Integer.parseInt(stringId);
	}
}
