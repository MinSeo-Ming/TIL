package Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main03 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int arr[]= new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Main03 main = new Main03();
        int [] result = main.solution(arr,N);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }

    private int[] solution(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n-1 ; j++) {
                if(arr[j]>arr[j+1])
                    swap(arr,j,j+1);
            }

        }
        return arr;
    }


    private void swap(int[] arr, int i, int min_idx) {
        int temp = arr[i];
        arr[i]=arr[min_idx];
        arr[min_idx] =temp;
    }
}
