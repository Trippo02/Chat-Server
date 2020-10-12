/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientchat;

/**
 *
 * @author informatica
 */
public class clientmain {
    public static void main(String[] args) {
        // TODO code application logic here
        ClientChat1 client1=new ClientChat1();
        client1.connetti();    
        ClientChat1 client2=new ClientChat1();
        
        client1.comunica();
        
    }
}
