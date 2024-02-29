
package Acessar_Tabelas_BD;

import Conexao_BD.Conexao_BD_hardware;
import Usuarios.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClienteBD {
    public void create(Cliente p) throws SQLException{
        
        Connection con = Conexao_BD_hardware.getConnection();//conecta ao banco de dados
        PreparedStatement atmt = null;
        try{
        atmt = con.prepareStatement("INSERT INTO cliente (login,senha,acesso,nome,endereco,saldo)VALUES(?,?,?,?,?,?)");
        atmt.setString(1, p.getLogin());
        atmt.setString(2, p.getSenha());
        atmt.setString(3, p.getAcesso());
        atmt.setString(4, p.getNome());
        atmt.setString(5, p.getEndereco());
        atmt.setDouble(6, p.getSaldo());
        
        atmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
        }finally{
            Conexao_BD_hardware.closeConnection(con, atmt);
        }
    }
    
    public List<Cliente> listar() {
        
        List<Cliente> admin = new ArrayList();
        Connection con = Conexao_BD_hardware.getConnection();//conectar com o banco de dados
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm =  con.prepareStatement("select * from cliente;");
            rs = pstm.executeQuery();
            while(rs.next()){
                Cliente p = new Cliente(rs.getString("nome"),rs.getString("endereco"),rs.getDouble("saldo"),rs.getString("login"),rs.getString("senha"));
                p.setId(rs.getInt("id"));
                admin.add(p);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler clientes","ERRO",JOptionPane.ERROR_MESSAGE);
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
