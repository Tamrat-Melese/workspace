package com.mpp.lab10.prob3;

public class QueueSafe {
    private Node head;
    private Node tail;
    synchronized public void add(Object newValue) {
        Node n = new Node();
        if(head == null) head = n;
        else tail.next = n;
        tail = n;
        tail.value = newValue;
    }
    synchronized public Object remove() {
        if(head == null) return null;
        Node n = head;
        head = n.next;
        return n.value;
    }

    public int countElement(){
        if(head == null) return 0;
        int count = 0;
        Node n = head;
        while(n != null){
            count++;
            n = n.next;
        }
        return count;
    }
}
