package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main02 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main02 main = new Main02();
        char[] arr = br.readLine().toCharArray();
        main.solution(arr);
    }

    private void solution(char[] arr) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()){
                if(arr[i]!='(') sb.append(arr[i]);
                else stack.add('(');
            }
            else{
                if(arr[i]==')'){
                    while (true) if(stack.pollLast()=='(')break;
                }else stack.add(arr[i]);
            }
        }
        System.out.println(sb.toString());
    }
}
