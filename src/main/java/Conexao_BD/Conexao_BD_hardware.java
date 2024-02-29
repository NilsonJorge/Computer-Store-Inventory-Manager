
package Conexao_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Conexao_BD_hardware {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/hardware";//escolhe o banco de dados
    private static final String USER = "root";
    private static final String PASS = "";
    
    public static Connection getConnection(){//inicia conexão com o banco de dados
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão",ex);
        }
    }
    
    public static void closeConnection(Connection con) throws SQLException{
        if(con!= null){
            con.close();
        }
    }
    public static void closeConnection(Connection con, PreparedStatement stmt) throws SQLException{
        closeConnection(con);
        
        if(stmt!= null){
            stmt.close();
        }
    }
    
     public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) throws SQLException{
        closeConnection(con,stmt);
        
        if(rs!= null){
            rs.close();
        }
    }
    
    
}
