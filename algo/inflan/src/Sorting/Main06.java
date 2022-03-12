package Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
        ArrayList<Integer> result = new ArrayList<>();
        int sorted[] = arr.clone();
        Arrays.sort(sorted);
        int idx =0;
        for (int i = 0; i < n; i++) {
            if(arr[i]!=sorted[i]){
                result.add(i+1);
            }
        }
        for (int i : result) {
            System.out.print(i+" ");
        }
    }
}
