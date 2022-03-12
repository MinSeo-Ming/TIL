package HashMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main03 {
    

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
        Main03 main = new Main03();
        main.soultion(N, K, arr);
    }

    private void soultion(int n, int k, int[] arr) {
        StringBuilder sb = new StringBuilder();
        HashMap<Integer,Integer>map = new LinkedHashMap<>();
        for(int i=0; i<k; i++){
            map.put(i,arr[i]);
        }

        sb.append(new HashSet<>(map.values()).size()+" ");
        int idx =0;
        for (int i = k; i < n; i++) {
            map.remove(idx++);

            map.put(i,arr[i]);
//            if(map.size()!=k) break;
            sb.append(new HashSet<>(map.values()).size()+" ");

        }
        System.out.println(sb.toString());
    }
}
