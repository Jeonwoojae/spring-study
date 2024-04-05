import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt(); // 테스트 케이스의 수

        for (int t = 0; t < P; t++) {
            int T = sc.nextInt(); // 테스트 케이스 번호
            int[] heights = new int[20]; // 아이들의 키를 저장할 배열

            for (int i = 0; i < 20; i++) {
                heights[i] = sc.nextInt(); // 아이들의 키 입력 받기
            }

            int steps = countSteps(heights); // 뒤로 물러난 걸음 수 계산
            System.out.println(T + " " + steps); // 결과 출력
        }
        sc.close();
    }

    public static int countSteps(int[] heights) {
        int steps = 0;

        // 버블 정렬과 유사한 방식으로 구현
        for (int i = 0; i < heights.length; i++) {
            for (int j = heights.length - 1; j > i; j--) {
                if (heights[j] < heights[j - 1]) {
                    // 위치 바꾸기
                    int temp = heights[j];
                    heights[j] = heights[j - 1];
                    heights[j - 1] = temp;
                    steps++; // 한 걸음 증가
                }
            }
        }

        return steps;
    }
}