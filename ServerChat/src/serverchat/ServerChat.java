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
public class ServerChat extends Thread{
    private ServerChat serverchat = null;
    private Socket socket_client = null;
    private String messaggio_client1 = null;
    private String messaggio_client2 = null;
    BufferedReader dati_dal_client;
    DataOutputStream dati_al_client;
    
    public ServerChat(Socket socket){
        this.socket_client = socket;
    }
    
    public void run(){
        boolean c=true;
        try{
            while(c){
            comunica();}
        }catch (Exception e){
            e.printStackTrace(System.out);}
    }
    
    public void comunica()throws Exception{
        System.out.println("In attesa del messaggio da parte del client.");
            dati_dal_client=new BufferedReader(new InputStreamReader(socket_client.getInputStream()));
            dati_al_client=new DataOutputStream(socket_client.getOutputStream());
            System.out.println("Messaggio ricevuto.");
            messaggio_client1 = dati_dal_client.readLine();
            System.out.println("Invio della risposta al client.");
            dati_al_client.writeBytes( Thread.currentThread().getName() + ": " + messaggio_client1+'\n');
            //dati_dal_client.close();
            //dati_al_client.close();
            System.out.println("Elaborazione completata.");
            //socket_client.close();
        }
}