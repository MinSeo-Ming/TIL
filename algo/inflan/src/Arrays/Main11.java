package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11 {
    public int solution(int n , int[][] arr){
        int answer =0;

        int max=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) { //명수
            int cnt =0;
            for (int j = 0; j < n; j++) { //다른 사람
                for (int k = 0; k < 5; k++) {
                    if(arr[i][k]==arr[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(max<cnt) {
                max = cnt;
                answer =i;
            }
        }
        return answer+1;
    }
    public static void main(String[] args) throws Exception{
        Main11 m = new Main11();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][]arr = new int[n][5];
        for (int i = 0; i <n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; st.hasMoreElements(); j++) {
                arr[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(m.solution(n,arr));
    }
}
