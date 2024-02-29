
package Hardware;

public class Processador extends Hardware {
    
    private String soquete;
    private int TDP;

    
    public Processador( String modelo, String marca, double preco, String descricao,int quantidade,String soquete, int TDP) {
        super(modelo, marca, preco, descricao,quantidade);
        
        this.soquete = soquete;
        this.TDP = TDP;
        this.setGenero("processador");
       
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
