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
        
        l1[0] = 1;
        l2[0] = 2;
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
        for(i = 2; i < A1.getCustosEstacoes().length - 2; i++){
            int custo1 = f1[i-2] + A1.getCustosEstacoes()[i];
            int custo2 = f2[i-2] + A2.getCustosTransportes()[i-2] + A1.getCustosEstacoes()[i];
                    
            if(custo1 <= custo2){
                f1[i-1] = custo1;
                l1[i-1] = l1[i-2];
            } else{
                f1[i-1] = custo2;
                if(l1[i-2] == 1)
                    l1[i-1] = 2;
                else l1[i-1] = 1;
            }
            
            custo1 = f2[i-2] + A2.getCustosEstacoes()[i];
            custo2 = f1[i-2] + A1.getCustosTransportes()[i-2] + A2.getCustosEstacoes()[i];
            
            if(custo1 <= custo2){
                f2[i-1] = custo1;
                l2[i-2] = l2[i-1];
            } else{
                f2[i-1] = custo2;
                if(l2[i-2] == 2)
                    l2[i-1] = 1;
                else l2[i-1] = 2;
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
        System.out.println();
        printaVetor(f2);
        System.out.println("\n");
        printaVetor(l1);
        System.out.println();
        printaVetor(l2);
        System.out.println();
        
        System.out.println("\nline " + j + ", station " + (A1.getCustosEstacoes().length - 2));
        
        for (int i = 0; i < l1.length; i++) {
                System.out.println("Linha: " + (l1[i]) + ", estacao: " + (i + 1));
            }
        /*for(i = A1.getCustosEstacoes().length - 2; i > 1; i--){
            if(j == 1)
                j = l1[i-1];
            else
                j = l2[i-1];
            
            System.out.println("line" + j + ", station" + (j-1));
            
        }*/
    }
    
    
    
    
    
}
