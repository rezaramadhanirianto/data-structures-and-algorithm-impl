package com.rezaramadhanirianto.dsaImpl.datastructures.hashtable;

class Entry<K, V>{
    private int hash;
    K key;
    V value;

    public Entry(K key, V value){
        this.key = key;
        this.value = value;
        this.hash = key.hashCode();
    }

    public boolean equals(Entry<K, V> other){
        if(other.hash != this.hash) return false;
        return key.equals(other.key);
    }

    @Override
    public String toString() {
        return "Entry{" +
                "hash=" + hash +
                ", key=" + key +
                ", value=" + value +
                '}';
    }
}
