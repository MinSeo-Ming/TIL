package Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main06 {
    public void solution(String arr[]){
        StringBuilder sb = new StringBuilder();
        for (String str:arr) {
            int n = Integer.parseInt(new StringBuilder(str).reverse().toString());
            boolean ch = true;
            for (int i = 2; i < (int)Math.sqrt(n)+1 ; i++) {
                if(n%i==0){
                    ch =false;
                    break;
                }
            }
            if(ch&&n!=1) sb.append(n).append(" ");
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) throws Exception{
        Main06 m = new Main06();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String arr[] = br.readLine().split(" ");
        m.solution(arr);
    }
}