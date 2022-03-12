package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class reverse_sep_5 {
    public void solution(String str){
        String answer ;
        char [] temp = str.toCharArray();
        int lt =0, rt = str.length()-1;
        while (lt<rt){
            if(!Character.isAlphabetic(temp[lt])) lt++;
            else if(!Character.isAlphabetic(temp[rt]))rt--;
            else {
                char t = temp[lt];
                temp[lt] =temp[rt];
                temp[rt]=t;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(temp);
        System.out.println(answer);
    }
    public static void main(String[] args)throws Exception {
        reverse_sep_5 m = new reverse_sep_5();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String arr[] = br.readLine().split("");
        String arr = br.readLine();
        br.close();
//        System.out.println((int)'z'+" " +(int)'Z');
        m.solution(arr);
    }
}
