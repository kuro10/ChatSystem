/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.system;

import java.net.InetAddress;
import main.system.model.Node;
import main.system.model.Peer;
import main.system.ui.Login;

/**
 *
 */
public class Chat {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {

        String ip = InetAddress.getLocalHost().getHostAddress();
        //String ip = this.getAddressIP();
        Node node = new Node(new Peer(ip));
        
        Login loginWindow = new Login(node);
        loginWindow.setLocationRelativeTo(null); 
        loginWindow.setVisible(true);
        
        //ChatWindow chatWindow = new ChatWindow();
        //chatWindow.setVisible(true);
    }
    
    public static String getAddressIP() {
        
        
        
        return null;
    }
}
