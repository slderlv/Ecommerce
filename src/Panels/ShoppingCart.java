package Panels;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Domain.Buy;
import Domain.Client;
import Domain.Product;
import Domain.ProductInfo;
import Domain.Transactions;

public class ShoppingCart extends javax.swing.JFrame {

	public ShoppingCart(Client client,ArrayList<Product> productList) {
    	ShoppingCart.client = new Client("21249678-2", "aaaaa", "aaaaa", "aaaaa@aaa.aaa", 949314109, null, "aaaaa", null, "UserIcons/juan_bekios.jpeg");
    	Product product = new Product(
    			new ProductInfo("Led Philips Ambilight 65",
    					250000,
    					"Tipo	Televisores\nConexi�n WiFi	S�\nTasa de refresco nativa	60Hz\nProfundidad	293,2 mm\nEntrada Internet	S�\nSintonizador digital	S�\nPotencia de los parlantes	20W\nEntradas auxiliares de 3.5 mm	1",
    					20, "Tecnolog�a", null), 10, null, 10);
    	
    	ShoppingCart.productList = new ArrayList<>();
    	ShoppingCart.productList.add(product);
    	// ShoppingCart.client = client;
        // ShoppingCart.productList = productList;
    	initComponents(client,ShoppingCart.productList);
	}
                     
