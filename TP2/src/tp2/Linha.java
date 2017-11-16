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
public class Linha {
        private int custosEstacoes[];
        private int custosTransportes[];

        public Linha(int[] custosEstacoes, int[] custosTransportes) {
            this.custosEstacoes = custosEstacoes;
            this.custosTransportes = custosTransportes;
        }

        public int[] getCustosEstacoes() {
            return custosEstacoes;
        }

        public void setCustosEstacoes(int[] custosEstacoes) {
            this.custosEstacoes = custosEstacoes;
        }

        public int[] getCustosTransportes() {
            return custosTransportes;
        }

        public void setCustosTransportes(int[] custosTransportes) {
            this.custosTransportes = custosTransportes;
        }
    
}
