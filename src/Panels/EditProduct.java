package Panels;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import Assets.ArrayToString;
import Assets.WordWrapCellRenderer;
import Database.SQLCommentsService;
import Database.SQLProductService;
import Domain.Admin;
import Domain.Comment;
import Domain.Product;
import Logic.SystemService;

@SuppressWarnings("serial")
public class EditProduct extends JFrame {

	public EditProduct(Product product,Admin admin) {
		categoriesList = SystemService.getSystem().getCategorys();
		EditProduct.product = product;
		commentsList = product.getComments();
    	initComponents();
        setLocationRelativeTo(null);
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
        categoryComboBox = new JComboBox<>();
        jPanel3 = new JPanel();
        commentsScrollPane = new JScrollPane();
        commentsTable = new JTable();
        jPanel4 = new JPanel();
        stockLabel = new JLabel();
        stockSpinner = new JSpinner();
        saveButton = new JButton();
        deleteCommentButton = new JButton();
        deleteProductButton = new JButton();
        idLabel = new JLabel();
        idField = new JTextField();
        descriptionLabel = new JLabel();

        setTitle("Ecommerce - Editor de producto");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new Color(255, 212, 171));
        jPanel1.setPreferredSize(new Dimension(1280, 720));

        backButton.setIcon(new ImageIcon(getClass().getResource("/Icons/back.png"))); 
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setFocusPainted(false);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        
        jPanel2.setBackground(new Color(255, 174, 167));
        jPanel2.setPreferredSize(new Dimension(350, 350));

        imageButton.setContentAreaFilled(false);
        imageButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageButton.setFocusPainted(false);
        if(product.getInfo().getImg_path()!=null) {
        	imageButton.setIcon(resizeImageIcon(new ImageIcon(getClass().getResource(product.getInfo().getImg_path()))));
        } else {
        	imageButton.setIcon(resizeImageIcon(new ImageIcon(getClass().getResource("/ProductIcons/cellphone.png"))));
        }
        imageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                imageButtonActionPerformed(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(imageButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(imageButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        nameLabel.setFont(new Font("Segoe UI", 0, 24)); 
        nameLabel.setForeground(new Color(0, 0, 0));
        nameLabel.setText("Nombre");

        nameField.setBackground(new Color(255, 255, 255));
        nameField.setFont(new Font("Segoe UI", 0, 18)); 
        nameField.setForeground(new Color(0, 0, 0));
        nameField.setText(product.getInfo().getName());
        nameField.setCaretColor(new Color(0, 0, 0));

        priceLabel.setBackground(new Color(255, 255, 255));
        priceLabel.setFont(new Font("Segoe UI", 0, 24)); 
        priceLabel.setForeground(new Color(0, 0, 0));
        priceLabel.setText("Precio");

        priceField.setBackground(new Color(255, 255, 255));
        priceField.setFont(new Font("Segoe UI", 0, 18)); 
        priceField.setForeground(new Color(0, 0, 0));
        priceField.setText(product.getInfo().getPrice()+"");
        priceField.setCaretColor(new Color(0, 0, 0));

        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        descriptionArea.setBackground(new Color(255, 255, 255));
        descriptionArea.setColumns(20);
        descriptionArea.setFont(new Font("Segoe UI", 0, 24)); 
        descriptionArea.setForeground(new Color(0, 0, 0));
        descriptionArea.setLineWrap(true);
        descriptionArea.setRows(5);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setCaretColor(new Color(0, 0, 0));
        descriptionArea.setText(product.getInfo().getDescription());
        jScrollPane1.setViewportView(descriptionArea);

        categoryLabel.setFont(new Font("Segoe UI", 0, 24)); 
        categoryLabel.setForeground(new Color(0, 0, 0));
        categoryLabel.setText("Categor\u00eda");

        categoryComboBox.setBackground(new Color(255, 255, 255));
        categoryComboBox.setFont(new Font("Segoe UI", 0, 18)); 
        categoryComboBox.setForeground(new Color(0, 0, 0));
        categoryComboBox.setModel(new DefaultComboBoxModel<>(ArrayToString.getStringArray(categoriesList)));

        jPanel3.setBackground(new Color(255, 212, 171));

        commentsScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        commentsScrollPane.setFont(new Font("Segoe UI", 0, 18)); 

        commentsTable.setBackground(new Color(255, 255, 255));
        commentsTable.setFont(new Font("Segoe UI", 0, 18)); 
        commentsTable.setForeground(new Color(0, 0, 0));
        String[] columnNames = {"Nombre del cliente", "Calificaci\u00f3n", "Comentario"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        for(int i=0; i<commentsList.size(); i++) {
        	Comment c = commentsList.get(i);
        	String[] rowData = {c.getRut(),c.getRating()+"", c.getComment()};
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
            .addComponent(commentsScrollPane, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(commentsScrollPane, GroupLayout.PREFERRED_SIZE, 248, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new Color(255, 212, 171));

        stockLabel.setFont(new Font("Segoe UI", 0, 24)); 
        stockLabel.setForeground(new Color(0, 0, 0));
        stockLabel.setText("Stock");

        SpinnerNumberModel snm = new SpinnerNumberModel();
    	snm.setMinimum(0);
    	stockSpinner.setModel(snm);
        stockSpinner.setFont(new Font("Segoe UI", 0, 24)); 
        stockSpinner.setValue(product.getInfo().getStock());

        saveButton.setBackground(new Color(255, 174, 167));
        saveButton.setFont(new Font("Segoe UI", 0, 24)); 
        saveButton.setForeground(new Color(0, 0, 0));
        saveButton.setText("Guardar cambios");
        saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saveButton.setFocusPainted(false);
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        deleteCommentButton.setBackground(new Color(255, 174, 167));
        deleteCommentButton.setFont(new Font("Segoe UI", 0, 24)); 
        deleteCommentButton.setForeground(new Color(0, 0, 0));
        deleteCommentButton.setText("Eliminar comentario");
        deleteCommentButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteCommentButton.setFocusPainted(false);
        deleteCommentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteCommentButtonActionPerformed(evt);
            }
        });

        deleteProductButton.setBackground(new Color(255, 174, 167));
        deleteProductButton.setFont(new Font("Segoe UI", 0, 24)); 
        deleteProductButton.setForeground(new Color(0, 0, 0));
        deleteProductButton.setText("Eliminar producto");
        deleteProductButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteProductButton.setFocusPainted(false);
        deleteProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteProductButtonActionPerformed(evt);
            }
        });

