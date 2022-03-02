package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12 {
    public int solution(int n, int m,int[][]arr){
        int answer =0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int cnt =0;
                for (int k = 0; k < m; k++) {
                    int pi=0;
                    int pj=0;
                    for (int s = 0; s < n; s++) {
                        if(arr[k][s]==i) pi =s;
                        if(arr[k][s]==j) pj =s;
                    }
                    if(pi<pj) cnt++;
                }
                if(cnt==m) answer++;
            }

        }
        return answer;
    }
    public static void main(String[] args) throws Exception{
        Main12 m = new Main12();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int [][]arr = new int[M][N];
        for (int i = 0; i <M ; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; st.hasMoreElements(); j++) {
                arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(m.solution(N,M,arr));
    }
}
/*
4 3
3 4 1 2
4 3 2 1
3 1 4 2
 */