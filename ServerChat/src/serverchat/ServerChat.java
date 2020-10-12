/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverchat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author informatica
 */
public class ServerChat extends Thread{

    ServerSocket socket_server=null;
    Socket socket_client=null;
    String messaggio_client=null;
    String risposta_server=null;
    BufferedReader dati_dal_client;
    DataOutputStream dati_al_client;
    
    public ServerChat(Socket socket){
        this.socket_client=socket;
    }
    
    public void run(){
        try{
            comunica();
        }catch (Exception e){
            e.printStackTrace(System.out);}
    }
    
    public void comunica(){
        try {
            dati_dal_client=new BufferedReader(new InputStreamReader(socket_client.getInputStream()));
            dati_al_client=new DataOutputStream(socket_client.getOutputStream());
            System.out.println("In attesa del messaggio da parte del client.");
            messaggio_client=dati_dal_client.readLine();
            System.out.println("Messaggio ricevuto.");
            System.out.println("Invio della risposta al client.");
            dati_al_client.writeBytes(messaggio_client+'\n');
            messaggio_client=dati_dal_client.readLine();
            System.out.println("Messaggio ricevuto.");
            System.out.println("Elaborazione completata.");
            socket_client.close();
        }
        catch (Exception e) {
            System.out.println("Errore durante la comunicazione.");
        }
    }
    
}
