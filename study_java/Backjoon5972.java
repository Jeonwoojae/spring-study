import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static List<List<Data>> list;
    static int[] dist;

    static class Data {
        int num, cost;
        public Data(int num, int cost) {
            this.num = num;  // 노드 번호
            this.cost = cost;  // 시작 노드부터 현재 노드까지 가중치
        }
        @Override
        public String toString() {
            return "num = " + num + " cost = " + cost;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i = 0; i<N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            // 노드 a,b를 연결하는 가중치를 리스트에 추가
            list.get(a).add(new Data(b, c));
            list.get(b).add(new Data(a, c));
        }

        dijkstra(0);  // 첫번째 노드부터 다익스트라 알고리즘 시작
        System.out.println(dist[N-1]);
    }

    private static void dijkstra(int start) {

        dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;  // 시작 노드의 최단 거리 설정

        PriorityQueue<Data> pq = new PriorityQueue<>((o1, o2)->o1.cost-o2.cost);
        pq.add(new Data(start, 0));  // 시작 노드를 우선순위 큐에 추가

        while(!pq.isEmpty()) {
            Data cur = pq.poll();
            if(dist[cur.num] < cur.cost) continue;  // 현재 노드까지의 거리가 더 짧으면 스킵

            for(Data next: list.get(cur.num)) {
                if(dist[next.num] > cur.cost + next.cost) {  // 다음 노드까지의 거리가 더 짧으면 업데이트
                    dist[next.num] = cur.cost + next.cost;
                    pq.add(new Data(next.num, dist[next.num]));  // 우선순위 큐에 추가
                }
            }
        }
    }
}