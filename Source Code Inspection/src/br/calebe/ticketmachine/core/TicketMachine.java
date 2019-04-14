package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.ConstructException;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import br.calebe.ticketmachine.exception.TrocoInsuficienteException;
import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
public class TicketMachine {

    private int precoDoBilhete;
    private int saldo;
    
    public TicketMachine(int precoDoBilhete) throws ConstructException {
        if (precoDoBilhete <= 0) {
            throw new ConstructException("Preço negativo.");
        } else {
            this.precoDoBilhete = precoDoBilhete;
            this.saldo = 0;
        }

    }

    public int getPrecoDoBilhete() {
        return this.precoDoBilhete;
    }

    public void inserir(int quantia) throws PapelMoedaInvalidaException {
 
        System.out.println("Aguarde alguns instantes.");
        switch (quantia) {
            case 2:
                this.saldo += quantia;
                break;
            case 5:
                this.saldo += quantia;
                break;
            case 10:
                this.saldo += quantia;
                break;
            case 20:
                this.saldo += quantia;
                break;
            case 50:
                this.saldo += quantia;
                break;
            case 100:
                this.saldo += quantia;
                break;
            default:
                throw new PapelMoedaInvalidaException("Nota é inválida.");
        }
        System.out.println("Nota aceita.");

    }

    public int getSaldo() {
        return saldo;
    }
    
    public Iterator getTroco() throws TrocoInsuficienteException{
        if(this.saldo == 1 || this.saldo == 3){
         throw new TrocoInsuficienteException("Não há troco disponível para essa quantidade de saldo.");
        }
       return new Troco(this.saldo).getIterator(); 
    }
  

    public String imprimir() throws SaldoInsuficienteException {

        verificaSaldo();
        this.saldo -= this.precoDoBilhete;
        String result = "*****************\n";
        result += "*** R$ " + saldo + ",00 ****\n";
        result += "*****************\n";
        return result;
    }

    //verifica o saldo
    private void verificaSaldo() throws SaldoInsuficienteException {
        if (saldo < precoDoBilhete) {
            throw new SaldoInsuficienteException("Saldo é insuficiente. Insira mais cédulas ou solicite o troco.");
        }

    }

    
}
