package TwoPoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main03 {
    public int solution(int n ,int m, int arr[]){
        int answer =0,sum=0;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }
        answer =sum;
        for (int i = m; i < n; i++) {
            sum +=(arr[i]+arr[i-m]);
            answer = Math.max(sum,answer);
        }
        return answer;
    }
    /*
    public int solution(int n ,int m, int arr[]){
        int answer =0,sum=0;
        for (int i = 0; i < n-m; i++) {
            sum =0;
            for (int j = i; j < i+ m; j++) {
                sum+=arr[j];
            }
            if(answer<sum)answer=sum;
        }

        return answer;
    }*/
    public static void main(String[] args) throws Exception{
        Main03 main = new Main03();
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
