import java.util.*;

public class Main {
    static boolean[][] a = new boolean[15][15];
    static int n;
    static boolean[] check_col = new boolean[15];  // i번 열에 퀸이 있으면 true
    static boolean[] check_dig = new boolean[40];  // /대각선에 퀸이 있으면 true
    static boolean[] check_dig2 = new boolean[40];  // \대각선에 퀀이 있으면 true
    // 퀸을 놓을 수 있는지 검사
    static boolean check(int row, int col) {
        // 현재 열
        if (check_col[col]) {
            return false;
        }
        // 왼쪽 위 대각선
        if (check_dig[row+col]) {
            return false;
        }
        // 오른쪽 위 대각선
        if (check_dig2[row-col+n]) {
            return false;
        }
        return true;
    }
    static int calc(int row) {
        if (row == n) {
            // ans += 1;
            return 1;
        }
        int cnt = 0;
        for (int col=0; col<n; col++) {
            if (check(row, col)) {
                check_dig[row+col] = true;
                check_dig2[row-col+n] = true;
                check_col[col] = true;
                a[row][col] = true;
                cnt += calc(row+1);
                check_dig[row+col] = false;
                check_dig2[row-col+n] = false;
                check_col[col] = false;
                a[row][col] = false;
            }
        }
        return cnt;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println(calc(0));
    }
}

public class Main {
    static boolean[][] a = new boolean[15][15];  // 체스판
    static int n;  // 1~15
    static int ans = 0;
    static boolean check(int row, int col) {
        // 같은 열 체크
        for (int i = 0; i < n; i++) {
            if (i==row) continue;
            if (a[i][col]) {
                return false;
            }
        }
        // 왼쪽 위 대각선 체크
        int x = row-1;
        int y = col-1;
        while (x >=0 && y>=0) {
            if (a[x][y] == true) {
                return false;
            }
            x -= 1;
            y -= 1;
        }
        // 왼쪽 아래 대각선 체크
        x = row-1;
        y = col+1;
        while (x >=0 && y<n) {
            if (a[x][y] == true) {
                return false;
            }
            x -= 1;
            y += 1;
        }
        return true;
    }
    static void calc(int row) {
        if (row == n) {
            // row==n이면 모든 행에 성공적으로 퀸을 놓았다는 것이기 때문에 답을 추가한다.
            ans += 1;
        }
        // 모든 열에 대해 퀸을 놓을 수 있는지 확인
        for (int col=0; col < n; col++) {
            a[row][col] = true;  // 퀸 놓기 시도
            if (check(row, col)) {
                // 만약 현재 위치에 퀸을 놓을 수 있다면 다음 행에 작업 시도
                calc(row+1);
            }
            // 탐색을 다 시도한 후에는 백트래킹
            a[row][col] = false;
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        calc(0);
        System.out.println(ans);
    }
}