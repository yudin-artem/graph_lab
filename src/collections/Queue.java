package collections;

public class Queue<T> {
    private static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Queue() {
        head = null;
        tail = null;
        size = 0;
    }

    public void enqueue(T data){
        Node<T> node = new Node<>(data);
        if(head == null){
            head = node;
            tail = node;
        }
        else{
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T dequeue(){
        if(head == null){
            return null;
        }
        T data = head.data;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
        return data;
    }

    public int length(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void  clear(){
        head = null;
        tail = null;
        size = 0;
    }
}