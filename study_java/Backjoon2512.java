import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 지방의 수 N 입력 받기
        int N = sc.nextInt();
        int[] requests = new int[N];

        // 각 지방의 예산요청 입력 받기
        for (int i = 0; i < N; i++) {
            requests[i] = sc.nextInt();
        }

        // 총 예산 M 입력 받기
        int M = sc.nextInt();

        // 이진 탐색을 위한 시작점과 끝점 설정
        int start = 0;
        int end = 0;
        for (int request : requests) {
            if (request > end) {
                end = request;
            }
        }

        // 이진 탐색 시작
        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;

            // 중간값을 상한액으로 설정할 때의 총 예산 계산
            for (int request : requests) {
                if (request > mid) {
                    sum += mid;
                } else {
                    sum += request;
                }
            }

            // 조건에 따라 상한액 조정
            if (sum > M) {
                end = mid - 1;
            } else {
                start = mid + 1;
                result = mid; // 가능한 상한액 중 최대값 저장
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}
