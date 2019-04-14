/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.ConstructException;
import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import br.calebe.ticketmachine.exception.TrocoInsuficienteException;
import java.util.Iterator;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author 31500129
 */
public class TicketMachineTest {

    public TicketMachineTest() {
    }

    /**
     * Test of inserir method, of class TicketMachine.
     *
     * @throws br.calebe.ticketmachine.exception.ConstructException
     */
    
    @Test(expected = ConstructException.class)
    public void testConstruirNulo() throws ConstructException {
        System.out.println("Construir com valor Nulo");
        try {
            TicketMachine ticketMachine = new TicketMachine(0);
        } catch (ConstructException e) {
            System.out.println("Sucesso.");
            throw new ConstructException("Valor nulo de preço.");
        }
    }

    @Test(expected = ConstructException.class)
    public void testConstruirNegativo() throws ConstructException {
        System.out.println("Construir com valor Negativo");
        try {
            TicketMachine ticketMachine = new TicketMachine(-1);
            TicketMachine ticketMachine1 = new TicketMachine(-3);
            TicketMachine ticketMachine2 = new TicketMachine(-4);
            TicketMachine ticketMachine3 = new TicketMachine(-5);
            TicketMachine ticketMachine4 = new TicketMachine(-7);
            TicketMachine ticketMachine5 = new TicketMachine(-123);
            System.out.println("Falha");
        } catch (ConstructException e) {
            System.out.println("Sucesso.");
            throw new ConstructException("Valor negativo de preço.");
        }
    }

    @Test
    public void testConstruirValorValido() throws ConstructException {
        System.out.println("Construir com valor válido");
        try {
            TicketMachine ticketMachine = new TicketMachine(4);
            TicketMachine ticketMachine1 = new TicketMachine(5);
            TicketMachine ticketMachine2 = new TicketMachine(6);
            TicketMachine ticketMachine3 = new TicketMachine(7);
            TicketMachine ticketMachine4 = new TicketMachine(8);
            TicketMachine ticketMachine5 = new TicketMachine(14);
            TicketMachine ticketMachine6 = new TicketMachine(19);
            TicketMachine ticketMachine7 = new TicketMachine(11);

            assertEquals(4, ticketMachine.getPrecoDoBilhete());
            assertEquals(0, ticketMachine.getSaldo());
            assertEquals(5, ticketMachine1.getPrecoDoBilhete());
            assertEquals(0, ticketMachine1.getSaldo());
            assertEquals(6, ticketMachine2.getPrecoDoBilhete());
            assertEquals(0, ticketMachine2.getSaldo());
            assertEquals(7, ticketMachine3.getPrecoDoBilhete());
            assertEquals(0, ticketMachine3.getSaldo());
            assertEquals(8, ticketMachine4.getPrecoDoBilhete());
            assertEquals(0, ticketMachine4.getSaldo());
            assertEquals(14, ticketMachine5.getPrecoDoBilhete());
            assertEquals(0, ticketMachine5.getSaldo());
            assertEquals(19, ticketMachine6.getPrecoDoBilhete());
            assertEquals(0, ticketMachine6.getSaldo());
            assertEquals(11, ticketMachine7.getPrecoDoBilhete());
            assertEquals(0, ticketMachine7.getSaldo());

            //new TicketMachine(-2);
            System.out.println("Sucesso.");
        } catch (ConstructException e) {
            System.out.println("Falhou.");
            throw new ConstructException("Valor de preço deveria ser válido.");
        }

    }

