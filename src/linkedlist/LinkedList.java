package linkedlist;

import node.Node;

import java.util.Scanner;

public class LinkedList<T> {
    private Node<T>  head;
    private Node<T> tail;
    private int size;


    public LinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    public LinkedList(Node<T> head, Node<T> tail, int size){
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addHead( T data) {
        Node<T> n = new Node<>(data, head);
        head = n;
        if (tail == null)
            tail = head;

        size++;
    }

    public void addTail( T data){
        Node<T> n = new Node<>(data,null);
        if(tail == null)
            head = tail = n;
        else
            tail.setNext(n);
            tail = n;
        size++;
    }

    public T removeHead() throws Exception{
        if(head == null)
            throw new Exception("Empty List");
        Node<T> n = head;
        head = head.getNext();
        if(head == null)
            tail = head;
        size--;

        return n.getData();
    }


    public String toString() {
        String ans = "";
        Node<T> n = head;
       // Node<T> t = tail;
        ans += "(H)-->";
        while (n != null) { //t != null
            ans += n.getData();
            ans += "-->";
           // ans += t.getData();
           // ans += "-->";
            n = n.getNext();
           // t = t.getNext();
        }
        return ans + "(T)";
    }


    public static void main(String[] args) {
        Node<Integer> n = new Node<>(5);
        Node<Integer> t = new Node<>(2);

        LinkedList<Integer> b = new LinkedList<>(n,t,1);
        System.out.println("This is b" + b);

        LinkedList<String> a = new LinkedList<>();

        a.addHead("3");a.addHead("4");a.addHead("5");a.addHead("6");
        System.out.println(a);




        try{

            System.out.println("What did I remove? " + a.removeHead());
            System.out.println(a);}
        catch (Exception e){System.out.println("Error");}

//        LinkedList<String>  a = new LinkedList<String>();
//                a.addHead("1"); a.addHead("2");a.addHead("3");
//        System.out.println(a);
//                try{System.out.println(a.removeHead());}
//                catch (Exception e){
//                    System.out.println("Error");
//                };
//        System.out.println(a);
//        LinkedList<String> l = new LinkedList<String>();
//        Scanner s = new Scanner(System.in);
//        while (true) {
//            System.out.println(l + "  :cmds are H T R Q: ");
//            String cmd = s.next();
//            if (cmd.charAt(0) == 'Q')
//                break;
//            if (cmd.charAt(0) == 'R')
//                try {
//                    l.removeHead();
//
//                } catch (Exception e) {
//                    System.out
//                            .println("Remove failed.  List was already empty!");
//                }
//            else {
//                String entry = s.next();
//                if (cmd.charAt(0) == 'H')
//                    l.addHead(entry);
//                if (cmd.charAt(0) == 'T')
//                    l.addTail(entry);
//            }
//        }
//        s.close();

    }
}
