package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;

    protected int[] tipoMoeda = {2, 5, 10, 20, 50, 100};

    public Troco(int valor) {

        papeisMoeda = new PapelMoeda[tipoMoeda.length];

        int k = tipoMoeda.length;
        int i = 0;
        int j = -1;

        while (i < tipoMoeda.length) {
            if (valor == 3 || valor == 1) {
                int quantidade = 0;
                int auxJ = j;

                while (quantidade == 0) {

                    quantidade = papeisMoeda[k - auxJ - 1].getQuantidade();
                    auxJ--;

                }
                auxJ++;

                int valorCedula = papeisMoeda[k - auxJ - 1].getValor() * papeisMoeda[k - auxJ - 1].getQuantidade();
                valor += valorCedula;
                switch (quantidade) {

                    case 1:
                        papeisMoeda[k - auxJ - 1].setQuantidade(0);
                        break;
                    case 2:
                        papeisMoeda[k - auxJ - 1].setQuantidade(1);
                        break;
                    case 3:
                        papeisMoeda[k - auxJ - 1].setQuantidade(2);
                        break;
                    case 4:
                        papeisMoeda[k - auxJ - 1].setQuantidade(3);
                        break;
                    case 5:
                        papeisMoeda[k - auxJ - 1].setQuantidade(4);
                        break;

                }
                if(quantidade > 5){
                    papeisMoeda[k - auxJ - 1].setQuantidade(quantidade-1);
                }
                valor = valor - (papeisMoeda[k - auxJ - 1].getQuantidade() * papeisMoeda[k - auxJ - 1].getValor());

            }

            if (valor / tipoMoeda[k - i - 1] != 0) {

                papeisMoeda[k - i - 1] = new PapelMoeda(tipoMoeda[k - i - 1], valor / tipoMoeda[k - i - 1]);

                valor = valor - (papeisMoeda[k - i - 1].getQuantidade() * papeisMoeda[k - i - 1].getValor());

            }

            i++;
            j++;
        }

        normalizePapeisMoeda();

    }

    public Iterator getIterator() {
        return new TrocoIterator(this);
    }

    private void normalizePapeisMoeda() {
        for (int i = 0; i < this.papeisMoeda.length; i++) {
            if (papeisMoeda[i] == null) {
                papeisMoeda[i] = new PapelMoeda(tipoMoeda[i], 0);
            }
        }
    }

}
