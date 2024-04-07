import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // 전체 사람의 수
        int[][] people = new int[N][2]; // 각 사람의 몸무게와 키를 저장하는 배열

        // 입력 받기
        for (int i = 0; i < N; i++) {
            people[i][0] = scanner.nextInt(); // 몸무게
            people[i][1] = scanner.nextInt(); // 키
        }

        // 각 사람의 덩치 등수 계산
        for (int i = 0; i < N; i++) {
            int rank = 1; // 덩치 등수는 최소 1등부터 시작
            for (int j = 0; j < N; j++) {
                if (i != j && people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    // 자신보다 몸무게와 키 모두 큰 사람이 있으면 등수를 증가시킴
                    rank++;
                }
            }
            // 출력 시 마지막 사람의 경우 줄바꿈을, 그 외는 공백을 사용
            System.out.print(rank + (i == N-1 ? "\n" : " "));
        }
        scanner.close();
        System.exit(0);
    }
}
