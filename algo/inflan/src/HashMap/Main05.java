package HashMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main05 {
    static TreeSet<Integer> set = new TreeSet<Integer>(( o1, o2)-> o2.compareTo(o1));
    static int temp[] ;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int [] arr = new int[N];
        for (int i = 0; st.hasMoreTokens(); i++) {
            arr[i] =Integer.parseInt(st.nextToken());
        }
        br.close();
        Main05 main = new Main05();

        System.out.println(main.soultion(N, K, arr));
    }

    private int soultion(int n, int k, int[] arr) {
        temp = new int[3];
        duplicombi(0,0,n,arr);

        List<Integer> list = new ArrayList<>(set);

        return set.size()>=k-1?list.get(k-1) : -1;

    }
    void duplicombi(int cnt, int start,int N,int[]arr){
        if(cnt == 3){
            set.add(Arrays.stream(temp).sum());
            return;
        }
        for (int i = start; i <N ; i++) {
            temp[cnt] =arr[i];
            duplicombi(cnt+1, i+1,N,arr);
        }
    }
}
