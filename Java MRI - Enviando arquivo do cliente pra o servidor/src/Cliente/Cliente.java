package Cliente;

import Servidor.Interface;
import java.io.File;
import java.io.FileInputStream;
import java.rmi.Naming;

public class Cliente {

    public static void main(String[] args) {
       try{
            Interface objRemoto = (Interface) Naming.lookup("//localhost/URLMensagem");
            
            File arquivo = new File("src/Cliente/arquivo.txt");
            
            FileInputStream entrada = new FileInputStream(arquivo);
            
            byte[] dados = new byte[1024 * 1024];
            int tamanho = entrada.read(dados);
            
            while(tamanho > 0){
                objRemoto.receberArquivo("arquivo.txt", dados, tamanho); // Eviar dados do txt para o servidor
                tamanho = entrada.read(dados);
            }
                        
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
