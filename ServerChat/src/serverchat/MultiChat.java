/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;
import java.io.*;
import java.net.*;
/**
 *
 * @author Leonardo
 */
public class MultiChat extends Thread{
    public Socket Avvia(){
        while(true){
        try {
            System.out.println("Server in esecuzione.");
            ServerSocket server = new ServerSocket(8888);
            System.out.println("Server in attesa del client.");
            Socket socket1 = server.accept();
            Socket socket2 = server.accept();
            System.out.println(socket1 + " connesso.");
            ServerChat serverthread1 = new ServerChat(socket1);
            serverthread1.setName("Mario");
            System.out.println(socket2 + " connesso.");
            ServerChat serverthread2 = new ServerChat(socket2);
            serverthread2.setName("Luigi");
            serverthread1.start();
            serverthread2.start();  
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore nell'istanziamento del server.");
            System.exit(1);
        }return null;
        }
    }
}