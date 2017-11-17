package tp2;

import pratica7.*;

public class Montagem {
    private JGrafo grafo;
    
    public Montagem(int [] est1, int [] est2, int [] transp1, int [] transp2) throws Exception{
        this.grafo = new JGrafo(est1.length + est2.length - 2);
        
        //linha 1
        
        //saindo do estado inicial para a primeira estação
        grafo.insereAresta(0, 1, est1[0] + est1[1]);
        
        //de estação para estação na linha
        for(int i = 1; i < est1.length - 2; i++)
            grafo.insereAresta(i, i + 1, est1[i + 1]);
        
        //transporte ao ponto final
        grafo.insereAresta(est1.length - 2, grafo.numVertices() - 1 , est1[est1.length - 1]);

        //linha 2
        
        //saindo do vértive inicial
        grafo.insereAresta(0, est1.length - 1, est2[0] + est2[1]);
        
        //de estação para estação na linha
        for(int i = 0; i < est2.length - 2; i++)
            grafo.insereAresta(i + est1.length - 1, i + est1.length, est2[i + 2]);
        
        //transporte entre linhas
        for(int i = 0; i < transp1.length; i++){
            grafo.insereAresta(i + 1, i + est1.length, transp1[i] +  est2[i + 2]);
            grafo.insereAresta(i + est1.length - 1, i + 2 , transp2[i] +  est1[i + 2]);
        }
        
        System.out.println("\nGULOSO:");
        grafo.imprime();
        JAEDsMaps j = new JAEDsMaps();
        j.caminhoMaisRapido(grafo, 0, grafo.numVertices() - 1);
        System.out.println("\n====================");
    }
}
