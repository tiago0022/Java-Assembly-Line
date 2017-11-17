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
    private int fFinal, lFinal; //valores que armazenarão a saída ótima, sua linha(lFinal) e peso(fFinal)

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
        
        l1[0] = 1;  //inicializa a primeira posição do vetor da ordem das linhas
        l2[0] = 2;  //inicializa a primeira posição do vetor da ordem das linhas
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
    
    
    public void calculaCaminhoMinimo(){  //metodo dinamico para calcular o caminho mínimo entre a entrada e saída
        for(i = 2; i <= A1.getCustosEstacoes().length - 2; i++){  //loop que começa do 2 para que não haja conflitos em arrays diferentes e de tamanhos diferentes
            
              /////LINHA 1/////
            int custo1 = f1[i-2] + A1.getCustosEstacoes()[i];  //calcula o custo de se manter na estação 1
            int custo2 = f2[i-2] + A2.getCustosTransportes()[i-2] + A1.getCustosEstacoes()[i];  //calcula o custo de se trocar para a estação 2
                    
            if(custo1 <= custo2){  //compara qual dos dois custos é melhor para ser armazenado no vetor
                f1[i-1] = custo1;  //armazena o custo 1 na posição de memória adequada do vetor f1 (é a subsolução ótima)
                l1[i-1] = 1;  //armazena que a linha 1 é que contem a subsolução ótima
            } else{
                f1[i-1] = custo2;  //armazena o custo 2 na posição de memória adequada do vetor f1 (é a subsolução ótima)
                l1[i-1] = 2; //armazena que a linha 2 é que contem a subsolução ótima
            }
            
            
              /////LINHA 2/////
            custo1 = f2[i-2] + A2.getCustosEstacoes()[i]; //calcula o custo de se manter na estação 2
            custo2 = f1[i-2] + A1.getCustosTransportes()[i-2] + A2.getCustosEstacoes()[i];  //calcula o custo de se trocar para a estação 1
            
            if(custo1 <= custo2){  //compara qual dos dois custos é melhor para ser armazenado no vetor
                f2[i-1] = custo1;  //armazena o custo 1 na posição de memória adequada do vetor f2 (é a subsolução ótima)
                l2[i-1] = 2;  //armazena que a linha 2 é que contem a subsolução ótima
            } else{
                f2[i-1] = custo2;  //armazena o custo 2 na posição de memória adequada do vetor f2 (é a subsolução ótima)
                l2[i-1] = 1;  //armazena que a linha 1 é que contem a subsolução ótima
            }
            
        }
        
        if(f1[i-2] + A1.getCustosEstacoes()[A1.getCustosEstacoes().length - 1] <= f2[i-2] + A2.getCustosEstacoes()[A2.getCustosEstacoes().length - 1]){  //ao final calcula qual saída é ótima
            fFinal = f1[i-2] + A1.getCustosEstacoes()[A1.getCustosEstacoes().length - 1];  //armazena a saída ótima caso seja a primeira
            lFinal = 1;  //registra que é na linha 1
        }else{
            fFinal = f2[i-2] + A2.getCustosEstacoes()[A2.getCustosEstacoes().length - 1];  //armazena a saída ótima caso seja a primeira
            lFinal = 2;  //registra que é na linha 2
        }
            
    }
    
    public void printaCaminhoMinimo(){
        int j = lFinal;
        System.out.println("Linha: " + j + "   Estação: " + (A1.getCustosEstacoes().length - 2));  //printa a primeira linha antes do loop
        
        for(i = A1.getCustosEstacoes().length - 2; i > 1; i--){  //loop decrescente, da última estação até a primeira
            if(j == 1)  //condição para qual linha deve ser printada, de acordo com os valores salvos nos vetores l1 e l2, na função calculaCaminhoMinimo()
                j = l1[i-1];
            else
                j = l2[i-1];
            
            System.out.println("Linha: " + j + "   Estação: " + (i-1));  //printa as estações e linhas de acordo com os valores previamente armazenados
        }
        System.out.println("\nCusto total: " + fFinal + "\n\n");  //ao final printa o custo total, que é o caminho ótimo
    }
    
    
    
    
    
}
