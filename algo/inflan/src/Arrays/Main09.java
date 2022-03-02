package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main09 {
    public int solution(int n, int[][]arr){
        int answer=0;
        for (int a[]:arr) {
            int temp =0;
            for (int t:a) {
                temp+=t;
            }
            if(temp>answer) answer=temp;
        }
        for (int i = 0; i < n; i++) {
            int temp=0;
            for (int j = 0; j < n; j++) {
                temp+=arr[j][i];
            }
            if(temp>answer) answer=temp;
        }
        int start_l =0,start_r=n-1;//그냥 i,i 더하기 (i, n-i-1) 이렇게 처리하면된다.
        int temp =0,x=0;
        while (start_l<n){
            temp+= arr[x++][start_l++];
        }
        if(temp>answer) answer=temp;

        temp=0;
        x=0;
        while (start_r>=0){
            temp+= arr[x++][start_r--];
        }
        if(temp>answer) answer=temp;
        return answer;
    }
    public static void main(String[] args) throws Exception{
        Main09 m = new Main09();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][]arr = new int[n][n];
        for (int i = 0; i <n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; st.hasMoreElements(); j++) {
                arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(m.solution(n,arr));
    }
}
