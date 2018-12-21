package main.system.model;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import main.system.data.ChatHistory;
import main.system.ui.ChatWindow;
import main.system.ui.Home;

public class Node {

    private Peer peer;
    private final ArrayList<Peer> onlinePeers;
    private final HashMap<String, ChatWindow> chatWindowForPeer;//String -> ipAddress
    private String msg = "";
    
    private Home home;
    private ChatHistory history = new ChatHistory();

    /**
    * Creates construvtors
    */

    public Node(Peer peer) {
            this.peer = peer;
            this.onlinePeers = new ArrayList();
            this.chatWindowForPeer = new HashMap<>();
            this.home = new Home(this, history);
    }

    /**
     * Creates new methods
     */

    public ArrayList<Peer> getOnlinePeers() {
        return this.onlinePeers;
    }
  
    public Peer getPeer(){
        return this.peer;
    }
    
    public void update (Peer newPeer) {
    	this.peer = newPeer;
    }
    
    public String getMsg() {
        return this.msg;
    }
    
    public void setMsg(String s) {
        this.msg = s;
    }

    public String userName(){
        return this.peer.getPseudonyme();
    }
	
    public void addPeer (Peer peer) {
    	this.onlinePeers.add(peer);
    }
    
    public void removePeer (Peer peer) {
        if (this.onlinePeers != null) {
            for (Peer p : this.onlinePeers) {
                if (p.getHost().equals(peer.getHost()) && p.getPort() == peer.getPort() && p.getPseudonyme().equals(peer.getPseudonyme())) {
                    this.onlinePeers.remove(p);
                }
            }
        }
        //this.onlinePeers.remove(peer);
    }
    
    

    
    /* Update list of Peers when a peer in the list has changed his nickname */
    public void updatePeersList(Peer peer1) {
    	// TODO
        if (peer1.getHost().equals(this.peer.getHost())) {
            return;
        }

        for (Peer peerInList : onlinePeers){
            if (peerInList.getHost().equals(peer1.getHost())){
                System.out.println("[peer] Le peer est deja dans la liste");
                if (peerInList.getPseudonyme().equals(peer1.getPseudonyme())) {
                }
                else{
                    System.out.println(" Name change "+ peerInList.getPseudonyme()+" > "+peer1.getPseudonyme());
                    peerInList.setPseudonyme(peer1.getPseudonyme());
                    this.msg = " Name change "+ peerInList.getPseudonyme()+" > "+peer1.getPseudonyme();
                }
//                if (peerInList.getPort()==peer1.getPort()) {
//                }
//                else{
//                    System.out.println(" Port change "+ peerInList.getPort()+" > "+peer1.getPort());
//                    peerInList.setPort(peer1.getPort());
//                }
                if (peer1.getStatusDisconnect() == false) {
                    System.out.println(" Status : connected ");
                    peerInList.setDisco(false);
                }
                else {
                    System.out.println(" Status : disconnected ");
                    peerInList.setDisco(true);
                }
                return;
            }
        }
        System.out.println("[peer] New Peer: Host>"+peer1.getHost()+" Pseudo>"+peer1.getPseudonyme());
        this.addPeer(peer1);
    }
    
    public void setChatWindowForPeer(Peer peer1,ChatWindow chatWindow) {
        this.chatWindowForPeer.put(peer1.getHost(),chatWindow);
    }

    public ChatWindow getChatWindowForPeer(String ipAddress){
        return this.chatWindowForPeer.get(ipAddress);
    }
    
    public boolean existChatWindow(Peer p) {
        //boolean res = false;
        return this.chatWindowForPeer.containsKey(p.getHost());
    }
    
    public void closeAllChatWindow() {
        for (ChatWindow c : chatWindowForPeer.values()) {
            c.closeWindow();
        }
    }
    
    public Home getHome() {
        return this.home;
    }
    
    public String findNicknameByHost (String host) {
    	// TODO
        String res = "";
        for(Peer p : this.getOnlinePeers()) {
            if (p.getHost().equals(host)) {
                res = p.getPseudonyme();
            }
        }
        return res;
    }
     
    public InetAddress getBroadcast() throws UnknownHostException {

        InetAddress myIpAddress = InetAddress.getByName(this.peer.getHost());
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
    
    public ChatHistory getHistory() {
        return this.history;
    }


    
    @Override
    public String toString(){
    String str = "This peer is " + this.peer.toString()+  " and his friends list :\n";
    for (Peer p : onlinePeers) {
        str += "- " + p.toString()+"\n";
    } 
    return str;
    }
    
    
	
}
