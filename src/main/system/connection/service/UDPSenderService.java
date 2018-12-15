/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.system.connection.service;

import java.net.UnknownHostException;
import main.system.connection.handler.UDPSenderHandler;
import main.system.model.Node;
import main.system.model.Peer;

/**
 *
 * @author Kuro10
 */
public class UDPSenderService implements SenderService {

    @Override
    public void sendMessageTo(Peer peer, String message) throws Exception {
        Thread t = new Thread (new UDPSenderHandler(peer,message));
        t.start();
    }

    @Override
    public void sendMessageTo(String host, int port, String message) throws Exception {
        Thread t = new Thread (new UDPSenderHandler(host,port,message));
        t.start();
    }
    
    public void sendBroadcast(Node node) throws UnknownHostException{
        Thread t = new Thread (new UDPSenderHandler(node));
        t.start();
    }
}
