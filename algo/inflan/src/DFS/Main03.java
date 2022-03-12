package DFS;

import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Main03 main = new Main03();
        System.out.println(main.solution(num));
    }

    private int solution(int num) {
        if(num<=1)return 1;
        else {
            return num * solution(num-1);
        }
    }
}
