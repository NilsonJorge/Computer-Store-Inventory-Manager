
package Hardware;

public class HD extends Hardware{
   private int qntdMemoria;
   private int rotacao;
   private double Tamanho;

    public HD(String modelo, String marca, double preco, String descricao, int quantidade, int qntdMemoria, int rotacao, double Tamanho) {
        super(modelo, marca, preco, descricao,quantidade);
        this.qntdMemoria = qntdMemoria;
        this.rotacao = rotacao;
        this.Tamanho = Tamanho;
        this.setGenero("hd");

    }

    public int getQntdMemoria() {
        return qntdMemoria;
    }

    public void setQntdMemoria(int qntdMemoria) {
        this.qntdMemoria = qntdMemoria;
    }

    public int getRotacao() {
        return rotacao;
    }

    public void setRotacao(int rotacao) {
        this.rotacao = rotacao;
    }

    public double getTamanho() {
        return Tamanho;
    }

    public void setTamanho(double Tamanho) {
        this.Tamanho = Tamanho;
    }
   
   
}
