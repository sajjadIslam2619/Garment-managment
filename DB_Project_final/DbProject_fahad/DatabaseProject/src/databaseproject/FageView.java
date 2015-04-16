/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

import databaseproject.getInfo.DataCollectorFromDB;
import databaseproject.getInfo.Constants;
import databaseproject.item.UserIdItem;
import databaseproject.item.connector.Connector;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class FageView extends javax.swing.JFrame {

    DataCollectorFromDB dataFromDb;
    static FageView fageView;

    ArrayList<UserIdItem> userIdItems;
    
    public FageView() {
        initComponents();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        dataFromDb = new DataCollectorFromDB();
        showView(-1);
        showView(1);
        actionListener();
    }

    private void showView(int i) {
        
        if (i == Constants.LOGIN_VIEW) {
            loginRightPanel.setVisible(true);
        } else if (i == Constants.SINGUP_VIEW) {
            signUpRightPanel.setVisible(true);
        } else if (i == -1) {
            loginRightPanel.setVisible(false);
            signUpRightPanel.setVisible(false);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginLeftBarPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        passwordLeftLoginEd = new javax.swing.JPasswordField();
        loginLeftLoginB = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        signUpLeftLoginB = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        userNameLeftLoginEd = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        loginRightPanel = new javax.swing.JPanel();
        signUpRightPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        userNameRightSignEd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fullNameRightSignEd = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        emailSignRightEd = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        companyRightSignEd = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        passwordRightSignEd = new javax.swing.JPasswordField();
        signUpRightSingB = new javax.swing.JButton();
        cancelRightSignB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        loginLeftBarPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));
        loginLeftBarPanel.setForeground(new java.awt.Color(141, 172, 206));

        jLabel1.setText("Email");

        jLabel2.setText("Password");

        loginLeftLoginB.setText("Login");
        loginLeftLoginB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginLeftLoginBActionPerformed(evt);
            }
        });

        signUpLeftLoginB.setText("Sign Up");

        jLabel4.setText("Don't have any account?");

        javax.swing.GroupLayout loginLeftBarPanelLayout = new javax.swing.GroupLayout(loginLeftBarPanel);
        loginLeftBarPanel.setLayout(loginLeftBarPanelLayout);
        loginLeftBarPanelLayout.setHorizontalGroup(
            loginLeftBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLeftBarPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(loginLeftBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginLeftBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(signUpLeftLoginB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .addComponent(userNameLeftLoginEd, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(passwordLeftLoginEd, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(loginLeftLoginB, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        loginLeftBarPanelLayout.setVerticalGroup(
            loginLeftBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginLeftBarPanelLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userNameLeftLoginEd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(passwordLeftLoginEd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginLeftLoginB)
                .addGap(44, 44, 44)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signUpLeftLoginB)
                .addGap(55, 55, 55))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        loginRightPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        signUpRightPanel.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(204, 204, 204)));

        jLabel5.setText("User Name");

        jLabel6.setText("Full Name");

        jLabel7.setText("Email");

        jLabel8.setText("Company Name");

        jLabel9.setText("Password");

        signUpRightSingB.setText("Sign Up");

        cancelRightSignB.setText("Cancel");

        javax.swing.GroupLayout signUpRightPanelLayout = new javax.swing.GroupLayout(signUpRightPanel);
        signUpRightPanel.setLayout(signUpRightPanelLayout);
        signUpRightPanelLayout.setHorizontalGroup(
            signUpRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signUpRightPanelLayout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addGroup(signUpRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(userNameRightSignEd)
                    .addComponent(fullNameRightSignEd)
                    .addComponent(emailSignRightEd)
                    .addComponent(companyRightSignEd)
                    .addComponent(passwordRightSignEd)
                    .addGroup(signUpRightPanelLayout.createSequentialGroup()
                        .addComponent(signUpRightSingB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addComponent(cancelRightSignB)))
                .addContainerGap(355, Short.MAX_VALUE))
        );
        signUpRightPanelLayout.setVerticalGroup(
            signUpRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(signUpRightPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addComponent(userNameRightSignEd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(4, 4, 4)
                .addComponent(fullNameRightSignEd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addComponent(emailSignRightEd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(companyRightSignEd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordRightSignEd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(signUpRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signUpRightSingB)
                    .addComponent(cancelRightSignB))
                .addContainerGap(155, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout loginRightPanelLayout = new javax.swing.GroupLayout(loginRightPanel);
        loginRightPanel.setLayout(loginRightPanelLayout);
        loginRightPanelLayout.setHorizontalGroup(
            loginRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signUpRightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        loginRightPanelLayout.setVerticalGroup(
            loginRightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(signUpRightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(loginLeftBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(loginRightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loginRightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(loginLeftBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actionListener() {
        loginLeftLoginB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userNameLeftLoginEd.getText().toString();
                String passString = passwordLeftLoginEd.getText().toString();
                System.out.println(userName + ":" + passString);
                
                userIdItems =dataFromDb.checkedLogin(userName, passString);
                if(userIdItems.size()>0){
                    if(userIdItems.get(0).getId_user_type().equals("2")){
                         goToNextPage("Login Successfully.",2);
                    }else if(userIdItems.get(0).getId_user_type().equals("1")){
                         goToNextPage("Login Successfully.",1);
                    }
                   
                }else{
                    JOptionPane.showMessageDialog(null, "Login failed, Try again");
                }
            }

            
        });
        signUpLeftLoginB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                showView(Constants.SINGUP_VIEW);
            }
        });

        signUpRightSingB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String user_name=userNameRightSignEd.getText().toString(); 
                String full_name=fullNameRightSignEd.getText().toString();
                String e_mail=emailSignRightEd.getText().toString();
                String company_name=companyRightSignEd.getText().toString();
                String password=passwordRightSignEd.getText().toString();
                UserIdItem item = new UserIdItem( 1,user_name, full_name, e_mail, company_name, password,"2",Constants.Byer);
                int flag=dataFromDb.insertSignUpDataIntoDB(item);
                if(flag==Constants.SuccessfulFlag) {
                    goToNextPage("Successfully registered.",2);
                }
                else if(flag==Constants.FailedFlag) JOptionPane.showMessageDialog(null, "Failed");
                else JOptionPane.showMessageDialog(null, "Duplicate");
                
            }

            
        });
    }

    private void goToNextPage(String msg,int userType) {
                 int res = JOptionPane.showOptionDialog(null, "Suucess", msg, JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE, null, null, null);
                    if(res==0){
                        Constants.userIdItem = userIdItems.get(0);
                        if(userType==2){
                            
                            ByerView byerView = new ByerView();
                            byerView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            byerView.setSize(1200, 600);

                            fageView.setVisible(false);
                            byerView.setVisible(true);
                            byerView.setLocation(200, 30);
                        }else if(userType==1){
                            OwnerView ownerView = new OwnerView();
                            ownerView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            ownerView.setSize(1200, 600);

                            fageView.setVisible(false);
                            ownerView.setVisible(true);
                            ownerView.setLocation(200, 30);
                        }
                        
                    }
            }
    private void loginLeftLoginBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginLeftLoginBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginLeftLoginBActionPerformed

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        }
        catch (Exception e) {
            System.out.println("An Exception occured: "+e);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                fageView = new FageView();
                fageView.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelRightSignB;
    private javax.swing.JTextField companyRightSignEd;
    private javax.swing.JTextField emailSignRightEd;
    private javax.swing.JTextField fullNameRightSignEd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel loginLeftBarPanel;
    private javax.swing.JButton loginLeftLoginB;
    private javax.swing.JPanel loginRightPanel;
    private javax.swing.JPasswordField passwordLeftLoginEd;
    private javax.swing.JPasswordField passwordRightSignEd;
    private javax.swing.JButton signUpLeftLoginB;
    private javax.swing.JPanel signUpRightPanel;
    private javax.swing.JButton signUpRightSingB;
    private javax.swing.JTextField userNameLeftLoginEd;
    private javax.swing.JTextField userNameRightSignEd;
    // End of variables declaration//GEN-END:variables


    
}
