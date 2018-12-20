/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.system.ui;

import com.sun.glass.events.KeyEvent;
import main.system.model.Node;
import main.system.connection.service.TCPSenderService;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.WindowConstants;
import main.system.connection.service.UDPSenderService;
import main.system.data.*;
import main.system.model.Peer;
import main.system.utilities.Emoji;

/**
 *
 */
public class ChatWindow extends javax.swing.JFrame implements WritableUI {
    
    private Node node;
    private Node client;
    private MessageLog l;
    int sourceport;
        
    /**
     * Creates new form Chat Window
     */
    public ChatWindow() {
        initComponents();
    }
    
    public ChatWindow(Node node) throws IOException {
        initComponents();       
        this.node = node;
        this.nicknameLabel.setText("Pseudo : " + node.getPeer().getPseudonyme());
        this.hostLabel.setText("Host : " + node.getPeer().getHost());
        this.portLabel.setText("Port : " + node.getPeer().getPort());
        sourceport = node.getPeer().getPort();
        //listen = new Thread(new TCPListenerHandler(this.node,this));  
        //listen.start();
    }

    public ChatWindow(Node node, Node client) {
        initComponents();
        this.node = node;
        this.client = client;
        this.nicknameLabel.setText("Pseudo : " + node.getPeer().getPseudonyme());
        this.hostLabel.setText("Host : " + node.getPeer().getHost());
        this.portLabel.setText("Port : " + node.getPeer().getPort());
        sourceport = node.getPeer().getPort();
        this.clientLabel.setText("To : " + this.client.getPeer().getPseudonyme() + " at " + this.client.getPeer().getHost() );
        //this.l = new MessageLog(node.getPeer(), client.getPeer());
    }

    public ChatWindow(Node node, Node client, MessageLog l) {
        initComponents();
        this.l = l;
        if (this.l != null) {
            chatBox.setText(this.l.toString());
        }
        this.node = node;
        this.client = client;
        this.nicknameLabel.setText("Pseudo : " + node.getPeer().getPseudonyme());
        this.hostLabel.setText("Host : " + node.getPeer().getHost());
        this.portLabel.setText("Port : " + node.getPeer().getPort());
        sourceport = node.getPeer().getPort();
        this.clientLabel.setText("To : " + this.client.getPeer().getPseudonyme() + " at " + this.client.getPeer().getHost() );
    }

    
    public String getPseudo() {return this.node.getPeer().getPseudonyme();} 
    
