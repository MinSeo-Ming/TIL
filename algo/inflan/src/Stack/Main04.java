package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main04 {

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main04 main = new Main04();
        char arr[] = br.readLine().toCharArray();
        System.out.println(main.solution(arr));
    }

    private int solution(char[] arr) {
        int answer =0;
        Stack<Integer> temp = new Stack<>();
        for (Character c : arr) {
            if(!Character.isDigit(c)){
                int a = temp.pop();
                int b = temp.pop();
                int result =cal(b,a,c);
                temp.push(result);
            }else{
                int cc = c-'0';
                temp.push(cc);
            }
        }
        answer=temp.pop();
        return answer;
    }

    private int cal(int b, int a,char op) {
        int result='0';
        if(op=='+'){
            result=(a+b);
        }
        else if(op=='-'){
            result= (b-a);
        }
        else if(op=='*'){

            result= (b*a);
        }
        else if(op=='/') {
            result=(b/a);
        }
        return result;
    }
}
