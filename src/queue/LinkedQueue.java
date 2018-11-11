package queue;

import node.Node;

public class LinkedQueue<T> implements Queue<T> {
    protected Node<T> front,back;
    private int size;

    public LinkedQueue(){
        front = back = null;
        size = 0;
    }


    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public void enqueue(T x) {
        Node<T> newBack = new Node<T>(x, null);
        if(back != null)
            back.setNext(newBack);
        else
            front = newBack;
        back = newBack;
        size++;
    }


    public T dequeue() throws Exception {
        if(isEmpty())
            throw new Exception("Empty");
        T answer = front.getData();
        front = front.getNext();
        if(front == null)
            back = front;
        size--;
        return answer;
    }
    public String toString() {
        String ans = "Linked Queue<T>:  ";
        Node<T> n = front;
        while (n != null) {
            ans += (n.getData() + " -> ");
            n = n.getNext();
        }
        return ans;
    }

    public static void main(String args[]) {
        Queue<String> q = new LinkedQueue<String>();
        ArrayQueue.testQueue(q);
    }
}
