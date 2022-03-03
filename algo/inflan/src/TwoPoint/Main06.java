package TwoPoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main06 {
    public int solution(int n, int k, int[]arr){
        int answer =0,lt=0,count=0;
        for (int rt = 0; rt < n; rt++) {
            if(arr[rt]==0) count++;
            while (count>k){
                if(arr[lt]==0)count--;
                lt++;
            }
            answer = Math.max(answer,rt-lt+1);
        }
        return answer;
    }

    public static void main(String[] args) throws Exception{
        Main06 main = new Main06();
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
