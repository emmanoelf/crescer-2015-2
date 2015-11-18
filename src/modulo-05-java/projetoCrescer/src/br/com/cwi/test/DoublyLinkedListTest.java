package br.com.cwi.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import br.com.cwi.crescer.complex.DoublyLinkedList;


public class DoublyLinkedListTest {

    @Test
    public void adicionarNodeFirst() {
        DoublyLinkedList doublyLinked = new DoublyLinkedList();
        doublyLinked.addFirst("primeiro");
        doublyLinked.addFirst("segundo");
        ArrayList<String> ordemEsperada = new ArrayList<>(Arrays.asList("segundo", "primeiro"));
        assertEquals(doublyLinked.list(), ordemEsperada);
    }

    @Test
    public void adicionarNodeLast() {
        DoublyLinkedList doublyLinked = new DoublyLinkedList();
        doublyLinked.addLast("ultimo");
        doublyLinked.addLast("ultimodosultimos");
        assertEquals(doublyLinked.getLast(), "ultimodosultimos");
    }

    @Test
    public void adicionarNodeMiddle() {
        DoublyLinkedList doublyLinked = new DoublyLinkedList();
        doublyLinked.addFirst("primeiro");
        doublyLinked.addLast("terceiro");
        doublyLinked.addMiddle(1, "segundo");
        ArrayList<String> ordemEsperada = new ArrayList<>(Arrays.asList("primeiro", "segundo", "terceiro"));
        assertEquals(doublyLinked.list(), ordemEsperada);
    }

    @Test
    public void removerPrimeiroDaLista() {
        DoublyLinkedList doublyLinked = new DoublyLinkedList();
        doublyLinked.addFirst("primeiro");
        doublyLinked.addFirst("ultimo");
        doublyLinked.removeFirst();
        String resultadoEsperado = "primeiro";
        assertEquals(doublyLinked.getFirst(), resultadoEsperado);
    }

    @Test
    public void removerDaListaPorIndice() {
        DoublyLinkedList doublyLinked = new DoublyLinkedList();
        doublyLinked.addFirst("primeiro");
        doublyLinked.addLast("ultimo");
        doublyLinked.addMiddle(1, "meio");
        doublyLinked.remove(2);
        ArrayList<String> ordemEsperada = new ArrayList<>(Arrays.asList("primeiro", "meio"));
        assertEquals(doublyLinked.list(), ordemEsperada);
    }

}
