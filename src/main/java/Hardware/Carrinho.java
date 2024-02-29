
package Hardware;

import Carrinho_pedidos.Produtos;
import Carrinho_pedidos.Produtos;
import java.util.ArrayList;


public class Carrinho {

    ArrayList<Produtos> produtos;
    private double Valor;
    private String Cliente;
    private String Endereço;
    private double SaldoCliente;
    private int id;

    public Carrinho( String Cliente, String Endereço, double SaldoCliente) {
        this.Cliente = Cliente;
        this.Endereço = Endereço;
        this.SaldoCliente = SaldoCliente;
        produtos = new ArrayList();
    }

    public double SomaTotal(){
        double valor_total = 0;
        for (int i = 0; i < produtos.size(); i++) {
            valor_total += produtos.get(i).getPreco()* produtos.get(i).getQuantidade();
        }
        return valor_total;
    } 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produtos> produtos) {
        this.produtos = produtos;
    }

    public void add_produto(Produtos h){
        produtos.add(h);
    }

    
    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getEndereço() {
        return Endereço;
    }

    public void setEndereço(String Endereço) {
        this.Endereço = Endereço;
    }

    public double getSaldoCliente() {
        return SaldoCliente;
    }

    public void setSaldoCliente(double SaldoCliente) {
        this.SaldoCliente = SaldoCliente;
    }
 

    
}
