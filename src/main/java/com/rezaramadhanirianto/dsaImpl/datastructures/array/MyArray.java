package com.rezaramadhanirianto.dsaImpl.datastructures.array;

@SuppressWarnings("ALL")
public class MyArray<T> {
    private T[] data;
    private int len = 0;
    private int cap = 0;

    // TODO: Create secondary constructor with cap
    public MyArray(){
        this(10);
    }

    private MyArray(int cap){
        if(cap <= 0) throw new IllegalArgumentException("Illegal Capacity: " + cap);
        this.cap = cap;
        data = (T[]) new Object[cap];
    }

    public int size(){
        return len;
    }

    // TODO: Create isEmpty
    public boolean isEmpty(){
        return size() == 0;
    }

    // TODO: Create get
    public T get(int index){
        if(index >= len && index < 0) throw new ArrayIndexOutOfBoundsException("Not found object in index: " + index);
        return data[index];
    }

    public int indexOf(T elem){
        for(int i = 0; i < len; i++){
            if(elem.equals(data[i])) return i;
        }
        return -1;
    }

    // TODO: Create add
    public T add(T elem){
        if(len + 1  >= cap){
            // resize capacity
            T[] temp = data;
            cap *= 2;
            data = (T[]) new Object[cap];
            for(int i = 0; i < temp.length; i++){
                data[i] = temp[i];
            }
        }
        data[len++] = elem;
        return elem;
    }

    // TODO: Create set
    public T set(int index, T elem){
        data[index] = elem;
        return elem;
    }

    // TODO: Create remove
    public T removeByIndex(int index){
        if(index >= len) throw new ArrayIndexOutOfBoundsException("Not found object in index: " + index);
        T result = data[index];
        if(index+1 != len)
              for(int i = index+1, j = index; i < len; i++, j++)
                data[j] = data[i];

        data[len--] = null;
        return result;
    }

    public T remove(T elem){
        int index = indexOf(elem);
        while(index != -1){
            removeByIndex(index);

            index = indexOf(elem);
        }
        return elem;
    }


    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MyArray[");
        for(int i = 0; i < len; i++){
            stringBuilder.append(data[i] + ",");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
