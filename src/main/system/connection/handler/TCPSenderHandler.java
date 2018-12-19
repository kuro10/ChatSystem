package main.system.connection.handler;

import main.system.model.Peer;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TCPSenderHandler implements Runnable  {

	private Socket chatSocket;
	private PrintWriter out;
	private String message;
	private String host;
	private int port;
	private int localPort = 0;
        
	public TCPSenderHandler(Peer peer, String message) throws IOException {
		// Request a connection to the given peer
		//this.chatSocket = new Socket(peer.getHost(),peer.getPort());  
		// Initialization the output channel
		//this.out = new PrintWriter( chatSocket.getOutputStream() );
		// Treatment the message
		this.message = message;
	}	
	
        public TCPSenderHandler(String host, int port, String message) throws IOException {
		this.host = host;
		this.port = port;
		// Treatment the message
		this.message = message;
	}
        
     
	@Override
	public void run() {
		try {			

			// Request a connection to the given peer            
			chatSocket = new Socket(host,port); 
			// Initialization the output channel
			this.out = new PrintWriter( chatSocket.getOutputStream() );
			
			//chatSocket.getOutputStream().write(message.getBytes());
			
			// Send the message...
			out.println(message);
			// Empty the buffer
			out.flush();
			//System.out.println("Envoie a " + host +"(" + port + "): " + message );
			// Close the socket
			chatSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
