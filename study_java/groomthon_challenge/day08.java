import java.util.Scanner;

/*
* 문제 설명
* 통증 수치를 줄이는 아이템이 3종류 각각 1,7,14를 감소시켜준다.
* 현재 N의 통증 수치를 가지고 있다.
* 통증을 0으로 줄이기 위한 아이템의 최소 개수는?
* 아이템을 사용할때 통증이 0보다 작아질 수 없다.
* 통증 수치 1 <= N <= 10^9
* */

public class Main {
    /*
    * 아이템을 최소로 줄이기 위해서는 가장 많이 통증을 줄여주는 것 부터 사용해야한다.
    * 반복문과 나눗셈을 통해 아이템 갯수를 구할 수 있다.
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력값 N을 받아옴
        int N = scanner.nextInt();
        scanner.close();

        // 결과값을 저장할 변수 초기화
        int ans = 0;
        // 주어진 진통제 단위를 배열로 선언
        int[] painKiller = {14, 7, 1};

        // 배열을 순회하면서 지폐 단위로 나눠주고 나머지를 업데이트하여 최종 결과값 계산
        for (int i : painKiller) {
            ans += N / i;
            N %= i;
        }

        System.out.println(ans);
    }
}