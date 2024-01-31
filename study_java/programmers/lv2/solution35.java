import java.util.*;

class Solution {
    // 모든 원소의 합/2가 각 큐에 저장되어야 한다.
    public int solution(int[] queue1, int[] queue2) {
        List<Long> list = new ArrayList<>();  // 원소를 모두 포함하는 리스트
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();

        if(sum1 == sum2) return 0;
        else if((sum1 + sum2) % 2 != 0) return -1;  // 홀수인 경우 같게 나눌 수 없음
        else if(sum2 > sum1) return solution(queue2, queue1);  // 위치 바꾸어 다시 싱행

        long target = (sum1 + sum2) / 2;
        for(int i = 0 ; i < queue1.length ; i ++) list.add((long)queue1[i]);
        for(int i = 0 ; i < queue2.length ; i ++) list.add((long)queue2[i]);
        for(int i = 0 ; i < queue1.length ; i ++) list.add((long)queue1[i]);
        for(int i = 0 ; i < queue2.length ; i ++) list.add((long)queue2[i]);

        // 투포인터로 탐색 시작
        int i = 0;
        int j = queue1.length;
        int ans = 0;
        while(i != j && i < queue1.length * 2 && j < list.size()){
            while(sum1 > target && i < queue1.length * 2){
                sum1 -= list.get(i++);
                ans ++;
            }

            while(sum1 < target && j < list.size()){
                sum1 += list.get(j++);
                ans ++;
            }

            if(sum1 == target) return ans;
        }

        return -1;
    }


}