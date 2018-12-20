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
import javax.swing.WindowConstants;
import main.system.connection.handler.TCPListenerHandler;
import main.system.connection.handler.UDPListenerHandler;
import main.system.connection.service.UDPSenderService;



/**
 *
 * @author th_tran
 */
public class Login extends javax.swing.JFrame {
    
    private Node node;
    static Thread listenTCP = null;
    static Thread listenUDP = null;
    static TCPListenerHandler runnableTCP = null;    
    static UDPListenerHandler runnableUDP = null;
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
    
    public void setTitle(String title){
        titleLabel.setText(title);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hostLabel = new javax.swing.JLabel();
        nicknameLabel = new javax.swing.JLabel();
        portLabel = new javax.swing.JLabel();
        nicknameField = new javax.swing.JTextField();
        hostField = new javax.swing.JTextField();
        portField = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        logInButton = new javax.swing.JButton();
        chatButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        hostLabel.setText("Your host :");

        nicknameLabel.setText("Your nickname :");

        portLabel.setText("Port :");

        nicknameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicknameFieldActionPerformed(evt);
            }
        });

        hostField.setEditable(false);
        hostField.setText("localhost");

        portField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                portFieldKeyPressed(evt);
            }
        });

        titleLabel.setForeground(new java.awt.Color(250, 0, 0));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Welcome !!!");

        logInButton.setText("Log in");
        logInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInButtonActionPerformed(evt);
            }
        });

        chatButton.setText("Chat");
        chatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatButtonActionPerformed(evt);
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
                            .addComponent(nicknameLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(portLabel)
                                .addComponent(hostLabel)
                                .addComponent(nicknameField)
                                .addComponent(hostField)
                                .addComponent(portField, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                            .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logInButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(chatButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nicknameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nicknameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hostLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hostField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(logInButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chatButton)
                .addContainerGap(17, Short.MAX_VALUE))
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
                        
            Home home = new Home(node);
            home.display();
            
            this.setVisible(false);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.dispose();
            
            //This thread is used to reveice le broadcast by UDP
            if (listenUDP != null && runnableUDP != null ){
                runnableUDP.terminate();
                 listenUDP.join();
             }
            runnableUDP = new UDPListenerHandler(this.node); 
            listenUDP = new Thread(runnableUDP);  
            listenUDP.start();

           // Send a broadcast when log in
            new UDPSenderService().sendBroadcast(this.node);
            
            

            
        } catch (UnknownHostException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_logInButtonActionPerformed

    private void portFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_portFieldKeyPressed
        // TODO add your handling code here:
//        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            try {
//                Peer peer = new Peer(nicknameField.getText(), hostField.getText(), Integer.parseInt(portField.getText()));
//                this.node =  new Node(peer);
//
//                ChatWindow chatWindow = new ChatWindow(node);
//                chatWindow.display();
//
//                this.setVisible(false);
//                setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//                this.dispose();
//
//                // This thread is used to receive message sent by TCP
//                if (listenTCP != null && runnableTCP != null ){
//                    runnableTCP.terminate();
//                    listenTCP.join();
//                    //System.out.println(listenTCP.getState());
//                }
//
//                runnableTCP = new TCPListenerHandler(this.node,chatWindow); 
//                listenTCP = new Thread(runnableTCP);  
//                listenTCP.start();
//                 //This thread is used to reveice le broadcast sent by UDP
//                if (listenUDP != null && runnableUDP != null ){
//                    runnableUDP.terminate();
//                    listenUDP.join();
//                    //System.out.println(listenUDP.getState());
//                }
//
//                runnableUDP = new UDPListenerHandler(this.node,chatWindow); 
//                listenUDP = new Thread(runnableUDP);  
//                listenUDP.start();

//                // Send a broadcast when log in
//                new UDPSenderService().sendBroadcast(this.node);

//            }catch (UnknownHostException ex) {
//                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//            } catch (IOException | InterruptedException ex) {
//                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_portFieldKeyPressed

    private void chatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatButtonActionPerformed
        // TODO add your handling code here:
        try {
            Peer peer = new Peer(nicknameField.getText(), hostField.getText(), Integer.parseInt(portField.getText()));
            this.node =  new Node(peer);
            
            ChatWindow chatWindow = new ChatWindow(node);
            chatWindow.display();
            
            this.setVisible(false);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            this.dispose();
            
            // This thread is used to receive message sent by TCP
            if (listenTCP != null && runnableTCP != null ){
                runnableTCP.terminate();
                listenTCP.join();
                //System.out.println(listenTCP.getState());
            }
 
            runnableTCP = new TCPListenerHandler(this.node,chatWindow); 
            listenTCP = new Thread(runnableTCP);  
            listenTCP.start();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_chatButtonActionPerformed

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
    private javax.swing.JButton chatButton;
    private javax.swing.JTextField hostField;
    private javax.swing.JLabel hostLabel;
    private javax.swing.JButton logInButton;
    private javax.swing.JTextField nicknameField;
    private javax.swing.JLabel nicknameLabel;
    private javax.swing.JTextField portField;
    private javax.swing.JLabel portLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}

