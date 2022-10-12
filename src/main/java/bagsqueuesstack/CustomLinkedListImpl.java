package bagsqueuesstack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomLinkedListImpl<E> implements Iterable<E> {
    private Node<E> head;
    private int size;

    @Override
    public Iterator<E> iterator() {
        return new IteratorLinkedListImpl<E>();
    }

    public void add(E value) {
        Node<E> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public E removeFromHead() {
        Node<E> first = head;
        head = head.next;
        size--;
        return first.value;
    }

    public int size() {
        return size;
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value) {
            this.value = value;
        }
    }

    private class IteratorLinkedListImpl<E> implements Iterator<E> {
        CustomLinkedListImpl.Node<E> currentNode = (Node<E>) head;
        int nodeCount;

        @Override
        public boolean hasNext() {
            return nodeCount < CustomLinkedListImpl.this.size;
        }

        @Override
        public E next() {
            if (hasNext()) {
                E value = currentNode.value;
                currentNode = currentNode.next;
                nodeCount++;
                return value;
            } else {
                throw new NoSuchElementException();
            }
        }
    }

    public Node<E> reverseList() {
        Node<E> first = head;
        Node<E> reversed = null;
        while (first != null) {
            Node<E> next = first.next;
            first.next = reversed;
            reversed = first;
            first = next;
        }

        head = reversed;
        return head;
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        for (E e : this) {
            list.append(" ").append(e);
        }
        return list.toString();
    }
}
