import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 세로
        int m = sc.nextInt(); // 가로
        int[][] a = new int[n+1][m+1];
        int[][] dist = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        for (int i=1;i<=n;i++) {
            for (int j=1;j<=m;j++) {
                dist[i][j] = Math.max(Math.max(dist[i-1][j], dist[i][j-1]), dist[i-1][j-1]) + a[i][j];
            }
        }
        System.out.println(dist[n][m]);
    }
}