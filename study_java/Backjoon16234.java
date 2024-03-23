import java.util.*;
import java.io.*;
public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean bfs(int[][] a, int l, int r) {
        int n = a.length;
        boolean[][] c = new boolean[n][n];  // 방문 정보 저장. 방문 여부는 독립
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                c[i][j] = false;
            }
        }
        boolean ok = false;  // 더이상 이동할게 없는지 확인하는 flag
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (c[i][j] == false) {
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i);
                    q.add(j);
                    c[i][j] = true;
                    Queue<Integer> s = new LinkedList<>();
                    s.add(i);
                    s.add(j);
                    int sum = a[i][j];
                    while (!q.isEmpty()) {
                        int x = q.remove();
                        int y = q.remove();
                        for (int k=0; k<4; k++) {
                            int nx = x+dx[k];
                            int ny = y+dy[k];
                            if (0<=nx && 0<=ny && nx<n && ny<n) {
                                if (c[nx][ny]) continue; // 이미 방문했으면 다음
                                int diff = a[nx][ny] - a[x][y];
                                if (diff<0) diff = -diff;
                                if (l<=diff && diff <=r) {
                                    // 국경선 열어서 연결하기
                                    q.add(nx);
                                    q.add(ny);
                                    s.add(nx);
                                    s.add(ny);
                                    c[nx][ny] = true;
                                    ok = true;
                                    sum += a[nx][ny];
                                }
                            }
                        }
                    }
                    int val = sum / (s.size() / 2);
                    // 같은 국경선 내의 요소들 업데이트
                    while (!s.isEmpty()) {
                        int x = s.remove();
                        int y = s.remove();
                        a[x][y] = val;
                    }
                }
            }
        }
        return ok;
    }
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int L = Integer.parseInt(line[1]);
        int R = Integer.parseInt(line[2]);
        int[][] a = new int[N][N];
        for (int i=0; i<N; i++) {
            line = br.readLine().split(" ");
            for (int j=0; j<N; j++) {
                a[i][j] = Integer.parseInt(line[j]);
            }
        }

        int count = 0;
        // 인구 이동이 없을 때 까지 반복
        while(true) {
            if (bfs(a,L,R)) {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}

