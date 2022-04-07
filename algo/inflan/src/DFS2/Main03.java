package DFS2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main03 {
    static int max =Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        Main03 main = new Main03();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        int arr[][] =  new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()," ");
            arr[i][0] =Integer.parseInt(st.nextToken());
            arr[i][1] =Integer.parseInt(st.nextToken());
        }

        main.solution(0,new boolean[n],arr,n,time);

        System.out.println(max);

    }
    static void solution(int cnt,boolean visited[],int arr[][],int n,int time){
        if(cnt == n){
            int sum =0;
            int time_cnt=0;
            for (int i = 0; i < n; i++) {
                if(visited[i]&&(time-time_cnt)>=arr[i][1]){
                    time_cnt += arr[i][1];
                    sum += arr[i][0];
                }
            }

            max = Math.max(max, sum);

            return;
        }
        visited[cnt]=true;
        solution(cnt+1,visited,arr,n,time);
        visited[cnt]=false;
        solution(cnt+1,visited,arr,n,time);

    }


}
