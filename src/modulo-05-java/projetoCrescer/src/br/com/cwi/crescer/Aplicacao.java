package br.com.cwi.crescer;

import br.com.cwi.crescer.simple.LinkedList;

public class Aplicacao {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        // linkedList.addLast("terceiro");
        // linkedList.addFirst("primeiro");
        // linkedList.addFirst("primeiro");
        // linkedList.addFirst("segundo");
        // linkedList.addFirst("terceiro");
        // linkedList.addMiddle(1, "teste");
        // linkedList.addLast("terceiro");
        // linkedList.addFirst("primeiroprimeiro");
        // linkedList.removeFirst();
        linkedList.addFirst("primeiro");
        linkedList.addLast("terceiro");
        // linkedList.addLast("tercedsiro");
        linkedList.addMiddle(1, "segundo");
        System.out.println(linkedList.list());
    }
}
