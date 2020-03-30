package com.seven.level10;

import java.util.LinkedList;

/**
 * @author QH
 * @date 2019/11/21
 * @description 手写 LinkedList
 */
public class MyLinkedList {

    private Node first;
    private Node last;

    private int size;

    public void add(Object obj) {
        Node node;
        if (first == null) {
            node = new Node(null, obj, null);
            first = node;
            last = node;
        } else {
            node = new Node(last, obj, null);
            last.setNext(node);

            last = node;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public Node node (int index) {
        Node temp = null;
        if (first != null) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
        }
        return temp;
    }

    public Object get(int index) {

        Node temp = node(index);
        if (temp != null) {
            return temp.getObj();
        }
        return null;
    }

    public void remove(int index) {
        Node temp = node(index);

        if (temp != null) {
            Node p = temp.getPrevious();
            Node l = temp.getNext();
            p.setNext(l);
            l.setPrevious(p);
            size--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("aaa");
        list.add("aa12a");
        System.out.println(list.get(1));
    }
}


class Node {
    private Node previous;
    private Object obj;
    private Node next;

    public Node() {
    }

    public Node(Node previous, Object obj, Node next) {
        this.previous = previous;
        this.obj = obj;
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
