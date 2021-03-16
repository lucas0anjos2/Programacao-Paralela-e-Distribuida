package servidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Servidor {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", "192.168.100.22");
            LocateRegistry.createRegistry(1099);
            ProvaRemota prova = new ProvaRemota();
            Naming.rebind("URLProva", prova);
            System.out.println("Servidor ativo...");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
