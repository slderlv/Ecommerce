package Panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.logging.Logger;
import java.util.logging.Level;
import Assets.ArrayToString;
import Assets.CryptoService;
import Assets.GhostText;
import Assets.RutFormat;
import Database.SQLCategoryService;
import Database.SQLClientService;
import Database.SQLCommentsService;
import Database.SQLProductService;
import Domain.Admin;
import Domain.Client;
import Domain.Comment;
import Domain.Product;
import Domain.ProductInfo;
import Domain.Purchase;
import Domain.Transactions;
import Logic.SystemService;

@SuppressWarnings("serial")
public class MenuAdminEdit extends JFrame {
    public MenuAdminEdit(Admin admin) {
    	MenuAdminEdit.admin = admin;
    	categoriesList = SystemService.getSystem().getCategorys();
    	initComponents();
    }
                         
    private void initComponents() {

        jPanel1 = new JPanel();
        backButton = new JButton();
        jPanel2 = new JPanel();
        editUserField = new JTextField();
        editUserButton = new JButton();
        addCategoryField = new JTextField();
        addCategoryButton = new JButton();
        deleteCategoryButton = new JButton();
        addProductComboBox = new JComboBox<>();
        addProductButton = new JButton();
        editProductField = new JTextField();
        editProductButton = new JButton();
        editCategoryComboBox = new JComboBox<>();
        deleteCategoryComboBox = new JComboBox<>();
        editCategoryButton = new JButton();
        jPanel3 = new JPanel();
        showProductListButton = new JButton();
        addUserButton = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ecommerce - Men\u00fa de Administrador");
        setBackground(new Color(255, 212, 171));
        setBounds(new Rectangle(0, 0, 1280, 720));
        setResizable(false);

        jPanel1.setBackground(new Color(255, 212, 171));
        jPanel1.setPreferredSize(new Dimension(1280, 720));

        backButton.setBackground(new Color(255, 212, 171));
        backButton.setIcon(new ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new Color(255, 212, 171));

        editUserField.setBackground(new Color(255, 255, 255));
        editUserField.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        editUserField.setForeground(new Color(0, 0, 0));
        editUserField.setHorizontalAlignment(JTextField.LEFT);
        editUserField.setCaretColor(new Color(0, 0, 0));
        new GhostText(editUserField," Ingrese rut");

        editUserButton.setBackground(new Color(255, 174, 167));
        editUserButton.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        editUserButton.setForeground(new Color(0, 0, 0));
        editUserButton.setText("Administrar usuarios");
        editUserButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editUserButton.setFocusPainted(false);
        editUserButton.setHorizontalTextPosition(SwingConstants.CENTER);
        editUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editUserButtonActionPerformed(evt);
            }
        });

        addCategoryField.setBackground(new Color(255, 255, 255));
        addCategoryField.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        addCategoryField.setForeground(new Color(0, 0, 0));
        addCategoryField.setHorizontalAlignment(JTextField.LEFT);
        new GhostText(addCategoryField," Ingrese nombre");
        addCategoryField.setAutoscrolls(false);
        addCategoryField.setCaretColor(new Color(0, 0, 0));

        addCategoryButton.setBackground(new Color(255, 174, 167));
        addCategoryButton.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        addCategoryButton.setForeground(new Color(0, 0, 0));
        addCategoryButton.setText("Agregar categor\u00eda");
        addCategoryButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addCategoryButton.setFocusPainted(false);
        addCategoryButton.setHorizontalTextPosition(SwingConstants.CENTER);
        addCategoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addCategoryButtonActionPerformed(evt);
            }
        });

        deleteCategoryButton.setBackground(new Color(255, 174, 167));
        deleteCategoryButton.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        deleteCategoryButton.setForeground(new Color(0, 0, 0));
        deleteCategoryButton.setText("Eliminar categor\u00eda");
        deleteCategoryButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        deleteCategoryButton.setFocusPainted(false);
        deleteCategoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                deleteCategoryButtonActionPerformed(evt);
            }
        });

        addProductComboBox.setBackground(new Color(255, 255, 255));
        addProductComboBox.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        addProductComboBox.setForeground(new Color(0, 0, 0));
        addProductComboBox.setMaximumRowCount(20);
        addProductComboBox.setModel(new DefaultComboBoxModel<>(ArrayToString.getStringArray(categoriesList)));

        addProductButton.setBackground(new Color(255, 174, 167));
        addProductButton.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        addProductButton.setForeground(new Color(0, 0, 0));
        addProductButton.setText("Agregar producto");
        addProductButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addProductButton.setFocusPainted(false);
        addProductButton.setHorizontalTextPosition(SwingConstants.CENTER);
        addProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addProductButtonActionPerformed(evt);
            }
        });

        editProductField.setBackground(new Color(255, 255, 255));
        editProductField.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        editProductField.setForeground(new Color(0, 0, 0));
        editProductField.setHorizontalAlignment(JTextField.LEFT);
        new GhostText(editProductField," Ingrese id");
        editProductField.setAutoscrolls(false);
        editProductField.setCaretColor(new Color(0, 0, 0));

        editProductButton.setBackground(new Color(255, 174, 167));
        editProductButton.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        editProductButton.setForeground(new Color(0, 0, 0));
        editProductButton.setText("Editar producto");
        editProductButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editProductButton.setFocusPainted(false);
        editProductButton.setHorizontalTextPosition(SwingConstants.CENTER);
        editProductButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editProductButtonActionPerformed(evt);
            }
        });

        editCategoryComboBox.setBackground(new Color(255, 255, 255));
        editCategoryComboBox.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        editCategoryComboBox.setForeground(new Color(0, 0, 0));
        editCategoryComboBox.setModel(new DefaultComboBoxModel<>(ArrayToString.getStringArray(categoriesList)));

        
        deleteCategoryComboBox.setBackground(new Color(255, 255, 255));
        deleteCategoryComboBox.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        deleteCategoryComboBox.setForeground(new Color(0, 0, 0));
        deleteCategoryComboBox.setModel(new DefaultComboBoxModel<>(ArrayToString.getStringArray(categoriesList)));

        editCategoryButton.setBackground(new Color(255, 174, 167));
        editCategoryButton.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        editCategoryButton.setForeground(new Color(0, 0, 0));
        editCategoryButton.setText("Editar categor\u00eda");
        editCategoryButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editCategoryButton.setFocusPainted(false);
        editCategoryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editCategoryButtonActionPerformed(evt);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(editProductField, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                            .addComponent(addProductComboBox, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(addProductButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                            .addComponent(editProductButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(editUserField, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(editUserButton, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(addCategoryField, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(addCategoryButton, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(deleteCategoryComboBox, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                            .addComponent(editCategoryComboBox, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(editCategoryButton, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteCategoryButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(editUserField, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addComponent(editUserButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addCategoryField, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addCategoryButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(editCategoryComboBox, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCategoryButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(deleteCategoryButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteCategoryComboBox, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addProductComboBox, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addProductButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(editProductField, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addComponent(editProductButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
        );

        jPanel3.setBackground(new Color(255, 212, 171));

        showProductListButton.setBackground(new Color(255, 174, 167));
        showProductListButton.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        showProductListButton.setForeground(new Color(0, 0, 0));
        showProductListButton.setText("Ver lista de productos");
        showProductListButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showProductListButton.setFocusPainted(false);
        showProductListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                showProductListButtonActionPerformed(evt);
            }
        });

        addUserButton.setBackground(new Color(255, 174, 167));
        addUserButton.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        addUserButton.setForeground(new Color(0, 0, 0));
        addUserButton.setText("Agregar usuario");
        addUserButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addUserButton.setFocusPainted(false);
        addUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(showProductListButton, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
            .addComponent(addUserButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(showProductListButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(addUserButton, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backButton)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(backButton)
                .addGap(227, 227, 227)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 102, Short.MAX_VALUE)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 1280, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 720, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }                       

    private void editUserButtonActionPerformed(ActionEvent evt) {                                               		
		
		ResultSet response = SQLClientService.getSQLClientService().read(RutFormat.formatToDatabase(editUserField.getText()));
		try {
			if (response.next()) {
				//String rut, String name, String password, String mail,int number, Transactions transactions, String address, ArrayList<Card> cards, String img_path)
				Client client = new Client(response.getString("rut"), response.getString("name"), CryptoService.getCryptoService().decodePassword(response.getString("password")), response.getString("mail"), response.getInt("phone_number"), null, response.getString("street"),null, "");
				String img_path = response.getString("img_path");
				client.setImg_path(img_path);
				client.setTransactions(new Transactions());
				ArrayList<Purchase> purchaseList = SystemService.getSystem().getPurchases(client);
				ArrayList<Product> shoppingCart = SystemService.getSystem().getShoppingCart(client);
				client.getTransactions().setPurchases(purchaseList);
				client.getTransactions().setShoppingCart(shoppingCart);
				dispose();
				ManageUser manageUser = new ManageUser(client,admin);
				manageUser.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "El usuario esta bloqueado o no existe");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }                                              

    private void addProductButtonActionPerformed(ActionEvent evt) {    
    	dispose();
    	SQLProductService.getSQLProductService().create(addProductComboBox.getSelectedItem().toString());
    	ResultSet response = SQLProductService.getSQLProductService().lastId();
    	try {
    		if(response.next()) {
    			int id = response.getInt("id");
    			ProductInfo info = new ProductInfo("",0,"",0,addProductComboBox.getSelectedItem().toString(),"");
    			ArrayList<Comment> comments = new ArrayList<Comment>();
    			Product p = new Product(info,id,null,0);
    			ResultSet rs = SQLCommentsService.getSQLCommentsService().read(p);
    			
    			while (rs.next()) {
    				Comment comment = new Comment(rs.getInt("id"),rs.getFloat("rating"),rs.getString("comment"),p,rs.getString("user_rut"));
    				comments.add(comment);    				
    			}
    			p.setComments(comments);
    			EditProduct ep = new EditProduct(p);	
    			ep.setVisible(true);
    		}
    		return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//ProductInfo info, int id, ArrayList<Comment> comments, int buy_quantity
    	//String name, int price, String description, int stock, String category, String img_path
    	
    	// AQUI CREAR NUEVO PRODUCTO
    }                               
    
    private void addUserButtonActionPerformed(ActionEvent evt) {                                         
    	dispose();
    	RegisterFrame registerFrame = new RegisterFrame(admin);
    	registerFrame.setVisible(true);
    	
    } 

    private void editProductButtonActionPerformed(ActionEvent evt) {               
    	int id = Integer.parseInt(editProductField.getText());
    	ResultSet response = SQLProductService.getSQLProductService().readById(id);
    	try {
    		
			if(response.next()) {
	    			ProductInfo info = new ProductInfo(response.getString("name"),response.getInt("price"),response.getString("description"),response.getInt("stock"),response.getString("category"),response.getString("img_path"));
	    			Product p = new Product(info,id,null,0);
	    			ResultSet rs = SQLCommentsService.getSQLCommentsService().read(p);
	    			ArrayList<Comment> comments = new ArrayList<Comment>();
	    			while (rs.next()) {
	    				Comment comment = new Comment(rs.getInt("id"),rs.getFloat("rating"),rs.getString("comment"),p,rs.getString("user_rut"));
	    				comments.add(comment);    				
	    			}
	    			p.setComments(comments);
	    			dispose();
	    			EditProduct ep = new EditProduct(p);	
	    			ep.setVisible(true);
	    			//ProductInfo info, int id, ArrayList<Comment> comments, int buy_quantity
	    			//String name, int price, String description, int stock, String category, String img_path
				
			}
			//return;
		} catch (Exception e) {
			// TODO: handle exception
		}
    	//EditProduct editProduct = new EditProduct(null);
    	//editProduct.setVisible(true);
    }                                                 

    private void editCategoryButtonActionPerformed(ActionEvent evt) {                                                  
    	String category = editCategoryComboBox.getSelectedItem().toString();
    	if (category.equals("NO ASIGNADO")) {
    		JOptionPane.showMessageDialog(null, "NO ES POSIBLE EDITAR LA CATEGORIA 'NO ASIGNADO'");
    		return;
    	}
    	String newCategory = JOptionPane.showInputDialog(null, "Inserte nuevo nombre", "Editar categor\u00eda", JOptionPane.INFORMATION_MESSAGE);
    	SQLCategoryService.getSQLCategoryService().update(category, newCategory);
    	
    
    	if(!category.strip().equals("")) {
    		SystemService.getSystem().refreshCategory();
    		categoriesList = SystemService.getSystem().getCategorys();
            updateComboBoxes();
    	}
    }  
    
	private void addCategoryButtonActionPerformed(ActionEvent evt) {                                                  
    	if(addCategoryField.getText().equals(" Ingrese nombre")) return;
    	SQLCategoryService.getSQLCategoryService().create(addCategoryField.getText());
    	SystemService.getSystem().refreshCategory();
    	categoriesList = SystemService.getSystem().getCategorys();
    	updateComboBoxes();
	}         
    
    private void deleteCategoryButtonActionPerformed(ActionEvent evt) {
    	String category = deleteCategoryComboBox.getSelectedItem().toString();
    	if (category.equals("NO ASIGNADO")) {
    		JOptionPane.showMessageDialog(null, "NO ES POSIBLE ELIMINAR LA CATEGORIA 'NO ASIGNADO'");
    		return;
    	}
    	
    	SQLCategoryService.getSQLCategoryService().delete(deleteCategoryComboBox.getSelectedItem().toString());
    	SystemService.getSystem().refreshCategory();
    	categoriesList = SystemService.getSystem().getCategorys();
    	updateComboBoxes();
    }

    private void backButtonActionPerformed(ActionEvent evt) {                                           
    	dispose();
    	LoginFrame lf = new LoginFrame();
    	lf.setVisible(true);
    }                                          

    private void showProductListButtonActionPerformed(ActionEvent evt) {                                         
    	dispose();
    	ProductListFrame productListFrame = new ProductListFrame(admin);
    	productListFrame.setVisible(true);
    }                 
    
    private void updateComboBoxes() {
    	editCategoryComboBox.setModel(new DefaultComboBoxModel<>(ArrayToString.getStringArray(categoriesList)));
    	deleteCategoryComboBox.setModel(new DefaultComboBoxModel<>(ArrayToString.getStringArray(categoriesList)));
    	addProductComboBox.setModel(new DefaultComboBoxModel<>(ArrayToString.getStringArray(categoriesList)));    	
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
            Logger.getLogger(MenuAdminEdit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MenuAdminEdit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MenuAdminEdit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MenuAdminEdit.class.getName()).log(Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdminEdit(admin).setVisible(true);
            }
        });
    }

    // Variables declaration                    
    private JButton addCategoryButton;
    private JTextField addCategoryField;
    private JButton addProductButton;
    private JComboBox<String> addProductComboBox;
    private JButton addUserButton;
    private JButton backButton;
    private JButton deleteCategoryButton;
    private JComboBox<String> deleteCategoryComboBox;
    private JButton editCategoryButton;
    private JComboBox<String> editCategoryComboBox;
    private JButton editProductButton;
    private JTextField editProductField;
    private JButton editUserButton;
    private JTextField editUserField;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JButton showProductListButton;
    private ArrayList<String> categoriesList;
    private static Admin admin;
    // End of variables declaration                   
}
