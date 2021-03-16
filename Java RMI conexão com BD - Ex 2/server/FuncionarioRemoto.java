package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import middleware.FuncionarioInterface;
import dao.FuncionarioDAO;
import entity.Funcionario;

public class FuncionarioRemoto extends UnicastRemoteObject implements FuncionarioInterface{
    public FuncionarioRemoto() throws RemoteException {
        super();
    }
    
    public ArrayList listar() throws RemoteException{
        FuncionarioDAO funcDAO = new FuncionarioDAO();
        return funcDAO.listar();       
    }
    
    public void salvar (Funcionario func) throws RemoteException {
        FuncionarioDAO funcDAO = new FuncionarioDAO();
        funcDAO.salvar(func);
    }
    
    public void apagar(int id) throws RemoteException {
        FuncionarioDAO funcDAO = new FuncionarioDAO();
        funcDAO.apagar(id);
    }
}
