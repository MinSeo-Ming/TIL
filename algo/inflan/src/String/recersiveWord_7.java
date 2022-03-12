package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class recersiveWord_7 {
    public void solution(char arr[]){
        int lt =0,len = arr.length/2, rt = arr.length-1;

        boolean flag = true;
        while (lt<rt && lt <len){
            if(arr[lt]!=arr[rt]){
                flag =false;
                break;
            }
            lt++;rt--;
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
    public static void main(String[] args)throws Exception {
        recersiveWord_7 m = new recersiveWord_7();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char arr[] = br.readLine().toLowerCase().toCharArray();
        m.solution(arr);
    }
}
