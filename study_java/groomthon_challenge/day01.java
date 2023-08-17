import java.io.*;
import java.util.Scanner;

/*
* 문제 설명
* 1 <= W <= 1,000,000
* 1 <= R <= 100
* 을 하나씩 입력받는다.
* 1RM = W * (1 + R/30)을 계산해야 한다.
*
* 입력
* 100 30
* 출력
* 200
* */

class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int r = sc.nextInt();

        System.out.println((int) (w*(1+ (double) r /30)));
    }
}