    private void initComponents(Client client,ArrayList<Product> productList) {

        jPanel1 = new javax.swing.JPanel();
        shoppingCartScrollPane = new javax.swing.JScrollPane();
        shoppingCartTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        selectedProductLabel = new javax.swing.JLabel();
        selectedProductField = new javax.swing.JTextField();
        addUnitButton = new javax.swing.JButton();
        removeUnitButton = new javax.swing.JButton();
        totalAmountField = new javax.swing.JTextField();
        totalAmountLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        addCardButton = new javax.swing.JButton();
        cardsComboBox = new javax.swing.JComboBox<>();
        payButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 212, 171));

        shoppingCartScrollPane.setBackground(new java.awt.Color(255, 111, 156));
        shoppingCartScrollPane.setForeground(new java.awt.Color(0, 0, 0));
        shoppingCartScrollPane.setAutoscrolls(true);

        shoppingCartTable.setBackground(new java.awt.Color(255, 255, 255));
        shoppingCartTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        shoppingCartTable.setForeground(new java.awt.Color(0, 0, 0));
        String[] columnNames = {"Nombre","Unidades","Subtotal"};
        String[] rowData = new String[3];
        
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(columnNames, 0);
        int sum = 0;
        for(int i=0; i<productList.size(); i++){
        	rowData[0] = productList.get(i).getInfo().getName();
        	rowData[1] = productList.get(i).getBuy_quantity()+"";
        	System.out.println(productList.get(i).getBuy_quantity());
        	rowData[2] = (productList.get(i).getInfo().getPrice()) * Integer.parseInt(rowData[1])+"";
        	model.addRow(rowData);
        	sum+=Integer.parseInt(rowData[2]);
        }
        totalAmountField.setText(sum+"");
        shoppingCartTable.setModel(model);
        for (int c = 0; c < shoppingCartTable.getColumnCount(); c++){
            Class<?> col_class = shoppingCartTable.getColumnClass(c);
            shoppingCartTable.setDefaultEditor(col_class, null);        // remove editor
        }
        shoppingCartTable.setGridColor(new java.awt.Color(0, 0, 0));
        shoppingCartTable.setShowGrid(true);
        shoppingCartTable.setShowHorizontalLines(false);
        shoppingCartTable.getTableHeader().setResizingAllowed(false);
        shoppingCartTable.getTableHeader().setReorderingAllowed(false);
        shoppingCartTable.getTableHeader().setBackground(new java.awt.Color(255,111,156));
        shoppingCartTable.getTableHeader().setForeground(new java.awt.Color(0,0,0));
        shoppingCartTable.getSelectionModel().addListSelectionListener(new ListSelectionListener () {
			public void valueChanged(ListSelectionEvent evt) {
				selectedRowActionPerformed(evt);
			}
        });

        shoppingCartScrollPane.setViewportView(shoppingCartTable);

        jPanel2.setBackground(new java.awt.Color(255, 212, 171));

        selectedProductLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        selectedProductLabel.setForeground(new java.awt.Color(0, 0, 0));
        selectedProductLabel.setText("Producto seleccionado:");

        selectedProductField.setEditable(false);
        selectedProductField.setBackground(new java.awt.Color(255, 255, 255));
        selectedProductField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        selectedProductField.setForeground(new java.awt.Color(0, 0, 0));
        selectedProductField.setText("Seleccione un producto");

        addUnitButton.setBackground(new java.awt.Color(255, 111, 156));
        addUnitButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addUnitButton.setForeground(new java.awt.Color(0, 0, 0));
        addUnitButton.setText("Agregar unidad");
        addUnitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addUnitButton.setFocusPainted(false);
        addUnitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUnitButtonActionPerformed(evt);
            }
        });

        removeUnitButton.setBackground(new java.awt.Color(255, 111, 156));
        removeUnitButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        removeUnitButton.setForeground(new java.awt.Color(0, 0, 0));
        removeUnitButton.setText("Eliminar unidad");
        removeUnitButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        removeUnitButton.setFocusPainted(false);
        removeUnitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeUnitButtonActionPerformed(evt);
            }
        });

        totalAmountField.setEditable(false);
        totalAmountField.setBackground(new java.awt.Color(255, 255, 255));
        totalAmountField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        totalAmountField.setForeground(new java.awt.Color(0, 0, 0));
        totalAmountField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        if(client.getTransactions().getShoppingCart() != null) {
        	int total = 0;
        	for(int i=0; i<productList.size(); i++){ 
        		total = total + client.getTransactions().getShoppingCart().get(i).getBuy_quantity()*productList.get(i).getInfo().getPrice();
        	}
        	String total2 = ""+total;
        	totalAmountField.setText(total2);
        }

        totalAmountLabel.setBackground(new java.awt.Color(255, 255, 255));
        totalAmountLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        totalAmountLabel.setForeground(new java.awt.Color(0, 0, 0));
        totalAmountLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalAmountLabel.setText("Total a pagar:");
        
        

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(addUnitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(removeUnitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(selectedProductField)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(selectedProductLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(totalAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(totalAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(selectedProductLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectedProductField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addUnitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeUnitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalAmountLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        addCardButton.setBackground(new java.awt.Color(255, 111, 156));
        addCardButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        addCardButton.setForeground(new java.awt.Color(0, 0, 0));
        addCardButton.setText("Agregar tarjeta");
        addCardButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addCardButton.setFocusPainted(false);
        addCardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCardButtonActionPerformed(evt);
            }
        });

        cardsComboBox.setBackground(new java.awt.Color(255, 255, 255));
        cardsComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cardsComboBox.setForeground(new java.awt.Color(0, 0, 0));
        cardsComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1111 1111 1111 1111", "2222 2222 2222 2222", "Item 3", "Item 4" }));

        payButton.setBackground(new java.awt.Color(255, 111, 156));
        payButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        payButton.setForeground(new java.awt.Color(0, 0, 0));
        payButton.setText("Pagar");
        payButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        payButton.setFocusPainted(false);
        payButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(shoppingCartScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cardsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(addCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(payButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backButton)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(shoppingCartScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cardsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addCardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addComponent(payButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void selectedRowActionPerformed(ListSelectionEvent evt) {                  
    	if(shoppingCartTable.getSelectedRowCount()==1) {
    		String productName = (String) shoppingCartTable.getModel().getValueAt(shoppingCartTable.getSelectedRow(), 0);
        	selectedProductField.setText(productName);
    	}
    } 
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {  
    	dispose();
    	ClientFrame cf = new ClientFrame(client, productList);
    	cf.setVisible(true);
    } 
    
    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {   
    	if(client.getCards().isEmpty() == true) {
    		dispose();
        	CardFrame cf = new CardFrame();
        	cf.setVisible(true);
    	}else {
    		client.getTransactions().getBuys().add(new Buy(0,client,client.getTransactions().getShoppingCart()));
    		for(int i=0;  i<productList.size(); i++) {
    			for(int x=0;x<client.getTransactions().getShoppingCart().size(); x++){
    				if(productList.get(i).getId() == client.getTransactions().getShoppingCart().get(x).getId()) {
    					int stock = productList.get(i).getInfo().getStock()-client.getTransactions().getShoppingCart().get(x).getBuy_quantity();
    					productList.get(i).getInfo().setStock(stock);
    				}
    			}
    		}
    	}
    } 
    
    private void addCardButtonActionPerformed(java.awt.event.ActionEvent evt) {   
    	dispose();
    	CardFrame cf = new CardFrame();
    	cf.setVisible(true);
    }

    private void addUnitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        int rowIndex = shoppingCartTable.getSelectedRow();
        int quantity = productList.get(rowIndex).getBuy_quantity();
        int stock = productList.get(rowIndex).getInfo().getStock();
        if(quantity==stock) {
        	JOptionPane.showMessageDialog(null, "No hay m�s productos en el stock", "Error al agregar unidad", JOptionPane.INFORMATION_MESSAGE);
        	return;
        }
        updateFrame(true,rowIndex,quantity);
    }                                             

    

	private void removeUnitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
    	int rowIndex = shoppingCartTable.getSelectedRow();
        int quantity = productList.get(rowIndex).getBuy_quantity();
        if(quantity==1) {
        	Object[] buttons = {"Aceptar","Cancelar"};
        	int reply = JOptionPane.showOptionDialog(null, "�Est� seguro que desea eliminar este producto del carrito?", "Eliminar producto del carrito",
        	        JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[0]);
        	if(reply==1) {
        		// ELIMINAR PRODUCTO
        		return;
        	}
        }
        updateFrame(false,rowIndex,quantity);
    }     
	
	private void updateFrame(boolean add,int rowIndex, int quantity) {
		int price = productList.get(rowIndex).getInfo().getPrice();
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
		productList.get(rowIndex).setBuy_quantity(quantity);
        shoppingCartTable.getModel().setValueAt(quantity, rowIndex, 1);
        shoppingCartTable.getModel().setValueAt(subtotal, rowIndex, 2);
        totalAmountField.setText(total+"");
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
            java.util.logging.Logger.getLogger(ShoppingCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShoppingCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShoppingCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShoppingCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShoppingCart(client,productList).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify          
    private javax.swing.JButton addCardButton;
    private javax.swing.JButton addUnitButton;
    private javax.swing.JComboBox<String> cardsComboBox;
    private javax.swing.JButton backButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton payButton;
    private javax.swing.JButton removeUnitButton;
    private javax.swing.JTextField selectedProductField;
    private javax.swing.JLabel selectedProductLabel;
    private javax.swing.JScrollPane shoppingCartScrollPane;
    private javax.swing.JTable shoppingCartTable;
    private javax.swing.JTextField totalAmountField;
    private javax.swing.JLabel totalAmountLabel;
    private static ArrayList<Product> productList;
    private static Client client;
    // End of variables declaration                   
}

