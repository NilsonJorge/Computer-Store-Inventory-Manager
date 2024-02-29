package Acessar_Tabelas_BD;

import Hardware.Carrinho;
import Hardware.Interface;
import Carrinho_pedidos.Pedidos;
import Conexao_BD.Conexao_BD_hardware;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PedidosBD {
    
    public void create(Carrinho c, String produtos){
        Connection connec = Conexao_BD_hardware.getConnection();//conecta ao banco de dados
        PreparedStatement atmt = null;
        try{
        atmt = connec.prepareStatement("INSERT INTO pedidos (nome_comprador,produtos,valor_pedido)VALUES(?,?,?)");
        atmt.setString(1, c.getCliente());
        atmt.setString(2, produtos);
        atmt.setDouble(3, c.SomaTotal());
    
        atmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
        }finally{
                try {
                    Conexao_BD_hardware.closeConnection(connec, atmt);
                } catch (SQLException ex) {
                    Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
    public List<Pedidos> listar() {
        
        List<Pedidos> pedido = new ArrayList();
        Connection con = Conexao_BD_hardware.getConnection();//conectar com o banco de dados
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm =  con.prepareStatement("select * from pedidos;");
            rs = pstm.executeQuery();
            while(rs.next()){
                Pedidos p = new Pedidos(rs.getInt("pedido"),rs.getString("nome_comprador"),rs.getString("produtos"),rs.getDouble("valor_pedido"));
                pedido.add(p);
                
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler Pedidos");
        }finally{
            try {
                Conexao_BD_hardware.closeConnection(con, pstm);
            } catch (SQLException ex) {
                Logger.getLogger(ProcessadorBD.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        
        
        return pedido;
    }
}
