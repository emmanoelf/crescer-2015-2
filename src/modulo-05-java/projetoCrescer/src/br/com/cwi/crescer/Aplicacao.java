package br.com.cwi.crescer;

import br.com.cwi.crescer.simple.LinkedList;

public class Aplicacao {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        // linkedList.addLast("terceiro");
        linkedList.addFirst("terceiro");
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        // linkedList.addFirst("primeiroprimeiro");
        linkedList.removeFirst();
        System.out.println(linkedList.list());
    }
}
