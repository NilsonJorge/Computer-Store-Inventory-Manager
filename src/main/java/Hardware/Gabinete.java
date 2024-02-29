package Hardware;

public class Gabinete extends Hardware{
    private String tipo;
    private int Fans;
    private String Cor;

    public Gabinete(String marca,String modelo,  double preco, String descricao, int quantidade, String tipo, int Fans, String Cor) {
        super(modelo, marca, preco, descricao, quantidade);
        this.tipo = tipo;
        this.Fans = Fans;
        this.Cor = Cor;
        this.setGenero("gabinete");
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getFans() {
        return Fans;
    }

    public void setFans(int Fans) {
        this.Fans = Fans;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String Cor) {
        this.Cor = Cor;
    }


}
