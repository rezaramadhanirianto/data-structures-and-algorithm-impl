package com.rezaramadhanirianto.dsaImpl.datastructures.list;

@SuppressWarnings("all")
public class MySingleLinkedList<T> {
    private Node<T> head = null;
    private Node<T> tail = null;
    private int len = 0;

    class Node<T>{
        private Node<T> next = null;
        private T data = null;

        Node(T data, Node<T> next){
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public int size(){
        return len;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void clear(){
        len = 0;
        Node<T> trav = head;
        head = tail = null;
        while(trav != null){
            Node<T> tempNext = trav.next;
            trav.data = null;
            trav.next = null;

            trav = tempNext;
        }
    }

    public void addFirst(T elem){
        Node<T> node = new Node(elem, null);
        if(tail == null){
            head = tail = node;
        }else{
            node.next = head;
            head = node;
        }
        len++;
    }

    public void add(T elem){
        Node<T> node = new Node(elem, null);
        if(head == null){
            head = tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
        len++;
    }

    private T remove(Node<T> node){
        if(isEmpty()) throw new RuntimeException("Linked list is empty");

        if(node.next == null) return removeLast();
        if(node.equals(head)) return removeFirst();

        Node<T> trav = head;

        while(trav != null){
            if(trav.equals(node)){
                trav.next = node.next;
                break;
            }
            trav = trav.next;
        }
        T tempData = node.data;
        node.data = null;
        node.next = null;
        len--;
        return tempData;
    }

    public T removeLast(){
        if(isEmpty()) throw new RuntimeException("Linked list is empty");

        Node<T> trav = head;
        while(trav != null){
            if(trav.equals(tail)){
                trav.next = null;
            }
            trav = trav.next;
        }
        T tempData = tail.data;
        tail.next = null;
        tail.data = null;
        len--;
        if(isEmpty()) head = null;
        return tempData;
    }

    public T removeFirst(){
        if(isEmpty()) if(isEmpty()) throw new RuntimeException("Linked list is empty");

        T tempData = head.data;

        head = head.next;
        len--;

        if(isEmpty()) tail = null;

        return tempData;
    }

    public T removeByIndex(int index){
        if(index >= len || isEmpty()) throw new RuntimeException("Out of bound");
        Node<T> trav = head;
        for(int i = 0; i < len; i++){
            if(i == index){
                return remove(trav);
            }
            trav = trav.next;
        }
        return null;
    }

    public T removeByValue(T elem){
        if(isEmpty()) throw new RuntimeException("Out of bound");
        Node<T> trav = head;
        if(elem == null){
            while(trav != null){
                if(trav.data == null) return remove(trav);

                trav = trav.next;
            }
        }else{
            while(trav != null){
                if(trav.data.equals(elem)) return remove(trav);

                trav = trav.next;
            }
        }

        return null;
    }

    public T getByIndex(int index){
        if(index >= len || isEmpty()) throw new RuntimeException("Out of bound");
        Node<T> trav = head;
        for(int i = 0; i < len; i++){
            if(i == index){
                System.out.println(trav.data);
                return trav.data;
            }
            trav = trav.next;
        }
        return null;
    }

}
