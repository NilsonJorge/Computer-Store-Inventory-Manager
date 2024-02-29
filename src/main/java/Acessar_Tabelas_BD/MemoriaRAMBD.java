
package Acessar_Tabelas_BD;

import Hardware.MemoriaRAM;

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


public class MemoriaRAMBD {
    public void create(MemoriaRAM m) throws SQLException{
        
        Connection con = Conexao_BD_hardware.getConnection();
        PreparedStatement atmt = null;
        try{
        atmt = con.prepareStatement("INSERT INTO memoria_ram (modelo,marca,preco,descricao,quantidade,tipo_memoria,quant_memoria,frequencia,genero)VALUES(?,?,?,?,?,?,?,?,?)");
        atmt.setString(1, m.getModelo());
        atmt.setString(2, m.getMarca());
        atmt.setString(3, ""+m.getPreco());
        atmt.setString(4, m.getDescricao());
        atmt.setString(5, ""+m.getQuantidade());
        atmt.setString(6, m.getTipo_memoria());
        atmt.setString(7, ""+m.getQtdMemoria());
        atmt.setString(8, ""+m.getFrequencia());
        atmt.setString(9, ""+m.getGenero());
        
        atmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        }catch(SQLException ex){
            Logger.getLogger(ProcessadorBD.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar");
        }finally{
            Conexao_BD_hardware.closeConnection(con, atmt);
        }
    }
    
    public List<MemoriaRAM> listar() {
        
        List<MemoriaRAM> ram = new ArrayList();
        Connection con = Conexao_BD_hardware.getConnection();//conectar com o banco de dados
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm =  con.prepareStatement("select * from memoria_ram;");
            rs = pstm.executeQuery();
            while(rs.next()){
                MemoriaRAM p = new MemoriaRAM(rs.getString("modelo"),rs.getString("marca"),rs.getDouble("preco"),rs.getString("descricao"),rs.getInt("quantidade"),
                        rs.getString("tipo_memoria"),rs.getInt("quant_memoria"),rs.getInt("frequencia"));
                p.setId(rs.getInt("id"));
                p.setAux_preco(rs.getDouble("aux_preco"));
                p.setAux_quant(rs.getInt("aux_quantidade"));
                ram.add(p);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler Memoria RAM");
        }finally{
            try {
                Conexao_BD_hardware.closeConnection(con, pstm);
            } catch (SQLException ex) {
                Logger.getLogger(ProcessadorBD.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        
        
        return ram;
    }
 
    public String listar_produto_unico(int id){
        String descricao = "";
        Connection con = Conexao_BD_hardware.getConnection();//conectar com o banco de dados
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            pstm =  con.prepareStatement("select * from memoria_ram WHERE id = "+id+";");
            rs = pstm.executeQuery();
            while(rs.next()){
                MemoriaRAM p = new MemoriaRAM(rs.getString("modelo"),rs.getString("marca"),rs.getDouble("preco"),rs.getString("descricao"),rs.getInt("quantidade"),
                        rs.getString("tipo_memoria"),rs.getInt("quant_memoria"),rs.getInt("frequencia"));
                p.setId(rs.getInt("id"));
                p.setAux_preco(rs.getDouble("aux_preco"));
                p.setAux_quant(rs.getInt("aux_quantidade"));
                
                descricao = " Marca: "+p.getMarca()+"\n Modelo: "+p.getModelo()+"\n Preço: "+p.getPreco()+"\n Quantidade: "+p.getQuantidade()+
                        "\n Tipo de Memória: "+p.getTipo_memoria()+"\n Quantidade de Memória: "+p.getQtdMemoria() +"\n Frequência: "
                        +p.getFrequencia()+"\n Descrição: "+p.getDescricao();
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
