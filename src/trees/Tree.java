package trees;

import java.util.Iterator;

import java.util.ArrayList;

public class Tree {

    protected  TNode root;
    public int size;

    // Constructor
    public Tree(){
        root = null;
        size = 0;
    }

    public Tree( TNode root, int size){
        this.root = root;
        this.size = size;
    }


    // Gets the root
    public boolean isRoot(TNode node){
        return node == root;
    }
    //Check if its an internal node. This means it has children
    public boolean isInternal(TNode node){
        return node.children().hasNext();
    }
    //Check if it is a leaf. Uses isInternal negation
    public boolean isLeaf(TNode node){
        return !isInternal(node);
    }


    public int depth(TNode node){
        if(isRoot(node))
            return 0;
        return 1 + depth(node.getParent());
    }

    public int height(TNode node){
        if(isLeaf(node))
            return 0;
        int maxChild = 0;
        java.util.Iterator<TNode> c = node.children();
        while (c.hasNext()){
            int hc = height(c.next());
            if(hc > maxChild)
                maxChild = hc;
        }
        return maxChild +1;

    }
    public int height(){
        if(root == null)
            return -1;
        return height(root);
    }

    public ArrayList<TNode> preOrder() {
        ArrayList<TNode> answer = new ArrayList<>();
        preOrder(root(), answer);
        return answer;
    }

    public void preOrder(TNode node, ArrayList<TNode> nodeOrder) {
        if (node == null)
            return;
        nodeOrder.add(node);
        Iterator<TNode> x = node.children();
        while (x.hasNext()) {
            TNode m = x.next();
            preOrder(m, nodeOrder);
        }
    }

    public ArrayList<TNode> postOrder() {
        ArrayList<TNode> answer = new ArrayList<TNode>();
        postOrder(root(), answer);
        return answer;
    }

    public void postOrder(TNode node, ArrayList<TNode> nodeOrder) {
        if (node == null)
            return;
        Iterator<TNode> x = node.children();
        while (x.hasNext()) {
            TNode m = x.next();
            postOrder(m, nodeOrder);
        }
        nodeOrder.add(node);
    }

    public ArrayList<TNode> levelOrder() {
        ArrayList<TNode> waiting = new ArrayList<>();
        waiting.add(null);
        if (root() == null)
            return waiting;
        waiting.add(root());
        int done = 0;
        while (done < waiting.size()) {
            TNode oldNode = waiting.get(done++);
            if (oldNode == null) {
                if (done < waiting.size())
                    waiting.add(null);
                continue;
            }
            Iterator<TNode> c = oldNode.children();
            while (c.hasNext())
                waiting.add(c.next());
        }
        return waiting;
    }

    public ArrayList<TNode> flatOrder() {
        return preOrder();
    }

    public String toString() {
        return treePrint(null);
    }

    public String treePrint(TNode cursor) {
        String answer = "  ";
        Iterator<TNode> lev = levelOrder().iterator();
        Iterator<TNode> flat = flatOrder().iterator();
        lev.next(); // skip first new line
        while (lev.hasNext()) {
            TNode o = lev.next();
            if (o == null) {
                answer += "\n  ";
                flat = flatOrder().iterator();
            } else
                while (true) {
                    boolean atCursor = false;
                    TNode n = flat.next();
                    if (n == cursor)
                        atCursor = true;
                    String s = n.printData();
                    if (atCursor)
                        s = "* " + s + " *";
                    if (n == o) {
                        answer += s + " ";
                        break;
                    } else {
                        for (int i = 0; i < s.length(); i++)
                            answer += ' ';
                        answer += ' ';
                    }
                }
        }
        return answer;
    }

    // Get the parents of the current node
    public TNode parent(TNode node){
        return node.getParent();
    }
    public TNode root() {
        return root;
    }
    // return size of the tree
    public int size(){
        return size;
    }
    // tells if the tree is empty or not
    public boolean isempty(){
       return size == 0;
    }








}
