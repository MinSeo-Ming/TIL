package TwoPoint;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main02 {
    public ArrayList<Integer> solution(int n, int []arr_1,int m, int[]arr_2){
        int p1=0 , p2 =0;
        ArrayList<Integer> answer= new ArrayList<>();
        while (p1<n&&p2<m){
            if(arr_1[p1]==arr_2[p2]) {
                answer.add(arr_1[p1]);
                p1++;
                p2++;
            }
            else if(arr_1[p1]<arr_2[p2]) p1++;
            else p2++;
        }
        return answer;
    }

    public static void main(String[] args) throws Exception{
        Main02 main = new Main02();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int arr_1[]= new int[n];
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr_1[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr_1);
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        int arr_2[]= new int[m];
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr_2[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr_2);
        br.close();
        for (int a :main.solution(n,arr_1,m,arr_2)){
            System.out.print(a+" ");
        }
    }
}
