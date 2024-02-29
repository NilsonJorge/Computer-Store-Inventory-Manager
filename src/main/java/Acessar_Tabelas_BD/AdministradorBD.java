
package Acessar_Tabelas_BD;

import Conexao_BD.Conexao_BD_hardware;
import Usuarios.Administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AdministradorBD {
    public void create(Administrador p) throws SQLException{
        
        Connection con = Conexao_BD_hardware.getConnection();//conecta ao banco de dados
        PreparedStatement atmt = null;
        try{
        atmt = con.prepareStatement("INSERT INTO administrador (login,senha,acesso)VALUES(?,?,?)");
        atmt.setString(1, p.getLogin());
        atmt.setString(2, p.getSenha());
        atmt.setString(3, p.getAcesso());
        
        
        
        atmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
        }finally{
            Conexao_BD_hardware.closeConnection(con, atmt);
        }
    }
    
    public List<Administrador> listar() {
        
        List<Administrador> admin = new ArrayList();
        Connection con = Conexao_BD_hardware.getConnection();//conectar com o banco de dados
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm =  con.prepareStatement("select * from administrador;");
            rs = pstm.executeQuery();
            while(rs.next()){
                Administrador p = new Administrador(rs.getString("login"),rs.getString("senha"));
                p.setId(rs.getInt("id"));
                admin.add(p);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler administradores","ERRO",JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                Conexao_BD_hardware.closeConnection(con, pstm);
            } catch (SQLException ex) {
                Logger.getLogger(ProcessadorBD.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        
        
        return admin;
    }
}
