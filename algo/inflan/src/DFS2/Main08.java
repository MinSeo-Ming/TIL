package DFS2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main08 {
    static int memo[][];
    public static void main(String[] args) throws Exception {
        Main08 main = new Main08();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        memo = new int[n][n];
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]= i+1;
        }


        per(0,n,new int[n],0,arr,r);


    }
    static int solution(int n, int r,int end,int val){
        if(memo[end][0]==val){
            for (int i : memo[0]) {
                System.out.print(i+" ");
            }
        }
        if(memo[n][r]>0)return memo[n][r];
        else return memo[n][r] = solution(n-1,r-1,end,val)+solution(n-1,r,end,val);
    }
    static void per(int cnt,int n,int results[],int flag,int[]arr,int val){
        if(cnt == n){
            memo[0]= results;
            solution(n-1,0,n-1,val);

            return;
        }
        for (int i = 0; i < n; i++) {
            if((flag&1<<i) !=0) continue;
            results[cnt] = arr[i];
            per(cnt+1,n,results,flag|1<<i,arr,val);
        }
    }


}
