package TwoPoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main05 {
    public int solution2(int n){
        int answer =0,cnt=1;
        n--;
        while(n>0){
            cnt++;
            n = n-cnt;
            if(n%cnt==0)answer++;
        }

        return answer;
    }
    public int solution(int n){
        int answer =0,lt =0, sum=0;
        int half = n/2 +1;
        int [] arr= new int[half];
        for (int i = 0; i < half ; i++) arr[i] =i+1;
        for (int rt = 0; rt < half; rt++) {
            sum+=arr[rt];
            if(sum==n) answer++;
            while(sum>=n){
                sum-=arr[lt++];
                if(sum==n)answer++;
            }
        }

        return answer;
    }/*
    public int solution(int n){
        int answer =0;
        int half = n/2 +1;
        for (int i = 1; i < half ; i++) {
            int sum =0;
            for (int j = i; j < n; j++) {
                sum+=j;
                if(sum==n){
                    answer++;
                    break;
                }else if(sum>n) break;
            }
        }

        return answer;
    }*/
    public static void main(String[] args) throws Exception{
        Main05 main = new Main05();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();
        System.out.println(main.solution(n));
    }
}
