package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDados {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/tp1_ppd";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection conn;
    
    public BaseDeDados(){
        
    }
    
    public Connection conecta(){
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            //System.out.println("Conectado ao banco");
            
        } catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        
        return conn;
    }
    
    public void desconecta(){
        try {
            conn.close();
            //System.out.println("Desconectado do banco");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
