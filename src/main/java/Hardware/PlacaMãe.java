
package Hardware;

public class PlacaMãe extends Hardware{
    private String tamanho;
    private String soquete;
    private int TDP;

    public PlacaMãe(String modelo, String marca, double preco, String descricao, int quantidade, String tamanho, String soquete, int TDP) {
        super(modelo, marca, preco, descricao, quantidade);
        this.tamanho = tamanho;
        this.soquete = soquete;
        this.TDP = TDP;
        this.setGenero("placa_mae");
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getSoquete() {
        return soquete;
    }

    public void setSoquete(String soquete) {
        this.soquete = soquete;
    }

    public int getTDP() {
        return TDP;
    }

    public void setTDP(int TDP) {
        this.TDP = TDP;
    }
    
}