    @Test
    public void testInserirValido() throws PapelMoedaInvalidaException, ConstructException {
        System.out.println("Inserir valores Válidos");
        System.out.println("Inserir e getSaldo");

        int quantia = 2;
        int quantia2 = 5;
        int quantia3 = 10;
        int quantia4 = 20;
        int quantia5 = 50;
        int quantia6 = 100;

        TicketMachine instance = new TicketMachine(2);
        TicketMachine instance2 = new TicketMachine(2);
        TicketMachine instance3 = new TicketMachine(2);
        TicketMachine instance4 = new TicketMachine(2);
        TicketMachine instance5 = new TicketMachine(2);
        TicketMachine instance6 = new TicketMachine(2);

        instance.inserir(quantia);
        assertEquals(quantia, instance.getSaldo());
        instance.inserir(quantia);
        assertEquals(quantia + quantia, instance.getSaldo());
        instance.inserir(quantia);
        assertEquals(quantia + quantia + quantia, instance.getSaldo());
        instance.inserir(quantia2);
        assertEquals((quantia * 3) + (quantia2), instance.getSaldo());
        instance.inserir(quantia4);
        assertEquals((quantia * 3) + (quantia2) + (quantia4), instance.getSaldo());
        instance.inserir(quantia5);
        instance.inserir(quantia5);
        assertEquals((quantia * 3) + (quantia2) + (quantia4) + (quantia5 * 2), instance.getSaldo());
        instance.inserir(quantia6);
        instance.inserir(quantia6);
        instance.inserir(quantia6);
        assertEquals((quantia * 3) + (quantia2) + (quantia4) + (quantia5 * 2) + (quantia6 * 3), instance.getSaldo());

        instance2.inserir(quantia2);
        assertEquals(quantia2, instance2.getSaldo());

        instance3.inserir(quantia3);
        assertEquals(quantia3, instance3.getSaldo());

        instance4.inserir(quantia4);
        assertEquals(quantia4, instance4.getSaldo());

        instance5.inserir(quantia5);
        assertEquals(quantia5, instance5.getSaldo());

        instance6.inserir(quantia6);
        assertEquals(quantia6, instance6.getSaldo());

    }

    @Test(expected = PapelMoedaInvalidaException.class)
    public void testInserirInvalido() throws PapelMoedaInvalidaException, ConstructException {
        System.out.println("Inserir valores inválidos");
        System.out.println("Inserir e getSaldo");
        int quantia = 1;
        int quantia2 = 3;
        int quantia3 = 4;
        int quantia4 = -1;
        int quantia5 = 12;
        int quantia6 = 44;

        TicketMachine instance = new TicketMachine(2);
        TicketMachine instance2 = new TicketMachine(2);
        TicketMachine instance3 = new TicketMachine(2);
        TicketMachine instance4 = new TicketMachine(2);
        TicketMachine instance5 = new TicketMachine(2);
        TicketMachine instance6 = new TicketMachine(2);

        instance.inserir(quantia);
        assertEquals(quantia, instance.getSaldo());
        instance.inserir(quantia);
        assertEquals(quantia + quantia, instance.getSaldo());
        instance.inserir(quantia);
        assertEquals(quantia + quantia + quantia, instance.getSaldo());
        instance.inserir(quantia2);
        assertEquals((quantia * 3) + (quantia2), instance.getSaldo());
        instance.inserir(quantia4);
        assertEquals((quantia * 3) + (quantia2) + (quantia4), instance.getSaldo());
        instance.inserir(quantia5);
        instance.inserir(quantia5);
        assertEquals((quantia * 3) + (quantia2) + (quantia4) + (quantia5 * 2), instance.getSaldo());
        instance.inserir(quantia6);
        instance.inserir(quantia6);
        instance.inserir(quantia6);
        assertEquals((quantia * 3) + (quantia2) + (quantia4) + (quantia5 * 2) + (quantia6 * 3), instance.getSaldo());

        instance2.inserir(quantia2);
        assertEquals(quantia2, instance2.getSaldo());

        instance3.inserir(quantia3);
        assertEquals(quantia3, instance3.getSaldo());

        instance4.inserir(quantia4);
        assertEquals(quantia4, instance4.getSaldo());

        instance5.inserir(quantia5);
        assertEquals(quantia5, instance5.getSaldo());

        instance6.inserir(quantia6);
        assertEquals(quantia6, instance6.getSaldo());
    }

