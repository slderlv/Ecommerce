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
import Assets.SQLClientServiceAdapter;
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
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        nameText = new JTextField();
        passwordText = new JPasswordField();
        emailText = new JTextField();
        password2Text = new JPasswordField();
        registerButtom = new JButton();
        loginText = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ecommerce - Register");

        jPanel1.setBackground(new Color(255, 212, 171));
        jPanel1.setPreferredSize(new Dimension(1280, 720));

        backButton.setBackground(new Color(255, 212, 171));
        backButton.setIcon(new ImageIcon(getClass().getResource("/Icons/back.png"))); // NOI18N
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Back(evt);
            }
        });

        rutLabel.setFont(new Font("Segoe UI", 0, 36)); // NOI18N
        rutLabel.setForeground(new Color(255, 255, 255));
        rutLabel.setText("Rut");

        jLabel2.setIcon(new ImageIcon(getClass().getResource("/Icons/person.png"))); // NOI18N

        jLabel3.setFont(new Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setForeground(new Color(255, 255, 255));
        jLabel3.setText("Contrase\u00f1a");

        jLabel4.setIcon(new ImageIcon(getClass().getResource("/Icons/key.png"))); // NOI18N

        jLabel5.setFont(new Font("Segoe UI", 0, 36)); // NOI18N
        jLabel5.setForeground(new Color(255, 255, 255));
        jLabel5.setText("Confirmar contrase\u00f1a");

        jLabel6.setIcon(new ImageIcon(getClass().getResource("/Icons/key.png"))); // NOI18N

        jLabel7.setFont(new Font("Segoe UI", 0, 36)); // NOI18N
        jLabel7.setForeground(new Color(255, 255, 255));
        jLabel7.setText("Email");

        jLabel8.setIcon(new ImageIcon(getClass().getResource("/Icons/email.png"))); // NOI18N

        nameText.setBackground(new Color(255, 174, 167));
        nameText.setFont(new Font("Segoe UI", 0, 24)); // NOI18N

        passwordText.setBackground(new Color(255, 174, 167));
        passwordText.setFont(new Font("Segoe UI", 0, 24)); // NOI18N

        emailText.setBackground(new Color(255, 174, 167));
        emailText.setFont(new Font("Segoe UI", 0, 24)); // NOI18N

        password2Text.setBackground(new Color(255, 174, 167));
        password2Text.setFont(new Font("Segoe UI", 0, 24)); // NOI18N

        registerButtom.setBackground(new Color(255, 27, 157));
        registerButtom.setFont(new Font("Segoe UI", 0, 48)); // NOI18N
        registerButtom.setText("Crear Cuenta");
        registerButtom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                RegisterButtom(evt);
            }
        });

        loginText.setText("\u00bfYa tienes cuenta? Inicia sesi\u00f3n");
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
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(password2Text, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(emailText, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                            .addComponent(rutLabel)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(nameText, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 191, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(registerButtom, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(jLabel2)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5))
                                    .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(registerButtom, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(loginText)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7))
                            .addComponent(password2Text, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailText, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
                    .addComponent(nameText, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
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
	private void RegisterButtom(ActionEvent evt) {
    	//JOptionPane.showMessageDialog(null, "EL BOTON FUNCIONA");
    	String rut = nameText.getText();
        String password = passwordText.getText();
        String password2 = password2Text.getText();
        
        if(password.equals(password2)) {
            password = CryptoService.getCryptoService().encodePassword(password);
            String email = emailText.getText();
            //String number = phoneText.getText();
            if(RutFormat.isValid(rut)) {
            	String format =  " ,"+ email+ "," + password +"," + RutFormat.formatToDatabase(rut);
            	User us = SQLClientServiceAdapter.userData(format);
            	
            	try {
            		ResultSet rs = SQLClientService.getSQLClientService().read(us);
					if (!rs.next()) {
						SQLClientService.getSQLClientService().create(us);   
						JOptionPane.showMessageDialog(null, "REGISTRADO");
						dispose();
						LoginFrame lf = new LoginFrame();            		
						lf.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "YA ESTAS REGISTRADO");
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
    private JTextField emailText;
    private JLabel rutLabel;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JPanel jPanel1;
    private JLabel loginText;
    private JTextField nameText;
    private JPasswordField passwordText;
    private JPasswordField password2Text;
    private JButton registerButtom;
    private static User user;
    // End of variables declaration
}
