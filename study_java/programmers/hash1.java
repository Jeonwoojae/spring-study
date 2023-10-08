import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesMap = new HashMap<>();

        // 종류 별 갯수 세기
        for (String[] cloth : clothes) {
            String type = cloth[1];
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }

        int answer = 1;

        // 경우의 수 구하기
        for (int value : clothesMap.values()) {
            // 안 입는 경우를 포함하기 때문에 +1을 한다.
            answer *= (value + 1);
        }

        return answer - 1;
    }
}