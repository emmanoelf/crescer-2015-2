package br.com.cwi.crescer.simple;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    private Node last, first;

    public void addFirst(String value) {
        Node node = new Node(value, first);
        if (isEmpty()) {
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
        Node node = new Node(value);
        if (isEmpty()) {
            first = node;
        }
        last.setNext(node);
        last = node;
    }

    public void removeFirst() {
        first = first.getNext();
    }

    public void addMiddle(int index, String value) {
        Node temp = getNode(index - 1);
        Node nextNode = getNode(index);
        temp.setNext(new Node(value, nextNode));
    }

    public void remove(int index) {
        Node temp = getNode(index - 1);
        Node removed = temp.getNext();
        temp.setNext(removed.getNext());
    }

    private Node getNode(int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    public boolean isEmpty() {
        return first == null;
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
