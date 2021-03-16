package middleware;

import entity.Funcionario;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface FuncionarioInterface extends Remote{
    public ArrayList listar() throws RemoteException;
    public void salvar (Funcionario func) throws RemoteException;
    public void apagar(int id) throws RemoteException;
    
}
