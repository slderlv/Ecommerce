package Panels;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import Assets.WordWrapCellRenderer;
import Database.SQLBuyService;
import Database.SQLShoppingCart;
import Domain.Client;
import Domain.Comment;
import Domain.Product;
import Domain.ProductInfo;

public class ProductFrame extends javax.swing.JFrame {

    public ProductFrame(Product product) {
    	ProductFrame.product = product; /*new Product(
    			new ProductInfo("Led Philips Ambilight 65 4K Uhd 65Pud7906 Android",
    					250000,
    					"Tipo	Televisores\nConexi�n WiFi	S�\nTasa de refresco nativa	60Hz\nProfundidad	293,2 mm\nEntrada Internet	S�\nSintonizador digital	S�\nPotencia de los parlantes	20W\nEntradas auxiliares de 3.5 mm	1",
    					20, "Tecnolog�a", null), 10, null, 0);
    	commentsList = new ArrayList<>();
    	for(int i=0; i<10; i++) {
            commentsList.add(new Comment(0,(float) 5.5,"Muy bueno me ayudo mucho etc etc etc etc etc",product,null));
    	}
    	*/
    	commentsList = product.getComments();
        initComponents();
    }
                        
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        imageButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        priceLabel = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        categoryLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        commentsScrollPane = new javax.swing.JScrollPane();
        commentsTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        stockLabel = new javax.swing.JLabel();
        addToCartButton = new javax.swing.JButton();
        idLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        stockField = new javax.swing.JTextField();
        quantityLabel = new javax.swing.JLabel();
        quantitySpinner = new javax.swing.JSpinner();
        addCommentButton = new javax.swing.JButton();
        deleteCommentButton = new javax.swing.JButton();
        descriptionLabel = new javax.swing.JLabel();
        categoryField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 212, 171));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

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

        jPanel2.setBackground(new java.awt.Color(255, 174, 167));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 350));

        imageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        imageButton.setContentAreaFilled(false);
        imageButton.setFocusPainted(false);
    	// imageButton.setIcon(resizeImageIcon(new javax.swing.ImageIcon(getClass().getResource(product.getInfo().getImg_path()))));
    	imageButton.setIcon(resizeImageIcon(new javax.swing.ImageIcon(getClass().getResource("/ProductIcons/cellphone.png"))));


        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imageButton, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(0, 0, 0));
        nameLabel.setText("Nombre");

        nameField.setEditable(false);
        nameField.setBackground(new java.awt.Color(255, 255, 255));
        nameField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameField.setForeground(new java.awt.Color(0, 0, 0));
        nameField.setText(product.getInfo().getName());
        nameField.setCaretColor(new java.awt.Color(0, 0, 0));

        priceLabel.setBackground(new java.awt.Color(255, 255, 255));
        priceLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(0, 0, 0));
        priceLabel.setText("Precio");

        priceField.setEditable(false);
        priceField.setBackground(new java.awt.Color(255, 255, 255));
        priceField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        priceField.setForeground(new java.awt.Color(0, 0, 0));
        priceField.setText(product.getInfo().getPrice()+"");
        priceField.setCaretColor(new java.awt.Color(0, 0, 0));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        descriptionArea.setBackground(new java.awt.Color(255, 255, 255));
        descriptionArea.setColumns(20);
        descriptionArea.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        descriptionArea.setForeground(new java.awt.Color(0, 0, 0));
        descriptionArea.setLineWrap(true);
        descriptionArea.setRows(5);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setCaretColor(new java.awt.Color(0, 0, 0));
        descriptionArea.setText(product.getInfo().getDescription());
        descriptionArea.setEditable(false);
        jScrollPane1.setViewportView(descriptionArea);

        categoryLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        categoryLabel.setForeground(new java.awt.Color(0, 0, 0));
        categoryLabel.setText("Categor�a");

        jPanel3.setBackground(new java.awt.Color(255, 212, 171));

        commentsScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        commentsScrollPane.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        commentsTable.setBackground(new java.awt.Color(255, 255, 255));
        commentsTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        commentsTable.setForeground(new java.awt.Color(0, 0, 0));
        commentsTable.setRowHeight(100);
        commentsTable.setShowGrid(true);
        commentsTable.setShowVerticalLines(false);
        String[] columnNames = {"Nombre del cliente", "Calificaci\u00f3n", "Comentario"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for(int i=0; i<commentsList.size(); i++) {
        	Comment c = commentsList.get(i);
        	String[] rowData = {"Nombre cliente"+i,c.getRating()+"", c.getComment()};
        	model.addRow(rowData);
        }
        commentsTable.setModel(model);
        commentsTable.setRowHeight(100);
        commentsTable.setShowGrid(true);
        commentsTable.setShowVerticalLines(false);
        commentsTable.getColumnModel().getColumn(2).setCellRenderer(new WordWrapCellRenderer());
        commentsScrollPane.setViewportView(commentsTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(commentsScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(commentsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 212, 171));

        stockLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        stockLabel.setForeground(new java.awt.Color(0, 0, 0));
        stockLabel.setText("En stock:");

        addToCartButton.setBackground(new java.awt.Color(255, 174, 167));
        addToCartButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        addToCartButton.setForeground(new java.awt.Color(0, 0, 0));
        addToCartButton.setText("Agregar al carrito");
        addToCartButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addToCartButton.setFocusPainted(false);
        addToCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartButtonActionPerformed(evt);
            }
        });

        idLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        idLabel.setForeground(new java.awt.Color(0, 0, 0));
        idLabel.setText("ID");

        idField.setEditable(false);
        idField.setBackground(new java.awt.Color(255, 255, 255));
        idField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        idField.setForeground(new java.awt.Color(0, 0, 0));
        idField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        idField.setText(product.getId()+"");

        stockField.setEditable(false);
        stockField.setBackground(new java.awt.Color(255, 255, 255));
        stockField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        stockField.setForeground(new java.awt.Color(0, 0, 0));
        stockField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        stockField.setText(product.getInfo().getStock()+"");

        quantityLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        quantityLabel.setForeground(new java.awt.Color(0, 0, 0));
        quantityLabel.setText("Cantidad:");

        quantitySpinner.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        SpinnerNumberModel snm = new SpinnerNumberModel();
    	snm.setMinimum(1);
    	snm.setValue(1);
    	snm.setMaximum(product.getInfo().getStock());
    	quantitySpinner.setModel(snm);

        addCommentButton.setBackground(new java.awt.Color(255, 174, 167));
        addCommentButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        addCommentButton.setForeground(new java.awt.Color(0, 0, 0));
        addCommentButton.setText("Agregar comentario");
        addCommentButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addCommentButton.setFocusPainted(false);
        addCommentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCommentButtonActionPerformed(evt);
            }
        });

        deleteCommentButton.setBackground(new java.awt.Color(255, 174, 167));
        deleteCommentButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        deleteCommentButton.setForeground(new java.awt.Color(0, 0, 0));
        deleteCommentButton.setText("Eliminar comentario");
        deleteCommentButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteCommentButton.setFocusPainted(false);
        deleteCommentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCommentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stockLabel)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(idLabel)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stockField)
                    .addComponent(idField)))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(quantityLabel)
                .addGap(29, 29, 29)
                .addComponent(quantitySpinner))
            .addComponent(addCommentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addToCartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(deleteCommentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(stockLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stockField))
                .addGap(30, 30, 30)
                .addComponent(addToCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quantityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quantitySpinner))
                .addGap(30, 30, 30)
                .addComponent(addCommentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(deleteCommentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        descriptionLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        descriptionLabel.setForeground(new java.awt.Color(0, 0, 0));
        descriptionLabel.setText("Descripci�n");

        categoryField.setEditable(false);
        categoryField.setBackground(new java.awt.Color(255, 255, 255));
        categoryField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        categoryField.setForeground(new java.awt.Color(0, 0, 0));
        categoryField.setText("jTextField1");
        categoryField.setCaretColor(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backButton)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(nameLabel)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(categoryLabel)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel)
                    .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(descriptionLabel))
                        .addGap(41, 41, 41)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(descriptionLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void addToCartButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
    	int total = product.getBuy_quantity() + (int)quantitySpinner.getValue();
    	if(total>product.getInfo().getStock()) {
    		JOptionPane.showMessageDialog(null, "Cantidad seleccionada excede el stock disponible", "Error en la compra", JOptionPane.ERROR_MESSAGE);
    	} else {
    		product.setBuy_quantity(total);
    		if(!shoppingCart.contains(product)) {
    			shoppingCart.add(product);
    			if (client.getTransactions().getShoppingCart().size() == 0) {
    				SQLBuyService.getSQLBuyService().create(client);
    			}
    			int buy_id = SQLShoppingCart.getSQLShoppingCart().get_id(client);
    			SQLShoppingCart.getSQLShoppingCart().create(product, buy_id);
    		}
    		
    	}
    }                                               

    private void addCommentButtonActionPerformed(java.awt.event.ActionEvent evt) {  
    	// CONSULTA SQL: SI EL CLIENTE HA COMPRADO ESTE PRODUCTO
    	float rating = 0; 
    	try {
    		rating = Float.parseFloat(JOptionPane.showInputDialog("Califique el producto de 1 a 5:"));
    	} catch (NumberFormatException e) {
    		JOptionPane.showMessageDialog(null, "La calificaci�n ingresada es inv�lida","Error de formato",JOptionPane.ERROR_MESSAGE);
    		return;
    	}
    	if(rating<1||rating>5) {
    		JOptionPane.showMessageDialog(null, "La calificaci�n ingresada es inv�lida", "Error de formato", JOptionPane.ERROR_MESSAGE);
    		return;
    	}
    	String comment = JOptionPane.showInputDialog("Ingrese su comentario:");
    	if(comment.isBlank()) {
    		JOptionPane.showMessageDialog(null, "El comentario est� vac�o", "Error de formato", JOptionPane.ERROR_MESSAGE);
    		return;
    	};
    	if(comment.length()>70) {
    		JOptionPane.showMessageDialog(null, "El comentario excede el m�ximo de car�cteres", "Error de formato", JOptionPane.ERROR_MESSAGE);
    		return;
    	}
    	// ARREGLAR ID
    	// commentsList.add(new Comment(0,rating,comment,product,client));
    	JOptionPane.showMessageDialog(null, "El comentario se ha publicado existosamente", "Comentario", JOptionPane.INFORMATION_MESSAGE);
    	String[] row = {"hola",rating+"",comment}; // client.getName()
    	((DefaultTableModel)commentsTable.getModel()).addRow(row);
    	commentsTable.getColumnModel().getColumn(2).setCellRenderer(new WordWrapCellRenderer());
    }                                                

    private void deleteCommentButtonActionPerformed(java.awt.event.ActionEvent evt) {  
    	int index = commentsTable.getSelectedRow();
    	if(!commentsList.get(index).getClient().equals(client)) {
    		JOptionPane.showMessageDialog(null, "Este comentario no te pertenece", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
    		return;
    	}
    	commentsList.remove(index);
    	((DefaultTableModel)commentsTable.getModel()).removeRow(index);
        commentsTable.getColumnModel().getColumn(2).setCellRenderer(new WordWrapCellRenderer());
    }                                                   

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {  
    	dispose();
    	ProductListFrame pdf = new ProductListFrame(client);
    	pdf.setVisible(true);
    }                 
    
    private ImageIcon resizeImageIcon(ImageIcon imageIcon) {
    	Image img = imageIcon.getImage();
		img = img.getScaledInstance(jPanel2.getPreferredSize().width, jPanel2.getPreferredSize().height,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(img);
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
            java.util.logging.Logger.getLogger(ProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductFrame(product).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton addCommentButton;
    private javax.swing.JButton addToCartButton;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField categoryField;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JScrollPane commentsScrollPane;
    private javax.swing.JTable commentsTable;
    private javax.swing.JButton deleteCommentButton;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JButton imageButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JSpinner quantitySpinner;
    private javax.swing.JTextField stockField;
    private javax.swing.JLabel stockLabel;
    private static Client client;
    private static Product product;
    private static ArrayList<Product> shoppingCart;
    private static ArrayList<Comment> commentsList;
    // End of variables declaration                   
}