    /**
     * Test of getSaldo method, of class TicketMachine.
     *
     * @throws br.calebe.ticketmachine.exception.ConstructException
     * @throws br.calebe.ticketmachine.exception.PapelMoedaInvalidaException
     */
    @Test
    public void testGetSaldo() throws ConstructException, PapelMoedaInvalidaException {
        System.out.println("getSaldo função simples");
        TicketMachine instance = new TicketMachine(2);
        int expResult = 0;
        int quantia = 100;
        int result = instance.getSaldo();
        assertEquals(expResult, result);
        instance.inserir(quantia);
        result = instance.getSaldo();
        expResult = 100;
        assertEquals(expResult, result);

    }

    /**
     * Test of getTroco method, of class TicketMachine.
     *
     * @throws br.calebe.ticketmachine.exception.ConstructException
     * @throws br.calebe.ticketmachine.exception.PapelMoedaInvalidaException
     * @throws br.calebe.ticketmachine.exception.SaldoInsuficienteException
     * @throws br.calebe.ticketmachine.exception.TrocoInsuficienteException
     */
    

   @Test
    public void testGetTrocoValido() throws ConstructException, PapelMoedaInvalidaException, SaldoInsuficienteException, TrocoInsuficienteException {
        System.out.println("Função getTroco");
        TicketMachine instance;
        Iterator iterador;
        instance = new TicketMachine(4);

        instance.inserir(10);
        instance.imprimir();

        iterador = instance.getTroco();

        PapelMoeda[] papeisMoeda = {new PapelMoeda(2, 3), new PapelMoeda(5, 0), new PapelMoeda(10, 0), new PapelMoeda(20, 0), new PapelMoeda(50, 0), new PapelMoeda(100, 0)};
        int i = 0;

        while (iterador.hasNext()) {

            PapelMoeda next = (PapelMoeda) iterador.next();
            if (next != null) {
          
                assertEquals(papeisMoeda[i].getQuantidade(), next.getQuantidade());
                assertEquals(papeisMoeda[i].getValor(), next.getValor());
              
                i++;
            }

        }
        i = 0;
        instance = new TicketMachine(1);
        instance.inserir(10);
        instance.imprimir();
        iterador = instance.getTroco();
        PapelMoeda[] papeisMoeda2 = {new PapelMoeda(2, 2), new PapelMoeda(5, 1), new PapelMoeda(10, 0), new PapelMoeda(20, 0), new PapelMoeda(50, 0), new PapelMoeda(100, 0)};
        while (iterador.hasNext()) {

            PapelMoeda next = (PapelMoeda) iterador.next();
            if (next != null) {
          
                assertEquals(papeisMoeda2[i].getQuantidade(), next.getQuantidade());
                assertEquals(papeisMoeda2[i].getValor(), next.getValor());
              
                i++;
            }

        }
        i = 0;
        instance = new TicketMachine(1);
        instance.inserir(10);
        instance.inserir(2);
        instance.imprimir();
        iterador = instance.getTroco();
        PapelMoeda[] papeisMoeda3 = {new PapelMoeda(2, 3), new PapelMoeda(5, 1), new PapelMoeda(10, 0), new PapelMoeda(20, 0), new PapelMoeda(50, 0), new PapelMoeda(100, 0)};
        while (iterador.hasNext()) {

            PapelMoeda next = (PapelMoeda) iterador.next();
            if (next != null) {
           
                assertEquals(papeisMoeda3[i].getQuantidade(), next.getQuantidade());
                assertEquals(papeisMoeda3[i].getValor(), next.getValor());
            
                i++;
            }

        }

        i = 0;
        instance = new TicketMachine(5);
        instance.inserir(10);
        instance.imprimir();
        iterador = instance.getTroco();
        PapelMoeda[] papeisMoeda4 = {new PapelMoeda(2, 0), new PapelMoeda(5, 1), new PapelMoeda(10, 0), new PapelMoeda(20, 0), new PapelMoeda(50, 0), new PapelMoeda(100, 0)};
        while (iterador.hasNext()) {

            PapelMoeda next = (PapelMoeda) iterador.next();
            if (next != null) {
           
               
                assertEquals(papeisMoeda4[i].getQuantidade(), next.getQuantidade());
                assertEquals(papeisMoeda4[i].getValor(), next.getValor());
                
                i++;
            }

        }
        
        i = 0;
        instance = new TicketMachine(5);
        instance.inserir(20);
        instance.inserir(10);
        instance.imprimir();
        iterador = instance.getTroco();
        PapelMoeda[] papeisMoeda5 = {new PapelMoeda(2, 0), new PapelMoeda(5, 1), new PapelMoeda(10, 0), new PapelMoeda(20, 1), new PapelMoeda(50, 0), new PapelMoeda(100, 0)};
        while (iterador.hasNext()) {

            PapelMoeda next = (PapelMoeda) iterador.next();
            if (next != null) {
                           
                assertEquals(papeisMoeda5[i].getQuantidade(), next.getQuantidade());
                assertEquals(papeisMoeda5[i].getValor(), next.getValor());
                
                i++;
            }

        }

    }
    
