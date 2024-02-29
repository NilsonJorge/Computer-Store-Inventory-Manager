/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Acessar_Tabelas_BD;


import Hardware.PlacadeVideo;
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

/**
 *
 * @author nilsi
 */
public class PlacadeVideoBD {
    public void create(PlacadeVideo p) throws SQLException{
        
        Connection con = Conexao_BD_hardware.getConnection();
        PreparedStatement atmt = null;
        try{
        atmt = con.prepareStatement("INSERT INTO gpu (modelo,marca,preco,descricao,quantidade,tipo_memoria,quant_memoria,quant_ventoinhas,genero)VALUES(?,?,?,?,?,?,?,?,?)");
        atmt.setString(1, p.getModelo());
        atmt.setString(2, p.getMarca());
        atmt.setString(3, ""+p.getPreco());
        atmt.setString(4, p.getDescricao());
        atmt.setString(5, ""+p.getQuantidade());
        atmt.setString(6, ""+p.getTipomemoria());
        atmt.setString(7, ""+p.getQtdmemoria());
        atmt.setString(8, ""+p.getQuantidade_ventoinhas());
        atmt.setString(9, ""+p.getGenero());
        
        atmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        }catch(SQLException ex){
            Logger.getLogger(ProcessadorBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
        }finally{
            Conexao_BD_hardware.closeConnection(con, atmt);
        }
    }
    
    public List<PlacadeVideo> listar() {
        
        List<PlacadeVideo> gpu = new ArrayList();
        Connection con = Conexao_BD_hardware.getConnection();//conectar com o banco de dados
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm =  con.prepareStatement("select * from gpu;");
            rs = pstm.executeQuery();
            while(rs.next()){
                PlacadeVideo p = new PlacadeVideo(rs.getString("modelo"),rs.getString("marca"),rs.getDouble("preco"),rs.getString("descricao"),rs.getInt("quantidade"),
                        rs.getString("tipo_memoria"),rs.getInt("quant_memoria"),rs.getInt("quant_ventoinhas"));
                p.setId(rs.getInt("id"));
                p.setAux_preco(rs.getDouble("aux_preco"));
                p.setAux_quant(rs.getInt("aux_quantidade"));
                gpu.add(p);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler Placa de Vídeo");
        }finally{
            try {
                Conexao_BD_hardware.closeConnection(con, pstm);
            } catch (SQLException ex) {
                Logger.getLogger(ProcessadorBD.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        
        
        return gpu;
    }
    
    public String listar_produto_unico(int id){
        String descricao = "";
        
        Connection con = Conexao_BD_hardware.getConnection();//conectar com o banco de dados
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm =  con.prepareStatement("select * from gpu WHERE id = "+id+";");
            rs = pstm.executeQuery();
            while(rs.next()){
                PlacadeVideo p = new PlacadeVideo(rs.getString("modelo"),rs.getString("marca"),rs.getDouble("preco"),rs.getString("descricao"),rs.getInt("quantidade"),
                        rs.getString("tipo_memoria"),rs.getInt("quant_memoria"),rs.getInt("quant_ventoinhas"));
                p.setId(rs.getInt("id"));
                p.setAux_preco(rs.getDouble("aux_preco"));
                p.setAux_quant(rs.getInt("aux_quantidade"));
                
                descricao = " Marca: "+p.getMarca()+"\n Modelo: "+p.getModelo()+"\n Preço: "+p.getPreco()+"\n Quantidade: "+p.getQuantidade()+
                        "\n Tipo de Memória: "+p.getTipomemoria()+"\n Quantidade de Memória: "+p.getQtdmemoria() +"\n Quantidade Ventoinhas: "
                        +p.getQuantidade_ventoinhas()+"\n Descrição: "+p.getDescricao();
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler placa mae");
        }finally{
            try {
                Conexao_BD_hardware.closeConnection(con, pstm);
            } catch (SQLException ex) {
                Logger.getLogger(ProcessadorBD.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
    return descricao;
    }
   
}
