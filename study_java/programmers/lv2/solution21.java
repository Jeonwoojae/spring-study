import java.util.*;

class Solution {
    // citations[] = 각 논문의 인용 횟수가 저장되어 있다.
    // h-index = h번 이상 인용된 논문이 h편 이상일 때.
    public int solution(int[] citations) {
        Arrays.sort(citations); // 인용 횟수가 적은 순서로 정렬

        int max = 0; // 인용 횟수와 H-index가 대응될 때 최댓값
        int len = citations.length;

        for (int i = 0; i < len; i++) {
            // min = 현재 인용횟수를 기준으로 H-index 구하기
            int min = Math.min(citations[i], len - i);
            max = Math.max(max, min);
        }

        return max;
    }

}