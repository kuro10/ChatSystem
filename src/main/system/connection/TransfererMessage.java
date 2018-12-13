/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.system.connection;

import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tranl
 */
public class TransfererMessage extends Thread {
    
    String message, hostname;
    int port;
    
    
    public TransfererMessage () {
        
    }
    
    public TransfererMessage (String message, String hostname, int port) {
        this.message = message;
        this.hostname = hostname;
        this.port = port;
    }
    
    @Override
    public void run() {
        try {
            try (Socket s = new Socket(hostname, port)) {
                s.getOutputStream().write(message.getBytes());
            }
        } catch (IOException ex) {
            Logger.getLogger(TransfererMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
