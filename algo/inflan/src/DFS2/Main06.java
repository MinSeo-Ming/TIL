package DFS2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main06 {
    static int max =Integer.MIN_VALUE;
    public static void main(String[] args) throws Exception {
        Main06 main = new Main06();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int arr[] =  new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =i+1;
        }

        main.solution(0,new int [r],arr,r,n,0);

        System.out.println(max);

    }
    static void solution(int cnt,int results[],int arr[],int r,int n,int start){
        if(cnt == r){
            for (int i = 0; i <r ; i++) {
                System.out.print(results[i]+" ");
            }
            System.out.println();

            return;
        }
        for (int i = 0; i < n; i++) {
            results[cnt] = arr[i];
            solution(cnt+1,results,arr,r,n,i);
        }


    }


}
