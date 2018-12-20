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
import java.util.logging.Level;
import java.util.logging.Logger;
import main.system.connection.service.UDPSenderService;
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
        this.dgramSocket = new DatagramSocket(Peer.PORT_UDP);  // or node.getPeer().getPort() ???
        byte[] buffer = new byte[256];
        this.inPacket = new DatagramPacket(buffer,buffer.length);
    }

    public void terminate() throws IOException {
        running = false;
        dgramSocket.close();
    }
        
    @Override
    public void run() {
        try {     
            while(running){
                System.out.println(node.getPeer().getPseudonyme() + " is listening by UDP at port " + Peer.PORT_UDP + "...");
                this.dgramSocket.receive(this.inPacket);
                System.out.println("CALL IN UDP Listener handler" );
                String msg = new String(inPacket.getData(),0,inPacket.getLength());
                String seg[] = msg.split(":");
                String pseudo = seg[0];
                int port = Integer.parseInt(seg[1]);
                msg = seg[2];
                String host = inPacket.getAddress().getHostAddress();
                //ui.write(msg);
                
                if (msg.equals("broadcast") && !host.equals(node.getPeer().getHost())){
                    System.out.println(host + " sends a " + msg);
                    new UDPSenderService().sendMessageTo(host,Peer.PORT_UDP,this.node.getPeer().getPseudonyme()+ ":" + this.node.getPeer().getPort() + ":OK");
//                    this.node.updatePeersList(new Peer(pseudo,host,port));
                    this.node.updatePeersList(new Peer(pseudo,host));

                }
                
                if (msg.equals("OK")){
                    System.out.println(host + " responds " + msg);
//                    this.node.updatePeersList(new Peer(pseudo,host,port));
                    this.node.updatePeersList(new Peer(pseudo,host));
                }
               
                
            }
            
        } catch (IOException e){
            System.out.println("ERROR: Connection failure with: "+inPacket.getAddress().getHostAddress());
            e.printStackTrace();
        } catch (Exception ex) {
            System.out.println("ERROR: Connection failure with: "+inPacket.getAddress().getHostAddress());
            Logger.getLogger(UDPListenerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
