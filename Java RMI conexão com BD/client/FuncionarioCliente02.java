package client;

import entity.Funcionario;
import java.rmi.Naming;
import java.util.ArrayList;
import middleware.FuncionarioInterface;

public class FuncionarioCliente02 {
    public static void main(String[] args) {
        try {
            FuncionarioInterface objRemoto = (FuncionarioInterface) Naming.lookup("//localhost/URLFuncionario");
            ArrayList<Funcionario> listagem = objRemoto.listar();
            
            System.out.println("Funcionários Cadastrados: ");
            listagem.forEach(func -> System.out.println(func.getId() + " | " + func.getNome() + " | " + func.getEndereco() + " | " + func.getSalario()));
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
