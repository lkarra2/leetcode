package main.java.datastructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyHashMap {

    class Pair<U, V> {
        public U key;
        public V value;

        public Pair(U key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    class Bucket {
        private List<Pair<Integer, Integer>> bucket;

        public Bucket() {
            this.bucket = new LinkedList<Pair<Integer, Integer>>();
        }

        public Integer get(Integer key) {
            for(Pair<Integer, Integer> pair : this.bucket) {
                if(pair.key.equals(key))
                    return pair.value;
            }
            return -1;
        }

        public void update(Integer key, Integer value) {
            boolean found = false;
            for(Pair<Integer, Integer> pair : this.bucket) {
                if(pair.key.equals(key)) {
                    pair.value = value;
                    found = true;
                }
            }
            if(!found) {
                this.bucket.add(new Pair<Integer, Integer>(key, value));
            }
        }

        public void remove(Integer key) {
            for (Pair<Integer, Integer> pair : this.bucket) {
                if (pair.key.equals(key)) {
                    this.bucket.remove(pair);
                    break;
                }
            }
        }
    }

    private int key_space;
    private List<Bucket> hashmap;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.key_space = 2069;
        this.hashmap = new ArrayList<Bucket>();
        for(int i=0; i<this.key_space; ++i) {
            this.hashmap.add(new Bucket());
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashKey = key % this.key_space;
        this.hashmap.get(hashKey).update(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashKey = key % this.key_space;
        return this.hashmap.get(hashKey).get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashKey = key % this.key_space;
        this.hashmap.get(hashKey).remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
