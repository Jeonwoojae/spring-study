import java.util.*;

class Main {
    static final int n = 4;  // 공간 크기
    static final int[] dx = {-1,-1,0,1,1,1,0,-1};  // 8방향 이동
    static final int[] dy = {0,-1,-1,-1,0,1,1,1};
    static int[][] copy2dArray(int[][] original) {
        int[][] result = new int[original.length][];
        for (int i=0; i<original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }

    // 물고기의 이동 및 상어가 먹을 수 있는 물고기 계산
    static int go(int[][] num, int[][] dir, int x, int y, int d) {
        for (int who=1; who<=n*n; who++) {  // 모든 물고기 이동
            boolean f = false;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (num[i][j] == who) {  // 현재 번호의 물고기 위치
                        for (int k=0; k<8; k++) {
                            int nx = i+dx[dir[i][j]];
                            int ny = j+dy[dir[i][j]];
                            // 이동 가능한지 검사
                            if (0 <= nx && nx < n && 0 <= ny && ny < n && num[nx][ny] >= 0 && !(nx == x && ny == y)) {
                                int temp;
                                // swap(num[i][j], num[nx][ny]);
                                temp = num[i][j];
                                num[i][j] = num[nx][ny];
                                num[nx][ny] = temp;
                                // swap(dir[i][j], dir[nx][ny]);
                                temp = dir[i][j];
                                dir[i][j] = dir[nx][ny];
                                dir[nx][ny] = temp;
                                f = true;  // 물고기가 이동했음
                                break;
                            } else {  // 이동할 수 없다면, 방향 변경
                                dir[i][j] += 1;
                                dir[i][j] %= 8;
                            }
                        }
                    }
                    if (f) break;  // 물고기가 이동했으면 반복문 탈출
                }
                if (f) break;
            }
        }
        int ans = 0;  // 상어가 먹을 수 있는 물고기 최대 수
        int sx = x+dx[d];  // 상어 다음 위치
        int sy = y+dy[d];
        while (0 <= sx && sx < n && 0 <= sy && sy < n) {  // 이동할 수 있는지
            if (num[sx][sy] != 0) {  // 먹을 수 있는 물고기가 있으면
                int temp = num[sx][sy];
                num[sx][sy] = 0;  // 물고기 먹은 상태
                int cur = temp + go(copy2dArray(num), copy2dArray(dir), sx, sy, dir[sx][sy]);
                if (ans < cur) ans = cur;  // 최대값 업데이트
                num[sx][sy] = temp;  // 원래 상태로 복구
            }
            sx += dx[d];  // 다음 위치로 업데이트
            sy += dy[d];
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] num = new int[n][n];
        int[][] dir = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                num[i][j] = sc.nextInt();
                dir[i][j] = sc.nextInt();
                dir[i][j] -= 1;
            }
        }

        // 시작 물고기 먹음
        int ans = num[0][0];
        num[0][0] = 0;
        // 재귀 계산 시작
        ans += go(num, dir, 0, 0, dir[0][0]);
        System.out.println(ans);
    }
}
