import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dist = new int[101];  // 해당 위치까지 최소 거리
        int[] next = new int[101];  // 해당 위치에서 이동하는 곳

        int n = sc.nextInt();  // 사다리 수
        int m = sc.nextInt();  // 뱀의 수

        for (int i = 1; i <=100; i++) {
            next[i] = i;
            dist[i] = -1;
        }
        for (int k = 0; k < n+m; k++) {
            int x = sc.nextInt();  // 해당 위치
            int y = sc.nextInt();  // 이동할 위치
            next[x] = y;
        }

        // BFS 탐색 시작
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 0;
        while(!q.isEmpty()) {
            int cur = q.remove();
            for (int d = 1; d <= 6; d++) {
                if (cur+d > 100) continue;  // 100 범위를 넘어설 수 없다.
                int nCur = next[cur+d];  // 만약 이동한다면 해당 index를 받고 아니면 그대로 유지할 것이다.
                if (dist[nCur] == -1) {
                    // 해당 위치를 아직 방문하지 않았다면
                    dist[nCur] = dist[cur] + 1;  // 횟수 계산
                    q.add(nCur);  // 다음 탐색 경로에 추가
                }
            }
        }
        System.out.println(dist[100]);
    }
}