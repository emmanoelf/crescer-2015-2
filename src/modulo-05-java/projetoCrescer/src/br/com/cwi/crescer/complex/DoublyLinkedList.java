package br.com.cwi.crescer.complex;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList<T> implements ILinkedList<T> {

    private Node<T> first;
    private Node<T> last;

    public T getFirst() {
        return first.getValue();
    }

    public T getLast() {
        return last.getValue();
    }

    @Override
    public void addFirst(T value) {
        Node<T> node = new Node<T>(value, first, null);
        if (isEmpty()) {
            first = node;
            last = node;
        }
        first.setPrevious(node);
        first = node;
    }

    @Override
    public void addLast(T value) {
        Node<T> node = new Node<T>(value, null, last);
        if (isEmpty()) {
            first = node;
            first.setNext(last);
            last = node;
        }
        last.setNext(node);
        last.setPrevious(node.getPrevious());
        last = node;
    }

    @Override
    public List<T> list() {
        ArrayList<T> list = new ArrayList<T>();
        Node<T> node = first;
        while (node != null) {
            list.add(node.getValue());
            node = node.getNext();
        }
        return list;
    }

    @Override
    public void removeFirst() {
        if (first != null) {
            first = first.getNext();
        }
    }

    @Override
    public void addMiddle(int index, T value) {
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node<T> previous = getNode(index - 1);
        Node<T> next = previous.getNext();
        Node<T> node = new Node<T>(value, next, previous);
        previous.setNext(node);
        next.setPrevious(node);
    }

    @Override
    public void remove(int index) {
        Node<T> previous = getNode(index - 1);
        Node<T> next = getNode(index).getNext();
        previous.setNext(next);
    }

    private Node<T> getNode(int index) {
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    public boolean isEmpty() {
        return first == null;
    }

    protected class Node<T> {

        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        public Node<T> getNext() {
            return this.next;
        }

        public Node<T> getPrevious() {
            return this.previous;
        }

        public void setNext(Node<T> node) {
            this.next = node;
        }

        public void setPrevious(Node<T> node) {
            this.previous = node;
        }
    }
}
