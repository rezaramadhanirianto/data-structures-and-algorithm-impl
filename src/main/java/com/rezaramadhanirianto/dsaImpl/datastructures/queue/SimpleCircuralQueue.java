package com.rezaramadhanirianto.dsaImpl.datastructures.queue;

@SuppressWarnings("unchecked")
public class SimpleCircuralQueue<T> implements Queue<T> {
    private int front;
    private int rear;
    private Object[] data;

    private SimpleCircuralQueue(){}

    SimpleCircuralQueue(int capacity){
        this();
        data = new Object[capacity];
        front = -1;
        rear = -1;
    }

    @Override
    public void enqueue(T elem) {
        if(isFull()) throw new RuntimeException("Queue is full u need to dequeue first");
        data[decideIndex(++rear, data.length)] = elem;
    }

    @Override
    public T dequeue() {
        if(isEmpty()) throw new RuntimeException("Queue is empty u need to enqueue first");
        return (T) data[decideIndex(++front, data.length)];
    }

    @Override
    public T peek() {
        if(isEmpty()) throw new RuntimeException("Queue is empty u need to enqueue first");
        int peek = front == -1 ? 0 : front + 1;
        return (T) data[decideIndex(peek, data.length)];
    }

    @Override
    public int size() {
        if(front == -1){
            return rear + 1;
        }else{
            return decideIndex(rear + data.length - front, data.length);
        }
    }

    @Override
    public boolean isEmpty() {
        return rear == -1 || front == rear;
    }

    @Override
    public boolean isFull() {
        return front == -1 && rear == data.length - 1 || front - 1 == rear;
    }

    private int decideIndex(int index, int length){
        return index >= data.length ? index - data.length : index;
    }
}
