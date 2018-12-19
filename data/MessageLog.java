/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.system.data;

import java.util.ArrayList;
import main.system.model.*;

/**
 *
 * @author lmtran
 */
public class MessageLog {
    
    private Peer peer1;
    private Peer peer2;
    private int port1;
    private int port2;
    private ArrayList<String> log;
    private int current_index = 0;
    
    public MessageLog(Peer p1, Peer p2) {
        // TODO
        this.peer1 = p1;
        this.peer2 = p2;
        this.port1 = p1.getPort();
        this.port2 = p2.getPort();
        this.log = new ArrayList<>(1000);
    }
    
    public MessageLog(int port1, int port2) {
        this.port1 = port1;
        this.port2 = port2;
        this.log = new ArrayList<>(100);
    }
    
    public void addMessage(String message) {
        this.log.add(message);
        current_index++;
    }
    
    public ArrayList<String> getLog() {
        return this.log;
    }
    
    public int getPort1() {
        return this.port1;
    }
    
    public int getPort2() {
        return this.port2;
    } 
    
    
    @Override 
    public String toString() {
        String res = "";
        for (int i = 0; i < current_index; i++) {
            res = res + this.log.get(i) + System.lineSeparator();
        }
        return res;
    }
//    @Override
//    public String toString() {
//        return "[" + this.port1 + " | " + this.port2 + "]";
//    }
    
}
