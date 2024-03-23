import java.util.*;
public class Main {
    static long[] d = new long[5001];
    static long mod = 1000000007L;
    static long go(int n) {
        if (n == 0) {
            return 1;
        } else if (d[n] >= 0) {
            return d[n];
        }
        d[n] = 0;
        // 모든 위치에 대해 계산
        for (int i=2; i<=n; i+=2) {  // 길이가 짝수만 고려하도록 2씩 증가시킨다.
            d[n] += go(i-2) * go(n-i);  // 왼쪽 부분 갯수와 오른쪽 부분 갯수를 계산
            d[n] %= mod;
        }
        return d[n];
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Arrays.fill(d, -1);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            if (n%2 == 0) {
                System.out.println(go(n));
            } else {
                // 홀수인 경우 찾을 수 없음
                System.out.println(0);
            }
        }
    }
}