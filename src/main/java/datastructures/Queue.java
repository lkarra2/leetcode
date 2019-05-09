package main.java.datastructures;


public class Queue {
    int front, rear, capacity, size;
    int[] array;

    public Queue(int capacity) {
        this.capacity = capacity;
        array = new int[this.capacity];
        front = 0;
        size = 0;
        rear = this.capacity - 1;
    }

    public boolean isFull(Queue queue) {
        return (queue.size == this.capacity);
    }

    public boolean isEmpty(Queue queue) {
        return queue.size == 0;
    }

    public void enqueue(int val) {
        if(isFull(this))
            return;
        this.rear = (this.rear + 1) % this.capacity;
        this.array[this.rear] = val;
        this.size = this.size + 1;
    }

    public int dequeue() {
        if(isEmpty(this))
            return Integer.MIN_VALUE;
        int val = this.array[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size = this.size - 1;
        return val;
    }



}
