import java.io.*;
import java.util.*;

class Main {
    /*
    * 노드의 개수 1 <= N <= 2000
    * 간선의 개수 1 <= M <= 200000
    * 시작 노드의 번호 1 <= K <= N
    * 다음 M개 줄에는 간선이 잇는 양끝 정점의 번호 si, ei가 공백을 두고 주어진다.
    *
    * 플레이어는 그래프에서 K번 노드에서 시작한다.
    * 한번 방문한 노드는 다시 방문할 수 없다. 시작 노드도 방문한 것.
    * 현재 노드와 간선으로 직접 연결된 다른 노드 중, 방문할 수 있으면서 번호가 가장 작은 노드로 이동한다.
    *
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 그래프 정보 입력 받기
        int N = scanner.nextInt(); // 정점 개수
        int M = scanner.nextInt(); // 간선 개수
        int K = scanner.nextInt(); // 시작 정점

        // 인접 리스트 방식
        Map<Integer, List<Integer>> graph = new HashMap<>();
        /*
        * 인접 행렬은 다음과 같이 사용할 수 있다.
        * 인접 행렬은 읽기가 상수 시간이지만,
        * 주어지는 정점 개수의 제곱에 비례하는 크기의 배열을 선언하여 공간 복잡도가 너무 커진다.
        * 어떤 정점과 연결된 다른 정점의 정보를 확인하려면 다른 N개의 정저에 대해 모두 살펴야 한다.
        * 그래서 보통 인접 리스트 방식을 사용
        * int[][] graph = new int[N + 1][N + 1];
        * */

        for (int i = 0; i < M; i++) {
            int s = scanner.nextInt();
            int e = scanner.nextInt();

            // 노드의 존재 여부 확인
            if (!graph.containsKey(s)){
                graph.put(s, new ArrayList<>());
            };
            if (!graph.containsKey(e)){
                graph.put(e, new ArrayList<>());
            };
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        int[] visited = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(K);
        int answer = 0; // 방문한 노드 개수
        int currentNode = K; // 마지막으로 방문한 노드 번호

        // 탐색할 수 있는 노드가 있을 때까지 탐색
        while (!q.isEmpty()) {
            currentNode = q.poll();
            // 방문 체크
            visited[currentNode] = 1;
            answer++;  // 정점을 방문할 때마다 답을 1씩 증가시킵니다.

            // 가장 작은 정점의 번호를 다음 방문 정점으로 선택하기 위해서 후보를 정렬
            List<Integer> tempNodes = graph.get(currentNode);
            if (tempNodes != null && !tempNodes.isEmpty()) {
                Collections.sort(tempNodes);
                for (int nextNode : tempNodes) {
                    // 방문할 수 있는 정점이 나오면 반복문을 탈출
                    if (visited[nextNode] == 0) {
                        q.add(nextNode);
                        break;
                    }
                }
            }
        }
        System.out.println(answer + " " + currentNode);
    }
}