package queue;

import linkedlist.LinkedList;

public class ListAdapterQueue<T> implements Queue<T> {
    private LinkedList<T> a;

    public ListAdapterQueue(){
        a = new LinkedList<T>();
    }
    public int size(){
        return a.size();
    }

    public boolean isEmpty(){
        return a.isEmpty();
    }

    public void enqueue(T x) {
        a.addTail(x);
    }
    public T dequeue() throws Exception{
        return a.removeHead();
    }

    public String toString() {
        return a.toString();
    }
    public static void main(String args[]) {
        Queue<String> q = new ListAdapterQueue<>();
        ArrayQueue.testQueue(q);
    }

}
