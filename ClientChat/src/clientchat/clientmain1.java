/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientchat;
/**
 *
 * @author Leonardo
 */
public class clientmain1 {
    public static void main(String[] args) {
        ClientChat1 client1 = new ClientChat1(); 
        client1.connetti();
        while(true){
        client1.comunica();
        }
    }
}