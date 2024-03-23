import java.util.*;

public class Main {
    static int n, k;
    static int[][] items;
    static Integer[][] dp;

    // 재귀 함수: 현재 index와 현재까지의 무게를 고려하여 최대 가치를 반환
    static int maxVal(int index, int weight) {
        // 종료 조건: 모든 아이템을 고려했거나, 무게 한도에 도달했을 경우
        if (index == n || weight == 0) return 0;

        // 메모이제이션: 이미 계산된 값이 있다면 반환
        if (dp[index][weight] != null) return dp[index][weight];

        // 현재 아이템을 배낭에 넣지 않는 경우
        int max = maxVal(index + 1, weight);

        // 현재 아이템을 배낭에 넣을 수 있는 경우
        if (weight - items[index][0] >= 0) {
            max = Math.max(max, maxVal(index + 1, weight - items[index][0]) + items[index][1]);
        }

        // 계산된 최대 가치를 저장하고 반환
        return dp[index][weight] = max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        items = new int[n][2];
        dp = new Integer[n][k + 1];

        for (int i = 0; i < n; i++) {
            items[i][0] = sc.nextInt(); // 무게
            items[i][1] = sc.nextInt(); // 가치
        }

        System.out.println(maxVal(0, k));
    }
}
