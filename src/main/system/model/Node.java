package main.system.model;

import java.io.IOException;
import java.util.ArrayList;

public class Node {

	private Peer peer;
	private ArrayList<Peer> onlinePeers;
	
	//constructors
	
	public Node(Peer peer) {
		this.peer = peer;
		this.onlinePeers = new ArrayList();
	}
	
	//methods
	
	public ArrayList<Peer> getOnlinePeers() {
        return this.onlinePeers;
    }
  
    public Peer getPeer(){
        return this.peer;
    }
    
    public void update (Peer newPeer) {
    	this.peer = newPeer;
    }

    public String userName(){
        return this.peer.getPseudonyme();
    }
	
    public void addPeer (Peer peer) {
    	this.onlinePeers.add(peer);
    }
    
    /* Update list of Peers when a peer in the list has changed his nickname */
    public void updatePeersList(Peer peer1) {
    	// TODO
    }
    
    public Peer findPeerByIPAddress (String ipAddress) {
    	// TODO
    	return null;
    }
     

	public String toString(){
        String str = new String ("This peer is " + this.peer.toString()+  " and his friends list :\n" );
        for (Peer p : onlinePeers) {
            str += "- " + p.toString()+"\n";
        } 
        return str;
    }
    
    
	
}
