package Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main06 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int arr[]= new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Main06 main = new Main06();
        main.solution(N,arr);
    }

    private void solution(int n, int[] arr) {
        int result [] = new int[2];

        for (int i = 1; i < n-1; i++) {
            if(arr[i]>arr[i+1]){
                if(result[0]==0) result[0]=i+1;
                break;
            }

        }
        result[1]= n-result[0];
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
}
