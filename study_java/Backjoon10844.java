import java.util.*;

public class Main {
    public static long mod = 1000000000L;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][] d = new long[n+1][10];

        // 배열의 N은 해당 자릿수를 의미하며 뒤의 숫자는 마지막 숫자를 의미한다.
        // 마지막 숫자에 따라 앞의 숫자들은 한정적이게 되기 때문이다.
        // 또한 규칙을 다음과 같이 정의할 수 있다.

        // d[1][0~9] = 1;
        // X0 : d[2][0] = d[1][1] = 1
        // X3 : d[2][3] = d[1][2] + d[1][4]
        // 즉 N-1일 때 맨끝이 1차이 나는 값의 경우를 더하여 N의 경우를 구할 수 있다.
        for (int i=1; i<=9; i++) {
            d[1][i] = 1;
        }
        for (int i=2; i<=n; i++) {
            for (int j=0; j<=9; j++) {
                d[i][j] = 0;
                if (j-1 >= 0) {
                    d[i][j] += d[i-1][j-1];
                }
                if (j+1 <= 9) {
                    d[i][j] += d[i-1][j+1];
                }
                d[i][j] %= mod;
            }
        }
        long ans = 0;
        for (int i=0; i<=9; i++) {
            ans += d[n][i];
        }
        ans %= mod;
        System.out.println(ans);
    }
}