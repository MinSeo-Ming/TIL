package DFS2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main06 {
    public static void main(String[] args) throws Exception {
        Main06 main = new Main06();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int arr[] =  new int[n];
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < n; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
        }

        main.solution(0,new int [r],arr,r,n,0);


    }
    static void solution(int cnt,int results[],int arr[],int r,int n,int flag){
        if(cnt == r){
            for (int i = 0; i <r ; i++) {
                System.out.print(results[i]+" ");
            }
            System.out.println();

            return;
        }
        for (int i = 0; i < n; i++) {
            if((flag&1<<i) !=0) continue;
            results[cnt] = arr[i];
            solution(cnt+1,results,arr,r,n,flag|1<<i);
        }


    }


}
