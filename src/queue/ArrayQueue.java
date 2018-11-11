package queue;

import java.util.Scanner;

public class ArrayQueue<T> implements Queue<T>{

    private T data[];
    private int front,back,size;
    private static final int CAP = 1000;

    public ArrayQueue(){
        data = (T[]) new Object[CAP];
        front = back = size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(T x) throws Exception {
        if(size() == CAP)
            throw new Exception("Fill");
        data[back++] = x;
        if(back == CAP)
            back = 0;
        size++;
    }

    public T dequeue() throws Exception{
        if(isEmpty())
            throw new Exception("Finished");
        T answer = data[front++];
        if(front == CAP)
            front = 0;
        size--;
        return answer;
    }

    public String toString() {
        int i, j;
        String ans = "Array Queue<T>:  ";
        for (i = 0, j = front; i < size; i++, j++) {
            if (j == CAP)
                j = 0;
            ans += (data[j] + " -> ");
        }
        return ans;
    }

    public static void main(String args[]) {
        Queue<String> q = new ArrayQueue<String>();
        testQueue(q);
    }

    public static void testQueue(Queue<String> q) {
        boolean done = false;
        Scanner sc = new Scanner(System.in);
        while (!done) {
            try {
                System.out.print(q + "  ");
                System.out.println("\ncmds are + - Q: >>");
                String cmd = sc.next();
                String entry = null;
                char command = cmd.charAt(0);
                if (command == '+')
                    entry = sc.next();
                switch (cmd.charAt(0)) {
                    case 'Q':
                        done = true;
                        break;
                    case '+':
                        q.enqueue(entry);
                        break;
                    case '-':
                        q.dequeue();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error " + e.toString());
            }
        }
        sc.close();
    }
}
