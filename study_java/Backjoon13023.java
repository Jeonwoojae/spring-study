import java.util.*;
class Edge {
    int from, to;
    Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
}
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] a = new boolean[n][n];
        ArrayList<Integer>[] g = (ArrayList<Integer>[]) new ArrayList[n];
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for (int i=0; i<n; i++) {
            g[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            edges.add(new Edge(from, to));
            edges.add(new Edge(to, from));
            a[from][to] = a[to][from] = true;  // 친구임을 저장
            g[from].add(to);
            g[to].add(from);
        }
        m *= 2;  // 경로를 두번 저장했기 때문에 2배로 탐색한다.
        for  (int i=0; i<m; i++) {
            for (int j=0; j<m; j++) {
                int A = edges.get(i).from;
                int B = edges.get(i).to;
                int C = edges.get(j).from;
                int D = edges.get(j).to;
                if (A == B || A == C || A == D || B == C || B == D || C == D) {
                    // 모두 다른 정점을 가져올 때 까지 반복
                    continue;
                }
                if (!a[B][C]) continue;  // B와 C가 연결되어있는지 찾기
                for (int E : g[D]) {
                    // 이때 D에서 시작하는 간선들 중 A,B,C,D가 다른 점인지 확인한다.
                    if (A == E || B == E || C == E || D == E) {
                        continue;
                    }
                    System.out.println(1);
                    System.exit(0);
                }
            }
        }
        System.out.println(0);
    }
}