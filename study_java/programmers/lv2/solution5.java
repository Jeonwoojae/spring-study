import java.util.*;

class Solution {
    // 동, 서, 남, 북
    int[] X = {0, 0, 1, -1};
    int[] Y = {1, -1, 0, 0};

    public int solution(String[] board) {
        int answer = Integer.MAX_VALUE;

        int[] start = findPosition('R', board);

        boolean[][] visited = new boolean[board.length][board[0].length()];
        visited[start[0]][start[1]] = true;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start[0], start[1], 0));

        while (!q.isEmpty()) {ㄴ
            Node cur = q.poll();

            if (answer <= cur.count) {
                continue;
            }

            if (board[cur.x].charAt(cur.y) == 'G') {
                answer = Math.min(answer, cur.count);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int x = cur.x + X[i];
                int y = cur.y + Y[i];

                if (x < 0 || y < 0 || x >= board.length || y >= board[0].length()) {
                    continue;
                }

                if (board[x].charAt(y) == 'D') {
                    continue;
                }

                while (x >= 0 && y >= 0 && x < board.length && y < board[0].length() && board[x].charAt(y) != 'D') {
                    x += X[i];
                    y += Y[i];
                }

                x -= X[i];
                y -= Y[i];
                if (visited[x][y]) {
                    continue;
                }

                visited[x][y] = true;

                q.offer(new Node(x, y, cur.count + 1));
            }
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private int[] findPosition(char find, String[] board) {
        for (int i = 0; i < board.length; i++) {
            String s = board[i];

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'R') {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }
}

class Node {
    int x;
    int y;
    int count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
