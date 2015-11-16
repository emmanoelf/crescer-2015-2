package br.com.cwi.crescer.simple;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    private Node last, first;

    public void addFirst(String value) {
        Node node = new Node(value, first);
        if (first == null) {
            last = node;
        }
        first = node;

    }

    public String getFirst() {
        return first.getValue();
    }

    public String getLast() {
        return last.getValue();
    }

    public List<String> list() {
        ArrayList<String> list = new ArrayList<String>();
        Node node = first;
        while (node != null) {
            list.add(node.getValue());
            node = node.getNext();
        }
        return list;
    }

    public void addLast(String value) {
        Node node = new Node(value, last);
        if (first == null) {
            first = node;
        }
        last.setNext(node);
        last = node;
    }

    public void removeFirst() {
        first = first.getNext();
    }

    public void addMiddle(int index, String value) {

    }

    public boolean isEmpty() {
        return first == null;
    }

    public void remove(int index) {

    }

    protected class Node {

        private String value;
        private Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node node) {
            this.next = node;
        }
    }
}
