package Panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Assets.WordWrapCellRenderer;
import Database.SQLBuyService;
import Database.SQLProductService;
import Database.SQLShoppingCart;
import Domain.Client;
import Domain.Comment;
import Domain.Product;

@SuppressWarnings("serial")
public class ProductFrame extends JFrame {

    public ProductFrame(Product product, Client client) {
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
    	ProductFrame.client = client;
    	commentsList = product.getComments();
        initComponents();
    }
                        
    private void initComponents() {

        jPanel1 = new JPanel();
        backButton = new JButton();
        jPanel2 = new JPanel();
        imageButton = new JButton();
        nameLabel = new JLabel();
        nameField = new JTextField();
        priceLabel = new JLabel();
        priceField = new JTextField();
        jScrollPane1 = new JScrollPane();
        descriptionArea = new JTextArea();
        categoryLabel = new JLabel();
        jPanel3 = new JPanel();
        commentsScrollPane = new JScrollPane();
        commentsTable = new JTable();
        jPanel4 = new JPanel();
        stockLabel = new JLabel();
        addToCartButton = new JButton();
        idLabel = new JLabel();
        idField = new JTextField();
        stockField = new JTextField();
        quantityLabel = new JLabel();
        quantitySpinner = new JSpinner();
        addCommentButton = new JButton();
        deleteCommentButton = new JButton();
        descriptionLabel = new JLabel();
        categoryField = new JTextField();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new Color(255, 212, 171));
        jPanel1.setPreferredSize(new Dimension(1280, 720));

        backButton.setIcon(new ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new Color(255, 174, 167));
        jPanel2.setPreferredSize(new Dimension(350, 350));

        imageButton.setIcon(new ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        imageButton.setContentAreaFilled(false);
        imageButton.setFocusPainted(false);
    	// imageButton.setIcon(resizeImageIcon(new ImageIcon(getClass().getResource(product.getInfo().getImg_path()))));
    	imageButton.setIcon(resizeImageIcon(new ImageIcon(getClass().getResource("/ProductIcons/cellphone.png"))));


        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(imageButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(imageButton, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );

        nameLabel.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        nameLabel.setForeground(new Color(0, 0, 0));
        nameLabel.setText("Nombre");

        nameField.setEditable(false);
        nameField.setBackground(new Color(255, 255, 255));
        nameField.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        nameField.setForeground(new Color(0, 0, 0));
        nameField.setText(product.getInfo().getName());
        nameField.setCaretColor(new Color(0, 0, 0));

        priceLabel.setBackground(new Color(255, 255, 255));
        priceLabel.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        priceLabel.setForeground(new Color(0, 0, 0));
        priceLabel.setText("Precio");

        priceField.setEditable(false);
        priceField.setBackground(new Color(255, 255, 255));
        priceField.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        priceField.setForeground(new Color(0, 0, 0));
        priceField.setText(product.getInfo().getPrice()+"");
        priceField.setCaretColor(new Color(0, 0, 0));

        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        descriptionArea.setBackground(new Color(255, 255, 255));
        descriptionArea.setColumns(20);
        descriptionArea.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        descriptionArea.setForeground(new Color(0, 0, 0));
        descriptionArea.setLineWrap(true);
        descriptionArea.setRows(5);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setCaretColor(new Color(0, 0, 0));
        descriptionArea.setText(product.getInfo().getDescription());
        descriptionArea.setEditable(false);
        jScrollPane1.setViewportView(descriptionArea);

        categoryLabel.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        categoryLabel.setForeground(new Color(0, 0, 0));
        categoryLabel.setText("Categor�a");

        jPanel3.setBackground(new Color(255, 212, 171));

        commentsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        commentsScrollPane.setFont(new Font("Segoe UI", 0, 18)); // NOI18N

        commentsTable.setBackground(new Color(255, 255, 255));
        commentsTable.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        commentsTable.setForeground(new Color(0, 0, 0));
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

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(commentsScrollPane, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(commentsScrollPane, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
        );

        jPanel4.setBackground(new Color(255, 212, 171));

        stockLabel.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        stockLabel.setForeground(new Color(0, 0, 0));
        stockLabel.setText("En stock:");

        addToCartButton.setBackground(new Color(255, 174, 167));
        addToCartButton.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        addToCartButton.setForeground(new Color(0, 0, 0));
        addToCartButton.setText("Agregar al carrito");
        addToCartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addToCartButton.setFocusPainted(false);
        addToCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addToCartButtonActionPerformed(evt);
            }
        });

        idLabel.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        idLabel.setForeground(new Color(0, 0, 0));
        idLabel.setText("ID");

        idField.setEditable(false);
        idField.setBackground(new Color(255, 255, 255));
        idField.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        idField.setForeground(new Color(0, 0, 0));
        idField.setHorizontalAlignment(JTextField.CENTER);
        idField.setText(product.getId()+"");

        stockField.setEditable(false);
        stockField.setBackground(new Color(255, 255, 255));
        stockField.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        stockField.setForeground(new Color(0, 0, 0));
        stockField.setHorizontalAlignment(JTextField.CENTER);
        stockField.setText(product.getInfo().getStock()+"");

        quantityLabel.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        quantityLabel.setForeground(new Color(0, 0, 0));
        quantityLabel.setText("Cantidad:");

        quantitySpinner.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        SpinnerNumberModel snm = new SpinnerNumberModel();
    	snm.setMinimum(1);
    	snm.setValue(1);
    	snm.setMaximum(product.getInfo().getStock());
    	quantitySpinner.setModel(snm);

