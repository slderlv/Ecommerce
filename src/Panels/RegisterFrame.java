package Panels;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Assets.CryptoService;
import Assets.JTextFieldLimit;
import Assets.SQLClientServiceAdapter;
import Assets.ValidateMail;
import Assets.RutFormat;
import Database.SQLClientService;
import Domain.Admin;
import Domain.User;

@SuppressWarnings("serial")
public class RegisterFrame extends JFrame {

    public RegisterFrame(User user) {
        RegisterFrame.user = user;
    	initComponents();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        backButton = new JButton();
        rutLabel = new JLabel();
        personIconLabel = new JLabel();
        passwordLabel = new JLabel();
        passwordIconLabel = new JLabel();
        confirmPasswordLabel = new JLabel();
        confirmPasswordIconLabel = new JLabel();
        emailLabel = new JLabel();
        emailIconLabel = new JLabel();
        rutField = new JTextField();
        passwordField = new JPasswordField();
        emailField = new JTextField();
        passwordField2 = new JPasswordField();
        registerButton = new JButton();
        loginText = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ecommerce - Register");

        jPanel1.setBackground(new Color(255, 212, 171));
        jPanel1.setPreferredSize(new Dimension(1280, 720));

        backButton.setBackground(new Color(255, 212, 171));
        backButton.setIcon(new ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        backButton.setContentAreaFilled(false);
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setBorderPainted(false);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Back(evt);
            }
        });

        rutLabel.setFont(new Font("Segoe UI", 0, 36)); // NOI18N
        rutLabel.setForeground(new Color(0, 0, 0));
        rutLabel.setText("Rut");

        personIconLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/person.png"))); // NOI18N

        passwordLabel.setFont(new Font("Segoe UI", 0, 36)); // NOI18N
        passwordLabel.setForeground(new Color(0, 0, 0));
        passwordLabel.setText("Contrase\u00f1a");

        passwordIconLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/key.png"))); // NOI18N

        confirmPasswordLabel.setFont(new Font("Segoe UI", 0, 36)); // NOI18N
        confirmPasswordLabel.setForeground(new Color(0, 0, 0));
        confirmPasswordLabel.setText("Confirmar contrase\u00f1a");

        confirmPasswordIconLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/key.png"))); // NOI18N

        emailLabel.setFont(new Font("Segoe UI", 0, 36)); // NOI18N
        emailLabel.setForeground(new Color(0, 0, 0));
        emailLabel.setText("Email");

        emailIconLabel.setIcon(new ImageIcon(getClass().getResource("/Icons/email.png"))); // NOI18N
        
        rutField.setDocument(new JTextFieldLimit(12));
        rutField.setBackground(new Color(255, 174, 167));
        rutField.setFont(new Font("Segoe UI", 0, 24)); // NOI18N
        
        passwordField.setDocument(new JTextFieldLimit(41));
        passwordField.setBackground(new Color(255, 174, 167));
        passwordField.setFont(new Font("Segoe UI", 0, 24)); // NOI18N

        emailField.setDocument(new JTextFieldLimit(39));
        emailField.setBackground(new Color(255, 174, 167));
        emailField.setFont(new Font("Segoe UI", 0, 24)); // NOI18N

        passwordField2.setDocument(new JTextFieldLimit(41));
        passwordField2.setBackground(new Color(255, 174, 167));
        passwordField2.setFont(new Font("Segoe UI", 0, 24)); // NOI18N

        registerButton.setBackground(new Color(255, 27, 157));
        registerButton.setForeground(new Color(0, 0, 0));
        registerButton.setFont(new Font("Segoe UI", 0, 48)); // NOI18N
        registerButton.setText("Crear Cuenta");
        registerButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerButton.setFocusPainted(false);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RegisterButton(evt);
            }
        });

        loginText.setText("\u00bfYa tienes cuenta? Inicia sesi\u00f3n");
        loginText.setFont(new Font("Segoe UI", 3, 13));
        loginText.setForeground(Color.blue);
        loginText.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginText.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                LoginText(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(confirmPasswordLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(confirmPasswordIconLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                            .addComponent(emailLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(emailIconLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                            .addComponent(rutLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(personIconLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rutField, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(passwordIconLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(passwordLabel))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(registerButton, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
                                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(loginText)
                                        .addGap(77, 77, 77)))))))
                .addGap(127, 127, 127))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rutLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(personIconLabel)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(passwordLabel)
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(passwordIconLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(confirmPasswordLabel))
                                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(loginText)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(confirmPasswordIconLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(emailLabel))
                            .addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(emailIconLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(rutField, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
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
    }

    private void Back(ActionEvent evt) {
        dispose();
    	if(user==null) {
    		LoginFrame login = new LoginFrame();
            login.setVisible(true);
        } else { 	
            MenuAdminEdit mae = new MenuAdminEdit((Admin) user);
        	mae.setVisible(true);
        }
    	
    }

    private void LoginText(MouseEvent evt) {
        LoginFrame login = new LoginFrame();
        login.setVisible(true);
        this.setVisible(false);
    }

    @SuppressWarnings("deprecation")
	private void RegisterButton(ActionEvent evt) {
    	//JOptionPane.showMessageDialog(null, "EL BOTON FUNCIONA");
    	String rut = rutField.getText();
        String password = passwordField.getText();
        String password2 = passwordField2.getText();
        if(rut.isBlank()) {
        	JOptionPane.showMessageDialog(null, "El campo rut se encuentra vac\u00edo");
        	return;
        }
        if(password.length()<4) {
        	JOptionPane.showMessageDialog(null, "Contrase\u00f1a debe tener al menos 4 car\u00e1cteres");
        	return;
        }
        
        if (!ValidateMail.isValid(emailField.getText())) {
        	JOptionPane.showMessageDialog(null, "EMAIL NO VALIDO");
        	return;
        }
        
        if(password.equals(password2)) {
            password = CryptoService.getCryptoService().encodePassword(password);
            String email = emailField.getText();
            //String number = phoneText.getText();
            if(RutFormat.isValid(rut)) {
            	String format =  " ,"+ email+ "," + password +"," + RutFormat.formatToDatabase(rut);
            	User us = SQLClientServiceAdapter.userData(format);
            	
            	try {
            		System.out.println(us.getRut());
            		System.out.println(us.getPassword());
            		ResultSet rs = SQLClientService.getSQLClientService().read(us.getRut());
            		//System.out.println(rs.next());
					if (rs.next()) {
						JOptionPane.showMessageDialog(null, "Usuario ya registrado");
					
					} else {
						SQLClientService.getSQLClientService().create(us);   
						JOptionPane.showMessageDialog(null, "Usuario registrado correctamente");
						dispose();
						LoginFrame lf = new LoginFrame();            		
						lf.setVisible(true);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
            	
            }
        }
        else {
        	JOptionPane.showMessageDialog(null, "Contrase\u00f1a no coincide");	
        }  	
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
            Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(RegisterFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterFrame(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JButton backButton;
    private JTextField emailField;
    private JLabel rutLabel;
    private JLabel personIconLabel;
    private JLabel passwordLabel;
    private JLabel passwordIconLabel;
    private JLabel confirmPasswordLabel;
    private JLabel confirmPasswordIconLabel;
    private JLabel emailLabel;
    private JLabel emailIconLabel;
    private JPanel jPanel1;
    private JLabel loginText;
    private JTextField rutField;
    private JPasswordField passwordField;
    private JPasswordField passwordField2;
    private JButton registerButton;
    private static User user;
    // End of variables declaration
}
