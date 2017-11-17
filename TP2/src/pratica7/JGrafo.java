/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica7;

/**
 *
 * @author mateus
 */
public class JGrafo {
    public class Peso{
            private int distancia, tempo;
            public Peso(int distancia, int tempo){
                this.distancia = distancia;
                this.tempo = tempo;
            }
            
            public Peso(int distancia){
                this.distancia = distancia;
                this.tempo = 0;
            }
            
            public int getDistancia(){
                return this.distancia;
            }
            public int getTempo(){
                return this.tempo;
            }

        public void setDistancia(int distancia) {
            this.distancia = distancia;
        }

        public void setTempo(int tempo) {
            this.tempo = tempo;
        }
            
            public int getPesoTotal(){
                return this.distancia + this.tempo;
            }

        @Override
        public String toString() {
            return distancia + "";
        }
            
        }
    public static class Aresta {
        
        
        
        private int v1, v2;
        private Peso peso;
        public Aresta (int v1, int v2, Peso peso) {
            this.v1 = v1; this.v2 = v2; this.peso = peso;
        }
        public Peso peso () { return this.peso; }
        public int v1 () { return this.v1; }
        public int v2 () { return this.v2; }

        public void setV1(int v1) {
            this.v1 = v1;
        }

        public void setV2(int v2) {
            this.v2 = v2;
        }

        public void setPeso(Peso peso) {
            this.peso = peso;
        }
        
  }
  public Peso mat[][]; // @{\it pesos do tipo inteiro}@
  private int numVertices;
  private int pos[]; // @{\it posi\c{c}\~ao atual ao se percorrer os adjs de um v\'ertice v}@

  public JGrafo (int numVertices) {
    this.mat = new Peso[numVertices][numVertices];
    this.pos = new int[numVertices]; 
    this.numVertices = numVertices; 
    for (int i = 0; i < this.numVertices; i++) {
      for (int j = 0; j < this.numVertices; j++) this.mat[i][j] = null;
      this.pos[i] = -1; 
    }
  }
  public void insereAresta (int v1, int v2, int distancia, int tempo) {
    Peso p = new Peso(distancia, tempo);
    this.mat[v1][v2] = p; 
  }
  
  public void insereAresta (int v1, int v2, int distancia) {
    Peso p = new Peso(distancia);
    this.mat[v1][v2] = p; 
  }
  
  public boolean existeAresta (int v1, int v2) {
    return (this.mat[v1][v2] != null);
  }
  public boolean listaAdjVazia (int v) {
    for (int i =0; i < this.numVertices; i++)
      if (this.mat[v][i] != null) return false;
    return true;
  }
  public Aresta primeiroListaAdj (int v) {
    // @{\it Retorna a primeira aresta que o v\'ertice v participa ou}@ 
    // @{\it {\bf null} se a lista de adjac\^encia de v for vazia}@
    this.pos[v] = -1; return this.proxAdj (v);
  }
  public Aresta proxAdj (int v) {
    // @{\it Retorna a pr\'oxima aresta que o v\'ertice v participa ou}@ 
    // @{\it {\bf null} se a lista de adjac\^encia de v estiver no fim}@ 
    this.pos[v] ++;
    while ((this.pos[v] < this.numVertices) && 
           (this.mat[v][this.pos[v]] == null)) this.pos[v]++;
    if (this.pos[v] == this.numVertices) return null;
    else return new Aresta (v, this.pos[v], this.mat[v][this.pos[v]]);
  }
  public Aresta retiraAresta (int v1, int v2) {
    if (this.mat[v1][v2] == null) return null; // @{\it Aresta n\~ao existe}@
    else {
      Aresta aresta = new Aresta (v1, v2, this.mat[v1][v2]);
      this.mat[v1][v2] = null; return aresta;
    }
  }
  public void imprime () {
//    System.out.print ("   ");
//    for (int i = 0; i < this.numVertices; i++) 
//      System.out.print (i + "   "); 
//    System.out.println ();
//    for (int i = 0; i < this.numVertices; i++) { 
//      System.out.print (i + "  ");
//      for (int j = 0; j < this.numVertices; j++){
//        if(this.mat[i][j] == null)
//            System.out.print ("." + "   ");
//        else
//            System.out.print (this.mat[i][j] + "   ");
//      }
//      System.out.println ();
//    }

    System.out.println();
    for (int i = 0; i < this.numVertices; i++){
        System.out.print("[" + i + "]-> ");
        for(int j = 0; j < this.numVertices; j++){
            if(this.mat[i][j] != null)
                System.out.print(j + " > ");
        }
        System.out.println(".");
    }
    System.out.println();

  }
  public int numVertices () { return this.numVertices; }
  public JGrafo grafoTransposto () {
    JGrafo grafoT = new JGrafo (this.numVertices); 
    for (int v = 0; v < this.numVertices; v++)
      if (!this.listaAdjVazia (v)) {
        Aresta adj = this.primeiroListaAdj (v);
        while (adj != null) {
          grafoT.insereAresta (adj.v2 (), adj.v1 (), adj.peso().distancia, adj.peso().tempo);
          adj = this.proxAdj (v);
        }
      }
    return grafoT;
  }
}
