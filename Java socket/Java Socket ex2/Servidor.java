package testes;

import java.net.*;
import java.io.*;
import java.util.Date;

public class Servidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(12345);
            System.out.println("Servidor ativo, aguardando conexões...");
            
            while(true){
                Socket cliente = servidor.accept();
                System.out.println("IP do cliente: " + cliente.getInetAddress().getHostAddress());
                
                ObjectInputStream dadosDoCliente = new ObjectInputStream(cliente.getInputStream());
                String nome = (String) dadosDoCliente.readObject();
                System.out.println("Nome do usuário conectado: " + nome);
                
                
                
                ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
                saida.flush();
                saida.writeObject(new Date());
                
                saida.close();
                cliente.close();
            
            }
            
        } catch (Exception e) {
            System.out.println("Eroo no servidor " + e.getMessage());
            e.printStackTrace();
        }
            
    }
    
}
