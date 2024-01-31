import java.util.*;

class Pair {
    public int x;
    public int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String args[]) {
        int[] dirX = {1,0,-1,0};
        int[] dirY = {0,1,0,-1};
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();
        int[][] a = new int[N][M];
        for(int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for(int j = 0; j < M; j++) {
                a[i][j] = line.charAt(j) - '0';
            }
        }
        int[][] d = new int[N][M];
        Queue<Pair> q = new LinkedList<>();
        Queue<Pair> next_queue = new LinkedList<>();
        q.add(new Pair(0,0));
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                d[i][j] = -1;
            }
        }
        d[0][0] = 0;
        while(!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for(int k=0;k<4;k++) {
                int nx = x + dirX[k];
                int ny = y + dirY[k];
                if( 0<=nx && nx<N && 0<=ny && ny<M) {
                    if(d[nx][ny] == -1) {
                        if(a[nx][ny] == 0) {
                            // 벽이 아니면
                            d[nx][ny] = d[x][y];
                            q.add(new Pair(nx,ny));
                        } else {
                            // 벽이면 가중치를 더하고 다음 단계에 작업
                            d[nx][ny] = d[x][y] + 1;
                            next_queue.add(new Pair(nx,ny));
                        }
                    }
                }
            }
            if(q.isEmpty()) {
                // 다음 단계 수행
                q = next_queue;
                next_queue = new LinkedList<>();
            }
        }
        System.out.println(d[N-1][M-1]);
    }

    /*
    * 해당 방법은 벽을 부수는 가정이 섞여서 계산되기 때문에 해결할 수 없다.
    * 이 문제를 해결하기 위해서는 위치별로 벽을 몇개 부숴야 접근할 수 있는지로 판단하여,
    * 그 갯수에 따라 탐색을 수행하고 이후 갯수에 대해 탐색을 수행하여 풀 수 있다.
    * */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // x
        int M = sc.nextInt();  // y
        int[][] array = new int[M+1][N+1];
        boolean[][] check = new boolean[M+1][N+1];
        int[][] dis = new int[M+1][N+1];
        for(int i=1; i<=M;i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                array[i][j+1] = line.charAt(j) - '0';
                dis[i][j+1] = Integer.MAX_VALUE;
            }
        }
        Queue<Pair> q = new LinkedList<>();

        check[1][1] = true;
        dis[1][1] = 0;
        q.add(new Pair(1,1));

        while(!q.isEmpty()) {
            Pair cur = q.remove();
            int curX = cur.x;
            int curY = cur.y;
            for(int i = 0; i < 4; i++) {
                if(curX + dirX[i]>0 && curX + dirX[i]<=N && curY + dirY[i]>0 && curY + dirY[i]<=M) {
                    if(!check[curY+dirY[i]][curX+dirX[i]]) {
                        q.add(new Pair(curX+dirX[i],curY+dirY[i]));
                        check[curY+dirY[i]][curX+dirX[i]] = true;
                        if(array[curY+dirY[i]][curX+dirX[i]] == 1) {
                            dis[curY+dirY[i]][curX+dirX[i]] = Math.min(dis[curY+dirY[i]][curX+dirX[i]], dis[curY][curX]+1);
                        } else {
                            dis[curY+dirY[i]][curX+dirX[i]] = Math.min(dis[curY+dirY[i]][curX+dirX[i]], dis[curY][curX]);
                        }
                    }
                }
            }
        }
        System.out.println(dis[M][N]);
    }
}
