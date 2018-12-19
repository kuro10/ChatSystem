/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.system;

import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import main.system.ui.ChatWindow;
/**
 *
 * @author lmtran
 */
public class TestUtilities {
    
 public static void main(String[] args) throws MalformedURLException {
        ChatWindow f = new ChatWindow();
        URL url = new URL("http://www.emoticonr.com/design/yahoo/applause.gif");
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);
        f.getContentPane().add(label);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }   
}
