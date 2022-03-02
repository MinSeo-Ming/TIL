package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main08 {
    public int[] solution(int[]arr,int n){
        int answer[] = new int[n];
        for (int i = 0; i <n ; i++) {
            int idx =1;
            for (int j = 0; j < n; j++) {
                if(arr[i]<arr[j]) idx++;
            }
            answer[i]=idx;
        }
        return answer;
    }
    public static void main(String[] args) throws Exception{
        Main08 m = new Main08();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int []arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i <n ; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        for (int a:m.solution(arr,n)) {
            System.out.print(a+" ");
        }
    }
}
