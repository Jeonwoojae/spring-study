import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int s;
    static int m;
    static int[] a;
    static boolean[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        s = Integer.parseInt(line[1]);  // 시작 볼륨
        m = Integer.parseInt(line[2]);  // 최대 볼륨

        a = new int[n+1];
        dp = new boolean[n+1][m+1];  // 해당 위치에서 해당 볼륨으로 연주할 수 있는지
        line = br.readLine().split(" ");
        for (int i=1; i<=n; i++) {
            a[i] = Integer.parseInt(line[i-1]);
        }
        dp[0][s] = true;
        for (int i=0; i<=n-1;i++) {
            for (int j=0; j<=m; j++) {
                if (dp[i][j] == false) {
                    continue;
                }
                // 볼륨을 내리는 경우
                if (j-a[i+1] >= 0) {
                    dp[i+1][j-a[i+1]] = true;
                }
                // 볼륨을 올리는 경우
                if (j+a[i+1] <= m) {
                    dp[i+1][j+a[i+1]] = true;
                }
            }
        }
        int ans = -1;
        for (int i=0;i<=m;i++) {
            if (dp[n][i]) ans = i;
        }
        System.out.println(ans);
    }
}
