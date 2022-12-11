package Panels;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Assets.ArrayToString;
import Database.SQLBuyService;
import Database.SQLProductService;
import Database.SQLShoppingCart;
import Domain.Client;
import Domain.Product;
import Logic.SystemService;

@SuppressWarnings("serial")
public class AdminShoppingCart extends JFrame {

	public AdminShoppingCart(Client client) {
    	AdminShoppingCart.client = client;
    	shoppingCart = client.getTransactions().getShoppingCart();
    	initComponents();
	}
                     
    private void initComponents() {

        jPanel1 = new JPanel();
        shoppingCartScrollPane = new JScrollPane();
        shoppingCartTable = new JTable();
        jPanel2 = new JPanel();
        selectedProductLabel = new JLabel();
        selectedProductField = new JTextField();
        addUnitButton = new JButton();
        removeUnitButton = new JButton();
        totalAmountField = new JTextField();
        totalAmountLabel = new JLabel();
        backButton = new JButton();
        addCardButton = new JButton();
        cardsComboBox = new JComboBox<>();
        payButton = new JButton();
        
        setTitle("Ecommerce - Administrar carrito de usuario");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(255, 212, 171));

        shoppingCartScrollPane.setBackground(new Color(255, 111, 156));
        shoppingCartScrollPane.setForeground(new Color(0, 0, 0));
        shoppingCartScrollPane.setAutoscrolls(true);

        shoppingCartTable.setBackground(new Color(255, 255, 255));
        shoppingCartTable.setFont(new Font("Segoe UI", 0, 14)); 
        shoppingCartTable.setForeground(new Color(0, 0, 0));
        String[] columnNames = {"Nombre","Unidades","Subtotal"};
        String[] rowData = new String[3];
        
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        int sum = 0;
        for(int i=0; i<shoppingCart.size(); i++){
        	rowData[0] = shoppingCart.get(i).getInfo().getName();
        	rowData[1] = shoppingCart.get(i).getBuy_quantity()+"";
        	rowData[2] = (shoppingCart.get(i).getInfo().getPrice()) * Integer.parseInt(rowData[1])+"";
        	if (shoppingCart.get(i).getBuy_quantity() > 0) {
        		model.addRow(rowData);
        		sum+=Integer.parseInt(rowData[2]);	
        	}
        }
        totalAmountField.setText(sum+"");
        shoppingCartTable.setModel(model);
        for (int c = 0; c < shoppingCartTable.getColumnCount(); c++){
            Class<?> col_class = shoppingCartTable.getColumnClass(c);
            shoppingCartTable.setDefaultEditor(col_class, null); // remove editor
        }
        shoppingCartTable.setGridColor(new Color(0, 0, 0));
        shoppingCartTable.setShowGrid(true);
        shoppingCartTable.setShowHorizontalLines(false);
        shoppingCartTable.getTableHeader().setResizingAllowed(false);
        shoppingCartTable.getTableHeader().setReorderingAllowed(false);
        shoppingCartTable.getTableHeader().setBackground(new Color(255,111,156));
        shoppingCartTable.getTableHeader().setForeground(new Color(0,0,0));
        shoppingCartTable.getSelectionModel().addListSelectionListener(new ListSelectionListener () {
			public void valueChanged(ListSelectionEvent evt) {
				selectedRowActionPerformed(evt);
			}
        });

        shoppingCartScrollPane.setViewportView(shoppingCartTable);

        jPanel2.setBackground(new Color(255, 212, 171));

        selectedProductLabel.setFont(new Font("Segoe UI", 0, 24)); 
        selectedProductLabel.setForeground(new Color(0, 0, 0));
        selectedProductLabel.setText("Producto seleccionado:");

        selectedProductField.setEditable(false);
        selectedProductField.setBackground(new Color(255, 255, 255));
        selectedProductField.setFont(new Font("Segoe UI", 0, 18)); 
        selectedProductField.setForeground(new Color(0, 0, 0));
        selectedProductField.setText("Seleccione un producto");

