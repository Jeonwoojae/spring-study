import java.util.*;
public class Main {
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {1,-1,0,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 지도 세로크기
        int m = sc.nextInt();  // 지도 가로크기
        int x = sc.nextInt(); // 주사위를 놓은 곳 좌표x
        int y = sc.nextInt(); // 주사위를 놓은 곳 좌표y
        int k = sc.nextInt(); // 명령의 개수
        int[][] a = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int[] dice = new int[7];
        while(k-- > 0) {
            int dir = sc.nextInt()-1;
            int nx = x+dx[dir];
            int ny = y+dy[dir];
            // 범위 밖으로 가려고 하면 무시
            if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
            if (dir == 0) { // right
                int temp = dice[1];
                dice[1] = dice[4];
                dice[4] = dice[6];
                dice[6] = dice[3];
                dice[3] = temp;
            } else if (dir == 1) { // left
                int temp = dice[1];
                dice[1] = dice[3];
                dice[3] = dice[6];
                dice[6] = dice[4];
                dice[4] = temp;
            } else if (dir == 2) { // up
                int temp = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[6];
                dice[6] = dice[2];
                dice[2] = temp;
            } else { // down
                int temp = dice[1];
                dice[1] = dice[2];
                dice[2] = dice[6];
                dice[6] = dice[5];
                dice[5] = temp;
            }
            x = nx;
            y = ny;
            if(a[x][y] == 0) {
                //이동한 칸이 0이면 주사위 바닥 면을 복사함
                a[x][y] = dice[6];
            } else {
                //0이 아니면 칸의 숫자가 주사위 바닥면으로 복사됨
                dice[6] = a[x][y];
                // 칸의 수는 0으로 변경됨
                a[x][y] = 0;
            }
            System.out.println(dice[1]);
        }
    }
}