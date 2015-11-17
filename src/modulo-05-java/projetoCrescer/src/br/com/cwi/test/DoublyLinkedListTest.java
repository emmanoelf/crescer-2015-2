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

}
