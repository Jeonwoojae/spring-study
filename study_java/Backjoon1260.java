import java.util.*;
public class Main {
    static ArrayList<Integer>[] a;
    static boolean[] c;
    public static void dfs(int x) {
        if(c[x]) return; // 방문 했던 곳을 방문하면 종료하도록
        c[x] = true;
        System.out.print(x + " ");
        for(int y:a[x]) {
            // 현재 위치에서 연결된 정점 방문
            if(c[y] == false) {
                dfs(y);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        // 시작 지점에서 시작
        q.add(start);
        c[start] = true;
        while(!q.isEmpty()) {
            // 큐를 사용하여 깊이 우선 탐색
            int x = q.remove();
            System.out.print(x + " ");
            for(int y:a[x]) {
                if(c[y] == false) {
                    c[y] = true;
                    q.add(y);
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();
        a = (ArrayList<Integer>[]) new ArrayList[N+1];

        for(int i = 1; i <= N;i++) {
            a[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i <M;i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }
        for(int i = 1; i <= N; i++) {
            Collections.sort(a[i]);
        }
        c = new boolean[N+1];
        dfs(V);
        System.out.println();
        c = new boolean[N+1];
        bfs(v);
        System.out.println();
    }
}