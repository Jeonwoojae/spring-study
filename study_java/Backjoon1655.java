import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 최소 힙과 최대 힙 생성
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            // 최대 힙이 비어 있거나 x가 최대 힙의 루트보다 작거나 같으면, 최대 힙에 x를 추가
            if (maxHeap.isEmpty() || x <= maxHeap.peek()) {
                maxHeap.offer(x);
            } else { // x가 최대 힙의 루트보다 크면 최소 힙에 x를 추가
                minHeap.offer(x);
            }

            // 최대 힙의 크기가 최소 힙의 크기 + 1보다 클 경우, 최대 힙의 루트를 최소 힙으로 이동
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                // 최소 힙의 크기가 최대 힙의 크기보다 크면, 최소 힙의 루트를 최대 힙으로 이동
                maxHeap.offer(minHeap.poll());
            }

            // 중간값 출력
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb);
    }
}