        addUnitButton.setBackground(new Color(255, 111, 156));
        addUnitButton.setFont(new Font("Segoe UI", 0, 18)); 
        addUnitButton.setForeground(new Color(0, 0, 0));
        addUnitButton.setText("Agregar unidad");
        addUnitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addUnitButton.setFocusPainted(false);
        addUnitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addUnitButtonActionPerformed(evt);
            }
        });

        removeUnitButton.setBackground(new Color(255, 111, 156));
        removeUnitButton.setFont(new Font("Segoe UI", 0, 18)); 
        removeUnitButton.setForeground(new Color(0, 0, 0));
        removeUnitButton.setText("Eliminar unidad");
        removeUnitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        removeUnitButton.setFocusPainted(false);
        removeUnitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                removeUnitButtonActionPerformed(evt);
            }
        });

        totalAmountField.setEditable(false);
        totalAmountField.setBackground(new Color(255, 255, 255));
        totalAmountField.setFont(new Font("Segoe UI", 0, 24)); 
        totalAmountField.setForeground(new Color(0, 0, 0));
        totalAmountField.setHorizontalAlignment(JTextField.CENTER);
        if(shoppingCart != null) {
        	int total = 0;
        	for(int i=0; i<shoppingCart.size(); i++){ 
        		total = total + shoppingCart.get(i).getBuy_quantity()*AdminShoppingCart.shoppingCart.get(i).getInfo().getPrice();
        	}
        	String total2 = ""+total;
        	totalAmountField.setText(total2);
        }

        totalAmountLabel.setBackground(new Color(255, 255, 255));
        totalAmountLabel.setFont(new Font("Segoe UI", 0, 24)); 
        totalAmountLabel.setForeground(new Color(0, 0, 0));
        totalAmountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        totalAmountLabel.setText("Total a pagar:");
        
        

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(addUnitButton, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(removeUnitButton, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
            .addComponent(selectedProductField)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(selectedProductLabel)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(totalAmountLabel, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(totalAmountField, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(selectedProductLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectedProductField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addUnitButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeUnitButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(totalAmountLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalAmountField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
        );

        backButton.setIcon(new ImageIcon(getClass().getResource("/Icons/back.png")));
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        addCardButton.setBackground(new Color(255, 111, 156));
        addCardButton.setFont(new Font("Segoe UI", 0, 18)); 
        addCardButton.setForeground(new Color(0, 0, 0));
        addCardButton.setText("Agregar tarjeta");
        addCardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addCardButton.setFocusPainted(false);
        addCardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addCardButtonActionPerformed(evt);
            }
        });

        cardsComboBox.setBackground(new Color(255, 255, 255));
        cardsComboBox.setFont(new Font("Segoe UI", 0, 14)); 
        cardsComboBox.setForeground(new Color(0, 0, 0));
        if(client.getCards()!=null) {
            cardsComboBox.setModel(new DefaultComboBoxModel<>(ArrayToString.getStringArrayFromCards(client.getCards())));
        }
        
        payButton.setBackground(new Color(255, 111, 156));
        payButton.setFont(new Font("Segoe UI", 0, 18)); 
        payButton.setForeground(new Color(0, 0, 0));
        payButton.setText("Pagar");
        payButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        payButton.setFocusPainted(false);
        payButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(shoppingCartScrollPane, GroupLayout.PREFERRED_SIZE, 800, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cardsComboBox, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(addCardButton, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(payButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(shoppingCartScrollPane, GroupLayout.PREFERRED_SIZE, 550, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(cardsComboBox, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                            .addComponent(addCardButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(payButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        
        pack();

        cardsComboBox.setVisible(false);
        payButton.setVisible(false);
        addCardButton.setVisible(false);
        setLocationRelativeTo(null);
    }                     

    private void selectedRowActionPerformed(ListSelectionEvent evt) {                  
    	if(shoppingCartTable.getSelectedRowCount()==1) {
    		String productName = (String) shoppingCartTable.getModel().getValueAt(shoppingCartTable.getSelectedRow(), 0);
        	selectedProductField.setText(productName);
    	}
    } 
    
    private void backButtonActionPerformed(ActionEvent evt) {  
    	dispose();
    	MenuAdminEdit mae = new MenuAdminEdit(null);
    	mae.setVisible(true);
    } 
    
    private void payButtonActionPerformed(ActionEvent evt) { 
    	if(client.getTransactions().getShoppingCart() != null ){
	    	if(client.getCards().isEmpty() == true) {
	    		dispose();
	        	CardFrame cf = new CardFrame(client, shoppingCart);
	        	cf.setVisible(true);
	    	}
	    	else {
	    		boolean allElements = true;
	    		for(int x=0;x<client.getTransactions().getShoppingCart().size(); x++){
	    			if(client.getTransactions().getShoppingCart().get(x).getBuy_quantity() > 0) {
	    				allElements = false;
	    				break;
	    			}
	    		}
	    		if(client.getTransactions().getShoppingCart().size() == 0 || allElements == true) {
	    			JOptionPane.showMessageDialog(null, "Tiene que haber un producto en el carrito antes de poder pagar");
	    		} else {
	    			SQLBuyService sqls = SQLBuyService.getSQLBuyService();
	    			sqls.update(client);
	    			JOptionPane.showMessageDialog(null, "ARTICULOS COMPRADOS");
	    			
	    		}
	    	}
    	}
    } 
    
    private void addCardButtonActionPerformed(ActionEvent evt) {   
    	dispose();
    	CardFrame cf = new CardFrame(client, shoppingCart);
    	cf.setVisible(true);
    }

    private void addUnitButtonActionPerformed(ActionEvent evt) { 
        int rowIndex = shoppingCartTable.getSelectedRow();
        int quantity = shoppingCart.get(rowIndex).getBuy_quantity();
        int stock = 0;
        Product p =null;
        for(int i =0 ; i < SystemService.getSystem().getProducts().size(); i ++) {
        	if (shoppingCart.get(rowIndex).getId() == SystemService.getSystem().getProducts().get(i).getId()) {
        		stock = SystemService.getSystem().getProducts().get(i).getInfo().getStock();
        		p = SystemService.getSystem().getProducts().get(i);
        		break;
        	}
        }
        
        if(stock <= 0) {
        	JOptionPane.showMessageDialog(null, "No hay mas productos en el stock", "Error al agregar unidad", JOptionPane.INFORMATION_MESSAGE);
        } else {
        	int buy_id = SQLShoppingCart.getSQLShoppingCart().get_id(client);
        	SQLProductService.getSQLProductService().updateStock(p, 1);
        	SQLShoppingCart.getSQLShoppingCart().update(shoppingCart.get(rowIndex), buy_id, quantity + 1);
        	SystemService.getSystem().refreshProducts();
        	updateFrame(true,rowIndex,quantity);

        }
    }                                             

    

	private void removeUnitButtonActionPerformed(ActionEvent evt) {                                                 
    	int rowIndex = shoppingCartTable.getSelectedRow();
        int quantity = shoppingCart.get(rowIndex).getBuy_quantity();
        Product p = null;
        for(int i =0 ; i < SystemService.getSystem().getProducts().size(); i ++) {
        	if (shoppingCart.get(rowIndex).getId() == SystemService.getSystem().getProducts().get(i).getId()) {
        		p = SystemService.getSystem().getProducts().get(i);
        		break;
        	}
        }
        if(quantity==1) {
        	Object[] buttons = {"Aceptar","Cancelar"};
        	int reply = JOptionPane.showOptionDialog(null, "\u00bfEst\u00e1 seguro que desea eliminar este producto del carrito?", "Eliminar producto del carrito",
        	        JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[0]);
        	System.out.println(reply);
        	if(reply==0) {
        		System.out.println("buenas");
        		int buy_id = SQLShoppingCart.getSQLShoppingCart().get_id(client);
        		SQLShoppingCart.getSQLShoppingCart().update(shoppingCart.get(rowIndex), buy_id, 0);
        		SQLProductService.getSQLProductService().sumStock(p, 1);
        		shoppingCart.remove(rowIndex);
        		dispose();
        		SystemService.getSystem().getTransactions(client);
        		AdminShoppingCart sc = new AdminShoppingCart(client);
        		sc.setVisible(true);
        		
        	} 
        } else {
        	shoppingCart.get(rowIndex).setBuy_quantity(shoppingCart.get(rowIndex).getBuy_quantity() - 1);
        	int buy_id = SQLShoppingCart.getSQLShoppingCart().get_id(client);
        	SQLProductService.getSQLProductService().sumStock(p, 1);
        	SQLShoppingCart.getSQLShoppingCart().update(shoppingCart.get(rowIndex), buy_id, shoppingCart.get(rowIndex).getBuy_quantity());
        	SystemService.getSystem().refreshProducts();
        }
        updateFrame(false,rowIndex,quantity);
    }     
	
	private void updateFrame(boolean add,int rowIndex, int quantity) {
		int price = shoppingCart.get(rowIndex).getInfo().getPrice();
        int subtotal = quantity*price;
        int total = Integer.parseInt(totalAmountField.getText());
		if(add) {
			quantity++;
	        subtotal += price;
	        total += price;
		} else {
			quantity--;
	        subtotal -= price;
	        total -= price;
		}
		shoppingCart.get(rowIndex).setBuy_quantity(quantity);
        shoppingCartTable.getModel().setValueAt(quantity, rowIndex, 1);
        shoppingCartTable.getModel().setValueAt(subtotal, rowIndex, 2);
        totalAmountField.setText(total+"");
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
            Logger.getLogger(AdminShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(AdminShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AdminShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(AdminShoppingCart.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminShoppingCart(client).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify          
    private JButton addCardButton;
    private JButton addUnitButton;
    private JComboBox<String> cardsComboBox;
    private JButton backButton;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JButton payButton;
    private JButton removeUnitButton;
    private JTextField selectedProductField;
    private JLabel selectedProductLabel;
    private JScrollPane shoppingCartScrollPane;
    private JTable shoppingCartTable;
    private JTextField totalAmountField;
    private JLabel totalAmountLabel;
    private static Client client;
    private static ArrayList<Product> shoppingCart;
    // End of variables declaration                   
}

