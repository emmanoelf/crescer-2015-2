package br.com.cwi.crescer.simple;

import java.util.ArrayList;
import java.util.List;

import br.com.cwi.crescer.complex.ILinkedList;

public class LinkedList<T> implements ILinkedList<T> {

    private Node<T> last, first;

    @Override
    public void addFirst(T value) {
        Node<T> node = new Node<T>(value, first);
        if (isEmpty()) {
            last = node;
        }
        first = node;
    }

    @Override
    public List<T> list() {
        ArrayList<T> list = new ArrayList<>();
        Node<T> node = first;
        while (node != null) {
            list.add(node.getValue());
            node = node.getNext();
        }
        return list;
    }

    @Override
    public void addLast(T value) {
        Node<T> node = new Node<T>(value);
        if (isEmpty()) {
            first = node;
        }
        last.setNext(node);
        last = node;
    }

    @Override
    public void removeFirst() {
        first = first.getNext();

    }

    @Override
    public void addMiddle(int index, T value) {
        Node<T> temp = getNode(index - 1);
        Node<T> nextNode = getNode(index);
        temp.setNext(new Node<T>(value, nextNode));
    }

    @Override
    public void remove(int index) {
        Node<T> temp = getNode(index - 1);
        Node<T> removed = temp.getNext();
        temp.setNext(removed.getNext());

    }

    public boolean isEmpty() {
        return first == null;
    }

    public T getFirst() {
        return first.getValue();
    }

    public T getLast() {
        return last.getValue();
    }

    private Node<T> getNode(int index) {
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }

    protected class Node<T> {

        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
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

        public void setNext(Node<T> node) {
            this.next = node;
        }
    }
}