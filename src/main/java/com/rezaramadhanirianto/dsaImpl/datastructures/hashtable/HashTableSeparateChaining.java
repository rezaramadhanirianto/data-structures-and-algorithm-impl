package com.rezaramadhanirianto.dsaImpl.datastructures.hashtable;

import java.util.*;

public class HashTableSeparateChaining<K, V> implements Iterable<K>{
    private static final int DEFAULT_CAPACITY = 3;
    // percentage is full from capacity
    // example: 10 * 0.75 = 7
    private static final double DEFAULT_LOAD_FACTOR = 0.75;

    private LinkedList<Entry<K, V>>[] table;
    int capacity = 0;
    private int size = 0;
    private int threshold = 0;

    public HashTableSeparateChaining(){
        this(DEFAULT_CAPACITY);
    }

    public HashTableSeparateChaining(int capacity){
        if (capacity <= 0) throw new IllegalArgumentException("Illegal capacity");
        if(capacity < DEFAULT_CAPACITY)
            this.capacity = DEFAULT_CAPACITY;
        else
            this.capacity = capacity;

        threshold = (int) (capacity * DEFAULT_LOAD_FACTOR);
        table = new LinkedList[this.capacity];
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        Arrays.fill(table, null);
        size = 0;
    }

    public boolean hasKey(K key){
        int index = getBucketIndex(key);
        Entry<K, V> output = bucketSeekEntry(index, key);
        return output != null;
    }

    public boolean contains(K key){
        return hasKey(key);
    }

    public V get(K key){
        if(key == null) throw new IllegalArgumentException("Key cannot null");
        int index = getBucketIndex(key);
        Entry<K, V> entry = bucketSeekEntry(index, key);
        if(entry != null) return entry.value;
        return null;
    }

    public V put(K key, V value){
        if(key == null) throw new IllegalArgumentException("Key cannot null");

        Entry<K, V> entry = new Entry(key, value);
        int index = getBucketIndex(entry.key);

        return bucketInsertEntry(index, entry);
    }

    public V add(K key, V value){
        return put(key, value);
    }

    public V remove(K key){
        int index = getBucketIndex(key);

        return bucketRemoveEntry(index, key);
    }

    // get index of table
    private int getBucketIndex(K key){
        int hashCode = key.hashCode();
        int index = hashCode % capacity;
        return index < 0 ? index * -1 : index;
    }

    // insert item
    private V bucketInsertEntry(int bucketIndex, Entry<K, V> entry){
        LinkedList<Entry<K, V>> bucket = table[bucketIndex];
        if(bucket == null) table[bucketIndex] = bucket = new LinkedList();

        Entry<K, V> existEntry = bucketSeekEntry(bucketIndex, entry.key);
        if(existEntry == null){
            bucket.add(entry);
            if (++size > threshold) resizeTable();
            return null;
        }else{
            V oldEntry = existEntry.value;
            existEntry.value = entry.value;
            return oldEntry;
        }
    }

    // remove item
    private V bucketRemoveEntry(int bucketIndex, K key){
        Entry<K, V> entry = bucketSeekEntry(bucketIndex, key);
        if(entry != null){
            LinkedList<Entry<K, V>> links = table[bucketIndex];
            links.remove(entry);
            if(links.isEmpty()) table[bucketIndex] = null;
            size--;
            return entry.value;
        }
        return null;
    }

    // see if theres a bucket in table
    private Entry<K, V> bucketSeekEntry(int bucketIndex, K key){
        if(key == null) return null;
        LinkedList<Entry<K, V>> bucket = table[bucketIndex];
        if(bucket == null) return null;
        for(Entry<K, V> entry : bucket){
            if(entry.key.equals(key)) return entry;
        }
        return null;
    }

    private void resizeTable(){
        capacity *= 2;
        LinkedList<Entry<K, V>>[] newTable = new LinkedList[capacity];

        for(int i = 0; i < table.length; i++){
            if(table[i] != null){
                for(Entry<K, V> entry : table[i]){
                    int index = getBucketIndex(entry.key);
                    LinkedList<Entry<K, V>> bucket = newTable[index];
                    if(bucket == null) newTable[index] = bucket = new LinkedList<>();
                    bucket.add(entry);
                }

                table[i].clear();
                table[i] = null;
            }
        }
        table = newTable;
        threshold = (int) (capacity * DEFAULT_LOAD_FACTOR);
    }

    // Returns the list of keys found within the hash table
    public List<K> keys() {

        List<K> keys = new ArrayList<>(size());
        for (LinkedList<Entry<K, V>> bucket : table)
            if (bucket != null) for (Entry<K, V> entry : bucket) keys.add(entry.key);
        return keys;
    }

    // Returns the list of values found within the hash table
    public List<V> values() {

        List<V> values = new ArrayList<>(size());
        for (LinkedList<Entry<K, V>> bucket : table)
            if (bucket != null) for (Entry<K, V> entry : bucket) values.add(entry.value);
        return values;
    }


    // Return an iterator to iterate over all the keys in this map
    @Override
    public java.util.Iterator<K> iterator() {
        final int elementCount = size();
        return new java.util.Iterator<K>() {

            int bucketIndex = 0;
            java.util.Iterator<Entry<K, V>> bucketIter = (table[0] == null) ? null : table[0].iterator();

            @Override
            public boolean hasNext() {

                // An item was added or removed while iterating
                if (elementCount != size) throw new java.util.ConcurrentModificationException();

                // No iterator or the current iterator is empty
                if (bucketIter == null || !bucketIter.hasNext()) {

                    // Search next buckets until a valid iterator is found
                    while (++bucketIndex < capacity) {
                        if (table[bucketIndex] != null) {

                            // Make sure this iterator actually has elements -_-
                            java.util.Iterator<Entry<K, V>> nextIter = table[bucketIndex].iterator();
                            if (nextIter.hasNext()) {
                                bucketIter = nextIter;
                                break;
                            }
                        }
                    }
                }
                return bucketIndex < capacity;
            }

            @Override
            public K next() {
                return bucketIter.next().key;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override
    public String toString() {
        return "HashTableSeparateChaining{" +
                "table=" + Arrays.toString(table) +
                '}';
    }
}
