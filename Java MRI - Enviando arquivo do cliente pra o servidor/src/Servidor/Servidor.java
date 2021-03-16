package Servidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Servidor {

    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(1099); 
            Metodos msg = new Metodos();
            
            Naming.rebind("URLMensagem", msg); // msg é o objeto pelo qual o cliente invocará os métodos do servidor
            
            System.out.println("Servidor rodando...");
            
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
