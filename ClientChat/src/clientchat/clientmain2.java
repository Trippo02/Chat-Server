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
public class clientmain2 {
    public static void main(String[] args) { 
        ClientChat2 client2 = new ClientChat2(); 
        client2.connetti();
        while(true){
        client2.comunica();
        }
    }
}