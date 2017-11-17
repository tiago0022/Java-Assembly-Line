package tp2;

import pratica7.*;

public class Montagem {
    private JGrafo grafo;
    
    public Montagem(int [] est1, int [] est2, int [] transp1, int [] transp2){
        this.grafo = new JGrafo(est1.length + est2.length - 2);
        grafo.imprime();
        
        
        
    }
}
