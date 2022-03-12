package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class fell_problem_8 {
    public void solution(String str){
        String ans = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]","");
        String temp = new StringBuilder(str).reverse().toString();
        if(temp.equals(str)) ans = "YES";
        System.out.println(ans);
    }
    public static void main(String[] args)throws Exception {
        fell_problem_8 m = new fell_problem_8();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        m.solution(str);
    }
}
