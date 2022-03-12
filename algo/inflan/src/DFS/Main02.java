package DFS;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Main02 main = new Main02();
        main.solution(num);
    }

    private void solution(int num) {
        if(num==0)return;
        else{
            solution(num/2);
            System.out.print(num%2);
        }
    }
}
