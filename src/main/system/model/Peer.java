package main.system.model;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;

public class Peer {
	
    public final static int PORT_TCP = 9999;
    public final static int PORT_UDP = 4444;

    private String pseudonyme;
    private String host;
    private int port;
    private boolean disco = false;

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
    
    public void setDisco(boolean status) {
        this.disco = status;
    }
    
    public boolean getStatusDisconnect() {
        return this.disco;
    }
    
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

    public void setPort(int localPort) {
       this.port = localPort;
    }
    
}
