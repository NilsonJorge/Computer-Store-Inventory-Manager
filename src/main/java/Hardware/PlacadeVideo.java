package Hardware;

public class PlacadeVideo extends Hardware{
    private String Tipomemoria;
    private int Qtdmemoria;
    private int quantidade_ventoinhas;

    public PlacadeVideo(String modelo, String marca, double preco, String descricao,int quantidade, String Tipomemoria, int Qtdmemoria, int quantidade_ventoinhas) {
        super(modelo, marca, preco, descricao, quantidade);
        this.Tipomemoria = Tipomemoria;
        this.Qtdmemoria = Qtdmemoria;
        this.quantidade_ventoinhas = quantidade_ventoinhas;
        this.setGenero("gpu");
    }

    public String getTipomemoria() {
        return Tipomemoria;
    }

    public void setTipomemoria(String Tipomemoria) {
        this.Tipomemoria = Tipomemoria;
    }

    public int getQtdmemoria() {
        return Qtdmemoria;
    }

    public void setQtdmemoria(int Qtdmemoria) {
        this.Qtdmemoria = Qtdmemoria;
    }

    public int getQuantidade_ventoinhas() {
        return quantidade_ventoinhas;
    }

    public void setQuantidade_ventoinhas(int quantidade_ventoinhas) {
        this.quantidade_ventoinhas = quantidade_ventoinhas;
    }

    


}
