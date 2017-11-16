/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

/**
 *
 * @author mateus
 */
public class DynamicProgramming {
    
    
    private Linha A1, A2;  //linhas de produção
    private int i; //variável a ser iterada no método recursivo
    private int[] f1, f2; //vetores para se guardar os custos mínimos
    private int[] l1, l2; //vetores para se guardar o caminho de quais linhas devem ser seguidas
    private int fFinal, lFinal;

    public DynamicProgramming(Linha A1, Linha A2) {
        this.A1 = A1;
        this.A2 = A2;
        this.i = 1;
        this.f1 = new int[A1.getCustosEstacoes().length - 2];
        this.f2 = new int[A2.getCustosEstacoes().length - 2];
        this.l1 = new int[A1.getCustosEstacoes().length - 2];
        this.l2 = new int[A2.getCustosEstacoes().length - 2];
        
        f1[0] = A1.getCustosEstacoes()[0] + A1.getCustosEstacoes()[1];  //inicializa a primeira posição do primeiro vetor dos caminhos mínimos 
        f2[0] = A2.getCustosEstacoes()[0] + A2.getCustosEstacoes()[1];  //inicializa a primeira posição do segundo vetor dos caminhos mínimos 
    }

    public Linha getA1() {
        return A1;
    }

    public void setA1(Linha A1) {
        this.A1 = A1;
    }

    public Linha getA2() {
        return A2;
    }

    public void setA2(Linha A2) {
        this.A2 = A2;
    }
    
    
    public void calculaCaminhoMinimo(){  //metodo recursivo para calcular o caminho mínimo entre a entrada e saída
        for(i = 1; i < A1.getCustosEstacoes().length - 2; i++){
            if(f1[i-1] + A1.getCustosEstacoes()[i] <= f2[i-1] + A2.getCustosTransportes()[i-1] + A1.getCustosEstacoes()[i]){
                f1[i] = f1[i-1] + A1.getCustosEstacoes()[i];
                l1[i] = 1;
            } else{
                f1[i] = f2[i-1] + A2.getCustosTransportes()[i] + A1.getCustosEstacoes()[i];
                l1[i] = 2;
            }
            
            if(f2[i-1] + A2.getCustosEstacoes()[i] <= f1[i-1] + A1.getCustosTransportes()[i-1] + A2.getCustosEstacoes()[i]){
                f2[i] = f2[i-1] + A2.getCustosEstacoes()[i];
                l2[i] = 2;
            } else{
                f2[i] = f1[i-1] + A1.getCustosTransportes()[i] + A2.getCustosEstacoes()[i];
                l2[i] = 1;
            }
            
        }
        
        if(f1[i-1] + A1.getCustosEstacoes()[A1.getCustosEstacoes().length - 1] <= f2[i-1] + A2.getCustosEstacoes()[A2.getCustosEstacoes().length - 1]){
            fFinal = f1[i-1] + A1.getCustosEstacoes()[A1.getCustosEstacoes().length - 1];
            lFinal = 1;
        }else{
            fFinal = f2[i-1] + A2.getCustosEstacoes()[A2.getCustosEstacoes().length - 1];
            lFinal = 2;
        }
            
    }
    
    public void printaVetor(int[] v){
        
        for(int i = 0; i < v.length; i++){
            System.out.print(v[i] + ", ");
        }
    }
    
    public void printaCaminhoMinimo(){
        int j = lFinal;
        printaVetor(f1);
        System.out.println("\n");
        printaVetor(f2);
        System.out.println("\n");
        printaVetor(l1);
        System.out.println("\n");
        printaVetor(l2);
        
        System.out.println("\nline" + j + ", station " + (A1.getCustosEstacoes().length - 2));
        
        /*for(i = A1.getCustosEstacoes().length - 2; i > 1; i--){
            if(j == 1)
                j = l1[i-1];
            else
                j = l2[i-1];
            
            System.out.println("line" + j + ", station" + (j-1));
            
        }*/
    }
    
    
    
    
    
}
