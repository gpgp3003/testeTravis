/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * autor Leonardo Fuso
 */
package br.calebe.ticketmachine.core;

import java.util.Iterator;



class TrocoIterator implements Iterator<PapelMoeda>{

    
    private static int ponteiro;
    private final Troco troco;
    
    public TrocoIterator(Troco troco) {
        this.troco = troco;
        TrocoIterator.ponteiro = 0;
    }

   
    @Override
    public boolean hasNext() {
        return ponteiro < troco.papeisMoeda.length; 
    }

  
    @Override
    public PapelMoeda next() {      
        if (this.hasNext()) {         
            return troco.papeisMoeda[ponteiro++];         
        }      
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
}
