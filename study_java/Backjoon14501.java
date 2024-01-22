import java.util.*;
public class Main {
    static final int inf = 100000000;
    static int[] t = new int[20];
    static int[] p = new int[20];
    static int[] d = new int[20];
    static int n;
    static int go(int day) {
        if (day == n+1) {
            // 탐색 종료
            return 0;
        }
        if (day > n+1) {
            // 범위를 넘은 날짜에 대해서는 후보로 할 수 없게 -값 지정
            return -inf;
        }
        if (d[day] != -1) {
            // 이미 계산한 값이라면 return
            return d[day];
        }
        // 현재 날짜에 상담 안할 때
        // 다음 날짜에 기대할 최대 수익 계산
        int t1 = go(day+1);

        // 현재 날짜에 상담 할때
        // 현재 날짜의 상담 수익 + 상담이 끝난 날부터 최대 수익 계산
        int t2 = p[day] + go(day+t[day]);
        d[day] = Math.max(t1,t2);
        return d[day];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i=1; i<=n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
            d[i] = -1;
        }
        System.out.println(go(1));
    }
}
