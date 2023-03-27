package ir.mapsa.linkedlist.main;

import ir.mapsa.linkedlist.LinkedList;
import ir.mapsa.linkedlist.Node;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.appendToTail(1);
        list.appendToTail(2);
        list.appendToTail(3);
        list.appendToTail(4);
        System.out.print("Nodes of singly linked list:");
        list.display();
        list.deleteNode(list.getNode(1), 1);
        list.deleteNode(list.getNode(3), 3);
        list.deleteNode(list.getNode(2), 4);
        System.out.print("Linked list elements after remove:");
        list.display();
    }
}
