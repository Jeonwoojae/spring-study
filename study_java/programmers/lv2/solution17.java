public class Solution {
    public int solution(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;
        if (n >= 2) {
            dp[2] = 2;
        }

        // 3칸 이상부터 방법의 수를 더하여 총 방법의 수를 구한다.
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }
}
