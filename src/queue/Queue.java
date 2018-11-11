package queue;

public interface Queue<T> {
    public T dequeue() throws Exception;

    public void enqueue(T x) throws Exception;

    public boolean isEmpty();

    public int size();

}
