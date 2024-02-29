/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Acessar_Tabelas_BD;

import Hardware.HD;
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
public class HDBD {
    public void create(HD h) throws SQLException{
        
        Connection con = Conexao_BD_hardware.getConnection();
        PreparedStatement atmt = null;
        try{
        atmt = con.prepareStatement("INSERT INTO hd (modelo,marca,preco,descricao,quantidade,quant_memoria,rotacao,tamanho,genero)VALUES(?,?,?,?,?,?,?,?,?)");
        atmt.setString(1, h.getModelo());
        atmt.setString(2, h.getMarca());
        atmt.setString(3, ""+h.getPreco());
        atmt.setString(4, h.getDescricao());
        atmt.setString(5, ""+h.getQuantidade());
        atmt.setString(6, ""+h.getQntdMemoria());
        atmt.setString(7, ""+h.getRotacao());
        atmt.setString(8, ""+h.getTamanho());
        atmt.setString(9, ""+h.getGenero());
        
        atmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        }catch(SQLException ex){
            Logger.getLogger(ProcessadorBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
        }finally{
            Conexao_BD_hardware.closeConnection(con, atmt);
        }
    }
    public List<HD> listar() {
        
        List<HD> hd = new ArrayList();
        Connection con = Conexao_BD_hardware.getConnection();//conectar com o banco de dados
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm =  con.prepareStatement("select * from hd;");
            rs = pstm.executeQuery();
            while(rs.next()){
                HD p = new HD(rs.getString("modelo"),rs.getString("marca"),rs.getDouble("preco"),rs.getString("descricao"),rs.getInt("quantidade"),
                        rs.getInt("quant_memoria"),rs.getInt("rotacao"),rs.getDouble("tamanho"));
                p.setId(rs.getInt("id"));
                p.setAux_preco(rs.getDouble("aux_preco"));
                p.setAux_quant(rs.getInt("aux_quantidade"));
                hd.add(p);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler HD");
        }finally{
            try {
                Conexao_BD_hardware.closeConnection(con, pstm);
            } catch (SQLException ex) {
                Logger.getLogger(ProcessadorBD.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        
        
        return hd;
    }
    
    public String listar_produto_unico(int id){
        String descricao = "";
        Connection con = Conexao_BD_hardware.getConnection();//conectar com o banco de dados
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm =  con.prepareStatement("select * from hd WHERE id = "+id+";");
            rs = pstm.executeQuery();
            while(rs.next()){
                HD p = new HD(rs.getString("modelo"),rs.getString("marca"),rs.getDouble("preco"),rs.getString("descricao"),rs.getInt("quantidade"),
                        rs.getInt("quant_memoria"),rs.getInt("rotacao"),rs.getDouble("tamanho"));
                p.setId(rs.getInt("id"));
                p.setAux_preco(rs.getDouble("aux_preco"));
                p.setAux_quant(rs.getInt("aux_quantidade"));
                
                descricao = " Marca: "+p.getMarca()+"\n Modelo: "+p.getModelo()+"\n Preço: "+p.getPreco()+"\n Quantidade: "+p.getQuantidade()+
                        "\n Rotação: "+p.getRotacao()+"\n Quantidade de Memória: "+p.getQntdMemoria() +"\n Tamanho: "
                        +p.getTamanho()+"\n Descrição: "+p.getDescricao();
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
