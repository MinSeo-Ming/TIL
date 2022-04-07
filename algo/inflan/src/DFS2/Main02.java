package DFS2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02 {
    static int max =Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        Main02 main = new Main02();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int arr[] =  new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =Integer.parseInt(br.readLine());
        }

        main.solution(0, new boolean[n],arr,n,c);

        System.out.println(max);

    }
    static void solution(int cnt,boolean visited[],int arr[],int n,int c){
        if(cnt == n){
            int sum =0;
            for (int i = 0; i < n; i++) {
                if(visited[i]) sum += arr[i];
            }
            if(sum<=c) {
                max = Math.max(max, sum);
            }
            return;
        }
        visited[cnt]=true;
        solution(cnt+1,visited,arr,n,c);
        visited[cnt]=false;
        solution(cnt+1,visited,arr,n,c);

    }


}
