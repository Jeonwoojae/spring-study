import java.util.*;

public class Main {
    static int[] a;  // 숫자 배열 저장
    static int[][] d;  // a[x]부터 a[y]까지 배열이 팰린드롬인지 확인
    public static int go(int x, int y) {
        if (x == y) {
            // 하나의 문자가 있으면 항상 팰린드롬
            return 1;
        } else if (x+1 == y) {
            // 두 문자만있을 때
            if (a[x] == a[y]) {
                // 두 문자가 같으면 팰린드롬
                return 1;
            } else {
                return 0;
            }
        }
        if (d[x][y] != -1) {
            // 이미 계산된 값이면 그 값을 반환
            return d[x][y];
        }
        if (a[x] != a[y]) {
            // 양 끝이 다르면 팰린드롬이 아님
            return d[x][y] = 0;
        } else {
            // a[x] == a[y]이면 크기를 줄여 다시 판별
            return d[x][y] = go(x+1,y-1);
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = new int[n];
        d = new int[n][n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            Arrays.fill(d[i],-1);  // 아직 계산하지 않았다는 의미로 -1 초기화
        }
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            sb.append(go(x-1,y-1));
            sb.append('\n');
        }
        System.out.println(sb);
    }
}