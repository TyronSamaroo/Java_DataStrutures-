package iterator;

import java.util.Iterator;

import queue.LinkedQueue;
import queue.ArrayQueue;
import queue.Queue;
import node.Node;

public class ItQueue<T> extends LinkedQueue<T> implements Queue<T>,
        Iterable<T> {
    public Iterator<T> iterator() {
        return new QueueIterator<>(front);
    }

    public String toString() {
        String ans = "ItQueue<T>: ";
        for (T x : this)
            ans += x + " ";
        return ans;
    }

    public static void main(String[] args) {
        ItQueue<String> q = new ItQueue<>();
        ArrayQueue.testQueue(q);
    }
}

class QueueIterator<T> implements Iterator<T> {
    private Node<T> current;

    public QueueIterator(Node<T> c) {
        current = c;
    }

    public T next() {
        T answer = current.getData();
        current.setNext((Node<T>) current.getData());
        System.out.println(current);
        return answer;
    }

    public boolean hasNext() {
        return current != null;
    }

    public void remove()  {
        throw new UnsupportedOperationException();
    }
}
