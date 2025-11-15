package collections;

import java.util.NoSuchElementException;

public class List<T> {
    private Object[] elements;
    private int size;
    private int capacity = 10;

    public List(){
        this.elements = new Object[this.capacity];
        this.size = 0;
    }

    public List(int capacity){
        if (capacity < 0){
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        this.elements = new Object[this.capacity];
        this.size = 0;
    }

    public int length(){
        return this.size;
    }

    public int capacity() {
        return capacity;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void pushback(T elem){
        if (size == capacity){
            Object[] temp = new Object[capacity*2];
            for (int i = 0; i < capacity; i++)
                temp[i] = elements[i];
            elements = temp;
            capacity *= 2;
        }

        elements[size++] = elem;
    }

    public int find(T elem){
        for (int i = 0; i < size; i++){
            if (elements[i] == elem){
                return i;
            }
        }
        return -1;
    }

    //посмотреть
    public T get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    public void remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        for (int i = index; i < size; i++){
            elements[i] = elements[i+1];
        }
        size--;
    }


    //сделать нормально
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
