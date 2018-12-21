package main.system.connection.handler;

import main.system.model.Peer;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPSenderHandler implements Runnable  {

    /**
     * Attributs
     */
    private Socket chatSocket;
    private PrintWriter out;
    private final String message;
    private final String host;
    private final int port;

    /**
     * 
     * @param host
     * @param port
     * @param message
     * @throws IOException 
     */
    
    public TCPSenderHandler(String host, int port, String message) throws IOException {
            this.host = host;
            this.port = port;
            this.message = message;
    }


    /**
     * Methods
     */
    
    @Override
    public void run() {
            try {			
                    /* Request a connection to the given peer  */
                    System.out.println("connecting to port "+ port +" and host "+host);
                    chatSocket = new Socket(host,Peer.PORT_TCP);
                    /* Initialization the output channel */
                    this.out = new PrintWriter( chatSocket.getOutputStream() );

                    /* Send the message...*/
                    out.println(message);
                    out.flush();
//                    System.out.println("Envoie a " + host +"(" + port + "): " + message );
                    
                    /* Close the socket */
                    chatSocket.close();
            } catch (IOException e) {
                    e.printStackTrace();
            }
    }

}
