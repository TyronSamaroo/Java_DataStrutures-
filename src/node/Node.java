package node;

import java.util.Scanner;

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node() {
        data = null;
        next = null;
    }

    public Node(T data ){
        this.data = data;

    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }


    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;

    }

    @Override
    public String toString() {
        Node current = this;
        String result = "";
        while (current != null) {
            result +=  current.getData();
            result += "-->";

            current = current.getNext();
        }
        return "Node: " + result;
    }


    public static void main(String[] args) {

        // My own testing of nodes in a weird way lol ????
        Node<String> empty = new Node<String>();
        Node<String> a = new Node<String>("A",empty);
        Node<String> b = new Node<String>("B", a);
//
       System.out.println(b);
        Node<Object> data = new Node<Object>();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("  Use Command D to Add Nodes)");
            System.out.println("Current Set of Node is " + data);
            String choice = scan.next();
            String datapoint = scan.next();
            if(choice.charAt(0) == 'D')
                data = new Node<>(datapoint,data);
            if(choice.charAt(0) == 'Q')
                break;
            }


    }


}