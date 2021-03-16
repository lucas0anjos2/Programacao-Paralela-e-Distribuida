package testes;

import java.net.*;
import java.io.*;
import java.util.Date;
import javax.swing.JOptionPane;

public class Cliente01 {
    public static void main(String[] args){
        try {
            Socket cliente = new Socket("localhost", 12345);
            
            String nomeCliente = JOptionPane.showInputDialog("Informe seu nome");
            ObjectOutputStream dadosParaServidor = new ObjectOutputStream(cliente.getOutputStream());
            dadosParaServidor.flush();
            dadosParaServidor.writeObject(nomeCliente); 
                           
            ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
            Date dataDoServidor = (Date) entrada.readObject();
            JOptionPane.showMessageDialog(null, "Data recebida do servidor: " + dataDoServidor.toString());
            
            entrada.close();
            System.out.println("Conexão encerrada.");
            
        } catch (Exception e) {
            System.out.println("Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
