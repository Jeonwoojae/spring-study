import java.util.*;

/*
* 연합의 개수를 세는 문제
* A섬과 B섬이 있을 떄 서로 이동할 수 있으면 연합이 될 수 있다.
* 연합 안에서 어떤 섬에서 출발해도 연합의 모든 섬에 방문할 수 있어야 한다.
* 모든 섬은 하나의 연합에 속해있다.
* */
public class Main {
    /*
    * 결과적으로 모든 섬을 방문해야 하기 떄문에 BFS로 문제를 해결할 수 있다.
    * 그래프 기초는 HashMap을 이용해 구현한다.
    * */
    public static void main(String[] args) {
        // 그래프 생성
        int N, M;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        int[][] graph = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();

            graph[s][e] = 1;
        }

        int[] visited = new int[N + 1];  // 방문 기록 & 연합 기록 확인
        int count = 1;  // 연합의 번호

        for (int i = 1; i <= N; i++) {
            // 0이면 어떤 연합에도 포함되지 않은 섬
            if (visited[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);

                // 탐색 후보가 바뀔 때 까지
                while (!q.isEmpty()) {
                    // BFS로 구현
                    int currentNode = q.poll();
                    // 현재 방문한 노드를 연합의 번호 할당
                    visited[currentNode] = count;

                    for (int nextNode = 1; nextNode <= N; nextNode++) {
                        // check 매트릭스에서 간선의 존재 여부를 확인
                        // cotain을 사용하여 존재 여부를 찾으면 Timeout이 발생한다.
                        if (graph[currentNode][nextNode] == 1 &&
                                graph[nextNode][currentNode] == 1 &&
                                visited[nextNode] == 0) {
                            q.add(nextNode);
                        }
                    }
                }
                count++;
            }
        }

        System.out.println(count - 1);
    }
}