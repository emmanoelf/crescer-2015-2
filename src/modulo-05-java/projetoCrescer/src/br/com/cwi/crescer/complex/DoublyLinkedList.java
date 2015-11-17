package br.com.cwi.crescer.complex;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList {

    private Node first;
    private Node last;

    public String getFirst() {
        return first.getValue();
    }

    public String getLast() {
        return last.getValue();
    }

    public void addFirst(String value) {
        Node node = new Node(value, first, null);
        if (isEmpty()) {
            first = node;
            last = node;
        }
        first.setPrevious(node);
        first = node;
    }

    public void addLast(String value) {
        Node node = new Node(value, null, last);
        if (isEmpty()) {
            first = node;
            first.setNext(last);
            last = node;
        }
        last.setNext(node);
        last.setPrevious(node.getPrevious());
        last = node;
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

    public void addMiddle(int index, String value) {
        Node node = getNode(index);
        if (isEmpty()) {
            addFirst(value);
            return;
        }
        Node temp = new Node(value);
        node.setNext(temp);
        temp.setPrevious(node);
        temp.setNext(node);
        node = temp;
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
        private Node previous;

        public Node(String value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
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

        public Node getPrevious() {
            return this.previous;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public void setPrevious(Node node) {
            this.previous = node;
        }
    }
}
