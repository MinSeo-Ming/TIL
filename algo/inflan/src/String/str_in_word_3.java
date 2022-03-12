package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class str_in_word_3 {
    public void solution(String arr[]){
        int idx =0,i=0,len = arr[0].length();
        for (String str:arr) {
            if(str.length()>len) idx =i;
            i++;
        }
        System.out.println(arr[idx]);
    }
    public static void main(String[] args)throws Exception {
        str_in_word_3 m = new str_in_word_3();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr[] = br.readLine().split(" ");
        m.solution(arr);
    }
}
