package br.com.cwi.crescer.complex;


public class DoublyLinkedList {

    public void addFirst(String value) {

    }

    protected class Node {

        private String value;
        private Node next;
        private Node previous;

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

        public Node getPrevious() {
            return this.previous;
        }

        public void setNext(Node node) {
            this.next = node;
        }
    }
}
