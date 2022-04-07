package DFS2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main01 {
    static boolean flag =false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main01 main = new Main01();
        int n = sc.nextInt();
        int sum = 0;
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextInt();
            sum += arr[i];
        }
        main.solution(0,n,arr,new boolean[n],sum);
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }

    private void solution(int cnt,int n,int[]arr,boolean visited[],int sum) {
        if(cnt ==n){
            int ans=0;
            for (int i = 0; i < n; i++) {
                if(visited[i]) ans += arr[i];
            }
            if(sum-ans == ans){
                flag =true;
                return;
            }
            return;
        }
        visited[cnt]=true;
        solution(cnt+1,n,arr,visited,sum);
        visited[cnt]=false;
        solution(cnt+1,n,arr,visited,sum);
    }


}
