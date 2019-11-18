package main.java.amazon;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private class DNode {
        int key;
        int value;
        DNode prev;
        DNode next;
    }

    private Map<Integer, DNode> map = new HashMap<>();
    private DNode head, tail;
    private int maxCapacity, totalItemsInCache;

    public LRUCache(int capacity) {
        totalItemsInCache = 0;
        maxCapacity = capacity;

        head = new DNode();
        head.prev = null;

        tail = new DNode();
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DNode node = map.get(key);

        if(node == null) {
            return -1;
        } else {
            moveToHead(node);
            return node.value;
        }

    }

    public void put(int key, int value) {
        DNode node = map.get(key);

        if(node == null) {
            DNode tmp = new DNode();
            tmp.key = key;
            tmp.value = value;

            map.put(key, tmp);
            addNode(tmp);

            totalItemsInCache++;

            if(totalItemsInCache > maxCapacity) {
                removeNodeFromLRU(node);

            }
        } else {
            node.value = value;
            map.put(key, node);
            moveToHead(node);
        }
    }


    private void addNode(DNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;

        head.next = node;
    }

    private void removeNode(DNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DNode node) {
        removeNode(node);
        addNode(node);
    }

    private void removeNodeFromLRU(DNode node) {
        DNode itemBeingRemoved = tail.prev;
        removeNode(itemBeingRemoved);
        map.remove(itemBeingRemoved.key);
        --totalItemsInCache;
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */