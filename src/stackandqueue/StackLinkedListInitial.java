/*
*
* Every implementation is O(1)
*
* */


package src.stackandqueue;

public class StackLinkedListInitial {
    private Node first = null;

    private class Node {
        String item;
        Node next;
    }

    private String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    private void push(String toPush) {
        Node oldfirst = first;
        first = new Node();
        first.item = toPush;
        first.next = oldfirst;
    }

    private boolean isEmpty() {
        return first == null;
    }
}