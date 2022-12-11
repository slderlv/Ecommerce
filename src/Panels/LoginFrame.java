package Panels;

import Database.SQLClientService;
import Assets.CryptoService;
import Assets.JTextFieldLimit;
import Assets.RutFormat;
import Assets.SQLClientServiceAdapter;
import Domain.User;
import Domain.UserDirector;
import Domain.AdminBuilder;
import Domain.ClientBuilder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import Logic.SystemService;
import Domain.Admin;
import Domain.Client; 

@SuppressWarnings("serial")
public class LoginFrame extends JFrame {

    public LoginFrame() {
    	SystemService.getSystem().refreshLists();
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        usernameText = new JTextField();
        passwordText = new JPasswordField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        errorLogin = new JLabel();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ecommerce - Login");
        setBackground(new Color(255, 212, 171));
        setName("Login"); 
        setPreferredSize(new Dimension(1280, 720));

        jPanel1.setBackground(new Color(255, 212, 171));
        jPanel1.setPreferredSize(new Dimension(1280, 720));

        usernameText.setDocument(new JTextFieldLimit(12));
        usernameText.setBackground(new Color(255, 174, 167));
        usernameText.setFont(new Font("Segoe UI", 0, 36)); 

        passwordText.setDocument(new JTextFieldLimit(41));
        passwordText.setBackground(new Color(255, 174, 167));
        passwordText.setFont(new Font("Segoe UI", 0, 36)); 

        jLabel1.setIcon(new ImageIcon(getClass().getResource("/Icons/personLogin.png"))); 

        jLabel2.setIcon(new ImageIcon(getClass().getResource("/Icons/passwordLogin.png"))); 

        jButton1.setBackground(new Color(255, 174, 167));
        jButton1.setFont(new Font("Segoe UI", 0, 24)); 
        jButton1.setText("\u00bfNo tienes cuenta? Reg\u00edstrate aqu\u00ed");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Register(evt);
            }
        });

        jButton2.setBackground(new Color(255, 174, 167));
        jButton2.setFont(new Font("Segoe UI", 0, 24)); 
        jButton2.setText("Iniciar Sesi\u00f3n");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    Login(evt);
                } catch (Exception e) {
                }
            }
        });

        errorLogin.setFont(new Font("Segoe UI", 0, 18)); 
        errorLogin.setForeground(new Color(255, 0, 51));
        errorLogin.setText("");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 759, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(usernameText)
                                .addComponent(passwordText, GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)))
                        .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(248, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errorLogin)
                .addGap(497, 497, 497))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameText, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordText, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLogin)
                .addGap(24, 24, 24)
                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
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

    private void Login(ActionEvent evt) throws SQLException {
    	String user = usernameText.getText();
    	@SuppressWarnings("deprecation")
		String password = passwordText.getText();
    	
    	if(password.isEmpty() || user.isEmpty()) {
    		errorLogin.setText("Falta alg\u00fan campo");
    		
    	}else {
            user = RutFormat.formatToDatabase(user);
            password = CryptoService.getCryptoService().encodePassword(password);
            String format = user + "," + password;
            User us = SQLClientServiceAdapter.loginData(format);
            ResultSet rs = SQLClientService.getSQLClientService().read(us);
            if (rs.next()){
                //si existe
                String validation = rs.getString("admin");
                String rut = rs.getString("rut");
                String name = rs.getString("name");
                password = rs.getString("password");
                String mail = rs.getString("mail");
                if (validation.equals("t")){
                    //Admin 
                	//BUILD ASSET
                    format = name + ","+ mail + ","+ password + ","+ rut;
                    AdminBuilder adminBuilder = new AdminBuilder();
                    UserDirector.getUserDirector().createUser(adminBuilder,format ); 
                    Admin admin = adminBuilder.getResult();
                    MenuAdminEdit af = new MenuAdminEdit(admin);
                    af.setVisible(true);
                    dispose();
                }
                else{
                	String img_path = rs.getString("img_path");
                    //Client 
                	//BUILD ASSET
                    format = name + "," + mail + ","+ password + ","+ rut;
                    ClientBuilder clientBuilder = new ClientBuilder();
                    clientBuilder.setAddress(rs.getString("street"));
                    clientBuilder.setName(rs.getString("name"));
                    clientBuilder.setNumber(rs.getInt("phone_number"));
                    UserDirector.getUserDirector().createUser(clientBuilder,format);
                    Client client = clientBuilder.getResult();
                    client.setImg_path(img_path);
                    ClientFrame cf = new ClientFrame(client);
                    cf.setVisible(true);
                    dispose();
                }
            } else {
                errorLogin.setText("Cuenta o contrase\u00f1a incorrecta");

            }
    		
    	}
        //NUEVO FUNCIONAMIENTO 
        //OBTENER LOS FIELDS 
        //LLAMAR A SQLLoginServiceAdapter("user,password"[ese formato]) --> retorna un usuario
        // RS rs = SQLClientService.getSQLClientService().read(SQLClientServiceAdapter(user,password));
        // while (rs.next()) -> getFields -> Builder -> redirigir con esa info el programa
        // if (rs.getAdmin -> true){
        //   Builder admin
        //} else builder client
    }

    private void Register(ActionEvent evt) {
    	RegisterFrame rf = new RegisterFrame(null);
        this.setVisible(false);
        rf.setVisible(true);
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
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private JLabel errorLogin;
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JPasswordField passwordText;
    private JTextField usernameText;
    // End of variables declaration
}
