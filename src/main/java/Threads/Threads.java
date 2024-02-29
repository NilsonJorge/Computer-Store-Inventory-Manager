
package Threads;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

public class Threads extends Thread {

    private final String Anúncio;
    private final JTextField lugar;
    private final int tempo;

    public Threads(String Anúncio, JTextField lugar, int tempo) {
        this.Anúncio = Anúncio;
        this.lugar = lugar;
        this.tempo = tempo;
    }


    @Override
    public synchronized void run() {
        for(;;){
        lugar.setText("");
        lugar.setText(Anúncio);
        try {
            
            Threads.sleep(tempo);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
    }
    }
