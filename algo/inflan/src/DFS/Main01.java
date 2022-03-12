package DFS;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Main01 main = new Main01();
        main.solution(n);
    }

    private void solution(int n) {
        if(n==0) return;
        else {
            solution(n-1);
            System.out.print(n+" ");
        }
    }

}
