package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class outNumber_9 {
    public void solution(String str){
        str = str.toUpperCase().replaceAll("[^0-9]","");
        System.out.println(Integer.parseInt(str));
    }
    public static void main(String[] args)throws Exception {
        outNumber_9 m = new outNumber_9();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        m.solution(str);
    }
}
