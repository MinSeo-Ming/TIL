package DFS;

import java.util.Scanner;

public class Main05 {
    static class Node{
        int data ;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left=right=null;
        }
    }
    static Node root;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main05 main = new Main05();
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        main.pre(root);
        System.out.println();
        main.in(root);
        System.out.println();
        main.post(root);

    }

    private void post(Node root) {
        if(root.left!=null) post(root.left);
        if(root.right!=null) post(root.right);
        System.out.print(root.data+" ");
    }
    private void pre(Node root) {
        System.out.print(root.data+" ");
        if(root.left!=null)pre(root.left);
        if(root.right!=null)pre(root.right);
    }
    private void in(Node root) {
        if(root.left!=null)in(root.left);
        System.out.print(root.data+" ");
        if(root.right!=null)in(root.right);
    }
}
