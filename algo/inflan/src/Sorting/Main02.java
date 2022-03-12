package Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int arr[]= new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Main02 main = new Main02();
        int [] result = main.solution(arr,N);
        for (int i : result) {
            System.out.print(i+" ");
        }
    }

    private int[] solution(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int target = arr[i];

            int j =i-1;
            while (j>=0 && target< arr[j]){
                arr[j+1]= arr[j];
                j--;
            }
            arr[j+1] =target;
        }
        return arr;
    }

    //private int[] solution(int[] arr, int n) {
    //        for (int i = 1; i < n; i++) {
    //            int temp = arr[i] ,j;
    //            for (j = i-1; j >=0;  j--) {
    //                if(arr[j]>temp)
    //                    arr[j+1] =arr[j];
    //                else break;
    //            }
    //            arr[j+1]= temp;
    //
    //        }
    //        return arr;
    //    }

}
