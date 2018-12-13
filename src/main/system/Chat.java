/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.system;

import main.system.ui.Login;

/**
 *
 */
public class Chat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Login loginWindow = new Login();
        loginWindow.setLocationRelativeTo(null); 
        loginWindow.setVisible(true);
        
        //ChatWindow chatWindow = new ChatWindow();
        //chatWindow.setVisible(true);
    }
    
}
