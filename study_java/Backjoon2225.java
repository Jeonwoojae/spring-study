import java.util.*;

public class Main {
    public static long mod = 1_000_000_000L;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[][] d = new long[k+1][n+1];

        d[0][0] = 1;
        // d[k][n] = 0부터 n까지의 정수 k개를 더해서 그 합이 n이 되는 경우의 수
        // d[k][n] = d[k-1][n-(0~n)];
        for (int i=1; i<=k; i++) {
            for (int j=0; j<=n; j++) {
                for (int l=0; l<=j; l++) {
                    d[i][j] += d[i-1][j-l];
                    d[i][j] %= mod;
                }
            }
        }
        System.out.println(d[k][n]);
    }
}