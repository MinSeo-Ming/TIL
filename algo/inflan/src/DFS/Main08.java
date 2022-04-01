package DFS;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main08 main = new Main08();
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(main.solution(s,e));
    }

    private int solution(int s,int e) {
        int move[] = {1,-1,5};
        int ch[]=new int[10001];
        ch[s]=1;
        int L =0;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(s);
        while (!q.isEmpty()){
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int temp = q.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = temp+move[j];
                    if(nx==e) {
                        return L+1;
                    }
                    if(nx>=1 &&nx<=10000 &&ch[nx]==0){
                        ch[nx]=1;
                        q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }
}
