import java.util.Scanner;

public class beak_17478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        String str  =  "\"재귀함수가 뭔가요?\"";

        re(t,str,"");

    }
    static String content_1= "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
    static String content_2= "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
    static String content_3="그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";


    private static void re(int t,String str,String pre) {
        System.out.println(pre.concat(str));
        if(t>0){
            System.out.println(pre.concat(content_1));
            System.out.println(pre.concat(content_2));
            System.out.println(pre.concat(content_3));

            String pre2 = "____".concat(pre);
            re(t-1,str,pre2);
            
            System.out.println(pre.concat("라고 답변하였지."));

        }else{
            System.out.println(pre.concat("\"재귀함수는 자기 자신을 호출하는 함수라네\""));
            System.out.println(pre.concat("라고 답변하였지."));

        }
    }
}
