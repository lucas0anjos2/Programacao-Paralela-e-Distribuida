package dao;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import entity.Usuario;

public class ProvaDAO implements Serializable {
    private BaseDeDados bd;
    
    public ProvaDAO(){
        
    }
    
    public boolean corrigir(int q, String r){
        PreparedStatement pstm;
        ResultSet rs;
        
        try {
            bd = new BaseDeDados();
            pstm = bd.conecta().prepareStatement("SELECT * FROM gabarito WHERE id_da_questao = " + q); 
            rs = pstm.executeQuery();
            
            rs.next();
            String asw = rs.getString("resposta_correta");
                     
            bd.desconecta();
            return asw.equals(r);
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }   
    }
    
    public boolean armazenarUsuario(Usuario u){
        PreparedStatement pstm;
        
        try {
            bd = new BaseDeDados();
            pstm = bd.conecta().prepareStatement(
                    "INSERT INTO respostas_dos_usuarios(nome_do_usuario, resposta_q1, resposta_q2, resposta_q3, resposta_q4, resposta_q5, nota_final)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?)" );
            pstm.setString(1, u.getNome());
            pstm.setString(2, u.getRespostas()[0]);
            pstm.setString(3, u.getRespostas()[1]);
            pstm.setString(4, u.getRespostas()[2]);
            pstm.setString(5, u.getRespostas()[3]);
            pstm.setString(6, u.getRespostas()[4]);
            pstm.setInt(7, u.getNota()); // Supondo que a prova em questão já foi corrgida            
            pstm.executeUpdate();            
            
            System.out.println("Prova salva no banco");
            
            bd.desconecta();
            
            return  true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }   
    }
    
    
}
