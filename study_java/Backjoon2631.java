import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        dp[0] = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;  // 가장 긴 오름차순 길이 구하기
        for (int i=1;i<n;i++) {
            dp[i] = 1;
            for (int j=0;j<i;j++) {
                if (arr[i]>arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(n-ans);
    }
}
