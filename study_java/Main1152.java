import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1152 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        sc.close();

        StringTokenizer st = new StringTokenizer(a," ");
        /*
        split을 사용하여 " "를 뗀다는 것은
        첫 시작이 공백일 때 사라지는 것이 아니라 ""로 변경되어
        개수가 한개 더 늘어나게 세진다.
         */

        System.out.println(st.countTokens());
    }
}