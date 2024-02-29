
package Hardware;

public class MemoriaRAM extends Hardware{
    private String tipo_memoria;
    private int QtdMemoria;
    private int frequencia;

    public MemoriaRAM(String modelo, String marca, double preco, String descricao, int quantidade, String tipo_memoria, int QtdMemoria, int frequencia) {
        super(modelo, marca, preco, descricao, quantidade);
        this.tipo_memoria = tipo_memoria;
        this.QtdMemoria = QtdMemoria;
        this.frequencia = frequencia;
        this.setGenero("memoria_ram");

    }

    public String getTipo_memoria() {
        return tipo_memoria;
    }

    public void setTipo_memoria(String tipo_memoria) {
        this.tipo_memoria = tipo_memoria;
    }
    
    public int getQtdMemoria() {
        return QtdMemoria;
    }

    public void setQtdMemoria(int QtdMemoria) {
        this.QtdMemoria = QtdMemoria;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }
    
    
}
