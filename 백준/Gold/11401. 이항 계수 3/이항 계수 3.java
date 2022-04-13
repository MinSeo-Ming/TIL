import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int N,R;
    static final int P = 1000000007;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        long num = fact2(N);
        long den = fact2(R) * fact2(N-R) %P;
        long result = num * perma(den,P-2)%P;

        sb.append(result);
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static long fact2(int n){
        long fac = 1L;
        while (n >1){
            fac = (fac*n) %P;
            n--;
        }
        return fac;
    }
    static long perma(long base, long expo){
        long temp =0;

        if(expo==1)return base%P;

        temp = perma(base,expo/2);
        if(expo%2==1){
            return (temp * temp  %P) * base %P;
        }

        return temp * temp  %P;
    }
}

