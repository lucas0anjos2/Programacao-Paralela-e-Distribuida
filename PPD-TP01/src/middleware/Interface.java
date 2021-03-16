package middleware;

import entity.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote{    
    public int rodar(String nomeAluno, String nomeArquivo, byte[] dados, int tamanho) throws RemoteException; // deve receber o nome do aluno, enviar o txt e retornar a nota final
    
}
