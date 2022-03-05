package HashMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main02 {
    public String solution(char [] str1,char [] str2){
        String answer="YES";
        HashMap<Character,Integer> temp1 = new HashMap<>();
        HashMap<Character,Integer> temp2= new HashMap<>();

        for (int i = 0; i <str1.length ; i++) {
            if (!temp1.containsKey(str1[i]))temp1.put(str1[i],1);
            else temp1.replace(str1[i],temp1.get(str1[i])+1);

        }
        for (int i = 0; i <str2.length; i++) {
            if(!temp2.containsKey(str2[i]))temp2.put(str2[i],1);
            else temp2.replace(str2[i],temp2.get(str2[i])+1);

        }
        for (Map.Entry<Character,Integer> check:temp1.entrySet()) {
            if(!temp2.containsKey(check.getKey())) {
                answer="NO";
                break;
            }else {
                if(temp2.get(check.getKey())!=check.getValue()){
                    answer="NO";
                    break;
                }
                else temp2.remove(check.getKey());
            }
        }
        if(temp2.size()!=0) answer="NO";
        return answer;
    }
    public static void main(String[] args) throws Exception {
        Main02 main = new Main02();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char str1[] = br.readLine().toCharArray();
        char str2[] = br.readLine().toCharArray();
        System.out.println(main.solution(str1,str2));
    }
}
