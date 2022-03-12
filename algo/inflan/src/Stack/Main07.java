package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main07 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main07 main = new Main07();
        String order  =br.readLine();
        char arr [] =br.readLine().toCharArray();
        System.out.println(main.solution(order,arr));
    }

    private String solution(String order, char[] arr) {
        String answer ="YES";
        Queue<Character> check = new ArrayDeque<>();
        for (int i=0; i<order.length(); i++) {
            check.offer(order.charAt(i));
        }
        for (char c : arr) {
            if(order.indexOf(c)!=-1){
                if(check.poll()!=c){
                    answer="NO";
                    break;
                }
            }
        }
        if(!check.isEmpty())answer="NO";
        return answer;
    }
}
