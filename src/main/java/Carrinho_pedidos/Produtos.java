
package Carrinho_pedidos;


public class Produtos {
    private String modelo;
    private String marca;
    private double preco;
    private int quantidade;
    private String genero;
    private int id;
    
     public Produtos(int id, String genero,String modelo, String marca, double preco, int quantidade) {
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        this.quantidade = quantidade;
        this.id = id;
        this.genero = genero;
    }
     public Produtos(Produtos p) {
        this.modelo = p.modelo;
        this.marca = p.marca;
        this.preco = p.preco;
        this.quantidade = p.quantidade;
        this.id = p.id;
        this.genero = p.genero;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
     
}
