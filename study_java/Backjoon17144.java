import java.util.*;
public class Main {
    static int[][] a, b;  // a:방의 현재 상태, b:먼지 확산 후 임시 저장
    static int n, m;
    static final int[] dx = {0,-1,0,1};
    static final int[] dy = {1,0,-1,0};
    // 공기 청정기 작동 함수
    static void go(int sx, int sy, int z) {
        int prev = 0;  // 이전 값 저장 변수
        int x = sx;  // 현재 x위치
        int y = sy+1;  // 공기 청정기 바로 옆에서 시작
        int k = 0;  // 방향 인덱스
        while (true) {
            if (x == sx && y == sy) break;  // 시작 지점으로 돌아오면 종료

            // 현재 위치의 값을 이전 값으로 업데이트
            int temp = prev;
            prev = a[x][y];
            a[x][y] = temp;
            x += dx[k];  // 다음 위치
            y += dy[k];  // 다음 위치
            // 범위를 벗어난 경우 방향 전환
            if (x < 0 || y < 0 || x >= n || y >= m) {
                x -= dx[k];
                y -= dy[k];
                k += z;  // 방향 전환
                k %= 4;  // 인덱스가  범위를 벗어나지 않도록
                x += dx[k];
                y += dy[k];
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();  // 세로 크기
        m = sc.nextInt();  // 가로 크기
        a = new int[n][m];
        b = new int[n][m];
        int t = sc.nextInt();  // 초
        int x=0,y=0;  // 공기 청정기 위치
        // 방의 상태 저장
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
                if (a[i][j] == -1) {
                    // 청정기 위치 저장
                    x = i;
                    y = j;
                }
            }
        }
        x -= 1;  // 공기청정기 윗부분 위치
        while (t-- > 0) {
            // 먼지 확산 시작
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (a[i][j] <= 0) continue;  // 해당 위치에 먼지가 없으면 스킵
                    int cnt = 0;
                    // 확산 가능 여부 체크
                    for (int k=0; k<4; k++) {
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        // 확산 가능 조건
                        if (0 <= nx && nx < n && 0 <= ny && ny < m && a[nx][ny] >= 0) {
                            cnt += 1;  // 인접한 확산 가능한 칸 수
                        }
                    }
                    // 확산 처리
                    if (cnt > 0) {
                        int val = a[i][j]/5;  // 확산된 먼지의 양
                        for (int k=0; k<4; k++) {
                            int nx = i+dx[k];
                            int ny = j+dy[k];
                            if (0 <= nx && nx < n && 0 <= ny && ny < m && a[nx][ny] >= 0) {
                                b[nx][ny] += val;
                            }
                        }
                        a[i][j] = a[i][j] - cnt*val;  // 원래 칸의 먼지 감소
                    }
                }
            }
            // 임시 저장 내용 최종 반영
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (a[i][j] == -1) continue;
                    a[i][j] += b[i][j];
                    b[i][j] = 0;
                }
            }
            // 공기 청정기 작동
            go(x,y,1); // 윗부분
            go(x+1,y,3);  // 아랫부분
        }
        // 결과 계산
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (a[i][j] >= 0) {
                    ans += a[i][j];
                }
            }
        }
        System.out.println(ans);
    }
}
