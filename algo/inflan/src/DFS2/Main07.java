package DFS2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main07 {
    static int memo[][];
    public static void main(String[] args) throws Exception {
        Main07 main = new Main07();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        memo = new int[n+1][n+1];


        System.out.println(main.solution(n,r));


    }
    static int solution(int n, int r){
        if(memo[n][r]>0)return memo[n][r];
        if(n ==r|r==0) return 1;
        else return memo[n][r] = solution(n-1,r-1)+solution(n-1,r);
    }


}
