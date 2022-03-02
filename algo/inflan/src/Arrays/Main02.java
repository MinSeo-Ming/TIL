package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02 {
    public void solution(int N, String[]arr){
        int answer =1;
        int max = Integer.parseInt(arr[0]);
        for (int i = 0; i < N; i++) {
            if(Integer.parseInt(arr[i])>max) {
                answer++;
                max= Integer.parseInt(arr[i]);
            }
        }
        System.out.println(answer);
    }
    public static void main(String[] args) throws Exception{
        Main02 m = new Main02();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String [] arr = br.readLine().split(" ");
        m.solution(N,arr);
    }
}
