import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        * 다음 조건을 확인하면서 경로를 확인한다.
        * - i일에는 i번 도시를 경유할 수 없다.
        * */
        Scanner scanner = new Scanner(System.in);
        int N, M, S, E;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        String[] firstLine = scanner.nextLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        M = Integer.parseInt(firstLine[1]);
        S = Integer.parseInt(firstLine[2]);
        E = Integer.parseInt(firstLine[3]);
        for (int i = 0; i < M; i++) {
            String[] edge = scanner.nextLine().split(" ");
            int s = Integer.parseInt(edge[0]);
            int e = Integer.parseInt(edge[1]);
            graph.putIfAbsent(s, new ArrayList<>());
            graph.putIfAbsent(e, new ArrayList<>());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        //System.out.println(graph);

        // S 부터 E 까지의 최단 경로를 탐색
        for (int off = 1; off <= N; off++) {
            if (off == S || off == E) {
                // 출발점이나 도착점이 off 상태면 -1 출력
                System.out.println(-1);
            }
            else {
                int[] visited = new int[N + 1];
                Arrays.fill(visited, (int) 1e8);
                Queue<Integer> queue = new LinkedList<>();
                queue.add(S);
                visited[S] = 1;
                while (!queue.isEmpty()) {

                    // 범위 오류 확인을 위한 간선이 있는지 확인
                    int curNode = queue.poll();
                    if (graph.containsKey(curNode)) {
                        for (int nextNode : graph.get(curNode)) {

                            // nextNode가 off인지 확인
                            if (nextNode != off) {
                                if (visited[nextNode] > visited[curNode] + 1) {
                                    visited[nextNode] = visited[curNode] + 1;
                                    queue.add(nextNode);
                                    // 최단 거리라면 탐색 후보에 추가
                                }

                                // 다음 노드가 E라면 탐색을 종료
                                if (nextNode == E)	break;
                            }
                        }
                    }
                }
                // 방문한 적 없으면 -1을 출력, 방문한 적 있다면 최단거리를 출력
                System.out.println(visited[E] == (int) 1e8 ? -1 : visited[E]);
            }
        }
    }
}