import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            // {우선순위, 위치}
            queue.add(new int[]{priorities[i], i});
        }

        Arrays.sort(priorities);
        int idx = priorities.length - 1; // 가장 높은 우선순위 참조

        int answer = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            if (current[0] == priorities[idx]) { // 현재 문서의 우선순위가 가장 높다면
                answer++; // 인쇄
                idx--;
                if (current[1] == location) { // 요청한 문서가 인쇄되었다면
                    break;
                }
            } else { // 아니라면 큐의 맨 뒤로 보냄
                queue.add(current);
            }
        }

        return answer;
    }
}
