package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class short_len_10 {
    public void solution(String str,String ch){
        StringBuilder sb = new StringBuilder();
        int start = str.indexOf(ch);
        for (int i = 0; i < str.length(); i++) {
            int temp =str.indexOf(ch,i);
            int m = Math.abs(i-start);
            int n = Math.abs( i-temp);
            if(n<m)start =temp;
            sb.append(Math.min(m,n)+" ");

        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args)throws Exception {
        short_len_10 m = new short_len_10();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        String str = st.nextToken();
        String ch = st.nextToken();
        m.solution(str,ch);
    }
}
