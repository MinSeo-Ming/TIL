package Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main06 {
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main06 main = new Main06();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        System.out.println(main.solution(N,M));
    }

    private int solution(int n, int m) {
        int answer =0;
        Queue<Integer> people = new ArrayDeque<>();
        for (int i = 1; i <=n ; i++) {
            people.offer(i);
        }
        int count =1;
        while (people.size()!=1){
            int num  =people.poll();
            if(count%m!=0){
                people.offer(num);
            }
            count++;
        }
        answer =people.poll();
        return answer;
    }
}
