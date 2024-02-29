package Carrinho_pedidos;


public class Pedidos {
    private int ID;
    private String Nome_comprador;
    private String Produtos;
    private double Valor_compra;

    public Pedidos(int ID, String Nome_comprador, String Produtos, double Valor_compra) {
        this.ID = ID;
        this.Nome_comprador = Nome_comprador;
        this.Produtos = Produtos;
        this.Valor_compra = Valor_compra;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome_comprador() {
        return Nome_comprador;
    }

    public void setNome_comprador(String Nome_comprador) {
        this.Nome_comprador = Nome_comprador;
    }

    public String getProdutos() {
        return Produtos;
    }

    public void setProdutos(String Produtos) {
        this.Produtos = Produtos;
    }

    public double getValor_compra() {
        return Valor_compra;
    }

    public void setValor_compra(double Valor_compra) {
        this.Valor_compra = Valor_compra;
    }
    
    
    
}
