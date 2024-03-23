import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer>[] a = new ArrayList[n];
        int[] parent = new int[n];
        int[] order = new int[n];
        boolean[] check = new boolean[n];
        for (int i = 0; i < n; i++) {
            a[i] = new ArrayList<>();
        }
        // 양방향 그래프 생성
        for (int i=0; i<n-1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            a[u].add(v);
            a[v].add(u);
        }
        for (int i=0; i<n; i++) {
            // 탐색 순서 입력
            order[i] = sc.nextInt() - 1;
        }

        // BFS 탐색 시작
        Queue<Integer> q = new LinkedList<>();
        // 0번 노드부터 탐색 시작
        q.add(0);
        check[0] = true;
        int m = 1;
        for (int i=0; i<n; i++) {
            if (q.isEmpty()) {
                // 큐가 비어있으면 순서가 유효하지 않음
                System.out.println(0);
                System.exit(0);
            }
            int x = q.remove();
            if (x != order[i]) {
                // 현재 노드가 예상 순서와 다르면 순서가 유효하지 않음
                System.out.println(0);
                System.exit(0);
            }
            int cnt = 0;  // 현재 노드의 자식 수
            for (int y: a[x]) {
                if (check[y] == false) {// 방문하지 않은 인접 노드인 경우
                    parent[y] = x;  // 부모 노드 설정
                    cnt ++;  // 자식 노드 수 증가
                }
            }
            for (int j=0; j<cnt; j++) {
                // 현재 노드의 자식 노드가 예상 순서와 일치하는지 검사
                if (m+j >= n || parent[order[m+j]] != x) {
                    System.out.println(0);  // 순서가 유효하지 않음
                    System.exit(0);
                }
                q.add(order[m+j]);  // 큐에 자식 노드 추가
                check[order[m+j]] = true;  // 방문 표시
            }
            m += cnt;  // 다음 검사할 인덱스로 이동
        }
        System.out.println(1);  // 주어진 순서대로 BFS 탐색이 가능함
    }
}