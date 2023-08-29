import java.util.*;

/*
* 문제 설명
* 아이템을 사용하여 통증 수치를 0으로 유지하는 것이 중요하다.
* A, B는 각각 Ap, Bp 만큼 통증 수치를 감소시켜준다.
* 플레이어는 N의 통증 수치를 가지고 있다.
* 플레이어가 통증  수치를 0으로 줄이기 위해 필요한 아이템의 최소 개수는?
* 통증 수치를 0으로 만들 수 없으면 -1을 출력한다.
*
* 2 <= N <= 10^6
* 2 <= Ap < Bp <=13
* Ap와 Bp는 배수 관계가 아니다.
*
* */
public class Main {
    /*
    * 이전의 비슷한 유형은 탐욕 알고리즘으로 해결했다.
    * 하지만 이것은 아이템이 2종류이며 서로 배수관계가 아니고, 0보다 줄일 수 없다.
    * 이 경우 다이나믹 프로그래밍이 필요하다.
    *
    * N = 18, A = 2, B = 5를 가정해보자.
    * 만약 기존 처럼 그리디 알고리즘을 사용하면 큰 수로 최대한 나눈다.
    * 이때 최대한 줄인 값이 남은 아이템으로 줄일 수 없기 때문에 -1을 반환한다.
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int[] dp = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            dp[i] = Integer.MAX_VALUE;
            // int 타입 배열을 최대값으로 초기화
            // 만약 최대 개수를 찾는 문제라면 최소값으로 초기화를 해야함
        }

        // dp[i]는, 통증 수치가 i일 때, 통증 수치를 0으로 만들기 위해 필요한 아이템의 최소 개수이다.
        dp[0] = 0;

        for (int i = 0; i <= N; i++) {
            if (i - A >= 0 && dp[i - A] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - A] + 1);
            }
            if (i - B >= 0 && dp[i - B] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i], dp[i - B] + 1);
            }
        }

        // 만약 값이 MAX_VALUE면 실패한 것이기 떄문에 -1을 반환
        System.out.println(dp[N] != Integer.MAX_VALUE ? dp[N] : -1);
    }
}