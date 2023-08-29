import java.util.Scanner;

/*
* 문제 설명
* 행렬 크기와 행렬을 입력 받는다.
* 지뢰찾기 처럼 지뢰가 존재하며 지뢰의 갯수를 반환하면 된다.
* 1 <= N <= 1000
* 1 <= K <= 8
* 각 칸은 0 또는 1
* */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 상하좌우 표현
        int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] dy = {1, -1, 1, 0, -1, 1, 0, -1};
        int[][] matrix;
        int N, M, answer;

        N = scanner.nextInt();
        M = scanner.nextInt();
        scanner.nextLine(); // 줄바꿈 기호를 없앤다


        matrix = new int[N][N];
        // 줄바꿈이 없어진 데이터를 배열로 변환하고 행렬에 배열을 추가
        for (int i = 0; i < N; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }

        // dx/dy기법 사용
        answer = 0;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int goormCount = 0;
                // 올바른 탐색 위치인지 확인
                if (matrix[x][y] == 0) {
                    // 8방향으로 탐색
                    for (int i = 0; i < 8; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            // 주변 지뢰 개수 확인
                            if (matrix[nx][ny] == 1) {
                                goormCount ++;
                            }
                        }
                    }
                    if (goormCount == M) {
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}