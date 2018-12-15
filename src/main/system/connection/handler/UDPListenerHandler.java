/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.system.connection.handler;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import main.system.model.Node;
import main.system.model.Peer;

/**
 *
 * @author Kuro10
 */
public class UDPListenerHandler implements Runnable {

    private Node node;
    private DatagramSocket dgramSocket;
    private DatagramPacket inPacket;
    
    public UDPListenerHandler(Node node) throws SocketException{
        this.node = node;
        this.dgramSocket = new DatagramSocket(Peer.PORT_UDP);  // or node.getPeer().getPort() ???
        byte[] buffer = new byte[256];
        this.inPacket = new DatagramPacket(buffer,buffer.length);
    }
    
    
    @Override
    public void run() {
        try {
            while(true){
                System.out.print(node.getPeer().getPseudonyme() + " is listening by UDP at port " + Peer.PORT_UDP + "...");
                this.dgramSocket.receive(this.inPacket);
                System.out.println("CALL IN UDP Listener handler run" );
                String host = inPacket.getAddress().getHostAddress();
                int port = inPacket.getPort();
                System.out.println("Client is at " + host + ":" + port);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
