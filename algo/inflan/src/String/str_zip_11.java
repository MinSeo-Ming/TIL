package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class str_zip_11 {
    public void solution(String str){
        StringBuilder sb = new StringBuilder();
        char ch = str.charAt(0);
        int count=1;
        sb.append(ch);
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i)==ch) count++;
            else{
                if(count!=1) sb.append(count);
                ch = str.charAt(i);
                sb.append(ch);
                count=1;
            }
        }
        if(count!=1)sb.append(count);
        System.out.println(sb.toString());
    }
    public static void main(String[] args)throws Exception {
        str_zip_11 m = new str_zip_11();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        br.close();
        m.solution(str);
    }
}
