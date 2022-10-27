/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Panels;

import Database.SQLClientService;
import Assets.CryptoService;
import Assets.RutFormat;
import Assets.SQLClientServiceAdapter;
import Domain.User;
import Domain.UserDirector;
import Domain.AdminBuilder;
import Domain.ClientBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Domain.Admin;
import Domain.Client;

/**
 *
 * @author sketc
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        usernameText = new javax.swing.JTextField();
        passwordText = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        errorLogin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Eccomerce - Login");
        setBackground(new java.awt.Color(255, 212, 171));
        setName("Login"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1280, 720));

        jPanel1.setBackground(new java.awt.Color(255, 212, 171));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        usernameText.setBackground(new java.awt.Color(255, 174, 167));
        usernameText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        passwordText.setBackground(new java.awt.Color(255, 174, 167));
        passwordText.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/personLogin.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/passwordLogin.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(255, 174, 167));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("¿No tienes cuenta? Registrate aqui");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Register(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 174, 167));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton2.setText("Iniciar Sesion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    Login(evt);
                } catch (Exception e) {
                    System.out.println("oli");
                }
            }
        });

        errorLogin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        errorLogin.setForeground(new java.awt.Color(255, 0, 51));
        errorLogin.setText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(usernameText)
                                .addComponent(passwordText, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)))
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(248, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(errorLogin)
                .addGap(497, 497, 497))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLogin)
                .addGap(24, 24, 24)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void Login(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_Login
        // TODO add your handling code here:
    	String user = usernameText.getText();
    	String password = passwordText.getText();
    	
    	if(password.isEmpty() || user.isEmpty()) {
    		errorLogin.setText("Falta algun campo");
    		
    	}else {
            user = RutFormat.formatToDatabase(user);
            password = CryptoService.getCryptoService().encodePassword(password);
            String format = user + "," + password;
            System.out.println(format);
            User us = SQLClientServiceAdapter.loginData(format);
            ResultSet rs = SQLClientService.getSQLLoginService().read(us);
            System.out.println(us);
            System.out.println(rs);
            if (rs.next()){
                //si existe
                String validation = rs.getString("admin");
                String rut = rs.getString("rut");
                String name = rs.getString("nombre");
                password = rs.getString("password");
                String mail = rs.getString("correo");

                System.out.println("ACA?");
                System.out.println(validation);
                System.out.println(rs.getString("admin"));
                System.out.println(rs.getString("password"));
                if (validation.equals("t")){
                    //Admin 
                    System.out.println("ENTRE");
                    format = name + ","+ mail + ","+ password + ","+ rut;
                    AdminBuilder adminBuilder = new AdminBuilder();
                    UserDirector.getUserDirector().createUser(adminBuilder,format ); 
                    Admin admin = adminBuilder.getResult();
                    MenuAdminFrame af = new MenuAdminFrame();
                    af.setVisible(true);
                    this.setVisible(false);
                }
                else{
                    //Client 
                    format = name + ","+ mail + ","+ password + ","+ rut;
                    ClientBuilder clientBuilder = new ClientBuilder();
                    UserDirector.getUserDirector().createUser(clientBuilder,format);
                    Client client = clientBuilder.getResult();
                }
            } else {
                errorLogin.setText("Cuenta o contraseña incorrectos");

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

    	
    }//GEN-LAST:event_Login

    private void Register(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Register
    	RegisterFrame rf = new RegisterFrame();
        this.setVisible(false);
        rf.setVisible(true);
        
    }//GEN-LAST:event_Register

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
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLogin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
