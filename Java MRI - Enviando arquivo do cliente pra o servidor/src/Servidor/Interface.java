package Servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote{
    public void receberArquivo(String nomeArquivo, byte[] dados, int tamanho) throws RemoteException;
}
