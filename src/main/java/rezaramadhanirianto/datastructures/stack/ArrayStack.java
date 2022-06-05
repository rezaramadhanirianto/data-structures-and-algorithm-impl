package rezaramadhanirianto.datastructures.stack;

import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {
    private int size = 0;
    private int cap = 0;
    private Object[] data;

    public ArrayStack(){
        cap = 10;
        data = new Object[cap];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(T elem) {
        if(size + 1 > cap){
            // time to resize
            cap += 10;
            increaseCapacity();
        }
        data[size++] = elem;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if(isEmpty()) throw new RuntimeException("Empty Stack");
        T elem = (T) data[--size];
        data[size] = null;
        return elem;

    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        return (T) data[size--];
    }

    private void increaseCapacity(){
        cap *=2;
        Object[] temp = data;
        data = new Object[cap];
        for(int i = 0; i < size; i++){
            data[i] = temp[i];
        }
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
