import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // N자리 수 1<=N<=90
        long [][] a = new long[N+1][2];
        // 규칙 : 0으로 시작하지 않음, 1이 두번 연속 나타나지 않음
        a[0][0] = 0;
        a[0][1] = 0;
        a[1][0] = 0;
        a[1][1] = 1;
        // a[2][0] = 1, a[2][1] = 0
        // a[3][0] = 1, a[3][1] = 1
        for(int i=2;i<=N;i++) {
            a[i][0] = 0;
            a[i][1] = 0;
            a[i][0] = a[i-1][0] + a[i-1][1];
            a[i][1] = a[i-1][0];
        }
        System.out.println(a[N][0]+a[N][1]);
    }
}