package br.com.cwi.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import br.com.cwi.crescer.simple.LinkedList;

public class LinkedListTest {

    @Test
    public void adicionaPrimeiroNaLista() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        String resultadoFirstEsperado = "terceiro";
        String resultadoLastEsperado = "primeiro";
        assertEquals(linkedList.getFirst(), resultadoFirstEsperado);
        assertEquals(linkedList.getLast(), resultadoLastEsperado);
    }

    @Test
    public void adicionarUltimoNaLista() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addLast("ultimo");
        String resultadoEsperado = "ultimo";
        assertEquals(linkedList.getLast(), resultadoEsperado);
    }

    @Test
    public void removePrimeiroDaLista() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("segundo");
        linkedList.addFirst("primeiro");
        linkedList.removeFirst();
        String resultadoEsperado = "segundo";
        assertEquals(linkedList.getFirst(), resultadoEsperado);
    }

    @Test
    public void removerDaListaComLast() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addLast("ultimo");
        linkedList.removeFirst();
        String resultadoEsperado = "ultimo";
        assertEquals(linkedList.getFirst(), resultadoEsperado);
    }

    @Test
    public void removerComIndice() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.remove(1);
        String resultadoEsperado = "segundo";
        assertEquals(linkedList.getFirst(), resultadoEsperado);
    }

    @Test
    public void adicionarNodeNoMeio() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addLast("terceiro");
        linkedList.addMiddle(1, "segundo");
        ArrayList<String> ordemEsperada = new ArrayList<>(Arrays.asList("primeiro", "segundo", "terceiro"));
        assertEquals(linkedList.list(), ordemEsperada);
    }
}
