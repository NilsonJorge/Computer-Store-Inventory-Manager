
package Hardware;


public abstract class Hardware {
    private String modelo;
    private String marca;
    private double preco;
    private String descricao;
    private int quantidade;
    private double aux_preco = 0;
    private int aux_quant = 0;
    private String genero;
    private int id;

    public Hardware() {
        
    }

   

    public Hardware(String modelo, String marca, double preco, String descricao, int quantidade) {
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    

    public String toString(){
        return "\nModelo:"+this.modelo+"\nMarca:"+this.marca+"\nPreço:"+this.preco+"\nQuantidade: "+this.quantidade+"\n Descrição:"+this.descricao;
    }

    public double getAux_preco() {
        return aux_preco;
    }

    public void setAux_preco(double aux_preco) {
        this.aux_preco = aux_preco;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
     public int getAux_quant() {
        return aux_quant;
    }

    public void setAux_quant(int aux_quant) {
        this.aux_quant = aux_quant;
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
