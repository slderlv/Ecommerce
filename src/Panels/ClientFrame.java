package Panels;

import java.awt.*;
import java.awt.event.*;
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
import Domain.Client;
import Domain.Product;
import Logic.SystemService;
import Assets.CryptoService;
import Assets.ValidateMail;
import Assets.JTextFieldLimit;
import Database.SQLClientService;

@SuppressWarnings("serial")
public class ClientFrame extends JFrame {

    public ClientFrame(Client client) {
    	//ClientFrame.client = new Client("21249678-2", "aaaaa", "aaaaa", "aaaaa@aaa.aaa", 949314109, null, "aaaaa", null, "UserIcons/juan_bekios.jpeg");
    	//ClientFrame.shoppingCart = client.getTransactions().getShoppingCart();
    	ClientFrame.client = client;
    	SystemService.getSystem().getTransactions(client);
    	shoppingCart = client.getTransactions().getShoppingCart();
    	if(shoppingCart==null) {
    		ClientFrame.shoppingCart = new ArrayList<>();
    	}
        initComponents();
    }
                         
    private void initComponents() {

        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        backButton = new JButton();
        jPanel3 = new JPanel();
        productButton = new JButton();
        productLabel = new JLabel();
        jPanel4 = new JPanel();
        cartButton = new JButton();
        cartLabel = new JLabel();
        jPanel5 = new JPanel();
        historyButton = new JButton();
        historyLabel = new JLabel();
        editButton = new JButton();
        jPanel7 = new JPanel();
        passwordLabel = new JLabel();
        addressLabel = new JLabel();
        addressField = new JTextField();
        nameLabel = new JLabel();
        invalidPasswordLabel = new JLabel();
        invalidAddressLabel = new JLabel();
        passwordField = new JPasswordField();
        nameField = new JTextField();
        userPhotoPanel = new JPanel();
        userPhoto = new JLabel();
        jPanel6 = new JPanel();
        rutLabel = new JLabel();
        rutField = new JTextField();
        invalidEmailLabel = new JLabel();
        emailLabel = new JLabel();
        emailField = new JTextField();
        invalidPhoneNumberLabel = new JLabel();
        phoneNumberField = new JTextField();
        phoneNumberLabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ecommerce - Men\u00fa de usuario");
        setResizable(false);

        jPanel1.setBackground(mainColor);
        jPanel1.setPreferredSize(new Dimension(1280, 720));

        jPanel2.setBackground(secondColor);
        jPanel2.setPreferredSize(new Dimension(405, 720));

        backButton.setIcon(new ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        backButton.setContentAreaFilled(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jPanel3.setBackground(secondColor);

        productButton.setBackground(mainColor);
        productButton.setFont(new Font("Segoe UI", 0, 36)); // NOI18N
        productButton.setForeground(black);
        productButton.setText("Productos");
        productButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        productButton.setFocusPainted(false);
        productButton.setHorizontalTextPosition(SwingConstants.LEFT);
        productButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                productButtonActionPerformed(evt);
            }
        });

        productLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/product.png"))); // NOI18N

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(productButton)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productLabel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(productLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                    .addComponent(productButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(secondColor);
        jPanel4.setPreferredSize(new Dimension(258, 67));

        cartButton.setBackground(mainColor);
        cartButton.setFont(new Font("Segoe UI", 0, 36)); // NOI18N
        cartButton.setForeground(black);
        cartButton.setText("Carrito");
        cartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cartButton.setFocusPainted(false);
        cartButton.setHorizontalTextPosition(SwingConstants.LEFT);
        cartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cartButtonActionPerformed(evt);
            }
        });

        cartLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/cart.png"))); // NOI18N

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cartButton, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cartLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(cartLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cartButton))
                .addContainerGap())
        );

        jPanel5.setBackground(secondColor);
        jPanel5.setPreferredSize(new Dimension(258, 67));

        historyButton.setBackground(mainColor);
        historyButton.setFont(new Font("Segoe UI", 0, 36)); // NOI18N
        historyButton.setForeground(black);
        historyButton.setText("Historial");
        historyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        historyButton.setFocusPainted(false);
        historyButton.setHorizontalTextPosition(SwingConstants.LEFT);
        historyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                historyButtonActionPerformed(evt);
            }
        });

        historyLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/history.png"))); // NOI18N

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(historyButton, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(historyLabel)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(historyLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                    .addComponent(historyButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(backButton)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(backButton)
                .addGap(88, 88, 88)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101)
                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 173, Short.MAX_VALUE))
        );

        editButton.setBackground(new Color(255, 111, 156));
        editButton.setFont(new Font("Segoe UI", 0, 22)); // NOI18N
        editButton.setForeground(black);
        editButton.setIcon(new ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        editButton.setText("Editar datos");
        editButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        editButton.setFocusPainted(false);
        editButton.setHorizontalTextPosition(SwingConstants.LEFT);
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        jPanel7.setBackground(mainColor);
        jPanel7.setFocusable(false);

        passwordLabel.setBackground(secondColor);
        passwordLabel.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        passwordLabel.setForeground(black);
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setText("Contrase\u00f1a");
        passwordLabel.setOpaque(true);

        addressLabel.setBackground(secondColor);
        addressLabel.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        addressLabel.setForeground(black);
        addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addressLabel.setText("Direcci\u00f3n");
        addressLabel.setOpaque(true);

        addressField.setDocument(new JTextFieldLimit(35));
        addressField.setEditable(false);
        addressField.setBackground(secondColor);
        addressField.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        addressField.setForeground(black);
        addressField.setText(client.getAddress());
        addressField.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));

        nameLabel.setBackground(secondColor);
        nameLabel.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        nameLabel.setForeground(black);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setText("Nombre");
        nameLabel.setOpaque(true);
        nameLabel.setVisible(true);
        
        invalidPasswordLabel.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        invalidPasswordLabel.setForeground(mainColor);
        invalidPasswordLabel.setText("Contrase\u00f1a inv\u00e1lida");
        invalidAddressLabel.setVisible(true);

        invalidAddressLabel.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        invalidAddressLabel.setForeground(mainColor);
        invalidAddressLabel.setText("Direcci\u00f3n inv\u00e1lida");
        invalidAddressLabel.setVisible(true);

        passwordField.setDocument(new JTextFieldLimit(41));
        passwordField.setEditable(false);
        passwordField.setBackground(secondColor);
        passwordField.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        passwordField.setForeground(black);
        passwordField.setText(CryptoService.getCryptoService().decodePassword(client.getPassword()));
        passwordField.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));

        nameField.setDocument(new JTextFieldLimit(16));
        nameField.setEditable(false);
        nameField.setBackground(secondColor);
        nameField.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        nameField.setForeground(black);
        nameField.setText(client.getName());
        nameField.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));

        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(invalidAddressLabel)
                            .addComponent(addressField, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                            .addComponent(invalidPasswordLabel)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invalidPasswordLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invalidAddressLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(addressField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addressLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
        );

        userPhoto.setHorizontalAlignment(SwingConstants.CENTER);
        if(client.getImg_path()==null) {
        	userPhoto.setIcon(resizeImageIcon(new ImageIcon(getClass().getResource("/UserIcons/FBmvyqjWQAwkCia.jpeg"))));
        } else {
        	userPhoto.setIcon(resizeImageIcon(new ImageIcon(getClass().getResource("/"+client.getImg_path()))));
        }
        userPhoto.setCursor(new Cursor(Cursor.HAND_CURSOR));
        userPhoto.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                userPhotoMouseClicked(evt);
            }
        });

        GroupLayout userPhotoPanelLayout = new GroupLayout(userPhotoPanel);
        userPhotoPanel.setLayout(userPhotoPanelLayout);
        userPhotoPanelLayout.setHorizontalGroup(
            userPhotoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(userPhoto, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        );
        userPhotoPanelLayout.setVerticalGroup(
            userPhotoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(userPhoto, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
        );

        jPanel6.setBackground(mainColor);
        jPanel6.setPreferredSize(new Dimension(420, 322));

        rutLabel.setBackground(secondColor);
        rutLabel.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        rutLabel.setForeground(black);
        rutLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rutLabel.setText("Rut");
        rutLabel.setOpaque(true);

        rutField.setEditable(false);
        rutField.setBackground(secondColor);
        rutField.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        rutField.setForeground(black);
        rutField.setText(client.getRut());
        rutField.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));

        invalidEmailLabel.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        invalidEmailLabel.setForeground(mainColor);
        invalidEmailLabel.setText("Correo inv\u00e1lido");
        invalidEmailLabel.setVisible(true);

        emailLabel.setBackground(secondColor);
        emailLabel.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        emailLabel.setForeground(black);
        emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
        emailLabel.setText("Correo");
        emailLabel.setOpaque(true);

        emailField.setDocument(new JTextFieldLimit(35));
        emailField.setEditable(false);
        emailField.setBackground(secondColor);
        emailField.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        emailField.setForeground(black);
        emailField.setText(client.getMail());
        emailField.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));

        invalidPhoneNumberLabel.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        invalidPhoneNumberLabel.setForeground(mainColor);
        invalidPhoneNumberLabel.setText("Tel\u00e9fono inv\u00e1lido");
        invalidPhoneNumberLabel.setVisible(true);

        phoneNumberField.setDocument(new JTextFieldLimit(12));
        phoneNumberField.setEditable(false);
        phoneNumberField.setBackground(secondColor);
        phoneNumberField.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        phoneNumberField.setForeground(black);
        phoneNumberField.setText("+56"+client.getNumber());
        phoneNumberField.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));

        phoneNumberLabel.setBackground(secondColor);
        phoneNumberLabel.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        phoneNumberLabel.setForeground(black);
        phoneNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        phoneNumberLabel.setText("Tel\u00e9fono");
        phoneNumberLabel.setOpaque(true);

        GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(rutLabel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(rutField, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(emailLabel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumberLabel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(phoneNumberField, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                    .addComponent(invalidEmailLabel)
                    .addComponent(invalidPhoneNumberLabel)
                    .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(rutLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(rutField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invalidEmailLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(emailLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(invalidPhoneNumberLabel)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNumberField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneNumberLabel, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)))
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(userPhotoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(editButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(userPhotoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editButton)
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addGap(0, 0, 0))
        );
        
        pack();
        setLocationRelativeTo(null);
    }                        

    private void backButtonActionPerformed(ActionEvent evt) {                                           
    	dispose();
    	LoginFrame lf = new LoginFrame();
    	lf.setVisible(true);
    }
    
    private void productButtonActionPerformed(ActionEvent evt) {                                           
    	dispose();
    	ProductListFrame plf = new ProductListFrame(client);
    	plf.setVisible(true);
    }  

    private void cartButtonActionPerformed(ActionEvent evt) {                                           
    	dispose();
    	ShoppingCart sc = new ShoppingCart(client);
    	sc.setVisible(true);
    }
    
    private void historyButtonActionPerformed(ActionEvent evt) {                                           
    	dispose();
    	ShoppingHistory sh = new ShoppingHistory(client);
    	sh.setVisible(true);
    }

    private void editButtonActionPerformed(ActionEvent evt) {                                           
    	// Edit to save changes
        if(editButton.getText().equals("Editar datos")) {
            
        	passwordField.setEditable(true);
            passwordField.setEchoChar((char)0);
            prevPassword = passwordField.getPassword();
            
            addressField.setEditable(true);
            prevAddress = addressField.getText();
            
            phoneNumberField.setEditable(true);
            prevTelephone = phoneNumberField.getText();
            
            nameField.setEditable(true);

            emailField.setEditable(true);
            prevEmail = emailField.getText();
            
            editButton.setText("Guardar");
        }
        // Save changes
        else {
        	
        	// If password is not valid
        	if(passwordField.getPassword().length<4) {
        		invalidPasswordLabel.setForeground(red);
        		passwordField.setText(new String(prevPassword));
        	} else {
        		invalidPasswordLabel.setForeground(mainColor);
        		prevPassword = passwordField.getPassword();
        	}
        	
        	// If address is not valid
        	if(addressField.getText().length()<4) {
        		invalidAddressLabel.setForeground(red);
        		addressField.setText(prevAddress);
        	} else { // If address is valid
        		prevAddress = addressField.getText();
        		invalidAddressLabel.setForeground(mainColor);
        	}
        	
        	// If phoneNumber is not valid
        	if(!phoneNumberIsValid(phoneNumberField.getText())) {
        		invalidPhoneNumberLabel.setForeground(red);
        		phoneNumberField.setText(prevTelephone);
        	} else { // If phoneNumber is valid
        		prevTelephone = phoneNumberField.getText();
        		invalidPhoneNumberLabel.setForeground(mainColor);
        	}
        	
        	if(!ValidateMail.isValid(emailField.getText())) {
        		invalidEmailLabel.setForeground(red);
        		emailField.setText(prevEmail);
        	} else {
        		prevEmail = emailField.getText();
        		invalidEmailLabel.setForeground(mainColor);
        	}
       
        	passwordField.setEchoChar('*');
        	passwordField.setEditable(false);
        	addressField.setEditable(false);
        	phoneNumberField.setEditable(false);
        	editButton.setText("Editar datos");
        	
        	// UPDATE BASE DE DATOS AQUI ----------------------------------------------
        	try {
        		String name = nameField.getText();
        		String password = CryptoService.getCryptoService().encodePassword(new String(passwordField.getPassword()));
        		String address = addressField.getText();
        		int number = Integer.parseInt(phoneNumberField.getText().substring(3)); // ignore +56	
        		client.setPassword(password); client.setAddress(address); client.setNumber(number);client.setName(name);
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        	SQLClientService.getSQLClientService().update(client);
        	// ------------------------------------------------------------------------
        }
    }                                    

    private void userPhotoMouseClicked(MouseEvent evt) {                                       
    	JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc.setDialogTitle("Seleccione una imagen");
		jfc.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG", "png");
		jfc.addChoosableFileFilter(filter);
		int returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			String imagePath = jfc.getSelectedFile().getPath();
			ImageIcon userIcon = resizeImageIcon(new ImageIcon(imagePath));
	        userPhoto.setIcon(userIcon);
			userPhoto.repaint();
			File original = new File(imagePath);
			String path = "UserIcons/"+client.getRut()+"."+getFileType(original);
			File copy = new File(path);
			client.setImg_path(path);
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
    
    private ImageIcon resizeImageIcon(ImageIcon imageIcon) {
    	Image img = imageIcon.getImage();
		img = img.getScaledInstance(200, 200,  Image.SCALE_SMOOTH);
        return new ImageIcon(img);
	}

	public static boolean phoneNumberIsValid(String t) {
    	if(!t.startsWith("+56")){
    		return false;
    	}
    	t = t.substring(3);
    	try {
    		@SuppressWarnings("unused")
			int intValue = Integer.parseInt(t);
    	} catch (NumberFormatException e) {
    		return false;
    	}
    	return true;
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
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ClientFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientFrame(client).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private JTextField addressField;
    private JLabel addressLabel;
    private JButton backButton;
    private JButton cartButton;
    private JLabel cartLabel;
    private JButton editButton;
    private JTextField emailField;
    private JLabel emailLabel;
    private JButton historyButton;
    private JLabel historyLabel;
    private JLabel invalidAddressLabel;
    private JLabel invalidEmailLabel;
    private JLabel invalidPasswordLabel;
    private JLabel invalidPhoneNumberLabel;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JPanel jPanel5;
    private JPanel jPanel6;
    private JPanel jPanel7;
    private JTextField nameField;
    private JLabel nameLabel;
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JTextField phoneNumberField;
    private JLabel phoneNumberLabel;
    private JButton productButton;
    private JLabel productLabel;
    private JTextField rutField;
    private JLabel rutLabel;
    private JLabel userPhoto;
    private JPanel userPhotoPanel;
    private Color mainColor = new Color(255,212,171);
    private Color black = new Color(0,0,0);
    private Color red = new Color(255,0,0);
    private Color secondColor = new Color(255, 174, 167);
    private char[] prevPassword;
	private String prevAddress;
	private String prevTelephone;
	private String prevEmail;
	private static Client client;
	private static ArrayList<Product> shoppingCart;
    // End of variables declaration                   
}