import java.util.*;
public class Main {
    // 그래프의 인접 리스트와 방문 체크, 거리를 저장할 배열 선언
    static ArrayList<Integer>[] a;
    static int[] check;  // 노드의 방문 상태 및 사이클 포함 여부 (0:미방문, 1:방문중, 2:사이클)
    static int[] dist;  // 사이클로부터의 거리
    static int go(int x, int p) {
        // 사이클을 찾으면 시작 인덱스 반환, 사이클 내 노드가 아니면 -2, 사이클을 못 찾으면 -1
        if (check[x] == 1) {
            return x;  // 사이클의 시작점 발견
        }
        check[x] = 1;  // 방문 표시
        for (int y : a[x]) {
            if (y == p) continue;  // 부모 노드는 건너뛴다.
            int res = go(y, x);
            if (res == -2) return -2;  // 사이클 내의 노드 처리
            if (res >= 0) {
                check[x] = 2;  // 사이클 내의 노드 표시
                if (x == res) return -2;  // 사이클 시작 노드에 다시 도달, 사이클 처리 종료
                else return res;  // 사이클의 다른 노드 처리를 계속
            }
        }
        return -1;  // 사이클을 못 찾음
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 노드의 수
        a = new ArrayList[n];
        dist = new int[n];
        check = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = new ArrayList<>();
        }
        // 양방향 그래프 구성
        for (int i=0; i<n; i++) {
            int u = sc.nextInt()-1;
            int v = sc.nextInt()-1;
            a[u].add(v);
            a[v].add(u);
        }
        // 사이클 찾기 및 사이클 내 노드 표시
        go(0, -1);

        // BFS를 사용하여 사이클로부터 최소 거리 계산
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<n; i++) {
            if (check[i] == 2) {
                // 사이클 내 노드는 거리 0으로 계산
                dist[i] = 0;
                q.add(i);
            } else {
                // 사이클 외의 노드는 거리 -1로 초기화
                dist[i] = -1;
            }
        }

        // BFS 실행
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : a[x]) {
                if (dist[y] == -1) {
                    // 미방문 노드만 처리
                    q.add(y);
                    dist[y] = dist[x]+1;  // 거리 갱신
                }
            }
        }
        // 결과 출력
        for (int i=0; i<n; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
}
