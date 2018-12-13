/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.system.connection;

import main.system.ui.WritableUI;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tranl
 */
public class ListenerMessage extends Thread {
    
    ServerSocket server;
    int port = 5678;
    private WritableUI ui;
    
    public ListenerMessage(WritableUI ui, int port) {
        this.port = port;
        this.ui = ui;
        try {
            server = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(ListenerMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ListenerMessage() {
        try {
            server = new ServerSocket(port);
        } catch (IOException ex) {
            Logger.getLogger(ListenerMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        Socket clientSocket;
       try {
            while((clientSocket = server.accept()) != null) { //Tant que port n'est pas ferme, on garde la connexion
                InputStream is = clientSocket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String line = br.readLine();
                if(line != null) {
                    ui.write(line);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ListenerMessage.class.getName()).log(Level.SEVERE, null, ex);
        }

            
        
    }
}
