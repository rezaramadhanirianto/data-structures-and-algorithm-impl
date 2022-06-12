package com.rezaramadhanirianto.dsaImpl.datastructures.priorityqueue;

import java.util.ArrayList;
import java.util.List;

// Binary heap is same as Priority Queue with binary tree implementation
// This implementation is build in dynamic array
@SuppressWarnings("all")
public class BinaryHeap<T extends Comparable> {

    private List<T> heap = null;

    BinaryHeap(){
        this(1);
    }
    BinaryHeap(int size){
        heap = new ArrayList(size);
    }

    // TODO: Check that
    // Construct a priority queue using heapify in O(n) time, a great explanation can be found at:
    // http://www.cs.umd.edu/~meesh/351/mount/lectures/lect14-heapsort-analysis-part.pdf
    BinaryHeap(T[] elems){
        int heapSize = elems.length;
        heap = new ArrayList(elems.length);
        for (T e: elems) {
            heap.add(e);
        }

        // add to sink
        // Heapify process, O(n)
        for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--) sink(i);
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void clear(){
        heap.clear();
    }

    public int size(){
        return heap.size();
    }

    public T peek(){
        if(isEmpty()) return null;
        return heap.get(0);
    }

    public T poll(){
        return removeAt(0);
    }

    public boolean contains(T elem){
        for(T e : heap) if(e.equals(elem)) return true;
        return false;
    }

    public void add(T elem){
        if(elem == null) throw new IllegalArgumentException();
        heap.add(elem);

        int indexOfLastElement = size() - 1;
        swim(indexOfLastElement);

    }
    // TODO: remove
    public boolean remove(T elem){
        if(elem == null) throw new IllegalArgumentException();

        for (int i = 0; i < size(); i++){
            if(elem.equals(heap.get(i))){
                removeAt(i);
                return true;
            }
        }

        return false;
    }

    // TODO: removeAt
    public T removeAt(int i){
        if(isEmpty()) return null;

        int indexOfLastElement = size() - 1;
        T removed_data = heap.get(i);
        swap(i, indexOfLastElement);

        // remove the last element cuz we was swap the value
        heap.remove(indexOfLastElement);

        // check if item want to remove is last element
        if(i == indexOfLastElement) return removed_data;

        T elem = heap.get(i);

        // sink first
        sink(i);

        // if sink not working we should swim
        if(heap.get(i).equals(elem)) swim(i);
        return removed_data;
    }

    private boolean less(int i, int j){
        T node_i = heap.get(i);
        T node_j = heap.get(j);

        return node_i.compareTo(node_j) <= 0;
    }

    private void swap(int i, int j){
        T elem_i = heap.get(i);
        T elem_j = heap.get(j);

        heap.set(i, elem_j);
        heap.set(j, elem_i);
    }

    // sink is the function for check smallest item to next child
    // is like if the item is bigger than children both left and right
    // then item is go down and if the item still bigger than children
    // and go down again and again until item is smaller than children left and right
    private void sink(int k){
        int size = size();
        while(true){
            int left = 2 * k + 1;
            int right = 2 * k + 2;
            int smallest = left;

            if(right < size  && less(right, left)) smallest = right;

            if(left >= size || less(k, smallest)) break;

            swap(smallest, k);
            k = smallest;
        }
    }

    // swim is function to check that item
    // if item is smaller than parent
    // then the item go up replace the parent
    // if the item still smaller than parent go up again
    // until the item is bigger than the parent
    private void swim(int k){
        int parent = (k - 1) / 2;

        while(k > 0 && less(k, parent)){

            swap(parent, k);

            k = parent;
            parent = (k - 1) / 2;
        }
    }

    // TODO: isMiniHeap?
    public boolean isMinHeap(int k){
        int heapSize = size();

        if(k >= heapSize) return true;

        int left = 2 * k + 1;
        int right = 2 * k + 2;

        if(left < heapSize && !less(k, left)) return false;
        if(right < heapSize && !less    (k, right)) return false;

        // Recurse on both children to make sure they're also valid heaps
        return isMinHeap(left) && isMinHeap(right);
    }

    @Override
    public String toString() {
        return "BinaryHeap{" +
                "heap=" + heap +
                '}';
    }
}
