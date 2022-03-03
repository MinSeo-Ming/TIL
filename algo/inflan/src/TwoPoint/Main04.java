package TwoPoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main04 {
    public int solution(int n, int m, int[]arr) {
        int answer = 0, sum =0, lt =0;
        for (int rt = 0; rt < n; rt++) {
            sum+=arr[rt];
            if(sum==m) answer++;
            while (sum>=m){
                sum-=arr[lt++];
                if(sum==m) answer++;
            }
        }
        return answer;
    }
    /*
    public int solution(int n, int m, int[]arr){
        int answer =0;
        for (int i = 0; i < n; i++) {
            int sum =0;
            for (int j = i; j < n; j++) {
                sum +=arr[j];
                if(sum==m){
                    answer++;
                    break;
                }
                if(sum>m) break;
            }
        }

        return answer;
    }*/
    public static void main(String[] args) throws Exception{
        Main04 main = new Main04();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int arr[]  = new int[n];
        for (int i = 0; st.hasMoreTokens();  i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        br.close();
        System.out.println(main.solution(n,k,arr));
    }
}
