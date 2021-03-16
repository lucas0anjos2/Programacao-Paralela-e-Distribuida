package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDados {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/exercícioppd";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private Connection conn;
    
    public BaseDeDados(){
        
    }
    
    public Connection conecta(){
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
