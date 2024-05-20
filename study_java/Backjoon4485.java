import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] CAVE;
    static int[] X = new int[] {1, -1, 0, 0};
    static int[] Y = new int[] {0, 0, 1, -1};
    static String ANSWER = "Problem {0}: {1}";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            CAVE = new int[N][N];
            StringTokenizer st;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    CAVE[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(MessageFormat.format(ANSWER, count++, bfs()));
        }
    }

    private static int bfs() {
        boolean[][] visit = new boolean[N][N];
        int[][] costs = new int[N][N];

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0, CAVE[0][0]));
        costs[0][0] = CAVE[0][0];
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            int start = now.start;
            int end = now.end;
            int cost = now.cost;

            for (int i = 0; i < 4; i++) {
                int nextX = start + X[i];
                int nextY = end + Y[i];

                // 이동 가능한 범위이고
                if (nextX < N && nextX >= 0 && nextY < N && nextY >= 0) {
                    // 방문한 적이 없다면
                    if (!visit[nextX][nextY]) {
                        visit[nextX][nextY] = true;
                        costs[nextX][nextY] = cost + CAVE[nextX][nextY];
                        queue.add(new Node(nextX, nextY, cost + CAVE[nextX][nextY]));
                    }
                }
            }
        }
        return costs[N - 1][N - 1];
    }
}

class Node implements Comparable<Node> {
    int start;
    int end;
    int cost;

    public Node(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}
