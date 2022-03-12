package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Duplicate_6 {
    public void solution(char arr[]){
        Set<Character> set = new LinkedHashSet<>();
        for (char c :arr) {
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (char c:set) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }

    /*
    String ans = "";
        for(int i =0; i < str.length(); i++) {
          //  System.out.println( str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
            // str.charAt(i) 가 처음 나왔다면 str.indexOf(str.charAt(i)) 와 i가 같다.
            // indexOf는 해당되는 문자열에 제일 처음 나온 인덱스를 반환한다.
            if(str.indexOf(str.charAt(i)) == i) {
                ans += str.charAt(i);
            }
        }

        return ans;
    }
    * */
    public static void main(String[] args)throws Exception {
        Duplicate_6 m = new Duplicate_6();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char arr[] = br.readLine().toCharArray();
        m.solution(arr);
    }
}
