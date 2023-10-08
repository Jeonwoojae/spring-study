import java.util.*;


public class Main {
    /**
     * 한변의 길이가 N인 정사각형을 격자 모양으로 바꾸고 M개의 직선을 규칙에 따라 그린다.
     * 이때 직선들끼리 교차하는 교점의 수를 세는 문제이다.
     */


    public static void main(String[] args) {
        /**
         * 완전 탐색 방법으로 문제를 해결한다.
         * (y,x)에서 시작하는 직선을 그리려고 하면 (y,x)에서 그려진 직선을 모두 알아야 한다.
         * 상/하로 그려질 직선은 좌/우로 그려진 직선의 개수만큼 점이 생기고,
         * 좌/우로 그려질 직선은 상/하로 그려진 직선의 개수만큼 점이 발생한다.
         * 직선의 개수가 100_000이기 떄문에 최악의 경우 100억번의 계산이 필요하다.
         * 따라서 이 문제는 동적 프로그래밍 문제이다.
         *
         * 해당 성질을 사용하여 문제를 해결한다.
         * 1. (y, x)칸에서 위/아래 방향으로 그리는 선이 생기면 해당 칸부터 끝까지 있는 모든 칸의 가로 선ㄴ의 개수가 발생하는 교점의 개수이다.
         * 2. (y, x)칸에서 좌/우 방향으로 그리는 선이 생기면, 해당 칸부터 끝까지 있는 모든 칸의 세로 선의 개수가 발생하는 교점의 개수이다.
         */

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        // 가로 선과 세로 선 모두 관리하는 변수
        long[][][] dp = new long[2][N+1][N+1];
        // dp[0] = verMatrix, dp[1] = horMatrix
        long spotCount = 0;

        for (int s = 0; s < M; s++) {
            int y = scanner.nextInt();
            int x = scanner.nextInt();
            String dir = scanner.next();
            scanner.nextLine();  // Consume the newline

            /*
            * D나 U일 경우, x좌표는 고정이면서 y좌표가 N으로 가거나 1로 간다.
            * spot_count는 가로 선을 관리하는 DP[1]에서 추출
            * DP 갱신은 세로 선을 관리하는 DP[0]을 갱신한다.
            * */
            if (dir.equals("D")) {
                for (int i = y; i <= N; i++) {
                    spotCount += dp[1][i][x];
                    dp[0][i][x] += 1;
                }
            } else if (dir.equals("U")) {
                for (int i = 1; i <= y; i++) {
                    spotCount += dp[1][i][x];
                    dp[0][i][x] += 1;
                }
                /*
                * R이나 L일 경우, y좌표는 고정이면서, x 좌표가 N으로 가거나 1로 간다.
                * spot_count는 세로 선을 관리하는 DP[0]에서 추출
                * DP 갱신은 가로 선을 관리하는 DP[1]을 갱신
                * */
            } else if (dir.equals("R")) {
                for (int i = x; i <= N; i++) {
                    spotCount += dp[0][y][i];
                    dp[1][y][i] += 1;
                }
            } else if (dir.equals("L")) {
                for (int i = 1; i <= x; i++) {
                    spotCount += dp[0][y][i];
                    dp[1][y][i] += 1;
                }
            }
        }

        System.out.println(spotCount);
    }
}