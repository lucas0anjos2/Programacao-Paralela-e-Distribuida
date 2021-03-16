package testes;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Servidor02 {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Porta 12345 aberta e aguardando conexões...");

        Socket cliente = servidor.accept();
        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());

        Scanner entrada = new Scanner(cliente.getInputStream());
        
        File arquivo = new File("msg.txt");
        FileWriter arqEscr = new FileWriter(arquivo);
        PrintWriter escrever = new PrintWriter(arqEscr);
        
        while (entrada.hasNextLine()) {
            String linha = entrada.nextLine();
            System.out.println("Recebido: " + linha);
            
            escrever.println(linha);
                        
        }                
        
        escrever.close();
        System.out.println("Menssagens armazenadas no arquivo txt");
        
        entrada.close();
        servidor.close();
       }  
    }
