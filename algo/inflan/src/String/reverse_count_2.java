package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class reverse_count_2 {
    public void solution(char arr[]){
        for (char c:arr) {
            if((int)c>=97) c= (char)(c-32);
            else c =(char)(c+32);
            System.out.print(c);
        }
    }
    public static void main(String[] args)throws Exception {
        reverse_count_2 m = new reverse_count_2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char arr[] = br.readLine().toCharArray();
        m.solution(arr);
    }
}
