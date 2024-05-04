import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 우선순위 큐를 최대 힙이 아닌 최소 힙으로 사용
        PriorityQueue<Long> q = new PriorityQueue<>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                long cur = Long.parseLong(st.nextToken());

                // 우선순위 큐의 크기가 N보다 작을 때는 그냥 값을 추가
                if (q.size() < n) {
                    q.add(cur);
                } else {
                    // 우선순위 큐의 크기가 N 이상일 때, 큐의 가장 작은 수(큐의 맨 앞)가 현재 수보다 작으면,
                    // 가장 작은 수를 제거하고 현재 수를 추가
                    if (q.peek() < cur) {
                        q.poll();
                        q.add(cur);
                    }
                }
            }
        }

        // 이 시점에서 우선순위 큐의 맨 앞에 있는 수가 N번째로 큰 수
        System.out.println(q.poll());
    }
}
