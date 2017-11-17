/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import pratica7.*;

/**
 *
 * @author mateus
 */
public class TP2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        int[] custoEstacaoA1 = new int[]{2, 7, 9, 3, 4, 8, 4, 3};  //declara o array de custos da primeira linha, sendo a primeira e ultima posições os custos de entrada e saída
        int[] custoEstacaoA2 = new int[]{4, 8, 5, 6, 4, 5, 7, 2};  //declara o array de custos da segunda linha, sendo a primeira e ultima posições os custos de entrada e saída
        
        int[] custoTransportesA1 = new int[]{2, 3, 1, 3, 4};  //declara o array de custos do transporte da estação da primeira linha para a próxima da segunda linha
        int[] custoTransportesA2 = new int[]{2, 1, 2, 2, 1};  //declara o array de custos do transporte da estação da primeira linha para a próxima da segunda linha
        
        Linha A1 = new Linha(custoEstacaoA1, custoTransportesA1);  //cria a linha A1 com seus respectivos custos de estações e transportes
        Linha A2 = new Linha(custoEstacaoA2, custoTransportesA2);  //cria a linha A2 com seus respectivos custos de estações e transportes
        
        System.out.println("\nPROGRAMACAO DINAMICA:\n");
        
//        System.out.println(A1.getCustosEstacoes()[A1.getCustosEstacoes().length - 2]);
        DynamicProgramming dinamico = new DynamicProgramming(A1, A2);
        dinamico.calculaCaminhoMinimo();
        dinamico.printaCaminhoMinimo();
        
        Montagem mon = new Montagem(custoEstacaoA1, custoEstacaoA2, custoTransportesA1, custoTransportesA2);
        
        System.out.println("\nPROGRAMACAO DINAMICA:\n");
        
        custoEstacaoA1 = new int[]{3, 5, 7, 10, 5, 9, 11, 9, 5, 2, 6};
        custoEstacaoA2 = new int[]{2, 6, 3, 9, 11, 4, 9, 3, 12, 4, 5};
        custoTransportesA1 = new int[]{3, 5, 4, 2, 7, 5, 8, 1};
        custoTransportesA2 = new int[]{5, 3, 7, 5, 6, 2, 5, 2};
        
        A1 = new Linha(custoEstacaoA1, custoTransportesA1);  //cria a linha A1 com seus respectivos custos de estações e transportes
        A2 = new Linha(custoEstacaoA2, custoTransportesA2);  //cria a linha A2 com seus respectivos custos de estações e transportes
        
//        System.out.println(A1.getCustosEstacoes()[A1.getCustosEstacoes().length - 2]);
        dinamico = new DynamicProgramming(A1, A2);
        dinamico.calculaCaminhoMinimo();
        dinamico.printaCaminhoMinimo();
        
        mon = new Montagem(custoEstacaoA1, custoEstacaoA2, custoTransportesA1, custoTransportesA2);
        
        System.out.println("\nPROGRAMACAO DINAMICA:\n");

        custoEstacaoA1 = new int[]{5, 10, 6, 3, 8, 5, 3, 7, 12, 8};
        custoEstacaoA2 = new int[]{7, 3, 5, 3, 7, 6, 4, 9, 10, 9};
        custoTransportesA1 = new int[]{4, 2, 7, 2, 5, 8, 2};
        custoTransportesA2 = new int[]{6, 1, 7, 3, 6, 4, 5};
        
        A1 = new Linha(custoEstacaoA1, custoTransportesA1);  //cria a linha A1 com seus respectivos custos de estações e transportes
        A2 = new Linha(custoEstacaoA2, custoTransportesA2);  //cria a linha A2 com seus respectivos custos de estações e transportes
        
//        System.out.println(A1.getCustosEstacoes()[A1.getCustosEstacoes().length - 2]);
        dinamico = new DynamicProgramming(A1, A2);
        dinamico.calculaCaminhoMinimo();
        dinamico.printaCaminhoMinimo();
        
        mon = new Montagem(custoEstacaoA1, custoEstacaoA2, custoTransportesA1, custoTransportesA2);
        
    }
    
}
