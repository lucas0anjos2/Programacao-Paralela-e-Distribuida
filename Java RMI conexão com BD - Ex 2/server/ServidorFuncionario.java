package server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorFuncionario {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            FuncionarioRemoto func = new FuncionarioRemoto();
            Naming.rebind("URLFuncionario", func);
            System.out.println("Servidor ativo...");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
