import java.util.*;

public class Main {
    static char[][] a;  // 입력 저장 배열
    static boolean[][] check;  // 방문 내역 저장 배열
    static int[][] dist;  // 시작점으로부터의 거리 저장
    static int n, m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    // 사이클을 찾으면 true를 반환, 아니면 false를 반환
    static boolean go(int x, int y, int cnt, char color) {
        // 이미 방문했던 칸인 경우
        if (check[x][y]) {
            if (cnt-dist[x][y] >= 4) {
                return true;
            } else {
                //이미 같ㅇ
                return false;
            }
        }
        check[x][y] = true;
        dist[x][y] = cnt;
        for (int k=0;k<4;k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            // 배열 범위 내인지 체크
            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                // 같은 색인 경우 재귀 호출
                if (a[nx][ny] == color) {
                    if (go(nx, ny, cnt+1, color)) {
                        return true;
                    }
                }
            }
        }
        return false;  // 사이클을 찾지 못하면 false 반환
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new char[n][m];
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = sc.next().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (check[i][j]) continue;
                dist = new int[n][m];  // 거리배열 초기화
                boolean ok = go(i,j,1,a[i][j]);
                if (ok) {  // 사이클을 찾은 경우
                    System.out.println("Yes");
                    System.exit(0);
                }
            }
        }
        System.out.println("No");
    }
}