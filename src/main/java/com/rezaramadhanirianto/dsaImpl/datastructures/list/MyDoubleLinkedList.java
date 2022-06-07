package com.rezaramadhanirianto.dsaImpl.datastructures.list;

@SuppressWarnings("ALL")
public class MyDoubleLinkedList<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int len = 0;


    private class Node<T>{
        T data;
        Node<T> prev, next;

        Node(T data, Node<T> prev, Node<T> next){
            this.data = data;
            this.prev = prev;
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
        return len == 0;
    }

    public void clear(){
        Node<T> trav = head;
        while(trav != null){
            Node<T> next = trav.next;
            trav.prev = null;
            trav.data = null;
            trav.next = null;
            trav = next;
        }
        head = tail = null;
        len = 0;
    }


    public T getByIndex(int index){
        if(index >= len) throw new IndexOutOfBoundsException("Not found Index: " + index);
        Node<T> trav = head;
        for(int i = 0; i < len; i++){
            if(index == i) return trav.data;
            trav = trav.next;
        }
        return null;
    }

    public T getFirst(){
        return head.data;
    }

    public T getLast(){
        return tail.data;
    }

    public void add(T elem){
        Node<T> trav = tail;
        Node<T> last = new Node(elem, tail, null);
        tail = last;
        if(trav == null)
            head = last;
        else
            trav.next = last;
        len++;
    }

    public void addFirst(T elem){
        Node<T> trav = head;
        if(trav == null){
            head = tail = new Node(elem, null, null);
        }else{
            head.prev = new Node(elem, null, head);
            head = trav.prev;
        }
        len++;
    }

    private T remove(Node<T> elem){
        Node<T> prev = elem.prev;
        Node<T> next = elem.next;

        if(prev == null) return removeFirst();
        if(next == null) return removeLast();

        T data = elem.data;

        elem.data = null;
        prev.next = elem.next;
        next.prev = elem.prev;

        elem.next = elem.prev = null;

        len--;
        return data;
    }

    public T removeFirst(){
        if(isEmpty()) throw new RuntimeException("Is Empty");

        Node<T> first = head.next;

        T temp = head.data;
        head = first;

        if(isEmpty()) tail = null;
        else head.prev = null;

        len--;
        return temp;
    }

    public T removeLast(){
        if(isEmpty()) throw new RuntimeException("Is Empty");

        Node<T> last = tail.prev;

        T temp = tail.data;
        tail = last;
        len--;

        if(isEmpty()) head = null;
        else tail.next = null;

        return temp;
    }

    public T removeByIndex(int index){
        if(index >= len) throw new ArrayIndexOutOfBoundsException("Not found index: " + index);
        Node<T> trav = head;
        for(int i = 0; i < len; i++){
            if(index == i){
                return remove(trav);
            }

            trav = trav.next;
        }
        return null;
    }

    public T removeByValue(T elem){
        Node<T> trav = head;
        if(elem == null){
            while(trav != null){
                if(null == trav.data) remove(trav);
                trav = trav.next;
            }
        }else{
            while(trav != null){
                if(trav.data.equals(elem)) remove(trav);
                trav = trav.next;
            }
        }
        return elem;
    }

    public int indexOf(T elem){
        int i = 0;
        Node<T> trav = head;
        if(elem == null){
            for(; trav != null;i++){
                if(null == trav.data) return i;
                trav = trav.next;
            }
        }else{
            for(; trav != null;i++){
                if(trav.data.equals(elem)) return i;
                trav = trav.next;
            }
        }
        return -1;
    }

    public boolean contains(T elem){
        return indexOf(elem) != -1;
    }

    public String toString(){
        Node<T> trav = head;
        StringBuilder stringBuilder = new StringBuilder();
        while(trav != null){
            stringBuilder.append(trav.toString() + ", ");
            trav = trav.next;
        }
        return stringBuilder.toString();
    }
}
