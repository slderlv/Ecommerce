package Panels;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import Assets.ArrayToString;
import Assets.WordWrapCellRenderer;
import Database.SQLProductService;
import Domain.Comment;
import Domain.Product;
import Domain.ProductInfo;
import Logic.SystemService;

@SuppressWarnings("serial")
public class EditProduct extends javax.swing.JFrame {

	public EditProduct(Product product) {
    	/*EditProduct.product = new Product(
    			new ProductInfo("Led Philips Ambilight 65 4K Uhd 65Pud7906 Android",
    				250000,
    					"Tipo	Televisores\nConexi�n WiFi	S�\nTasa de refresco nativa	60Hz\nProfundidad	293,2 mm\nEntrada Internet	S�\nSintonizador digital	S�\nPotencia de los parlantes	20W\nEntradas auxiliares de 3.5 mm	1",
    					20, "Tecnolog�a", null), 10, null, 0); 
    	commentsList = new ArrayList<>();
    	for(int i=0; i<10; i++) {
            commentsList.add(new Comment(0,(float) 5.5,"Muy bueno me ayudo mucho etc etc etc etc etc",product,null));
    	}
    	*/
		categoriesList = SystemService.getSystem().getCategorys();
		EditProduct.product = product;
		commentsList = product.getComments();
    	initComponents();
        setLocationRelativeTo(null);
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
        idLabel = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        descriptionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 212, 171));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        
        // ProductIcons/foto.png
        
        jPanel2.setBackground(new java.awt.Color(255, 174, 167));
        jPanel2.setPreferredSize(new java.awt.Dimension(350, 350));

        imageButton.setContentAreaFilled(false);
        imageButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        imageButton.setFocusPainted(false);
        if(product.getInfo().getImg_path()!=null) {
        	imageButton.setIcon(resizeImageIcon(new javax.swing.ImageIcon(getClass().getResource(product.getInfo().getImg_path()))));
        } else {
        	imageButton.setIcon(resizeImageIcon(new javax.swing.ImageIcon(getClass().getResource("/ProductIcons/cellphone.png"))));
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
            .addComponent(imageButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        categoryLabel.setText("Categor\u00eda");

        categoryComboBox.setBackground(new java.awt.Color(255, 255, 255));
        categoryComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        categoryComboBox.setForeground(new java.awt.Color(0, 0, 0));
        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(ArrayToString.getStringArray(categoriesList)));

        jPanel3.setBackground(new java.awt.Color(255, 212, 171));

        commentsScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        commentsScrollPane.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        commentsTable.setBackground(new java.awt.Color(255, 255, 255));
        commentsTable.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        commentsTable.setForeground(new java.awt.Color(0, 0, 0));
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

        idLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        idLabel.setForeground(new java.awt.Color(0, 0, 0));
        idLabel.setText("ID");

        idField.setEditable(false);
        idField.setBackground(new java.awt.Color(255, 255, 255));
        idField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        idField.setForeground(new java.awt.Color(0, 0, 0));
        idField.setText(product.getId()+"");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(deleteProductButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(deleteCommentButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(stockLabel))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(idLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stockSpinner)
                    .addComponent(idField))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockLabel)
                    .addComponent(stockSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(deleteCommentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(deleteProductButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        descriptionLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        descriptionLabel.setForeground(new java.awt.Color(0, 0, 0));
        descriptionLabel.setText("Descripci\u00f3n");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backButton)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(descriptionLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(0, 6, Short.MAX_VALUE))
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
        
        prevName = nameField.getText();
        prevPrice = Integer.parseInt(priceField.getText());
        
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
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG", "png");
		jfc.addChoosableFileFilter(filter);
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			String imagePath = jfc.getSelectedFile().getPath();
			ImageIcon productIcon = resizeImageIcon(new ImageIcon(imagePath));
	        imageButton.setIcon(productIcon);
			imageButton.repaint();
			File original = new File(imagePath);
			String path = "ProductIcons/"+product.getId()+"."+getFileType(original);
			File copy = new File(path);
			product.getInfo().setImg_path("/"+path);
			try {
				Files.copy(original.toPath(), copy.toPath(), StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    
    private String getFileType(File original) {
    	String fileName = original.getPath();
    	int lastIndex = fileName.lastIndexOf(".");
    	return fileName.substring(lastIndex+1);
	}

	private void saveButtonActionPerformed(ActionEvent evt) {
    	
    	if(nameField.getText().strip().equals("")) {
    		JOptionPane.showMessageDialog(null, "El nombre no puede estar vac\u00edo", "Error al guardar", JOptionPane.INFORMATION_MESSAGE);
    		nameField.setText(prevName);
    	} else {
    		product.getInfo().setName(nameField.getText());
    	}
    	
    	try {
    		@SuppressWarnings("unused")
			int intValue = Integer.parseInt(priceField.getText());
    		product.getInfo().setPrice(Integer.parseInt(priceField.getText()));
    	} catch (NumberFormatException e) {
    		JOptionPane.showMessageDialog(null, "Precio ingresado es inv\u00e1lido", "Error al guardar", JOptionPane.INFORMATION_MESSAGE);
    		priceField.setText(prevPrice+"");
    	}
    	
    	product.getInfo().setDescription(descriptionArea.getText());
    	product.getInfo().setStock((Integer) stockSpinner.getValue());
    	product.getInfo().setCategory(categoryComboBox.getSelectedItem().toString());
    	SQLProductService.getSQLProductService().update(product);		
	}
    
    private void deleteCommentButtonActionPerformed(ActionEvent evt) {
    	int index = commentsTable.getSelectedRow();
    	commentsList.remove(index);
    	((DefaultTableModel)commentsTable.getModel()).removeRow(index);
        commentsTable.getColumnModel().getColumn(2).setCellRenderer(new WordWrapCellRenderer());
    }
    
    private void deleteProductButtonActionPerformed(ActionEvent evt) {
    	SQLProductService.getSQLProductService().delete(product);
    	dispose();
    	MenuAdminEdit mae = new MenuAdminEdit(null);
    	mae.setVisible(true);    	
	}
    
    private ImageIcon resizeImageIcon(ImageIcon imageIcon) {
    	Image img = imageIcon.getImage();
		img = img.getScaledInstance(jPanel2.getPreferredSize().width-50, jPanel2.getPreferredSize().height,  java.awt.Image.SCALE_SMOOTH);
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
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
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
    private javax.swing.JLabel idLabel;
    private javax.swing.JTextField idField;
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
    private String prevName;
    private int prevPrice;
    private ArrayList<Comment> commentsList;
    private ArrayList<String> categoriesList;
    // End of variables declaration                   
}