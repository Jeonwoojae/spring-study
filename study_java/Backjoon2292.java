import java.util.*;
public class Main2292 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        /*
        * 1 => 1번
        * 2 ~ 7 => 2번
        * 8 ~ 19 => 3번
        * 20 ~ 37 => 4번
        * 38 ~ 61 => 5번
        *
        * 범위를 변수로 가지고, 범위 시작은 앞의 끝부분 +1,
        * 범위 끝은 count*6을 더하면 구할 수 있다.
        * 실제 도출되는 값들을 통해 규칙을 찾으면 해결할 수 있는 문제
        * */
        int count = 1;
        int maxRange = 2;

        if (n == 1) {
            System.out.println(1);
        } else {
            while (maxRange <= n) {
                maxRange = maxRange + (6 * count);
                count++;
            }
            System.out.println(count);
        }
    }
}