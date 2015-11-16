package br.com.cwi.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.cwi.crescer.simple.LinkedList;

public class LinkedListTest {

    @Test
    public void adicionaPrimeiroNaLista() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        assertEquals(linkedList.getFirst(), "terceiro");
        assertEquals(linkedList.getLast(), "primeiro");
    }

    @Test
    public void removePrimeiroDaLista() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("segundo");
        linkedList.addFirst("primeiro");
        linkedList.removeFirst();
        assertEquals(linkedList.getFirst(), "segundo");
    }

    @Test
    public void removePrimeiroDaListaComLast() {
        LinkedList linkedList = new LinkedList();
        linkedList.addLast("terceiro");
        linkedList.addFirst("primeiro");
        assertEquals(linkedList.getFirst(), "terceiro");
    }

}