        idLabel.setFont(new Font("Segoe UI", 0, 24)); 
        idLabel.setForeground(new Color(0, 0, 0));
        idLabel.setText("ID");

        idField.setEditable(false);
        idField.setBackground(new Color(255, 255, 255));
        idField.setFont(new Font("Segoe UI", 0, 24)); 
        idField.setForeground(new Color(0, 0, 0));
        idField.setText(product.getId()+"");

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(deleteProductButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(deleteCommentButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(saveButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(stockLabel))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(idLabel)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(stockSpinner)
                    .addComponent(idField))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(idField, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLabel))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(stockLabel)
                    .addComponent(stockSpinner, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(deleteCommentButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(deleteProductButton, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
        );

        descriptionLabel.setFont(new Font("Segoe UI", 0, 24)); 
        descriptionLabel.setForeground(new Color(0, 0, 0));
        descriptionLabel.setText("Descripci\u00f3n");

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
                    .addComponent(categoryComboBox, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryLabel)
                    .addComponent(priceField, GroupLayout.PREFERRED_SIZE, 350, GroupLayout.PREFERRED_SIZE)
                    .addComponent(priceLabel))
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(descriptionLabel)
                            .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backButton)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(descriptionLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                        .addComponent(categoryComboBox, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
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
        
        prevName = nameField.getText();
        prevPrice = Integer.parseInt(priceField.getText());
        
    }                   
    
    private void backButtonActionPerformed(ActionEvent evt) {
		dispose();
		MenuAdminEdit mae = new MenuAdminEdit(admin);
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
    	System.out.println(categoryComboBox.getSelectedItem().toString());
    	SQLProductService.getSQLProductService().update(product);		
    	JOptionPane.showMessageDialog(null, "PRODUCTO EDITADO CON EXITO");
	}
    
    private void deleteCommentButtonActionPerformed(ActionEvent evt) {
    	int index = commentsTable.getSelectedRow();
    	SQLCommentsService.getSQLCommentsService().delete(commentsList.get(index));
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
		img = img.getScaledInstance(jPanel2.getPreferredSize().width-50, jPanel2.getPreferredSize().height,  Image.SCALE_SMOOTH);
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
            Logger.getLogger(EditProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(EditProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EditProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(EditProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditProduct(product,admin).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private JButton backButton;
    private JComboBox<String> categoryComboBox;
    private JLabel categoryLabel;
    private JScrollPane commentsScrollPane;
    private JTable commentsTable;
    private JButton deleteCommentButton;
    private JButton deleteProductButton;
    private JTextArea descriptionArea;
    private JLabel descriptionLabel;
    private JLabel idLabel;
    private JTextField idField;
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
    private JButton saveButton;
    private JLabel stockLabel;
    private JSpinner stockSpinner;
    private static Product product;
    private String prevName;
    private int prevPrice;
    private ArrayList<Comment> commentsList;
    private ArrayList<String> categoriesList;
    private static Admin admin;
    // End of variables declaration                   
}