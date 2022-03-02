package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main04 {
    public int[] solution(int n){
        int []answer = new int[n];
        answer[0]=1;
        answer[1]=1;
        for (int i = 2; i < n ; i++) {
            answer[i] =answer[i-1]+answer[i-2];
        }

        return answer;
    }
    public static void main(String[] args) throws Exception{
        Main04 m = new Main04();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i : m.solution(n)) {
            sb.append(i+" ");
        }
        System.out.println(sb.toString());
    }
}
