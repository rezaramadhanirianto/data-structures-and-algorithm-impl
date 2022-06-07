package com.rezaramadhanirianto.dsaImpl.datastructures.queue;

public class CircuralQueue<T> implements Queue<T>{
    private Object[] data;
    private int front;
    private int rear;
    private CircuralQueue(){}

    public CircuralQueue(int capacity){
        this();
        /* capacity have to add one more space to make all function run properly
         * if you want to create a real capacity u have to change front and rear to -1
         * and make find logic for isFull isEmpty size and decide index I
        */
        data = new Object[capacity + 1];
        front = 0;
        rear = 0;
    }


    @Override
    public void enqueue(T elem) {
        if(isFull()) throw new RuntimeException("Full queue, you need to pool before");
        rear = decideIndex(rear, data.length);
        data[rear++] = elem;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T dequeue() {
        if(isEmpty()) throw new RuntimeException("Queue is empty, you need to add before");
        front = decideIndex(front, data.length);
        return (T) data[front++];
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if(isEmpty()) throw new RuntimeException("Queue is empty, you need to add before");
        front = decideIndex(front, data.length);
        return (T) data[front];
    }

    // TODO: should check the com.rezaramadhan.algorithm next
    @Override
    public int size() {
        return decideIndex(rear + data.length - front, data.length);
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public boolean isFull() {
        return size() == data.length - 1;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    // TODO: should check the com.rezaramadhan.algorithm next
    public int decideIndex(int index, int length){
        return index >= length ? index - length : index;
    }
}
