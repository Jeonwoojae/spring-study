import java.io.*;
import java.util.*;

public class Main {
    static int answer = 1;
    static char[][] map;
    static int R,C;
    static boolean[] visited;
    static int max = 0;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[26]; // 이전 알파벳을 저장

        for(int r = 0 ; r < R ; r++) {
            String str = br.readLine();
            for(int c = 0 ; c < C ; c++) {
                map[r][c] = str.charAt(c);
            }
        }

        visited[map[0][0] - 'A'] = true;

        backTracking(0, 0);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();

    }

    static void backTracking(int r, int c) {

        for(int i = 0 ; i < 4 ; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(isValid(nr, nc)) {
                visited[map[nr][nc] - 'A'] = true;
                answer++;
                backTracking(nr, nc);
                visited[map[nr][nc] - 'A'] = false;
                answer--;
            }
        }

        max = Math.max(answer, max);
    }

    static boolean isValid(int r, int c) {
        // 범위 안이며, 이전에 방문안했던 알파벳인지 확인
        if(r >= 0 && r < R && c >= 0 && c < C && !visited[map[r][c] - 'A']) return true;
        return false;
    }
}