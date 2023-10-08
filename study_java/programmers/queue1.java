import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int index = 0; index < progresses.length; index++) {
            queue.add(index);
        }

        while (!queue.isEmpty()) {
            // speeds 만큼 작업 수행
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            int count = 0;

            //  매일 작업완료량 체크
            // 큐 맨 앞의 값이 100보다 크거나 같으면 완료처리 반복
            while (!queue.isEmpty() && progresses[queue.peek()] >= 100) {
                queue.poll();
                count++;
            }

            if (count > 0) {
                list.add(count);
            }
        }


        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
