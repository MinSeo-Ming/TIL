package TwoPoint;

import java.io.*;
import java.util.*;

public class Main01 {
    public ArrayList<Integer> solution(int n , int[] arr,int m, int[]arr2){
        ArrayList<Integer> answer = new ArrayList<>();
        int p1=0,p2=0;
        while(p1<n&&p2<m){
            if(arr[p1]<arr2[p2]) answer.add(arr[p1++]);
            else answer.add(arr2[p2++]);
        }
        Collections.sort(answer);
        return answer;
    }
    public static void main(String[] args) throws Exception{
        Main01 main = new Main01();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int []arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<n; i++) arr[i]= Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        int []arr2 = new int[m];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0; i<m; i++) arr2[i]= Integer.parseInt(st.nextToken());
        br.close();
        for(int a :main.solution(n,arr,m,arr2))
            System.out.print(a+" ");
    }
}