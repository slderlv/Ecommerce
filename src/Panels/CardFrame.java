package Panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import Assets.JTextFieldLimit;
import Database.SQLBuyService;
import Database.SQLCardService;
import Domain.Card;
import Domain.CardInfo;
import Domain.Client;
import Domain.Product;

@SuppressWarnings("serial")
public class CardFrame extends JFrame {

    public CardFrame(Client client, ArrayList<Product> productList) {
    	CardFrame.client = client;
    	CardFrame.productList = productList;
        initComponents();
    }
                       
    private void initComponents() {

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();
        cardholderName = new JFormattedTextField();
        jLabel2 = new JLabel();
        cardNumber = new JFormattedTextField();
        month = new JFormattedTextField();
        year = new JFormattedTextField();
        cvv = new JFormattedTextField();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        pay = new JButton();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        back = new JButton();

        setTitle("Ecommerce - Agregar tarjeta");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(255, 212, 171));

        jPanel2.setBackground(new Color(255, 174, 167));

        jLabel1.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("TITULAR");

        jLabel2.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new Color(255, 255, 255));
        jLabel2.setText("N\u00daMERO");

        jLabel3.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setText("EXPIRACI\u00d3N\n");

        jLabel4.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new Color(255, 255, 255));
        jLabel4.setText("MES");

        jLabel5.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new Color(255, 255, 255));
        jLabel5.setText("A\u00d1O");

        jLabel6.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new Color(255, 255, 255));
        jLabel6.setText("CVV");

        pay.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        pay.setText("PAGAR");
        pay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	Pay(evt);
            }
        });
        

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(cardholderName)
                            .addComponent(cardNumber)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(jLabel4))
                                            .addComponent(month, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(jLabel5))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(year, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(cvv, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))))))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pay, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cardholderName, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cardNumber, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(month, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(year, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cvv, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(pay, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new Color(255, 174, 167));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jTextArea1.setForeground(new Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("\t\n\n\tDATOS DE TRANSFERECIA\n\nCUENTA N:\n\nBANCO:\n\nTIPO DE CUENTA:\n\nCORREO:\n\n\n\tTOTAL A PAGAR\n");
        jScrollPane1.setViewportView(jTextArea1);

        back.setBackground(new Color(255, 212, 171));
        back.setIcon(new ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        back.setActionCommand("VOLVER");
        back.setBorderPainted(false);
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	Back(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(back)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(back)
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        cardholderName.setFont(new Font("Segoe UI", 0, 24)); 
        cardholderName.setDocument(new JTextFieldLimit(40));
        cardNumber.setFont(new Font("Segoe UI", 0, 24));
        cardNumber.setDocument(new JTextFieldLimit(16));
        cvv.setFont(new Font("Segoe UI", 0, 16));
        cvv.setDocument(new JTextFieldLimit(3));
        month.setDocument(new JTextFieldLimit(2));
        year.setDocument(new JTextFieldLimit(2));
        pack();
    }
    
    private void Back(ActionEvent evt) {                      
    	dispose();
    	ShoppingCart sc = new ShoppingCart(client);
    	sc.setVisible(true);
    }      
    
    private void Pay(ActionEvent evt) {                      
    	CardInfo cardInfo = new CardInfo(Integer.parseInt(cvv.getText()),cardNumber.getText(),Integer.parseInt(month.getText()),Integer.parseInt(year.getText()));
    	Card card = new Card(cardInfo,client);
    	ResultSet rs = SQLCardService.getSQLCardService().checkIfExists(card);
    	try {
			if(rs.next()) {
				//The card exists only link
				SQLCardService.getSQLCardService().linkCard(card, client);
			} else {
				//Create the new card and link
				SQLCardService.getSQLCardService().create(card, client);
			}
			JOptionPane.showMessageDialog(null, "Tarjeta creada con exito");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	   
   		for(int x=0;x<client.getTransactions().getShoppingCart().size(); x++){
    		if(client.getTransactions().getShoppingCart().get(x).getBuy_quantity() == 0) {
    				client.getTransactions().getShoppingCart().remove(x);
    		}
    	}
    		
    	for(int i=0;  i<productList.size(); i++) {
    		for(int x=0;x<client.getTransactions().getShoppingCart().size(); x++){
    			if(productList.get(i).getId() == client.getTransactions().getShoppingCart().get(x).getId()) {
    				int stock = productList.get(i).getInfo().getStock()-client.getTransactions().getShoppingCart().get(x).getBuy_quantity();
    				productList.get(i).getInfo().setStock(stock);
    			}
    		}
    	}
    	JOptionPane.showMessageDialog(null, "Compra realizada con \u00e9xito","Confirmaci\u00f3n de compra",JOptionPane.INFORMATION_MESSAGE);
	    SQLBuyService sqls = SQLBuyService.getSQLBuyService();
	    sqls.update(client);
	    dispose();
	    ClientFrame cf = new ClientFrame(client);
	    cf.setVisible(true);
    }      

    public static void main(String args[]) {

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CardFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CardFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CardFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CardFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CardFrame(client, productList).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private JButton back;
    private JFormattedTextField cardNumber;
    private JFormattedTextField cardholderName;
    private JFormattedTextField cvv;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private JFormattedTextField month;
    private JButton pay;
    private JFormattedTextField year;
    private static Client client;
    private static ArrayList<Product> productList;
    // End of variables declaration                   
}