    @Test
    public void testGetTrocoValidoEspecifico() throws ConstructException, PapelMoedaInvalidaException, SaldoInsuficienteException, TrocoInsuficienteException {
        System.out.println("Função getTroco");
        TicketMachine instance;
        Iterator iterador;
        instance = new TicketMachine(4);

        instance.inserir(100);
        instance.inserir(100);
        instance.inserir(100);
        instance.inserir(100);
        instance.inserir(100);
        instance.inserir(100);
        instance.inserir(5);
        instance.imprimir();

        iterador = instance.getTroco();

        PapelMoeda[] papeisMoeda = {new PapelMoeda(2, 3), new PapelMoeda(5, 1), new PapelMoeda(10, 0), new PapelMoeda(20, 2), new PapelMoeda(50, 1), new PapelMoeda(100, 5)};
        int i = 0;

        while (iterador.hasNext()) {

            PapelMoeda next = (PapelMoeda) iterador.next();
            if (next != null) { 
                
                assertEquals(papeisMoeda[i].getQuantidade(), next.getQuantidade());
                assertEquals(papeisMoeda[i].getValor(), next.getValor());
              
                i++;
            }

        }
    }
    
    
    

    @Test(expected = TrocoInsuficienteException.class)
    public void testGetTrocoInvalido() throws ConstructException, PapelMoedaInvalidaException, SaldoInsuficienteException, TrocoInsuficienteException {
        System.out.println("Função getTroco Inválida");
        TicketMachine instance;
        Iterator iterador;
        instance = new TicketMachine(4);

        instance.inserir(5);
        instance.imprimir();

        iterador = instance.getTroco();

        instance = new TicketMachine(2);

        instance.inserir(5);
        instance.imprimir();

        iterador = instance.getTroco();

    }

    /**
     * Test of imprimir method, of class TicketMachine.
     * @throws java.lang.Exception
     */
    @Test
    public void testImprimirValido() throws Exception {
        System.out.println("Teste Imprimir");
        TicketMachine instance;
        instance = new TicketMachine(10);
        instance.inserir(20);
        instance.imprimir();
        assertEquals(10, instance.getSaldo());
        
        instance = new TicketMachine(1);
        instance.inserir(20);
        instance.imprimir();
        assertEquals(19, instance.getSaldo());
        
        instance = new TicketMachine(4);
        instance.inserir(5);
        instance.imprimir();
        assertEquals(1, instance.getSaldo());
        
        instance = new TicketMachine(2);
        instance.inserir(10);
        instance.imprimir();
        assertEquals(8, instance.getSaldo());                             
    }
    
    @Test(expected = SaldoInsuficienteException.class)
    public void testImprimirInvalido() throws ConstructException, PapelMoedaInvalidaException, SaldoInsuficienteException{
        System.out.println("Teste Imprimir Inválido");
        TicketMachine instance;
        instance = new TicketMachine(10);
        instance.inserir(5);
        instance.imprimir();
             
        instance = new TicketMachine(5);
        instance.inserir(2);
        instance.imprimir();
        
        
        instance = new TicketMachine(50);
        instance.inserir(20);
        instance.imprimir();
      
        
        instance = new TicketMachine(3);
        instance.inserir(2);
        instance.imprimir();
          
    }
     
}
