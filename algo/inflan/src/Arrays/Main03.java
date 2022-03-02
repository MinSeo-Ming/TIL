package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main03 {
    public void solution(int n , String A[], String B[]){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            if(Integer.parseInt(A[i])==Integer.parseInt(B[i])) sb.append("D").append("\n");
            else if(Integer.parseInt(A[i])==1&&Integer.parseInt(B[i])==3)
                sb.append("A").append("\n");
            else if(Integer.parseInt(A[i])==3&&Integer.parseInt(B[i])==2)
                sb.append("A").append("\n");
            else if(Integer.parseInt(A[i])==2&&Integer.parseInt(B[i])==1)
                sb.append("A").append("\n");
            else sb.append("B").append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) throws Exception{
        Main03 m = new Main03();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N  = Integer.parseInt(br.readLine());
        String A[] = br.readLine().split(" ");
        String B[] = br.readLine().split(" ");
        m.solution(N,A,B);
    }
}
