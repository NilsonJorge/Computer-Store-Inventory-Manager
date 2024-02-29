
package Hardware;

public class Fonte extends Hardware{
    private int potencia;
    private String cabos;
    private String eficiencia;

    public Fonte( String marca, String modelo, double preco, String descricao, int quantidade, int potencia, String cabos, String eficiencia) {
        super(modelo, marca, preco, descricao,quantidade);
        this.potencia = potencia;
        this.cabos = cabos;
        this.eficiencia = eficiencia;
        this.setGenero("fonte");
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getCabos() {
        return cabos;
    }

    public void setCabos(String cabos) {
        this.cabos = cabos;
    }

    public String getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(String eficiencia) {
        this.eficiencia = eficiencia;
    }
    
    
}
