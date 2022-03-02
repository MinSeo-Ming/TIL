package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main05 {
    public int solution(int n){
        int answer =0;
        boolean nums[] = new boolean[n+1];
        nums[0]=true;
        nums[1]=true;
        int num =2;
        while (num<=n){
            if(!nums[num]){
                int end = n/num;
                for (int i = 2; i <=end ; i++) {
                    nums[i*num] =true;
                }
            }
            num++;

        }
        for (boolean ch: nums) {
            if(!ch) answer++;
        }

        return answer;
    }
    public static void main(String[] args) throws Exception{
        Main05 m = new Main05();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(m.solution(n));
    }
}
