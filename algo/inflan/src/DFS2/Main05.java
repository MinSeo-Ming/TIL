package DFS2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main05 {
    static int min =Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        Main05 main = new Main05();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");


        int arr[] =  new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
        }
        int goal = Integer.parseInt(br.readLine());

        main.solution(0,arr,n,goal);

        System.out.println(min);

    }
    static void solution(int cnt,int arr[],int n,int goal){
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{0,goal});
        while (!q.isEmpty()){
            int temp [] = q.poll();
            int coin = temp[0];
            int g = temp[1];
            if(g==0){
                min = Math.min(coin,min);
                return;
            }
            for (int i = 0; i < n; i++) {
                int ncoin = coin+1;
                int ng = temp[1]-arr[i];
                if(ng>=0){
                    q.offer(new int[]{ncoin,ng});
                }
            }
        }

    }


}
