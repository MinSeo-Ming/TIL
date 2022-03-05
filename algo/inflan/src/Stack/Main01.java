package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class Main01 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Main01 main = new Main01();
        main.solution(arr);
    }

    private void solution(char[] arr) {
        ArrayDeque<Character>stack = new ArrayDeque<Character>();
        String flag = "YES";
        out:for (char c : arr) {
            switch (c){
                case '(':
                    stack.add('(');
                    break;
                case ')':
                    if(stack.isEmpty()){
                        flag ="NO";
                        break out;
                    }
                    stack.pop();
                    break;
            }
        }
        if(!stack.isEmpty()) flag="NO";
        System.out.println(flag);
    }
}
