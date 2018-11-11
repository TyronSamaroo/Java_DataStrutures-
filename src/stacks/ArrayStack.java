package stacks;


import java.util.Scanner;

 class ArrayStack<T> implements Stack<T> {
    private static final int CAP = 1000;
    private T data[];
    private int top;

    public ArrayStack(){
        data = (T[]) new Object[CAP];
        top = -1;
    }


     public boolean isEmpty() {
         return top == -1;
     }

         //The size would technically be 0
     public int size() {
         return top +1;
     }

    public void push( T x) throws Exception{
        if(size() == 1000)
            throw new Exception("Stack Full");
       data[++top] = x;
    }


     public T pop() throws Exception{
         if(isEmpty())
             throw new Exception("Stack Empty");
         return data[top--];
     }

    public String toString() {
        String ans = "Array Stack<T>:  ";
        for (int i = top; i >= 0; i--)
            ans += (data[i] + " -> ");
        return ans;
    }


    public static void main(String[] args) {
        Stack<String> s = new ArrayStack<>();
        testStack(s);

    }

    public static void testStack(Stack<String> s) {
        boolean done = false;
        Scanner sc = new Scanner(System.in);
        while (!done) {
            try {
                System.out.print(s + "  ");
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
                        s.push(entry);
                        break;
                    case '-':
                        s.pop();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error " + e.toString());
            }
        }
        sc.close();
    }


}
