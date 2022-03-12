package String;

import java.util.Locale;
import java.util.Scanner;

public class Find_character_1 {
    public static void main(String[] args) throws Exception {
        Find_character_1 m = new Find_character_1();
        Scanner in=new Scanner(System.in);
        String str = in.nextLine().toLowerCase(Locale.ROOT);
        char c = in.nextLine().toLowerCase(Locale.ROOT).charAt(0);
        m.solution(str,c);

    }
    public void solution(String str,char c){
        int count =0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==c) count++;
        }
        System.out.println(count);
    }
}
