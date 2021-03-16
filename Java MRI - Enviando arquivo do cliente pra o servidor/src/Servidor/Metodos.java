package Servidor;

import java.io.File;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Metodos extends UnicastRemoteObject implements Interface {
    public Metodos() throws RemoteException {
        super();
    }
    
    public void receberArquivo(String nomeArquivo, byte[] dados, int tamanho) throws RemoteException { // receber dados do cliente e criar o arquivo no servidor
        try{
            File arquivo = new File(nomeArquivo);
            arquivo.createNewFile();
            FileOutputStream buffSaida = new FileOutputStream(arquivo, true);
            buffSaida.write(dados, 0, tamanho);
            buffSaida.flush();
            buffSaida.close();
            System.out.println("Arquivo recebido!");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
