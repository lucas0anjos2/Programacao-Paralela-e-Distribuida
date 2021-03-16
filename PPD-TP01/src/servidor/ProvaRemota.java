package servidor;

import dao.ProvaDAO;
import entity.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import middleware.Interface;


public class ProvaRemota extends UnicastRemoteObject implements  Interface {
    
    private int idCliente;
    
    public ProvaRemota() throws RemoteException {
        super();
        this.idCliente = 0;
    }

    public int rodar(String nomeAluno, String nomeArquivo, byte[] dados, int tamanho) throws RemoteException {
        int nota = 0;
        // Receber arquivo txt
        try {
            File arquivo = new File(nomeArquivo + idCliente + ".txt");
            arquivo.createNewFile();
            FileOutputStream buffSaida = new FileOutputStream(arquivo, true);
            buffSaida.write(dados, 0, tamanho);
            buffSaida.flush();
            buffSaida.close();
            System.out.println("Arquivo recebido!");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        //--------------------
        
        //Armazenar em um objeto do tipo "Usuario" os dados recebidos
        Usuario usuario = new Usuario();
        usuario.setNome(nomeAluno);
        ProvaDAO provaDAO = new ProvaDAO();
        
        try {
            BufferedReader buffLeitura = new BufferedReader(new FileReader(nomeArquivo + idCliente + ".txt"));
            String [] prova = new String[5];
            
            for(int i = 0; i < 5; i++){
                prova[i] = buffLeitura.readLine().substring(2); // capturar do arquivo a resposta para cada questao
                if(provaDAO.corrigir(i + 1, prova[i])) nota++; // corrigir cada resposta
            }
                        
            usuario.setRespostas(prova);
            usuario.setNota(nota);   
            
            usuario.print();
            
        } catch (Exception e) {
            e.printStackTrace();
        }                         
        //-------------------------------------------------
        
        
        // Inserir na tabela resposta_dos_usuarios
        provaDAO.armazenarUsuario(usuario);
        //----------------------------------------
        idCliente++;
        
        return nota;
    }
    
}
