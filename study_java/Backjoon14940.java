import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private final static int[] dx = {1, 0, -1, 0};
    private final static int[] dy = {0, -1, 0, 1};
    private static int[][] map, distance;
    private static int m, n;
    private static boolean[][] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean isStartChecked = false;
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int startX = -1, startY = -1;

        map = new int[n][m];
        distance = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (!isStartChecked && map[i][j] == 2) {
                    isStartChecked = true;
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && map[i][j] == 1)
                    writer.write(-1 + " ");
                else
                    writer.write(distance[i][j] + " ");
            }
            writer.write("\n");
        }

        writer.flush();
        writer.close();
        reader.close();
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new ArrayDeque<>();
        queue.add(new Point(x, y));
        isVisited[x][y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) continue;
                if (map[nextX][nextY] == 0) continue;
                if (isVisited[nextX][nextY]) continue;

                queue.add(new Point(nextX, nextY));
                distance[nextX][nextY] = distance[current.x][current.y] + 1;
                isVisited[nextX][nextY] = true;
            }
        }
    }
}

class Point {
    public int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
