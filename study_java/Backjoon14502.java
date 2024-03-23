import java.util.*;

public class Main{
    public static int[] dy = {-1,0,1,0};
    public static int[] dx = {0,1,0,-1};
    public static int[][] a;
    public static int sy;
    public static int sx;
    public static int dir;

    // 청소되지 않은 빈칸이 있으면 true
    public static boolean isBlank() {
        for(int k=0;k<4;k++) {
            int y = sy+dy[k];
            int x = sx+dx[k];
            if(y>=0 && x>=0 && y< a.length && x<a[0].length) {
                if(a[y][x] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        a = new int[n][m];

        sy = sc.nextInt();
        sx = sc.nextInt();
        dir = sc.nextInt();  // 0~3 : 북동남서

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                a[i][j] = sc.nextInt();
            }
        }

        int ans = 0;
        // 작동을 멈출 때 까지 반복
        while(true) {
            //1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
            if(a[sy][sx] == 0) {
                a[sy][sx] = 2;
                ans++;
            }
            //2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
            if(!isBlank()) {
                //  1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                int by = sy + dy[(dir+2)%4];
                int bx = sx + dx[(dir+2)%4];
                if(bx>=0 && by>=0 && by<a.length && bx<a[0].length) {
                    if(a[by][bx] == 1) break;
                    sy = by;
                    sx = bx;
                    continue;
                } else {
                    //  2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                    break;
                }

            } else {
                //3. 현재 칸의 주변의 4칸 중 청소되지 않은 빈 칸이 있는 경우,
                //  1. 반시계 방향으로 90도 회전한다.
                dir = (dir+3)%4;
                //  2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
                int fy = sy + dy[dir];
                int fx = sx + dx[dir];
                if(fx>=0 && fy>=0 && fy<a.length && fx<a[0].length) {
                    if(a[fy][fx]==0) {
                        sy = fy;
                        sx = fx;
                    }
                }
                //  3. 1번으로 돌아간다.
            }
        }
        System.out.println(ans);
    }
}