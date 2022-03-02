package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main07 {
    public int solution(int []arr,int n){
        int answer =0;
        int cont =0;
        for (int i = 0; i < n; i++) {
            if(arr[i]==1) ++cont;
            else if(arr[i]==0) cont=0;
            answer+= cont;
        }
        return answer;
    }
    public static void main(String[] args) throws Exception{
        Main07 m = new Main07();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int []arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i <n ; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        System.out.println(m.solution(arr,n));
    }
}