        addCommentButton.setBackground(new Color(255, 174, 167));
        addCommentButton.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        addCommentButton.setForeground(new Color(0, 0, 0));
        addCommentButton.setText("Agregar comentario");
        addCommentButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addCommentButton.setFocusPainted(false);
        addCommentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addCommentButtonActionPerformed(evt);
            }
        });

        deleteCommentButton.setBackground(new Color(255, 174, 167));
        deleteCommentButton.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        deleteCommentButton.setForeground(new Color(0, 0, 0));
        deleteCommentButton.setText("Eliminar comentario");
        deleteCommentButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteCommentButton.setFocusPainted(false);
        deleteCommentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteCommentButtonActionPerformed(evt);
            }
        });

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(stockLabel)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(idLabel)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(stockField)
                    .addComponent(idField)))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(quantityLabel)
                .addGap(29, 29, 29)
                .addComponent(quantitySpinner))
            .addComponent(addCommentButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addToCartButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(deleteCommentButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(idField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel))
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(stockLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stockField))
                .addGap(30, 30, 30)
                .addComponent(addToCartButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(quantityLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quantitySpinner))
                .addGap(30, 30, 30)
                .addComponent(addCommentButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(deleteCommentButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        descriptionLabel.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        descriptionLabel.setForeground(new Color(0, 0, 0));
        descriptionLabel.setText("Descripci�n");

        categoryField.setEditable(false);
        categoryField.setBackground(new Color(255, 255, 255));
        categoryField.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        categoryField.setForeground(new Color(0, 0, 0));
        categoryField.setText("jTextField1");
        categoryField.setCaretColor(new Color(0, 0, 0));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backButton)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(nameLabel)
                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
                    .addComponent(categoryLabel)
                    .addComponent(priceField, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel)
                    .addComponent(categoryField, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
                            .addComponent(descriptionLabel))
                        .addGap(41, 41, 41)
                        .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(descriptionLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void addToCartButtonActionPerformed(ActionEvent evt) {                                                
    	int total = product.getBuy_quantity() + (int)quantitySpinner.getValue();
    	if(total>product.getInfo().getStock()) {
    		JOptionPane.showMessageDialog(null, "Cantidad seleccionada excede el stock disponible", "Error en la compra", JOptionPane.ERROR_MESSAGE);
    	} else {
    		boolean have_product = false;
    		product.setBuy_quantity(total);
    		int localQuantity = 0;
    		if (client.getTransactions().getShoppingCart().size() == 0) {

    			SQLBuyService.getSQLBuyService().create(client);
    			client.getTransactions().getShoppingCart().add(product);

    				
    		} else {
    			have_product = false;
    			for (int i =0; i < client.getTransactions().getShoppingCart().size(); i ++ ) {
    				if (client.getTransactions().getShoppingCart().get(i).getId() == product.getId()) {
    					have_product = true;
    					localQuantity = client.getTransactions().getShoppingCart().get(i).getBuy_quantity();
    					break;
    				}
    			}
    			
    		}
    		//System.out.println("ola");
    		int buy_id = SQLShoppingCart.getSQLShoppingCart().get_id(client);
    		if (have_product) {
    			SQLShoppingCart.getSQLShoppingCart().update(product, buy_id,(int)quantitySpinner.getValue() + localQuantity);
    	
    		} else {
    			SQLShoppingCart.getSQLShoppingCart().create(product, buy_id,(int)quantitySpinner.getValue());    			
    		}
    		SQLProductService.getSQLProductService().updateStock(product, (int)quantitySpinner.getValue());
    		product.getInfo().setStock(product.getInfo().getStock() - (int)quantitySpinner.getValue());
    		stockField.setText(product.getInfo().getStock()+"");;
			//SystemService.getSystem().refreshProducts();
				
    		
    	}
    }                                               

    private void addCommentButtonActionPerformed(ActionEvent evt) {  
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

    private void deleteCommentButtonActionPerformed(ActionEvent evt) {  
    	int index = commentsTable.getSelectedRow();
    	if(!commentsList.get(index).getRut().equals(client.getRut())) {
    		JOptionPane.showMessageDialog(null, "Este comentario no te pertenece", "Error al eliminar", JOptionPane.ERROR_MESSAGE);
    		return;
    	}
    	commentsList.remove(index);
    	((DefaultTableModel)commentsTable.getModel()).removeRow(index);
        commentsTable.getColumnModel().getColumn(2).setCellRenderer(new WordWrapCellRenderer());
    }                                                   

    private void backButtonActionPerformed(ActionEvent evt) {  
    	dispose();
    	ProductListFrame pdf = new ProductListFrame(client);
    	pdf.setVisible(true);
    }                 
    
    private ImageIcon resizeImageIcon(ImageIcon imageIcon) {
    	Image img = imageIcon.getImage();
		img = img.getScaledInstance(jPanel2.getPreferredSize().width, jPanel2.getPreferredSize().height,  Image.SCALE_SMOOTH);
        return new ImageIcon(img);
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
            Logger.getLogger(ProductFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ProductFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ProductFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ProductFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductFrame(product,client).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private JButton addCommentButton;
    private JButton addToCartButton;
    private JButton backButton;
    private JTextField categoryField;
    private JLabel categoryLabel;
    private JScrollPane commentsScrollPane;
    private JTable commentsTable;
    private JButton deleteCommentButton;
    private JTextArea descriptionArea;
    private JLabel descriptionLabel;
    private JTextField idField;
    private JLabel idLabel;
    private JButton imageButton;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    private JTextField nameField;
    private JLabel nameLabel;
    private JTextField priceField;
    private JLabel priceLabel;
    private JLabel quantityLabel;
    private JSpinner quantitySpinner;
    private JTextField stockField;
    private JLabel stockLabel;
    private static Client client;
    private static Product product;
    private static ArrayList<Comment> commentsList;
    // End of variables declaration                   
}
