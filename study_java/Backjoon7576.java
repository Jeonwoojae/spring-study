import java.util.*;
class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static final int[] dx = {-2,-1,1,2,2,1,-1,-2};
    static final int[] dy = {1,2,2,1,-1,-2,-2,-1};
    public static int[][] array;
    public static int[][] dis;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Queue<Pair> q = new LinkedList<Pair>();

        for(int t=0;t<T;t++) {
            int l = sc.nextInt();
            dis = new int[l][l];
            for(int i = 0; i <l;i++) {
                for(int j = 0; j <l;j++) {
                    dis[i][j] = -1;
                }
            }

            int x = sc.nextInt();
            int y = sc.nextInt();
            Pair cur = new Pair(x,y);
            int ex = sc.nextInt();
            int ey = sc.nextInt();
            Pair end = new Pair(ex,ey);

            q.add(cur);
            dis[x][y] = 0;

            while (!q.isEmpty()) {
                Pair p = q.remove();
                int cx = p.x;
                int cy = p.y;
                for(int k=0;k<8;k++) {
                    int nx = cx + dx[k];
                    int ny = cy + dy[k];
                    if(nx >= 0 && ny >= 0 && nx<l && ny<l) {
                        if(dis[nx][ny] == -1) {
                            dis[nx][ny] = dis[cx][cy] + 1;
                            q.add(new Pair(nx, ny));
                        }
                    }
                }
            }
            System.out.println(dis[ex][ey]);
        }
    }
}