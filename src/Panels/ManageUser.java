package Panels;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import Assets.CryptoService;
import Assets.ValidateMail;
import Database.SQLClientService;
import Domain.Admin;
import Domain.Client;

@SuppressWarnings("serial")
public class ManageUser extends JFrame {

    public ManageUser(Client client,Admin admin) {
    	ManageUser.admin = admin;
    	ManageUser.client = client;
        initComponents();
    }
                      
    private void initComponents() {

        jButton1 = new JButton();
        jPanel1 = new JPanel();
        jPanel2 = new JPanel();
        backButton = new JButton();
        jPanel4 = new JPanel();
        cartButton = new JButton();
        cartLabel = new JLabel();
        jPanel5 = new JPanel();
        historyButton = new JButton();
        historyLabel = new JLabel();
        saveButton = new JButton();
        jPanel7 = new JPanel();
        passwordLabel = new JLabel();
        addressLabel = new JLabel();
        addressField = new JTextField();
        nameLabel = new JLabel();
        passwordField = new JPasswordField();
        nameField = new JTextField();
        invalidPasswordLabel = new JLabel();
        invalidAddressLabel = new JLabel();
        userPhotoPanel = new JPanel();
        userPhoto = new JLabel();
        jPanel6 = new JPanel();
        rutLabel = new JLabel();
        rutField = new JTextField();
        emailLabel = new JLabel();
        emailField = new JTextField();
        phoneNumberField = new JTextField();
        phoneNumberLabel = new JLabel();
        invalidPhoneNumberLabel = new JLabel();
        invalidEmailLabel = new JLabel();
        blockButton = new JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ecommerce - Editar usuario");
        setResizable(false);

        jPanel1.setBackground(mainColor);
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel2.setBackground(secondColor);
        jPanel2.setPreferredSize(new java.awt.Dimension(405, 720));

        backButton.setIcon(new ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        backButton.setContentAreaFilled(false);
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jPanel4.setBackground(secondColor);
        jPanel4.setPreferredSize(new java.awt.Dimension(258, 67));

        cartButton.setBackground(mainColor);
        cartButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        cartButton.setForeground(black);
        cartButton.setText("Carrito");
        cartButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cartButton.setFocusPainted(false);
        cartButton.setHorizontalTextPosition(SwingConstants.LEFT);
        cartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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
        jPanel5.setPreferredSize(new java.awt.Dimension(258, 67));

        historyButton.setBackground(mainColor);
        historyButton.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        historyButton.setForeground(black);
        historyButton.setText("Historial");
        historyButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        historyButton.setFocusPainted(false);
        historyButton.setHorizontalTextPosition(SwingConstants.LEFT);
        historyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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
                    .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(backButton)
                .addGap(172, 172, 172)
                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 257, Short.MAX_VALUE))
        );

        saveButton.setBackground(new java.awt.Color(255, 111, 156));
        saveButton.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        saveButton.setForeground(black);
        saveButton.setIcon(new ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        saveButton.setText("Guardar");
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveButton.setFocusPainted(false);
        saveButton.setHorizontalTextPosition(SwingConstants.LEFT);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jPanel7.setBackground(mainColor);
        jPanel7.setFocusable(false);

        passwordLabel.setBackground(secondColor);
        passwordLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        passwordLabel.setForeground(black);
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setText("Contrase\u00f1a");
        passwordLabel.setOpaque(true);

        addressLabel.setBackground(secondColor);
        addressLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        addressLabel.setForeground(black);
        addressLabel.setHorizontalAlignment(SwingConstants.CENTER);
        addressLabel.setText("Direcci\u00f3n");
        addressLabel.setOpaque(true);

        addressField.setBackground(secondColor);
        addressField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        addressField.setForeground(black);
        addressField.setText(client.getAddress());
        addressField.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));

        nameLabel.setBackground(secondColor);
        nameLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        nameLabel.setForeground(black);
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel.setText("Nombre");
        nameLabel.setOpaque(true);

        passwordField.setBackground(secondColor);
        passwordField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        passwordField.setForeground(black);
        passwordField.setText(client.getPassword());
        passwordField.setEchoChar((char) 0);
        passwordField.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));

        nameField.setBackground(secondColor);
        nameField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        nameField.setForeground(black);
        nameField.setText(client.getName());
        nameField.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));

        invalidPasswordLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        invalidPasswordLabel.setForeground(mainColor);
        invalidPasswordLabel.setText("Contrase\u00f1a inv\u00e1lida");

        invalidAddressLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        invalidAddressLabel.setForeground(mainColor);
        invalidAddressLabel.setText("Direcci\u00f3n inv\u00e1lida");

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
                            .addComponent(addressField, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
                            .addComponent(invalidAddressLabel)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(nameLabel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(invalidPasswordLabel)
                            .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))))
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
        userPhoto.setFocusable(false);
        userPhoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        userPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
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
        jPanel6.setPreferredSize(new java.awt.Dimension(420, 322));

        rutLabel.setBackground(secondColor);
        rutLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        rutLabel.setForeground(black);
        rutLabel.setHorizontalAlignment(SwingConstants.CENTER);
        rutLabel.setText("Rut");
        rutLabel.setOpaque(true);

        rutField.setEditable(false);
        rutField.setBackground(secondColor);
        rutField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        rutField.setForeground(black);
        rutField.setText(client.getRut());
        rutField.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));

        emailLabel.setBackground(secondColor);
        emailLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        emailLabel.setForeground(black);
        emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
        emailLabel.setText("Correo");
        emailLabel.setOpaque(true);

        emailField.setBackground(secondColor);
        emailField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        emailField.setForeground(black);
        emailField.setText(client.getMail());
        emailField.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));

        phoneNumberField.setBackground(secondColor);
        phoneNumberField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        phoneNumberField.setForeground(black);
        phoneNumberField.setText("+56"+client.getNumber());
        phoneNumberField.setBorder(BorderFactory.createEmptyBorder(1, 10, 1, 1));

        phoneNumberLabel.setBackground(secondColor);
        phoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        phoneNumberLabel.setForeground(black);
        phoneNumberLabel.setHorizontalAlignment(SwingConstants.CENTER);
        phoneNumberLabel.setText("Tel\u00e9fono");
        phoneNumberLabel.setOpaque(true);

        invalidPhoneNumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        invalidPhoneNumberLabel.setForeground(mainColor);
        invalidPhoneNumberLabel.setText("Tel\u00e9fono inv\u00e1lido");

        invalidEmailLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        invalidEmailLabel.setForeground(mainColor);
        invalidEmailLabel.setText("Correo inv\u00e1lido");

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
                    .addComponent(invalidEmailLabel)
                    .addComponent(invalidPhoneNumberLabel)
                    .addComponent(phoneNumberField, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
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

        blockButton.setBackground(new java.awt.Color(255, 111, 156));
        blockButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        blockButton.setForeground(black);
        blockButton.setIcon(new ImageIcon(getClass().getResource("/Icons/block.png"))); // NOI18N
        blockButton.setText("Bloquear");
        blockButton.setFocusPainted(false);
        blockButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        blockButton.setHorizontalTextPosition(SwingConstants.LEFT);
        blockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blockButtonActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jPanel6, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(341, 341, 341)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(userPhotoPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(blockButton)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(userPhotoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(blockButton, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveButton)
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
    }// </editor-fold>                                                            

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
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
    	
    	// UPDATE BASE DE DATOS AQUI ----------------------------------------------
    	String password = new String(passwordField.getPassword());
    	String address = addressField.getText();
    	int number = Integer.parseInt(phoneNumberField.getText().substring(3)); // ignore +56
    
    	client.setPassword(CryptoService.getCryptoService().encodePassword(password));
    	client.setAddress(address);
    	client.setNumber(number);
    	client.setName(nameField.getText());
    	SQLClientService.getSQLClientService().update(client);
    	// ------------------------------------------------------------------------
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
		img = img.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
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

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	dispose();
    	MenuAdminEdit menuAdminEdit = new MenuAdminEdit(admin);
    	menuAdminEdit.setVisible(true);
    }                                          

    private void cartButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	dispose();
    	AdminShoppingCart adminShoppingCart = new AdminShoppingCart(client,admin);
    	adminShoppingCart.setVisible(true);
    }
    
    private void historyButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	dispose();
    	ShoppingHistory sh = new ShoppingHistory(client,admin);
    	sh.setVisible(true);
    }                 
    
    private void blockButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
    	SQLClientService.getSQLClientService().delete(client);
    	JOptionPane.showMessageDialog(null, "BLOQUEADO");
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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageUser(client,admin).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private JTextField addressField;
    private JLabel addressLabel;
    private JButton backButton;
    private JButton blockButton;
    private JButton cartButton;
    private JLabel cartLabel;
    private JTextField emailField;
    private JLabel emailLabel;
    private JButton historyButton;
    private JLabel historyLabel;
    private JLabel invalidAddressLabel;
    private JLabel invalidEmailLabel;
    private JLabel invalidPasswordLabel;
    private JLabel invalidPhoneNumberLabel;
    private JButton jButton1;
    private JPanel jPanel1;
    private JPanel jPanel2;
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
    private JTextField rutField;
    private JLabel rutLabel;
    private JButton saveButton;
    private JLabel userPhoto;
    private JPanel userPhotoPanel;
    private Color mainColor = new Color(255, 212, 171);
    private Color black = new Color(0, 0, 0);
    private Color red = new Color(255, 0, 0);
    private Color secondColor = new Color(255, 174, 167);
    private char[] prevPassword;
	private String prevAddress;
	private String prevTelephone;
	private String prevEmail;
    private static Client client;
    private static Admin admin;
    // End of variables declaration                   
}