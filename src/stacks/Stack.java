package stacks;

public interface Stack<T> {

    public T pop() throws Exception;

   public void push(T x) throws Exception;

    public boolean isEmpty();

    public int size();
}
