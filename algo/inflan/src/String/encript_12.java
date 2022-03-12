package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class encript_12 {
    public void solution(String str,int n){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            String temp= str.substring(i*7,(i+1)*7).replace('#','1').replace('*','0');

            sb.append((char) Integer.parseInt(temp,2));
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args)throws Exception {
        encript_12 m = new encript_12();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        br.close();
        m.solution(str,N);
    }
}
