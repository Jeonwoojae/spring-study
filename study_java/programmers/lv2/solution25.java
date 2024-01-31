import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dictionary = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // 사전 초기화
        for(int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char)('A' + i)), i + 1);
        }

        int dictionaryIdx = 27;
        int start = 0; // 시작 위치
        while(start < msg.length()) {
            int end = msg.length();

            // 사전에 문자열 있는지 찾기
            while(start < end && !dictionary.containsKey(msg.substring(start, end))) {
                end--;
            }

            result.add(dictionary.get(msg.substring(start, end))); // 결과에 추가
            if(end == msg.length()) break; // 문자열의 끝에 도달했으면 종료

            // 새로운 문자열을 사전에 등록
            dictionary.put(msg.substring(start, end + 1), dictionaryIdx++);
            start = end; // 시작 위치 업데이트
        }

        // 결과를 배열로 변환하여 반환
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}