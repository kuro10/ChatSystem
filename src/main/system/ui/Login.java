/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.system.ui;

import java.awt.event.KeyEvent;
import main.system.model.Node;
import main.system.model.Peer;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import main.system.connection.handler.TCPListenerHandler;



/**
 *
 * @author th_tran
 */
public class Login extends javax.swing.JFrame {
    
    private Node node;
    static Thread listen = null;
    static TCPListenerHandler runnable = null;    
    
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
    }
    
    public Login(Node node){
        initComponents();
        this.node = node;
        hostField.setText(node.getPeer().getHost());
    }
    

    public void display(){
        this.setLocationRelativeTo(null); 
        this.setVisible(true);
    }
    
    public void setTitre(String titre){
        titreLabel.setText(titre);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nicknameField = new javax.swing.JTextField();
        hostField = new javax.swing.JTextField();
        portField = new javax.swing.JTextField();
        titreLabel = new javax.swing.JLabel();
        logInButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Your host :");

        jLabel2.setText("Your nickname :");

        jLabel3.setText("Port :");

        nicknameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicknameFieldActionPerformed(evt);
            }
        });

        hostField.setText("localhost");

        portField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                portFieldKeyPressed(evt);
            }
        });

        titreLabel.setText("Welcome !!!");

        logInButton.setText("Log in");
        logInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel1)
                                .addComponent(nicknameField)
                                .addComponent(hostField)
                                .addComponent(portField, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(titreLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(logInButton)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(titreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nicknameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logInButton)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void nicknameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicknameFieldActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nicknameFieldActionPerformed

    private void logInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInButtonActionPerformed
        // TODO add your handling code here:
        try {
            Peer peer = new Peer(nicknameField.getText(), hostField.getText(), Integer.parseInt(portField.getText()));
            this.node =  new Node(peer);
            
            ChatWindow chatWindow = new ChatWindow(node);
            chatWindow.display();
            
            this.setVisible(false);
            
            if (listen != null && runnable != null ){
                runnable.terminate();
                listen.join();
                System.out.println(listen.getState());
            }
 
            runnable = new TCPListenerHandler(this.node,chatWindow); 
            listen = new Thread(runnable);  
            listen.start();
            System.out.println(listen.getState());
  
        } catch (UnknownHostException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logInButtonActionPerformed

    private void portFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_portFieldKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                Peer peer = new Peer(nicknameField.getText(), hostField.getText(), Integer.parseInt(portField.getText()));
                this.node =  new Node(peer);

                ChatWindow chatWindow = new ChatWindow(node);
                chatWindow.display();

                this.setVisible(false);

                if (listen != null && runnable != null ){
                    runnable.terminate();
                    listen.join();
                    System.out.println(listen.getState());
                }

                runnable = new TCPListenerHandler(this.node,chatWindow); 
                listen = new Thread(runnable);  
                listen.start();
                System.out.println(listen.getState());

            }catch (UnknownHostException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_portFieldKeyPressed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Login().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField hostField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton logInButton;
    private javax.swing.JTextField nicknameField;
    private javax.swing.JTextField portField;
    private javax.swing.JLabel titreLabel;
    // End of variables declaration//GEN-END:variables
}

