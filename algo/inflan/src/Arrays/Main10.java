package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10 {
    public boolean check(int n , int x,int y){
        if(x<0||y<0||x>=n||y>=n)return false;
        return true;
    }
    public int solution(int n, int[][]arr){
        int answer =0;
        int dx[] = {-1,1,0,0};
        int dy[] = {0,0,-1,1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = false;
                for (int k = 0; k < 4; k++) {
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if(check(n,nx,ny)){
                        if(arr[i][j]>arr[nx][ny]) flag =true;
                        else{
                            flag =false;
                            break;
                        }
                    }
                }
                if(flag) answer++;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws Exception{
        Main10 m = new Main10();
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
