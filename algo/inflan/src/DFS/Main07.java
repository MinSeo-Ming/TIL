package DFS;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main07 {
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
        Main07 main = new Main07();
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        main.bfs();

    }

    public void bfs(){
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()){
            Node pop = q.poll();
            System.out.print(pop.data+" ");
            if(pop.left!=null){
                q.offer(pop.left);
            }if(pop.right!=null){
                q.offer(pop.right);
            }
        }
    }
}
