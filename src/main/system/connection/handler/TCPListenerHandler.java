package main.system.connection.handler;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import main.system.model.Node;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import main.system.data.ChatHistory;
import main.system.model.Peer;

public class TCPListenerHandler implements Runnable {

    /*
     * Attributs
     */
    private final Node node;
    private ServerSocket serverSocket = null;
    private Socket chatSocket;
    private volatile boolean running = true;
    public static ChatHistory history;

    /**
     * Constructors
     *
     * @param node
     * @param history
     * @throws java.io.IOException
     */
    /* this handler is used at a node of the network */
    public TCPListenerHandler(Node node, ChatHistory history) throws IOException {
        this.node = node;
        TCPListenerHandler.history = history;
//        this.serverSocket = new ServerSocket(node.getPeer().getPort());
        this.serverSocket = new ServerSocket(Peer.PORT_TCP);
        this.node.getPeer().setPort(this.serverSocket.getLocalPort());
    }

    /*
     * Methods
     */
    public void terminate() throws IOException {
        running = false;
        this.serverSocket.close();
        //this.chatSocket.close();
    }
    
    public static BufferedImage decodeToImage(String imageString) {
 
        BufferedImage image = null;
        byte[] imageByte;
        try {
            /*BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);*/

            imageByte = Base64.getDecoder().decode(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
      }

    @Override
    public void run() {
        try {
            while (running) {
                System.out.println("[TCP] " + node.getPeer().getPseudonyme() + " is listening by TCP at port " + node.getPeer().getPort() + "...");
                this.chatSocket = this.serverSocket.accept();

                /* Receive the message */
                InputStream input = chatSocket.getInputStream();

                BufferedReader in = new BufferedReader(new InputStreamReader(input));
                String msgDistant = in.readLine();
                if (msgDistant.charAt(0) == "[".charAt(0)) {
                    /* Write the message on the chat window between this node and client */
                    Node client = new Node(new Peer(chatSocket.getInetAddress().getHostAddress()));
                    if (msgDistant != null) {
                        this.node.getChatWindowForPeer(client.getPeer().getHost()).write(msgDistant);
                        System.out.println(msgDistant);
                    }
                } else {
                    
                    BufferedImage img = decodeToImage(msgDistant);
                    
                    //BufferedImage img = ImageIO.read(ImageIO.createImageInputStream(input));

                    JFrame frame = new JFrame();
                    frame.getContentPane().add(new JScrollPane(new JLabel(new ImageIcon(img))));
                    frame.pack();
                    frame.setSize(new Dimension(800, 800));
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true); 
                }
                /* Close the socket */
                //chatSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
