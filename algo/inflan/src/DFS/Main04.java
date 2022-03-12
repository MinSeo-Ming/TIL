package DFS;

import java.util.Scanner;

public class Main04 {
    static int[] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main04 main = new Main04();
        int num = sc.nextInt();
        result = new int[num+1];
        main.solution(num);
        for (int i = 1; i <= num; i++) {

            System.out.print(result[i]+" ");
        }
    }

    private int solution(int num) {
        if(result[num]>0) return result[num];
        if(num<=2){
            return result[num]=1;
        }
        else {
            return result[num]= solution(num-1)+solution(num-2);
        }
    }
}
