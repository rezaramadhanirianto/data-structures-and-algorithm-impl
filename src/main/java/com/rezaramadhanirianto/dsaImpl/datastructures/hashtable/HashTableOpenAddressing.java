package com.rezaramadhanirianto.dsaImpl.datastructures.hashtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("unchecked")
abstract public class HashTableOpenAddressing<K, V> {
    protected int capacity, threshold;

    private int usedBucket, keyCount;
    private K[] keys;
    private V[] values;

    protected final K TOMBSTONE = (K) (new Object());

    private static final int DEFAULT_CAPACITY = 7;
    private static final double DEFAULT_LOAD_FACTOR = 0.70;

    protected HashTableOpenAddressing(int capacity){
        if(capacity <= 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        capacity = Math.max(DEFAULT_CAPACITY, capacity);
        this.capacity = capacity;
        adjustCapacity();
        this.threshold = (int) (this.capacity * DEFAULT_LOAD_FACTOR);
        keys = (K[]) (new Object[this.capacity]);
        values = (V[]) (new Object[this.capacity]);
    }

    protected abstract void setupProbing(K key);

    protected abstract int probe(int x);

    // Adjusts the capacity of the hash table after it's been made larger.
    // This is important to be able to override because the size of the hashtable
    // controls the functionality of the probing function.
    protected abstract void adjustCapacity();

    protected void increaseCapacity(){
        capacity = (2 * capacity) + 1;
    }

    public void clear(){
        for(int i = 0; i < capacity; i++){
            keys[i] = null;
            values[i] = null;
        }
        keyCount = usedBucket = 0;
    }

    public int size(){
        return keyCount;
    }

    public boolean isEmpty(){
        return keyCount == 0;
    }

    public V put(K key, V value) {
        return insert(key, value);
    }

    public V add(K key, V value) {
        return insert(key, value);
    }

    // Returns true/false on whether a given key exists within the hash-table.
    public boolean containsKey(K key) {
        return hasKey(key);
    }

    public List<K> keys(){
        ArrayList<K> hashTablekeys = new ArrayList<K>(size());
        for(int i = 0; i < capacity; i++){
            if(keys[i] != TOMBSTONE && keys[i] != null) hashTablekeys.add(keys[i]);
        }
        return hashTablekeys;
    }

    public List<V> values(){
        ArrayList<V> hashTablekeys = new ArrayList<V>(size());
        for(int i = 0; i < capacity; i++){
            if(values[i] != null) hashTablekeys.add(values[i]);
        }
        return hashTablekeys;
    }
    String a;
    protected int getBucketIndex(int key){
        int index = (key & 0x7FFFFFFF) % capacity;
        int index2 = (key < 0 ? key * -1 : key) % capacity;
        a = index + " " + index2;
        return index;
    }

    protected int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    // Returns the capacity of the hashtable (used mostly for testing)
    public int getCapacity() {
        return capacity;
    }

    // TODO: resizeTable
    private void resizeTable(){
        increaseCapacity();
        adjustCapacity();

        threshold = (int) (capacity * DEFAULT_LOAD_FACTOR);

        K[] oldKeysTable = (K[]) (new Object[capacity]);
        V[] oldValueTable = (V[]) (new Object[capacity]);


        K[] keyTableTemp = keys;
        keys = oldKeysTable;
        oldKeysTable = keyTableTemp;

        V[] valueTableTemp = values;
        values = oldValueTable;
        oldValueTable = valueTableTemp;

        keyCount = usedBucket = 0;

        for(int i = 0; i < oldKeysTable.length;i++){
            if(oldKeysTable[i] != TOMBSTONE && oldKeysTable[i] != null) {
                insert(oldKeysTable[i], oldValueTable[i]);
            }
            oldKeysTable[i] = null;
            oldValueTable[i] = null;
        }


    }
    // TODO: haskey
    public boolean hasKey(K key){
        if (key == null) throw new IllegalArgumentException("Illegal key: " + key);

        setupProbing(key);
        final int offset = getBucketIndex(key.hashCode());

        for (int i = offset, x = 1, j = -1; ; i = getBucketIndex(offset + probe(x++))) {
            if(keys[i] == TOMBSTONE){
                if(j == -1) j = i;
            } else if(keys[i] != null){
                if(keys[i].equals(key)){
                    if(j != -1){
                        keys[j] = keys[i];
                        values[j] = values[i];
                        keys[i] = TOMBSTONE;
                        values[i] = null;
                    }
                    return true;
                }
            } else{
                return false;
            }
        }
    }

    // TODO: get
    public V get(K key){
        if(key == null) throw new IllegalArgumentException("Illegal key: ");
        if(usedBucket >= threshold) resizeTable();

        setupProbing(key);
        final int offset = getBucketIndex(key.hashCode());
        for(int i = offset, j = -1, x = 1; ; i = getBucketIndex(offset + probe(x++))){
            if(keys[i] == TOMBSTONE){
                if(j == -1) j = i;
            } else if(keys[i] != null){
                if(keys[i].equals(key)){
                    if(j != -1){
                        keys[j] = keys[i];
                        values[j] = values[i];
                        keys[i] = TOMBSTONE;
                        values[i] = null;
                        return values[j];
                    }else{
                        return values[i];
                    }
                }
            } else{
                return null;
            }
        }
    }
    // TODO: remove
    public V remove(K key) {
        if (key == null) throw new IllegalArgumentException("Illegal key: " + key);

        setupProbing(key);
        final int offset = getBucketIndex(key.hashCode());

        for (int i = offset, x = 1; ; i = getBucketIndex(offset + probe(x++))) {
            if (keys[i] == TOMBSTONE) continue;
            if (keys[i] == null) return null;

            if (keys[i].equals(key)) {
                V oldValue = values[i];
                keys[i] = TOMBSTONE;
                values[i] = null;
                keyCount--;
                return oldValue;
            }
        }
    }
    // TODO: Insert
    public V insert(K key, V value){
        if(key == null) throw new IllegalArgumentException("Illegal key: " + key);
        if(usedBucket >= threshold) resizeTable();

        setupProbing(key);
        final int offset = getBucketIndex(key.hashCode());
        for(int i = offset, j = -1, x = 1; ; i = getBucketIndex(offset + probe(x++))){
            if(keys[i] == TOMBSTONE){
                if(j == -1) j = i;
            } else if(keys[i] != null){
                V oldValue = values[i];
                if(keys[i].equals(key)){
                    if(j == -1){
                        values[i] = value;
                    }else{
                        keys[i] = TOMBSTONE;
                        values[i] = null;
                        keys[j] = key;
                        values[j] = value;
                    }
                    return oldValue;
                }
            } else{
                if(j == -1){
                    usedBucket++;
                    keyCount++;
                    keys[i] = key;
                    values[i] = value;
                }else{
                    keyCount++;
                    keys[j] = key;
                    values[j] = value;
                }

                return null;
            }


        }

    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        for (int i = 0; i < capacity; i++)
            if (keys[i] != null && keys[i] != TOMBSTONE) sb.append(keys[i] + ", ");
        sb.append("}");

        return sb.toString();
    }

}
