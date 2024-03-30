import java.util.*;
public class Main {
    static long[] d;
    static long[] p;
    // 레벨 N버거의 아래 X장 먹었을 때 먹은 패티의 수 구하기
    static long go(int n, long x) {
        // 레벨 0일때
        if (n == 0) {
            if (x == 0) {
                return 0;
            } else {
                return 1;
            }
        } else if (x == 1) {
            // 1장만 먹었을 때
            return 0;
        } else if (x <= 1 + d[n-1]) {
            // 하단 빵과 그 위의 [n-1]버거 일부를 먹었을 때
            return go(n-1, x-1);
        } else if (x == 1 + d[n-1] + 1) {
            // 중앙의 패티까지 먹었을 때
            return p[n-1] + 1;
        } else if (x <= 1 + d[n-1] + 1 + d[n-1]) {
            // 제일 위의 버거 일부를 먹었을 때
            return p[n-1] + 1 + go(n-1, x-1-d[n-1]-1);
        } else {
            // 전부 먹었을 때
            return p[n-1] + 1 + p[n-1];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        d = new long[n+1];
        p = new long[n+1];
        long x = sc.nextLong();
        // 레벨 0
        d[0] = 1;
        p[0] = 1;
        for (int i=1; i<=n; i++) {
            // 레벨-i버거 = 번 + [i-1]버거 + 패티
            d[i] = 1 + d[i-1] + 1 + d[i-1] + 1;
            // 레벨-i버거의 패티 수 = [i-1]패티 + 패티 + [i-1]패티
            p[i] = p[i-1] + 1 + p[i-1];
        }
        System.out.println(go(n, x));
    }
}