    public void setNicknameLabel (String s) {
        this.nicknameLabel.setText(s);
    }
    
    
    public void display(){
        this.setLocationRelativeTo(null); 
        this.setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        disconnectButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        chatBox = new javax.swing.JTextArea();
        message = new javax.swing.JTextField();
        sendButton = new javax.swing.JButton();
        targetPort = new javax.swing.JTextField();
        targetButton = new javax.swing.JButton();
        nicknameLabel = new javax.swing.JLabel();
        hostLabel = new javax.swing.JLabel();
        portLabel = new javax.swing.JLabel();
        ipDistantField = new javax.swing.JTextField();
        renameButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        clientLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        chatBox.setColumns(20);
        chatBox.setRows(5);
        jScrollPane1.setViewportView(chatBox);

        message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageActionPerformed(evt);
            }
        });
        message.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                messageKeyPressed(evt);
            }
        });

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        targetPort.setText("5678");
        targetPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                targetPortActionPerformed(evt);
            }
        });

        targetButton.setText("Target");
        targetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                targetButtonActionPerformed(evt);
            }
        });

        nicknameLabel.setText("Nickname : ");

        hostLabel.setText("Host :");

        portLabel.setText("Port :");

        ipDistantField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipDistantFieldActionPerformed(evt);
            }
        });

        renameButton.setText("Rename");
        renameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                renameButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        clientLabel.setText("To :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(targetPort, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ipDistantField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(targetButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(renameButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nicknameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(clientLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hostLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(portLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addComponent(disconnectButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nicknameLabel)
                            .addComponent(hostLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(clientLabel)
                            .addComponent(portLabel)))
                    .addComponent(disconnectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(renameButton)
                    .addComponent(targetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ipDistantField)
                    .addComponent(targetPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    int target;
    String ipDistant;
    private void targetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_targetButtonActionPerformed
//      target = Integer.parseInt(this.targetPort.getText());
//      ipDistant = this.ipDistantField.getText();
//      System.out.println("Target to "+ ipDistant + " : " + target);
//      l = new MessageLog(sourceport, target);
////      MessageLog l1 = new MessageLog(sourceport, 2222);
////      MessageLog l2 = new MessageLog(sourceport, 3333);
//      if (history.existHistory(l)) {
//          chatBox.setText("");
//          l = history.getMessageLog(target); 
//          chatBox.append(l.toString());
//          chatBox.append("------Old messages------\n");
//      }
//      else {
//          history.addHistory(l);
//          chatBox.setText("New chat" + System.lineSeparator());
//          historyBox.setText("");
//          historyBox.append(history.toString());
//      }

    }//GEN-LAST:event_targetButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        //TransfererMessage trans = new TransfererMessage(message.getText(), hostField.getText(), Integer.parseInt(portCible.getText()));
        //trans.start();
        try {
            String msg = "[" + node.getPeer().getPseudonyme() + "] : " + message.getText();
            message.setText("");
            //new TCPSenderService().sendMessageTo("localhost",target,msg);
            //new TCPSenderService().sendMessageTo(ipDistant,target,msg);
//            new TCPSenderService().sendMessageTo(this.client.getPeer().getHost(),this.client.getPeer().getPort(),msg);
            new TCPSenderService().sendMessageTo(this.client.getPeer().getHost(),Peer.PORT_TCP,msg);
//            System.out.println("Client port : " + this.client.getPeer().getPort());
            //new UDPSenderService().sendMessageTo(ipDistant,target,msg);
            this.write(msg);
            
        } catch (Exception ex) {
            Logger.getLogger(ChatWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_sendButtonActionPerformed

    private void targetPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_targetPortActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_targetPortActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed

        // Close the chat window
        this.setVisible(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.dispose();
        Login loginWindow = new Login(node);
        loginWindow.setTitle("You have disconnected.");
        loginWindow.display();     
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void ipDistantFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipDistantFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipDistantFieldActionPerformed




    /*
    private void ipDistantFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    */
    private void messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageActionPerformed

    private void messageKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messageKeyPressed
        // TODO add your handling code here:
//        if(evt.getKeyCode() ==KeyEvent.VK_ENTER){
//            try {
//                String msg = "[" + node.getPeer().getPseudonyme() + "] : " + message.getText();
//                new TCPSenderService().sendMessageTo("localhost",target,msg);
//                //new TCPSenderService().sendMessageTo(ipDistant,target,msg);
//                //new UDPSenderService().sendMessageTo(ipDistant,target,msg);
//                this.write(msg);
//                message.setText("");
//            } catch (Exception ex) {
//                Logger.getLogger(ChatWindow.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_messageKeyPressed

    private void renameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_renameButtonActionPerformed
        // TODO add your handling code here: 
        ChangeName changeNameWindow = new ChangeName(this.node, this);
        changeNameWindow.display();
        //System.out.println(this.node.getPeer().getPseudonyme());
        // TODO update new nickname
    }//GEN-LAST:event_renameButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_backButtonActionPerformed
    
    

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
//            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(ChatWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ChatWindow().setVisible(true);
//            }
//        });
//    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JTextArea chatBox;
    private javax.swing.JLabel clientLabel;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JLabel hostLabel;
    private javax.swing.JTextField ipDistantField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField message;
    private javax.swing.JLabel nicknameLabel;
    private javax.swing.JLabel portLabel;
    private javax.swing.JButton renameButton;
    private javax.swing.JButton sendButton;
    private javax.swing.JButton targetButton;
    private javax.swing.JTextField targetPort;
    // End of variables declaration//GEN-END:variables

    public String timeStamp() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("[HH:mm, dd/MM/yyyy] - ");
        return sdf.format(cal.getTime());
    }
    
    @Override
    public void write(String s) {
        String msg = timeStamp() + Emoji.replaceInText(s);
        chatBox.append(msg + System.lineSeparator());
//        this.l.addMessage(msg);
    }
}
