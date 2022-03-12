package Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main05 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int arr[]= new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Main05 main = new Main05();
        System.out.println(main.solution(arr));
    }

    private char solution(int[] arr) {
        char answer ='U';
        HashSet<Integer> check = new HashSet<>();
        for (int i : arr) {
            if(check.contains(i)){
                answer='D';
                break;
            }
            check.add(i);
        }
        return answer;
    }
}
