
package Acessar_Tabelas_BD;

import Hardware.Gabinete;
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


public class GabineteBD {
    public void create(Gabinete g) throws SQLException{
        
        Connection con = Conexao_BD_hardware.getConnection();
        PreparedStatement atmt = null;
        try{
        atmt = con.prepareStatement("INSERT INTO gabinete (modelo,marca,preco,descricao,quantidade,tipo_gabinete,fans,cor,genero)VALUES(?,?,?,?,?,?,?,?,?)");
        atmt.setString(1, g.getModelo());
        atmt.setString(2, g.getMarca());
        atmt.setString(3, ""+g.getPreco());
        atmt.setString(4, g.getDescricao());
        atmt.setString(5, ""+g.getQuantidade());
        atmt.setString(6, g.getTipo());
        atmt.setString(7, ""+g.getFans());
        atmt.setString(8, g.getCor());
        atmt.setString(9, ""+g.getGenero());
        
        atmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        }catch(SQLException ex){
            Logger.getLogger(ProcessadorBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
        }finally{
            Conexao_BD_hardware.closeConnection(con, atmt);
        }
    }
    public List<Gabinete> listar() {
        
        List<Gabinete> gabi = new ArrayList();
        Connection con = Conexao_BD_hardware.getConnection();//conectar com o banco de dados
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm =  con.prepareStatement("select * from gabinete;");
            rs = pstm.executeQuery();
            while(rs.next()){
                Gabinete p = new Gabinete(rs.getString("modelo"),rs.getString("marca"),rs.getDouble("preco"),rs.getString("descricao"),rs.getInt("quantidade"),
                        rs.getString("tipo_gabinete"),rs.getInt("fans"),rs.getString("cor"));
                p.setId(rs.getInt("id"));
                p.setAux_preco(rs.getDouble("aux_preco"));
                p.setAux_quant(rs.getInt("aux_quantidade"));
                gabi.add(p);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler Gabinete","ERRO",JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
                Conexao_BD_hardware.closeConnection(con, pstm);//encerra a conexão
            } catch (SQLException ex) {
                Logger.getLogger(ProcessadorBD.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        
        
        return gabi;
    }
   
    public String listar_produto_unico(int id){
        String descricao = "";
        
        Connection con = Conexao_BD_hardware.getConnection();//conectar com o banco de dados
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm =  con.prepareStatement("select * from gabinete WHERE id = "+id+";");
            rs = pstm.executeQuery();
            while(rs.next()){
                Gabinete p = new Gabinete(rs.getString("modelo"),rs.getString("marca"),rs.getDouble("preco"),rs.getString("descricao"),rs.getInt("quantidade"),
                        rs.getString("tipo_gabinete"),rs.getInt("fans"),rs.getString("cor"));
                p.setId(rs.getInt("id"));
                p.setAux_preco(rs.getDouble("aux_preco"));
                p.setAux_quant(rs.getInt("aux_quantidade"));
                
                 descricao = " Marca: "+p.getMarca()+"\n Modelo: "+p.getModelo()+"\n Preço: "+p.getPreco()+"\n Quantidade: "+p.getQuantidade()+
                        "\n Tamanho do gabinete: "+p.getTipo()+"\n Quantidade de Fans suportadas: "+p.getFans() +"\n Cor: "
                        +p.getCor()+"\n Descrição: "+p.getDescricao();
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
