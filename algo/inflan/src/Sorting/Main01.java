package Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int arr[]= new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Main01 main = new Main01();
        int [] result = main.solution(arr,N);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }

    private int[] solution(int[] arr,int n) {

        for (int i = 0; i < n-1; i++) {
            int min_idx =i;
            for (int j = i+1; j < n; j++) {
                if(arr[j]<arr[min_idx])
                    min_idx=j;
            }
            swap(arr,i,min_idx);
        }
        return arr;
    }

    private void swap(int[] arr, int i, int min_idx) {
        int temp = arr[i];
        arr[i]=arr[min_idx];
        arr[min_idx] =temp;
    }
}
