package DFS;

import java.util.Arrays;
import java.util.Scanner;

public class Main06 {
    static int data[],result[];
    static boolean visited[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main06 main = new Main06();
        int num =sc.nextInt();
        data = new int[num];
        result = new int[num];
        visited = new boolean[num];
        for (int i = 1; i <=num ; i++) {
            data[i-1] =i;
        }
        main.solution(0,num);
        for (int i = 1; i <=num ; i++) {
            main.combi(0,0,i);

        }

    }

    private void solution(int cnt,int num) {
        if(cnt ==num){
            for (int i = 0; i < num; i++) {
                if(visited[i]) System.out.print(data[i]);
            }
            System.out.println();
            return;
        }
        visited[cnt]=true;
        solution(cnt+1,num);
        visited[cnt]=false;
        solution(cnt+1,num);


    }
    public void combi(int cnt ,int start, int num){
        if(cnt==num){
            for (int i : result) {
                if(i==0)continue;
                else System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <3 ; i++) {
            result[cnt] = data[i];
            combi(cnt+1,i+1,num);
        }
    }
}
