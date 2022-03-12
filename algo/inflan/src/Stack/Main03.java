package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main03 {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main03 main = new Main03();
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; st.hasMoreTokens(); j++) {
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int m = Integer.parseInt(br.readLine());

        int move[] = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; st.hasMoreTokens();  i++) {
            move[i]=Integer.parseInt(st.nextToken());
        }
        System.out.println(main.solution(n,arr,m,move));
    }

    private int solution(int n, int[][] arr, int m, int[] move) {
        int answer =0;
        Stack<Integer> list = new Stack<>();
        for (int i = 0; i < m; i++) {
            int y = move[i]-1;
            out: for (int j = 0; j < n; j++) {
                if(arr[j][y]!=0){
                    if(!list.isEmpty()&&list.peek()==arr[j][y]){
                        list.pop();
                        arr[j][y]=0;
                        answer+=2;

                    }
                    else{
                        list.add(arr[j][y]);
                        arr[j][y]=0;
                    }
                    break out;
                }
            }
        }
        return answer;
    }
}
