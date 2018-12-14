/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.system.data;

import java.util.ArrayList;

/**
 *
 * @author lmtran
 */
public class ChatHistory {
    
    private final ArrayList<MessageLog> history;
    
    public ChatHistory() {
        this.history = new ArrayList<>(100);
    }
    
    public void addHistory(MessageLog l) {
        this.history.add(l);
    }
    
//    public boolean existHistory(int port1, int port2) {
//        int i = 0;
//        boolean found = false;
//        while (i < this.history.size() && found == false) {
//            found = (this.history.get(i).getPort1() == port1 && this.history.get(i).getPort2() == port2);
//        }
//        return found;
//    }
    
    public MessageLog getMessageLog(int port1, int port2) {
        MessageLog res = null;
        int i = 0;
        boolean found = false;
        while (i < this.history.size() && found == false) {
            if(this.history.get(i).getPort1() == port1 && this.history.get(i).getPort2() == port2) {
                res = this.history.get(i);
                found = true;
            }
        }
        return res;
    }
}
