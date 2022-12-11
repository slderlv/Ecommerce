package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import Assets.ArrayToString;
import Domain.Admin;
import Domain.Client;
import Domain.Product;
import Domain.User;
import Logic.SystemService;


@SuppressWarnings("serial")
public class ProductListFrame extends JFrame {

	private ArrayList<String> categorys;
	private ArrayList<Product> products;

    public ProductListFrame(User user) {
    	ProductListFrame.user = user;
    	SystemService.getSystem().refreshLists();
    	categorys = SystemService.getSystem().getCategorys();
    	products = SystemService.getSystem().getProducts();
        initComponents();
        setLocationRelativeTo(null);
    }
                       
    private void initComponents() {

        jPanel1 = new JPanel();
        backButton = new JButton();
        menuPanel = new JPanel();
        jScrollPane1 = new JScrollPane();
        productList = new JList<>();
        filterText = new JTextField();
        jComboBox1 = new JComboBox<>();
        jButton2 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ecommerce - Lista de productos");

        jPanel1.setBackground(new Color(255, 212, 171));
        jPanel1.setPreferredSize(new Dimension(1280, 720));

        backButton.setBackground(new Color(255, 212, 171));
        backButton.setIcon(new ImageIcon(getClass().getResource("/Icons/back.png"))); 
        backButton.setBorder(null);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Back(evt);
            }
        });

        menuPanel.setBackground(new Color(255, 111, 156));
        menuPanel.setPreferredSize(new Dimension(1024, 512));

        productList.setModel(new AbstractListModel<String>() {
            String[] strings = ArrayToString.getStringArrayFromProducts(products);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        productList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                DoubleClick(evt);
            }
        });
        jScrollPane1.setViewportView(productList);

        filterText.setFont(new Font("Segoe UI", 0, 18)); 
        filterText.setPreferredSize(new Dimension(73, 32));

        jComboBox1.setFont(new Font("Segoe UI", 0, 18)); 
        jComboBox1.setModel(new DefaultComboBoxModel<>(ArrayToString.getStringArray(categorys)));
        jComboBox1.setPreferredSize(new Dimension(256, 32));

        jButton2.setFont(new Font("Segoe UI", 0, 24)); 
        jButton2.setText("Filtrar");
        jButton2.setPreferredSize(new Dimension(32, 32));
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Filter(evt);
            }
        });

        GroupLayout menuPanelLayout = new GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(filterText, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 846, GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(filterText, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(menuPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
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
    }                    

    private void Filter(ActionEvent evt) {                        
        String filter = filterText.getText();
        String category = (String) jComboBox1.getSelectedItem();
        SystemService.getSystem().refreshProducts(category,filter);
        products = SystemService.getSystem().getProducts();
        productList.setModel(new AbstractListModel<String>() {
            String[] strings = ArrayToString.getStringArrayFromProducts(products);
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
    }     
    
	private void DoubleClick(MouseEvent evt) {
    	if (evt.getClickCount() == 2) {
    		String selectProduct = productList.getSelectedValue();
    		Product product = products.get(0);
    		for (int i = 0; i < products.size(); i++) {
    			product = products.get(i);
    			if (product.getInfo().getName().equals(selectProduct)) break;
    		}
    		dispose();
    		ProductFrame pf = new ProductFrame(product,user);
    		pf.setVisible(true);
		 	
    	}
    	
    }

    private void Back(ActionEvent evt) {                      
    	dispose();
    	if(user instanceof Admin) {
    		MenuAdminEdit mae = new MenuAdminEdit((Admin)user);
    		mae.setVisible(true);
    	} else {
    		ClientFrame cf = new ClientFrame((Client)user);
    		cf.setVisible(true);
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
            Logger.getLogger(ProductListFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ProductListFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ProductListFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ProductListFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductListFrame(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private JButton backButton;
    private JTextField filterText;
    private JButton jButton2;
    private JComboBox<String> jComboBox1;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JPanel menuPanel;
    private JList<String> productList;
    private static User user;
    // End of variables declaration                   
}
