import java.util.*;

/*
* 연합의 개수를 세는 문제
* A섬과 B섬이 있을 떄 서로 이동할 수 있으면 연합이 될 수 있다.
* 연합 안에서 어떤 섬에서 출발해도 연합의 모든 섬에 방문할 수 있어야 한다.
* 모든 섬은 하나의 연합에 속해있다.
*
* 이번 문제는 그래프 탐색을 통해 정보를 얻어야 한다.
* 1. 컴포넌트에 속한 컴퓨터 수
* 2. 컴포넌트에 속한 회선의 수
* 3. 컴포넌트에서 가장 작은 컴퓨터의 번호
* 3가지 정보를 한번의 그래프 탐색으로 얻을 수 있다.
* */
public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }

        List<Integer> result = new ArrayList<>();
        double density = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                Pair pair = bfs(i);
                List<Integer> temp = pair.list;
                double tempDensity = pair.value;

                if (Math.abs(tempDensity - density) < 1e-8) {
                    // 만약 밀도가 같으면 2번 조건으 확인
                    // 만약 현재 컴포넌트 배열이 더 크면 result값을 확인
                    // 만약 배열의 크기가 같으면 첫번째 값을 비교
                    if (result.size() > temp.size()) {
                        result = temp;
                        density = tempDensity;
                    } else if (result.size() == temp.size()) {
                        if (temp.get(0) < result.get(0)) {
                            result = temp;
                            density = tempDensity;
                        }
                    }

//                    밀도가 다른 경우 1번 조건을 고려
                } else if (tempDensity > density) {
                    result = temp;
                    density = tempDensity;
                }
            }
        }

        for (int node : result) {
            System.out.print(node + " ");
        }

        sc.close();
    }

    public static Pair bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        Set<Integer> component = new HashSet<>();

        while (!q.isEmpty()) {
            int now = q.poll();

            if (visited[now]) {
                continue;
            }

            visited[now] = true;
            component.add(now);

            for (int to : graph[now]) {
                if (!visited[to]) {
                    q.add(to);
                }
            }
        }

        // 간선의 수
        int edge = 0;

        // 컴포넌트에 속한 모든 컴퓨터에 대해 순회한다.
        for (int i : component) {
            // 범위 오류 방지를 위해 간선이 존재하는 노드인지 확인한다.
            for (int to : graph[i]) {
                // 도달 가능한 컴퓨터 중,
                // 해당 컴포넌트에 속하면 컴포넌트 내부의 통신 회선
                if (component.contains(to)) {
                    edge++;
                }
            }
        }

        List<Integer> sortedList = new ArrayList<>(component);
        Collections.sort(sortedList);

        return new Pair(sortedList, (double) edge / component.size());
    }

    // 찾아낸 컴포넌트와 밀도 데이터를 하나의 데이터인 Pair로 관리
    static class Pair {
        List<Integer> list;
        double value;

        Pair(List<Integer> list, double value) {
            this.list = list;
            this.value = value;
        }
    }
}