package Acessar_Tabelas_BD;

import Hardware.Processador;
import Conexao_BD.Conexao_BD_hardware;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ProcessadorBD {
    
    public void create(Processador p) throws SQLException{
        
        Connection con = Conexao_BD_hardware.getConnection();//conecta ao banco de dados
        PreparedStatement atmt = null;
        try{
        atmt = con.prepareStatement("INSERT INTO processador (modelo,marca,preco,descricao,quantidade,soquete,tdp,genero)VALUES(?,?,?,?,?,?,?,?)");
        atmt.setString(1, p.getModelo());
        atmt.setString(2, p.getMarca());
        atmt.setString(3, ""+p.getPreco());
        atmt.setString(4, p.getDescricao());
        atmt.setString(5, ""+p.getQuantidade());
        atmt.setString(6, p.getSoquete());
        atmt.setString(7, ""+p.getTDP());
        atmt.setString(8, ""+p.getGenero());
        
        
        atmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        }catch(SQLException ex){
            
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
        }finally{
            Conexao_BD_hardware.closeConnection(con, atmt);
        }
    }
    
  
    
    public List<Processador> listar() {
        
        List<Processador> cpu = new ArrayList();
        Connection con = Conexao_BD_hardware.getConnection();//conectar com o banco de dados
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm =  con.prepareStatement("select * from processador;");
            rs = pstm.executeQuery();
            while(rs.next()){
                Processador p = new Processador(rs.getString("modelo"),rs.getString("marca"),rs.getDouble("preco"),rs.getString("descricao"),rs.getInt("quantidade"),rs.getString("soquete"),
                rs.getInt("TDP"));
                p.setId(rs.getInt("id"));
                p.setAux_preco(rs.getDouble("aux_preco"));
                p.setAux_quant(rs.getInt("aux_quantidade"));
                cpu.add(p);
                p.setDescricao("Marca: "+p.getMarca()+"\n Modelo: "+p.getModelo()+"\n Preço: "+p.getPreco()+"\n Quantidade: "+p.getQuantidade()+
                        "\n Soquete: "+p.getSoquete()+"\n TDP: "+p.getTDP()+"\n Descrição: "+p.getDescricao());
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler processadores");
        }finally{
            try {
                Conexao_BD_hardware.closeConnection(con, pstm);
            } catch (SQLException ex) {
                Logger.getLogger(ProcessadorBD.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        
        
        return cpu;
    }
    
    public String listar_produto_unico(int id){
        Connection con = Conexao_BD_hardware.getConnection();//conectar com o banco de dados
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String  descricao = ""; 
        try {
            pstm =  con.prepareStatement("select * from processador WHERE id = "+id+";");
            rs = pstm.executeQuery();
            while(rs.next()){
                Processador p = new Processador(rs.getString("modelo"),rs.getString("marca"),rs.getDouble("preco"),rs.getString("descricao"),rs.getInt("quantidade"),rs.getString("soquete"),
                rs.getInt("TDP"));
                p.setId(rs.getInt("id"));
                p.setAux_preco(rs.getDouble("aux_preco"));
                p.setAux_quant(rs.getInt("aux_quantidade"));

                descricao = " Marca: "+p.getMarca()+"\n Modelo: "+p.getModelo()+"\n Preço: "+p.getPreco()+"\n Quantidade: "+p.getQuantidade()+
                        "\n Soquete: "+p.getSoquete()+"\n TDP: "+p.getTDP() +"\n Descrição: "+p.getDescricao();
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler processadores");
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
