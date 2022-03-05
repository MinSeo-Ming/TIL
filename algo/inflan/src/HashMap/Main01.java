package HashMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main01 {
    public char solution(int n, char [] arr){
        char answer=' ';
        HashMap<Character,Integer> vote = new HashMap<>();
        for (char c:arr) {
            vote.put(c,vote.getOrDefault(c,0)+1); //처음 알았음..... 없으면 0으로 나오는거...
        }
        int max =Integer.MIN_VALUE;
        for (char key: vote.keySet()){
            if(vote.get(key)>max){
                max = vote.get(key);
                answer=key;
            }
        }
        return answer;
        /*
        for (char c:arr) {
            if(!vote.containsKey(c))
                vote.put(c,1);
            else vote.replace(c,vote.get(c)+1);
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>(vote.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        return list.get(0).getKey();

         */
    }
    public static void main(String[] args) throws Exception {
        Main01 main = new Main01();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char arr[] = br.readLine().toCharArray();
        System.out.println(main.solution(n,arr));
    }
}
