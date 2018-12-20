package main.system.connection.handler;

import main.system.ui.WritableUI;
import main.system.model.Node;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import main.system.data.ChatHistory;
import main.system.data.MessageLog;
import main.system.model.Peer;
import main.system.ui.ChatWindow;

public class TCPListenerHandler implements Runnable {

	private final Node node;
	private ServerSocket serverSocket = null;
	private Socket chatSocket;
	//private BufferedReader in;
	private WritableUI ui=null;
        private volatile boolean running = true;
        static int num = 1;
        public static ChatHistory history;
        
        // this handler is used at a node of the network
	public TCPListenerHandler (Node node) throws IOException {	
            this.node = node;
            //this.serverSocket = new ServerSocket(node.getPeer().getPort());
            this.serverSocket = new ServerSocket(Peer.PORT_TCP);
            this.node.getPeer().setPort(this.serverSocket.getLocalPort());
	}
        
        // this handler is used at a node of the network
	public TCPListenerHandler (Node node, ChatHistory history) throws IOException {	
            this.node = node;
            this.history = history;
            //this.serverSocket = new ServerSocket(node.getPeer().getPort());
            this.serverSocket = new ServerSocket(Peer.PORT_TCP);
            this.node.getPeer().setPort(this.serverSocket.getLocalPort());
	}
        
	// this handler is used at a node of the network
	public TCPListenerHandler (Node node, WritableUI ui) throws IOException {	
            this.node = node;
            this.ui = ui;
            //this.serverSocket = new ServerSocket(node.getPeer().getPort());
            this.serverSocket = new ServerSocket(0);
            this.node.getPeer().setPort(this.serverSocket.getLocalPort());
	}
        
        
        public void terminate() throws IOException {
            running = false;
            this.serverSocket.close();
            //this.chatSocket.close();
        }
            
	@Override
	public void run() {
                try {
                    while(running) {
                        System.out.println("[TCP] " + node.getPeer().getPseudonyme() + " is listening by TCP at port " + node.getPeer().getPort() + "...");

                        //System.out.println(node.getPeer().getPseudonyme() + " is listening by TCP at port " + this.serverSocket.getLocalPort() + "...");
                        this.chatSocket = this.serverSocket.accept();
                        
                        System.out.println("Client number "+num + " at " + chatSocket.getInetAddress().getHostAddress() + ":" + chatSocket.getPort() + " has connected."); 
                        num ++;
                        
                        // Create a chat window between this node and client
                        Node client = new Node (new Peer(chatSocket.getInetAddress().getHostAddress()));
//                        ChatWindow chatWindow = new ChatWindow(this.node, client);
//                        MessageLog l = new MessageLog(this.node.getPeer(), client.getPeer());
//                        if (history.existHistory(l)) {
//                            l = history.getMessageLog(node.getPeer().getHost(), client.getPeer().getHost());
//                        }
//                        else {
//                            history.addHistory(l);
//                            //chatBox.setText("New chat" + System.lineSeparator());
////                            historyBox.setText("");
////                            historyBox.append(history.toString());
//                        }
                        

                        // Write the message on this chat window
                        BufferedReader in = new BufferedReader(new InputStreamReader(chatSocket.getInputStream()));
                        
                        // Print the message received from a node distant
                        String msgDistant = in.readLine();

                        if(msgDistant != null) {
//                            chatWindow.write(msgDistant);
//                            l.addMessage(msgDistant);
                            this.node.getChatWindowForPeer(client.getPeer().getHost()).write(msgDistant);
                            System.out.println(msgDistant);
                        }
                        
//                        ChatWindow chatWindow = new ChatWindow(node);
//                        TCPListenerHandler runnableTCP = new TCPListenerHandler(this.node,chatWindow); 
//                        Thread listenTCP = new Thread(runnableTCP);  
//                        listenTCP.start();
//                        
//                        BufferedReader in = new BufferedReader(new InputStreamReader(chatSocket.getInputStream()));
//                        
//                        System.out.println("CALL IN TCP Listner handler run");
//                        // Print the message received from a node distant
//                        String msgDistant = in.readLine();
//
//                        if(msgDistant != null) {
//                            ui.write(msgDistant);
//                            System.out.println(msgDistant);
//                        }
                         

                        

                    
                        // Close the socket
                        //chatSocket.close();
                    }
                } catch(IOException e) {
                    e.printStackTrace();
                }

		
	}


}
