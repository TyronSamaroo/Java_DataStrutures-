package stacks;

import node.Node;

public class LinkedStack<T> implements Stack<T>{

    private Node<T> top;
    private int size;

    public LinkedStack(){
        top = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public T pop() throws Exception{
        if(isEmpty())
            throw new Exception("Lis is empty");
        T answer = top.getData();
        top = top.getNext();
        size--;
        return answer;
    }
    public void push(T x){
        Node<T> newtop = new Node<T>(x,top);
        top = newtop;
        size++;
    }
    public String toString() {
        String ans = "Linked Stack<T>:  ";
        Node<T> n = top;
        while (n != null) {
            ans += (n.getData() + " -> ");
            n = n.getNext();
        }
        return ans;
    }

    public static void main(String args[]) {
        Stack<String> s = new LinkedStack<>();
        ArrayStack.testStack(s);
    }


}