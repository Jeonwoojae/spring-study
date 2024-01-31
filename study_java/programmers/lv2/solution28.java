import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int a : scoville){
            heap.offer(a);
        }

        int count = 0;
        while(heap.peek() < K){
            if(heap.size() < 2) return -1;
            int first = heap.poll();
            int second = heap.poll();

            int newScoville = first + (second * 2);
            heap.offer(newScoville);
            count++;
        }

        return count;
    }
}
