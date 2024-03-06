import java.util.*;

public class Main {

    static String[] a;
    static int n, ans;
    static int[][] color = new int[50][50];  // 각 셓의 색 상태를 저장하는 배열
    static int[] dx = {-1,-1,0,0,1,1};  // 육각형 모양을 고려한 6가지 방향
    static int[] dy = {0,1,-1,1,-1,0};
    static void dfs(int x, int y, int c) {
        color[x][y] = c;
        ans = Math.max(ans, 1);
        for (int k=0;k<6;k++) {
            int nx = x+dx[k];
            int ny = y+dy[k];
            // 범위 내에 있는지 체크
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                // 아직 방문하지 않은 경우
                if (a[nx].charAt(ny) == 'X') {
                    if (color[nx][ny] == -1) {
                        dfs(nx, ny, 1-c); // 다음 색을 반대 색으로 탐색
                    }
                    ans = Math.max(ans, 2);  // 최소 2개의 X가 인접해 있음
                    if (color[nx][ny] == c) {
                        // 같은 색으로 인접한 경우 최대 값 업데이트
                        ans = Math.max(ans, 3);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new String[n];
        for (int i=0;i<n;i++) {
            a[i] = sc.next();
        }
        // 모든 셀을 미방문 상태(-1)로 설정
        for (int i=0;i<50;i++) {
            Arrays.fill(color[i], -1);
        }
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                // 모든 방문하지 않은 X셀에 대해 dfs 실행
                if (a[i].charAt(j) == 'X' && color[i][j] == -1) {
                    dfs(i,j,0);
                }
            }
        }
        System.out.println(ans);
    }
}