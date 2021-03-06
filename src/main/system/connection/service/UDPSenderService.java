/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.system.connection.service;

import java.net.UnknownHostException;
import main.system.connection.handler.UDPSenderHandler;
import main.system.model.Node;

/**
 *
 * @author Kuro10
 */
public class UDPSenderService implements SenderService {

    public void sendBroadcast(Node node) throws UnknownHostException {
        Thread t = new Thread(new UDPSenderHandler(node, "broadcast"));
        t.start();
    }

    public void sendDisconnect(Node node) throws UnknownHostException {
        Thread t = new Thread(new UDPSenderHandler(node, "disconnect"));
        t.start();
    }

    public void sendRename(Node node) throws UnknownHostException {
        Thread t = new Thread(new UDPSenderHandler(node, "rename"));
        t.start();
    }

    @Override
    public void sendMessageTo(String host, int port, String message) throws Exception {
        Thread t = new Thread(new UDPSenderHandler(host, port, message));
        t.start();
    }
}
