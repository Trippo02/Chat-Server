/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author informatica
 */
public class MultiChat {
    public Socket Avvia(){
        try {
            while(true){
            System.out.println("Server in esecuzione.");
            ServerSocket server =new ServerSocket(8888);
            System.out.println("Server in attesa del client.");
            Socket socket = server.accept();
            System.out.println(socket+" connesso.");
            ServerChat serverthread= new ServerChat(socket);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore nell'istanziamento del server.");
            System.exit(1);
        }
        return null;
    }
}
