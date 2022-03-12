package Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main08 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        TreeSet<Integer> list = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int cnt =0;
        for (Integer integer : list) {
            cnt++;
            if(integer==M){
                System.out.println(cnt);
                return;
            }
        }
        Main08 main = new Main08();
//        System.out.println(main.solution());
    }
}
