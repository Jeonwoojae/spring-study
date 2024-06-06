import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // 최대 힙
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Comparator.reverseOrder());
        // 최소 힙
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        for(int i=0; i<N; i++) {
            int a = Integer.parseInt(br.readLine());

            if(maxPQ.size() == minPQ.size()) {
                // 먼저 최대힙에 값을 넣어 중간 값이 최대힙에서 가져오도록
                maxPQ.add(a);

                // 크기를 비교하여 교환
                if(!minPQ.isEmpty() && maxPQ.peek() > minPQ.peek()) {
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }
            }
            else {
                minPQ.add(a);

                if(maxPQ.peek() > minPQ.peek()) {
                    minPQ.add(maxPQ.poll());
                    maxPQ.add(minPQ.poll());
                }
            }

            System.out.println(maxPQ.peek());
        }
    }
}
