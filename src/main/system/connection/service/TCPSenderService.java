package main.system.connection.service;

import java.awt.image.BufferedImage;
import java.io.File;
import main.system.connection.handler.TCPSenderHandler;
import main.system.model.Peer;

public class TCPSenderService implements SenderService {

//	@Override
//	public void sendMessageTo (Peer peer, String message) throws Exception {
//		Thread t = new Thread( new TCPSenderHandler(peer,message));
//		t.start();
//	}
        
        @Override
	public void sendMessageTo (String host, int port, String message) throws Exception {
		Thread t = new Thread( new TCPSenderHandler(host,port,message, 1));
		t.start();
	}
        
        public void sendImageTo (String host, int port, File selectedFile) throws Exception {
            Thread t = new Thread ( new TCPSenderHandler(host, port, selectedFile, 2));
            t.start();
        }

}
