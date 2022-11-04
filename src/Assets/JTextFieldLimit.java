package Assets;

public class JTextFieldLimit extends javax.swing.text.PlainDocument {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1300817086295022323L;
	private int limit;

	  public JTextFieldLimit(int limit) {
	   super();
	   this.limit = limit;
	   }

	  public void insertString( int offset, String  str, javax.swing.text.AttributeSet attr ) throws javax.swing.text.BadLocationException {
	    if (str == null) return;

	    if ((getLength() + str.length()) <= limit) {
	      super.insertString(offset, str, attr);
	    }
	  }
}
