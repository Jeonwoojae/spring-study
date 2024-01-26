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
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int[][] array;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        array = new int[N][M];
        sc.nextLine();
        for(int i=0;i<N;i++) {
            String line = sc.nextLine();
            for(int j=0;j<M;j++) {
                array[i][j] = line.charAt(j)-'0';
            }
        }

        int[][] dist = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(0,0));
        visited[0][0] = true;
        dist[0][0] = 1;  // 거리 계산
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            for(int k=0;k<4;k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];
                if(0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if(visited[nx][ny] == false && array[nx][ny] == 1) {
                        // 방문하지 않았고 갈 수 있는 길이면 이동 후보 큐에 추가
                        q.add(new Pair(nx,ny));
                        dist[nx][ny] = dist[x][y] + 1;
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        System.out.println(dist[N-1][M-1]);
    }
}
