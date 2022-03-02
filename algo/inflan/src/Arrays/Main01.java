package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main01 {
    public void solution(int N,String s){
        String arr[] = s.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]+" ");
        for (int i=1; i<N; i++) {
            if(Integer.parseInt(arr[i-1])<Integer.parseInt(arr[i]))
                sb.append(Integer.parseInt(arr[i])).append(" ");
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) throws Exception{
        Main01 m = new Main01();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        m.solution(N,s);
    }
}
