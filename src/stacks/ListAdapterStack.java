package stacks;

import linkedlist.LinkedList;

public class ListAdapterStack<T> implements Stack<T>  {
    private LinkedList<T> a;

    public ListAdapterStack(){
        a = new LinkedList<T>();
    }

    public T pop() throws Exception{
       return a.removeHead();
    }

    public void push(T x) throws Exception{
        a.addHead(x);
    }

    public boolean isEmpty(){
        return a.isEmpty();
    }
    public int size(){
        return a.size();

    }

    public String toString(){
        return a.toString();
    }


    public static void main(String args[]) {
        Stack<String> s = new ListAdapterStack<>();
        ArrayStack.testStack(s);
    }
}
