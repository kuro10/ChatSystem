package main.system.model;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

public class Peer {
	
    public final static int PORT_TCP = 2222;
    public final static int PORT_UDP = 4444;

    private String pseudonyme;
    private String host;
    private int port;

    //Constructors

    public Peer(String host) throws UnknownHostException{
            this.host = host;
            this.port = PORT_TCP;
    }

    public Peer(String pseudo,String host) throws UnknownHostException{
            this.pseudonyme = pseudo;
            this.host = host;
            this.port = PORT_TCP;
    }

    public Peer(String pseudonyme, String host, int port) throws UnknownHostException {
        this.pseudonyme = pseudonyme;
        this.host = host;
        this.port = port;
    }

    public Peer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Methods
    
    public void setPseudonyme(String pseudo) {this.pseudonyme = pseudo;}
    
    public String getPseudonyme() {
        return pseudonyme;
    }

    public String getHost(){
        return this.host;
    }

    public int getPort(){
        return this.port;
    }

    @Override
    public String toString(){
        return this.pseudonyme + " ("+ this.host+ " : "+ this.port+ ")";
    }
    
    public InetAddress getBroadcast() throws UnknownHostException {

        InetAddress myIpAddress = InetAddress.getByName(this.host);
        NetworkInterface temp;
        InetAddress iAddr = null;
        try {
            temp = NetworkInterface.getByInetAddress(myIpAddress);
            List<InterfaceAddress> addresses = temp.getInterfaceAddresses();

            for (InterfaceAddress inetAddress : addresses) {
                iAddr = inetAddress.getBroadcast();
            }
            System.out.println("Call in Peer.getBroadcast : " + iAddr);
            return iAddr;

        } catch (SocketException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
