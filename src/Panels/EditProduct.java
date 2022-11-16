/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Panels;

import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import Assets.WordWrapCellRenderer;
import Database.SQLProductService;
import Domain.Product;
import Domain.ProductInfo;

public class EditProduct extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public EditProduct(Product product) {
    	EditProduct.product = new Product(
    			new ProductInfo("Led Philips Ambilight 65 4K Uhd 65Pud7906 Android",
    					250000,
    					"Tipo	Televisores\nConexi�n WiFi	S�\nTasa de refresco nativa	60Hz\nProfundidad	293,2 mm\nEntrada Internet	S�\nSintonizador digital	S�\nPotencia de los parlantes	20W\nEntradas auxiliares de 3.5 mm	1",
    					20, "Tecnolog�a", null), 10, null, 0); 
        initComponents();
    	setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
        categoryComboBox = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        commentsScrollPane = new javax.swing.JScrollPane();
        commentsTable = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        stockLabel = new javax.swing.JLabel();
        stockSpinner = new javax.swing.JSpinner();
        saveButton = new javax.swing.JButton();
        deleteCommentButton = new javax.swing.JButton();
        deleteProductButton = new javax.swing.JButton();
        descriptionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 212, 171));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 174, 167));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 350));

        imageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        imageButton.setContentAreaFilled(false);
        imageButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imageButton.setFocusPainted(false);
        if(product.getInfo().getImg_path()!=null) {
        	imageButton.setIcon(resizeImageIcon(new javax.swing.ImageIcon(getClass().getResource(product.getInfo().getImg_path()))));
        } else {
        	imageButton.setIcon(resizeImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/product.png"))));
        }
        imageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageButtonActionPerformed(evt);
            }
        });


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

        nameField.setBackground(new java.awt.Color(255, 255, 255));
        nameField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        nameField.setForeground(new java.awt.Color(0, 0, 0));
        nameField.setText(product.getInfo().getName());
        nameField.setCaretColor(new java.awt.Color(0, 0, 0));

        priceLabel.setBackground(new java.awt.Color(255, 255, 255));
        priceLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(0, 0, 0));
        priceLabel.setText("Precio");

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
        jScrollPane1.setViewportView(descriptionArea);

        categoryLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        categoryLabel.setForeground(new java.awt.Color(0, 0, 0));
        categoryLabel.setText("Categor�a");

        categoryComboBox.setBackground(new java.awt.Color(255, 255, 255));
        categoryComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        categoryComboBox.setForeground(new java.awt.Color(0, 0, 0));
        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Category 1", "Category 2", "Category 3", "Category 4" }));

        jPanel3.setBackground(new java.awt.Color(255, 212, 171));

        commentsScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        commentsScrollPane.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        commentsTable.setBackground(new java.awt.Color(255, 255, 255));
        commentsTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        commentsTable.setForeground(new java.awt.Color(0, 0, 0));
        commentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
            		"Nombre del cliente", "Calificaci�n", "Comentario"
            }
        ));
        commentsTable.setPreferredSize(new java.awt.Dimension(200, 400));
        commentsTable.setRowHeight(100);
        commentsTable.setShowGrid(true);
        commentsTable.setShowVerticalLines(false);
        commentsTable.getColumnModel().getColumn(2).setCellRenderer(new WordWrapCellRenderer());
        commentsScrollPane.setViewportView(commentsTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(commentsScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commentsScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 212, 171));

        stockLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        stockLabel.setForeground(new java.awt.Color(0, 0, 0));
        stockLabel.setText("Stock");
        
        SpinnerNumberModel snm = new SpinnerNumberModel();
    	snm.setMinimum(0);
    	stockSpinner.setModel(snm);
        stockSpinner.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        stockSpinner.setValue(product.getInfo().getStock());

        saveButton.setBackground(new java.awt.Color(255, 174, 167));
        saveButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        saveButton.setForeground(new java.awt.Color(0, 0, 0));
        saveButton.setText("Guardar cambios");
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveButton.setFocusPainted(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
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

        deleteProductButton.setBackground(new java.awt.Color(255, 174, 167));
        deleteProductButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        deleteProductButton.setForeground(new java.awt.Color(0, 0, 0));
        deleteProductButton.setText("Eliminar producto");
        deleteProductButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteProductButton.setFocusPainted(false);
        deleteProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductButtonActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deleteProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(deleteCommentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stockLabel)
                .addGap(18, 18, 18)
                .addComponent(stockSpinner))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockLabel)
                    .addComponent(stockSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(deleteCommentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(deleteProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        descriptionLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        descriptionLabel.setForeground(new java.awt.Color(0, 0, 0));
        descriptionLabel.setText("Descripci�n");

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
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryLabel)
                    .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(descriptionLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backButton)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(descriptionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                        .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 44, Short.MAX_VALUE))
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
    }// </editor-fold>                        
    
    private void backButtonActionPerformed(ActionEvent evt) {
		dispose();
		MenuAdminEdit mae = new MenuAdminEdit(null);
		mae.setVisible(true);
	}
    
    private void imageButtonActionPerformed(ActionEvent evt) {
    	JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Seleccione una imagen");
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG o JPEG", "png", "jpeg", "gif");
		jfc.addChoosableFileFilter(filter);
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			// System.out.println(jfc.getSelectedFile().getPath());
			ImageIcon userIcon = resizeImageIcon(new ImageIcon(jfc.getSelectedFile().getPath()));
			imageButton.setIcon(userIcon);
			imageButton.repaint();
		}
	}
    
    private void saveButtonActionPerformed(ActionEvent evt) {
    	product.getInfo().setDescription(descriptionArea.getText());
    	//p.getInfo().setImg_path(getName());
    	product.getInfo().setName(nameField.getText());
    	product.getInfo().setPrice(Integer.parseInt(priceField.getText()));
    	product.getInfo().setStock((Integer) stockSpinner.getValue());
    	product.getInfo().setCategory(categoryComboBox.getSelectedItem().toString());
    	SQLProductService.getSQLProductService().update(product);		
	}
    
    private void deleteCommentButtonActionPerformed(ActionEvent evt) {
    			
	}
    
    private void deleteProductButtonActionPerformed(ActionEvent evt) {
    	SQLProductService.getSQLProductService().delete(product);				
	}
    
    private ImageIcon resizeImageIcon(ImageIcon imageIcon) {
    	Image img = imageIcon.getImage();
		img = img.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(img);
	}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditProduct(product).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JScrollPane commentsScrollPane;
    private javax.swing.JTable commentsTable;
    private javax.swing.JButton deleteCommentButton;
    private javax.swing.JButton deleteProductButton;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JLabel descriptionLabel;
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
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel stockLabel;
    private javax.swing.JSpinner stockSpinner;
    private static Product product;
    // End of variables declaration                   
}