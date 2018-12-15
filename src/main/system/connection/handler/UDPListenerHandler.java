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
import java.util.Arrays;
import main.system.model.Node;
import main.system.model.Peer;
import main.system.ui.WritableUI;

/**
 *
 * @author Kuro10
 */
public class UDPListenerHandler implements Runnable {

    private Node node;
    private DatagramSocket dgramSocket;
    private DatagramPacket inPacket;
    private WritableUI ui=null;
    private volatile boolean running = true;
    
    public UDPListenerHandler(Node node) throws SocketException{
        this.node = node;
        this.dgramSocket = new DatagramSocket(Peer.PORT_UDP);  // or node.getPeer().getPort() ???
        byte[] buffer = new byte[256];
        this.inPacket = new DatagramPacket(buffer,buffer.length);
    }
    

    public UDPListenerHandler(Node node, WritableUI ui) throws SocketException{
        this.node = node;
        this.ui = ui;
        this.dgramSocket = new DatagramSocket(node.getPeer().getPort());  // or node.getPeer().getPort() ???
        byte[] buffer = new byte[256];
        this.inPacket = new DatagramPacket(buffer,buffer.length);
    }

    public void terminate() throws IOException {
        running = false;
    }
        
    @Override
    public void run() {
        try {
            while(running){
                System.out.print(node.getPeer().getPseudonyme() + " is listening by UDP at port " + Peer.PORT_UDP + "...");
                this.dgramSocket.receive(this.inPacket);
                System.out.println("CALL IN UDP Listener handler run" );
                String host = inPacket.getAddress().getHostAddress();
                int port = inPacket.getPort();
                System.out.println("Client is at " + host + ":" + port);
                ui.write(new String(inPacket.getData(),0,inPacket.getLength()));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
}
