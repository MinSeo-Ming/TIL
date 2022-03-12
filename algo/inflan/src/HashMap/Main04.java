package HashMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main04 {
    static ArrayList<String> anagrams = new ArrayList<>();
    static char [] ana_result;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        Main04 main = new Main04();
        String str = br.readLine();
        String ana = br.readLine();
        ana_result = new char[ana.length()];
        main.solution(str,ana);
    }

    private void solution(String str, String ana) {
        int answer =0;

        HashMap<Character,Integer> am = new HashMap<>();
        HashMap<Character,Integer> bm = new HashMap<>();
        for (char c : ana.toCharArray()) {
            bm.put(c,bm.getOrDefault(c,0)+1);
        }
        int L = ana.length()-1;
        for (int i = 0; i < L; i++) {
            am.put(str.charAt(i),am.getOrDefault(str.charAt(i),0)+1);
        }
        int lt =0;
        for (int rt = L; rt < str.length(); rt++) {
            am.put(str.charAt(rt),am.getOrDefault(str.charAt(rt),0)+1);
            if(am.equals(bm)) answer++;
            am.put(str.charAt(lt),am.get(str.charAt(lt))-1);
            if(am.get(str.charAt(lt))==0) am.remove(str.charAt(lt));
            lt++;
        }
        System.out.println(answer);
    }




}
