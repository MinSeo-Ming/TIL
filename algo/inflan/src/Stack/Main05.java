package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main05 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main05 main = new Main05();
        char arr[] = br.readLine().toCharArray();
        System.out.println(main.solution(arr));
    }

    private int solution(char[] arr) {
        int answer = 0;
        char check='-';//바로 앞 인덱스
        Stack<Character> stick = new Stack<>();
        for (char c : arr) {
            if(c=='(')
                stick.push(c);
            else{
                stick.pop();
                if(check=='(') {
                    answer += stick.size();
                }else{
                    answer+=1;
                }
            }
            check=c;
        }

        return answer;
    }
}
