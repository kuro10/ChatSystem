package main.system.connection.handler;

import java.awt.image.BufferedImage;
import java.io.File;
import main.system.model.Peer;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javax.imageio.ImageIO;

public class TCPSenderHandler implements Runnable {

    /**
     * Attributs
     */
    private Socket chatSocket;
    private PrintWriter out;
    private final String message;
    private final String host;
    private final int port;
    private final int type;
    private final File file;

    /**
     *
     * @param host
     * @param port
     * @param message
     * @param type
     * @throws IOException
     */
    public TCPSenderHandler(String host, int port, String message, int type) throws IOException {
        this.host = host;
        this.port = port;
        this.message = message;
        this.type = type;
        this.file = null;
    }

    public TCPSenderHandler(String host, int port, File selectedFile, int type) throws IOException {
        this.host = host;
        this.port = port;
        this.file = selectedFile;
        this.message = selectedFile.getName();
        this.type = type;
    }

    /**
     * Methods
     */
    @Override
    public void run() {
        try {
            switch (type) {
                case 1: //Text Message
                    /* Request a connection to the given peer  */
                    System.out.println("connecting to port " + port + " and host " + host);
                    chatSocket = new Socket(host, Peer.PORT_TCP);
                    /* Initialization the output channel */
                    this.out = new PrintWriter(chatSocket.getOutputStream());

                    /* Send the message...*/
                    out.println(message);
                    out.flush();
//                    System.out.println("Envoie a " + host +"(" + port + "): " + message );

                    /* Close the socket */
                    chatSocket.close();
                    break;
                case 2: //Image Message
                    String path = this.file.getAbsoluteFile().toString();
                    String[] split = path.split("[.]");
                    String ext = split[1];
                    System.out.println("Sending: " + path + " extension: " + ext);
                    System.out.println("Sending Image!");
                    
                    chatSocket = new Socket(host, Peer.PORT_TCP);
                    ImageIO.write(ImageIO.read(this.file),ext,chatSocket.getOutputStream());
                    chatSocket.close();
                    
                    break;
                default:
                    System.out.println("Invalid type of message");
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
