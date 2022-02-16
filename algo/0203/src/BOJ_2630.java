import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
    static char arr[][];
    static int N,white =0, blue=0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr =new char[N][N];
        for (int i = 0; i < N; i++) {
            String temp [] = br.readLine().split(" ");
            for (int j = 0; j<N; j++) {
                arr[i][j] = temp[j].charAt(0);

            }
        }
        solve(N,0,0);
        System.out.println(white+"\n"+blue);


    }
    static void solve(int len, int x,int y){
        //1. 영역 내에 속하면 점수 ++
        if(check(len,x,y)){
            if(arr[x][y]=='0') white++;
            else blue++;
            return;
        }
        //2. 아니라면~
        int half = len /2;
        solve(half,x,y);
        solve(half,x+half,y);
        solve(half,x,y+half);
        solve(half,x+half,y+half);
    }

    private static boolean check(int len, int x, int y) {
        char spot = arr[x][y];
        for(int i =x; i<x+len; i++){
            for (int j = y; j <y+len ; j++) {
                if(arr[i][j]!=spot){
                    return false;
                }
            }
        }
        return true;
    }
}
