package Panels;

import Domain.Admin;
import Domain.Client;
import Domain.Purchase;

@SuppressWarnings("serial")
public class PurchaseFrame extends javax.swing.JFrame {

    public PurchaseFrame(Client client,Purchase purchase,Admin admin) {
    	PurchaseFrame.client = client;
    	PurchaseFrame.purchase = purchase;
    	PurchaseFrame.admin = admin;
        initComponents();
    }
                        
    private void initComponents() {

        background = new javax.swing.JPanel();
        exitbutton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        shoppinglist = new javax.swing.JTable();

        setTitle("Ecommerce - Registro de compra");
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(255, 212, 171));

        exitbutton.setBackground(new java.awt.Color(255, 212, 171));
        exitbutton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        exitbutton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitbuttonActionPerformed(evt);
            }
        });

        shoppinglist.setBackground(new java.awt.Color(255, 27, 157));
        shoppinglist.setForeground(new java.awt.Color(255, 255, 255));
        shoppinglist.getTableHeader().setResizingAllowed(false);
        shoppinglist.getTableHeader().setReorderingAllowed(false);
        shoppinglist.setShowGrid(false);
        String[] columnNames = {"Nombre","Unidades","Subtotal"};
        String[] rowData = new String[3];
        
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(columnNames, 0);
        for(int i=0; i<purchase.getProducts().size(); i++){
        	rowData[0] = purchase.getProducts().get(i).getInfo().getName();
        	rowData[1] = purchase.getProducts().get(i).getBuy_quantity()+"";
        	rowData[2] = (purchase.getProducts().get(i).getInfo().getPrice()) * Integer.parseInt(rowData[1])+"";
        	model.addRow(rowData);
        }
        shoppinglist.setModel(model);
        for (int c = 0; c < shoppinglist.getColumnCount(); c++){
            Class<?> col_class = shoppinglist.getColumnClass(c);
            shoppinglist.setDefaultEditor(col_class, null); // remove editor
        }
        jScrollPane3.setViewportView(shoppinglist);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(exitbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(exitbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);

    }                    

    private void exitbuttonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        dispose();
        if(admin==null) {
        	ShoppingHistory sh = new ShoppingHistory(client,admin);
        	sh.setVisible(true);
        } else {
        	AdminShoppingHistory ash = new AdminShoppingHistory(client,admin);
        	ash.setVisible(true);
        }
    	
    }                                          

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PurchaseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PurchaseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PurchaseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PurchaseFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PurchaseFrame(client,purchase,admin).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel background;
    private javax.swing.JButton exitbutton;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable shoppinglist;
    private static Purchase purchase;
    private static Client client;
    private static Admin admin;
    // End of variables declaration                   
}
