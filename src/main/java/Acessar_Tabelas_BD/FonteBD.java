
package Acessar_Tabelas_BD;

import Hardware.Fonte;
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


public class FonteBD {
    public void create(Fonte f) throws SQLException{
        
        Connection con = Conexao_BD_hardware.getConnection();
        PreparedStatement atmt = null;
        try{
        atmt = con.prepareStatement("INSERT INTO fonte (modelo,marca,preco,descricao,quantidade,potencia,cabos,eficiencia,genero)VALUES(?,?,?,?,?,?,?,?,?)");
        atmt.setString(1, f.getModelo());
        atmt.setString(2, f.getMarca());
        atmt.setString(3, ""+f.getPreco());
        atmt.setString(4, f.getDescricao());
        atmt.setString(5, ""+f.getQuantidade());
        atmt.setString(6, ""+f.getPotencia());
        atmt.setString(7, f.getCabos());
        atmt.setString(8, f.getEficiencia());
        atmt.setString(9, ""+f.getGenero());
        
        atmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        }catch(SQLException ex){
            Logger.getLogger(ProcessadorBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
        }finally{
            Conexao_BD_hardware.closeConnection(con, atmt);
        }
    }
    
    public List<Fonte> listar() {
        
        List<Fonte> fonte = new ArrayList();
        Connection con = Conexao_BD_hardware.getConnection();//conectar com o banco de dados
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm =  con.prepareStatement("select * from fonte;");
            rs = pstm.executeQuery();
            while(rs.next()){
                Fonte p = new Fonte(rs.getString("modelo"),rs.getString("marca"),rs.getDouble("preco"),rs.getString("descricao"),rs.getInt("quantidade"),
                        rs.getInt("potencia"),rs.getString("cabos"),rs.getString("eficiencia"));
                p.setId(rs.getInt("id"));
                p.setAux_preco(rs.getDouble("aux_preco"));
                p.setAux_quant(rs.getInt("aux_quantidade"));
                
                fonte.add(p);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler Fonte","ERRO",JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                Conexao_BD_hardware.closeConnection(con, pstm);//encerra a conexão
            } catch (SQLException ex) {
                Logger.getLogger(ProcessadorBD.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        
        
        return fonte;
    }
  
    public String listar_produto_unico(int id){
        String descricao = "";
        Connection con = Conexao_BD_hardware.getConnection();//conectar com o banco de dados
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm =  con.prepareStatement("select * from fonte WHERE id = "+id+";");
            rs = pstm.executeQuery();
            while(rs.next()){
                Fonte p = new Fonte(rs.getString("modelo"),rs.getString("marca"),rs.getDouble("preco"),rs.getString("descricao"),rs.getInt("quantidade"),
                        rs.getInt("potencia"),rs.getString("cabos"),rs.getString("eficiencia"));
                p.setId(rs.getInt("id"));
                p.setAux_preco(rs.getDouble("aux_preco"));
                p.setAux_quant(rs.getInt("aux_quantidade"));
                
                descricao = " Marca: "+p.getMarca()+"\n Modelo: "+p.getModelo()+"\n Preço: "+p.getPreco()+"\n Quantidade: "+p.getQuantidade()+
                        "\n Potência: "+p.getPotencia()+"\n Tipo de cabos: "+p.getCabos() +"\n Eficiência: "
                        +p.getEficiencia()+"\n Descrição: "+p.getDescricao();
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler placa mae");
        }finally{
            try {
                Conexao_BD_hardware.closeConnection(con, pstm);//encerra a conexão
            } catch (SQLException ex) {
                Logger.getLogger(ProcessadorBD.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        
        
    return descricao;
    }
    
}
