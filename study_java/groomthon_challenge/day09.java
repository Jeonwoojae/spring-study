import java.util.Scanner;

/*
* 문제 설명
* 앞에서 풀었던 폭탄 문제에서 추가 조건이 생긴다.
* 폭탄이 떨어지면 떨어진 위치를 기준으로 십자가 영역 폭탄 값이 조건에 따라 증가한다.
* #은 폭탄의 영향을 받지 않는다.
* 0이면 폭탄 값이 1만큼 증가한다.
* @이면 폭탄 값이 2만큼 증가한다.
* 모든 폭탄이 떨어진 이후 폭탄 값이 가장 높은 값을 출력한다.
* */

public class Main {
    public static void main(String[] args) {
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.nextLine(); // 줄바꿈 기호를 없애준다.
        // 문자열 행렬에 값을 추가해준다.
        String[][] matrix = new String[N][N];
        for (int i = 0; i < N; i++) {
            // 이번에는 문자열이기 때문에 split으로 문자열을 배열로 변환한다.
            matrix[i] = scanner.nextLine().split(" ");
        }

        // 원래 위치와 상하좌우
        int[] dx = {0, 0, 0, 1, -1};
        int[] dy = {0, 1, -1, 0, 0};
        int[][] score = new int[N][N];  // 폭탄 값을 기록하는 행렬

        // 폭탄이 떨어지는 좌표를 입력받고, 좌표 조정을 해준다.
        for (int k = 0; k < K; k++) {
            // 폭탄 좌표는 0부터 시작한다.
            int x = scanner.nextInt() - 1; // Adjusting index
            int y = scanner.nextInt() - 1; // Adjusting index

            // dx/dy가 5곳을 탐색하기 때문에 반복문의 길이도 5가 된다.
            for (int i = 0; i < 5; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 행렬의 범위를 나가거나, 탐색할 행렬의 값이 #일 경우 탐색하지 않는다.
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (!matrix[nx][ny].equals("#")) {
                        // matrix[nx][ny]의 값이 @일때, score[nx][ny] 값을 +2 한다.
                        if (matrix[nx][ny].equals("@")) {
                            score[nx][ny] += 2;
                        }
                        // matrix[nx][ny]값이 @가 아니라면, score[nx][ny] 값을 +1 한다.
                        else {
                            score[nx][ny] += 1;
                        }
                    }
                }
            }
        }

        // 행렬의 최대값 찾기
        int result = 0;
        // 모든 배열을 순회하며 최대값을 찾으면 된다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result = Math.max(result, score[i][j]);
            }
        }

        System.out.println(result);
        scanner.close();
    }
}