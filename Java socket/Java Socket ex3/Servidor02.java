package testes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class Servidor02 {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Porta 12345 aberta e aguardando conexões...");

        Socket cliente = servidor.accept();
        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());

        Scanner entrada = new Scanner(cliente.getInputStream());
        while (entrada.hasNextLine()) {
            System.out.println(entrada.nextLine());
        }

        entrada.close();
        servidor.close();
       }  
    }
