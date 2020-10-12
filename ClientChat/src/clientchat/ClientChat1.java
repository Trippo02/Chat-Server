/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientchat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author informatica
 */
public class ClientChat1 {
String nome_server="Mario";
    int porta_server=8888;
    Socket socket;
    BufferedReader input_tastiera;
    String messaggio;
    String risposta;
    DataOutputStream dati_al_server;
    BufferedReader dati_dal_server;
    
    
    public Socket connetti(){
        System.out.println("Client in esecuzione.");
        try {
            input_tastiera=new BufferedReader(new InputStreamReader(System.in));
            socket=new Socket(nome_server,porta_server);
            
        }
        catch(UnknownHostException e){
            System.err.println("Host non riconosciuto.");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la connessione.");
            System.exit(1);
        }
        return(socket);
    }
    public void comunica(){
        try {
            while(true){
            dati_al_server=new DataOutputStream(socket.getOutputStream());
            dati_dal_server=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Manda un messaggio a : "+nome_server);
            messaggio=input_tastiera.readLine();
            System.out.println("Invio del messaggio al server.");
            dati_al_server.writeBytes(messaggio+'\n');
            risposta=dati_dal_server.readLine();
            System.out.println("Risposta del server: "+risposta);
            messaggio=input_tastiera.readLine();
            }
            
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante la comunicazione col server.");
            System.exit(1);
        }
    }
}
