package main.system.connection.service;

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
		Thread t = new Thread( new TCPSenderHandler(host,port,message));
		t.start();
	}

}
