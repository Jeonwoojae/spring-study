import java.util.*;
public class Main {
    static int[][] a;  // 종이에 쓰여있는 수
    static boolean[][] c;  // 해당 칸을 방문했는지 저장하는 배열
    static int n, m;  // 종이의 크기
    static int[] dx = {0,0,1,-1};  // 이동 방향
    static int[] dy = {1,-1,0,0};
    static int ans = 0;
    static void go(int x, int y, int sum, int cnt) {
        // x,y : 현재 위치, sum : 현재까지 쌓은 테트로미노의 수들의 합
        // cnt : 현재까지 쌓은 테트로미노의 개수
        if (cnt == 4) {
            // 만약 4개를 다 구성했다면
            if (ans < sum) ans = sum;  // 최댓값 갱신
            return;  // 함수 종료
        }
        if (x < 0 || x >= n || y < 0 || y >= m) return;
        if (c[x][y]) return;  // 방문했다면 pass
        c[x][y] = true;
        // 모든 테트로미노 방향으로 시도
        for (int k=0; k<4; k++) {
            go(x+dx[k],y+dy[k],sum+a[x][y],cnt+1);
        }
        // 방문한 이휴아 해당 위치를 다시 방문할 수 있도록 상태를 초기화
        c[x][y] = false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        c = new boolean[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        // 모든 칸에 대해 go 함수를 호출하여 최댓값을 찾는다.
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                go(i,j,0,0);
                if (j+2 < m) {
                    // 오른쪽으로 3칸 이동할 수 있는 경우의 테트로미노를 구성할 수 있는 경우
                    // 현재 위치와 오른쪽 두칸에 있는 수들 더하기
                    int temp = a[i][j] + a[i][j+1] + a[i][j+2];
                    if (i-1 >= 0) {
                        // 위쪽으로 이동하여 테트로미노를 구성할 수 있는 경우
                        // 현재위치와 그 왼쪽 위의 수들 더하기
                        int temp2 = temp + a[i-1][j+1];
                        if (ans < temp2) ans = temp2;
                    }
                    if (i+1 < n) {
                        // 아래로 이동하여 테트로미노를 구성할 수 있는 경우
                        // 현재 위치와 그 오른쪽 아래의 수를 더하기
                        int temp2 = temp + a[i+1][j+1];
                        if (ans < temp2) ans = temp2;
                    }
                }
                if (i+2 < n) {
                    // 아래로 3칸 이동할 수 있는 경우
                    // 현재 위치와 그 아래 드칸에 있는 수를 더하기
                    int temp = a[i][j] + a[i+1][j] + a[i+2][j];
                    if (j+1 < m) {
                        // 현재 위치의 오른쪽 아래 수를 더하기
                        int temp2 = temp + a[i+1][j+1];
                        if (ans < temp2) ans = temp2;
                    }
                    if (j-1 >= 0) {
                        // 현재 위치의 왼쪽 아래 수를 더하기
                        int temp2 = temp + a[i+1][j-1];
                        if (ans < temp2) ans = temp2;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}