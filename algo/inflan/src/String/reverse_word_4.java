package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class reverse_word_4 {
    public void solution(String arr[]){
        StringBuilder sb = new StringBuilder();
        for (String str:arr) {
            for(int i=str.length()-1; i>=0; i--){
                sb.append(str.charAt(i));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args)throws Exception {
        reverse_word_4 m = new reverse_word_4();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String arr[]= new String[N];
        for(int i=0; i<N; i++) arr[i] =br.readLine();
        br.close();
        m.solution(arr);
    }
}
