package Sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main04 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int arr[]= new int[N];
        for (int i = 0; i < N; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Main04 main = new Main04();
        ArrayDeque<Integer> temp =main.solution(S,N,arr);
        while (!temp.isEmpty()){
            System.out.print(temp.pollLast()+" ");
        }
    }

    private ArrayDeque<Integer> solution(int s, int n, int[] arr) {
        ArrayDeque<Integer> check = new ArrayDeque<>();
        for (int i : arr) {
            if(check.size()==s)
                check.poll();
            if(check.contains(i))
                check.remove(i);
            check.offer(i);
        }
        return check;
    }
}
