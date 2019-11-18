package main.java.datastructures;

public class MyArrayList<E> {

    private int size;
    private Object[] array;
    private double loadfactor = 0.5;
    private int capacity = 10;

    public MyArrayList() {
        array = new Object[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if(size == 0)
            return true;
        return false;
    }

    public boolean contains(Object o) {
        for(int i=0; i<size; i++) {
            if(array[i] == o)
                return true;
        }
        return false;
    }

    public boolean add(E e) {
        if(size < loadfactor*capacity) {
            array[size] = e;
            size++;
            return true;
        } else {
            Object[] arraycopy = array.clone();
            array = new Object[capacity*2];
            capacity = capacity*2;
            for(int i=0; i<=size; i++) {
                array[i] = arraycopy[i];
            }
            array[size] = e;
            size++;
            return true;
        }
    }

    public boolean remove(Object o) {
        for(int i=0; i<size; i++) {
            if(array[i].equals(o)) {
                for(int j=i+1; j<size; j++) {
                    array[j-1] = array[j];
                }
                array[size] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public E get(int index) {
        return (E) array[index];
    }

    public E set(int index, E element) {
        E replaced = (E) array[index];
        array[index] = element;
        return replaced;
    }

    public static void main(String[] args) {
        MyArrayList<Integer> myarray = new MyArrayList<>();
        for(int i=0; i<7; i++) {
            boolean didFunction = myarray.add(2);
        }
        myarray.remove(2);
    }
}
