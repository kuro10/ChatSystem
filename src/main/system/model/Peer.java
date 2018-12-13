package main.system.model;

import java.net.UnknownHostException;

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

    public String toString(){
        return this.pseudonyme + " ("+ this.host+ " : "+ this.port+ ")";
    }
    
}
