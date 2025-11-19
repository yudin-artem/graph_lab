package collections;

import java.util.NoSuchElementException;
import java.util.Arrays;
import java.util.Objects;

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
        // увеличение размера массива
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

    public T get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        return (T) elements[index];
    }

    public void insert(int index, T elem){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        elements[index] = elem;
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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof List<?> list)) return false;
        return size == list.size && capacity == list.capacity && Objects.deepEquals(elements, list.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(elements), size, capacity);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("List: [ ");
        for (int i = 0; i < size; i++){
            res.append(elements[i]).append(" ");
        }
        res.append("]");
        return res.toString();
    }
}
