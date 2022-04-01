package DFS2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main15 {
    static int N,M;
    static int[][] arr;
    static int selected[][];
    static boolean visited[][];
    public static void main(String[] args) throws Exception {
        Main15 main = new Main15();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
         N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr =new int[N][N];
        visited  = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; st.hasMoreTokens(); j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }

        }

        main.bfs();
    }

    private void bfs() {
//        Queue<Integer>
    }


}
