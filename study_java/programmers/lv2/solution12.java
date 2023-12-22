import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> usedWords = new HashSet<>();
        int round = 0;

        // 말한 단어와 최종 글자를 저장
        String lastWord = words[0];
        usedWords.add(lastWord);

        // 모든 단어에 대해 반복
        for (int i = 1; i < words.length; i++) {
            // 앞의 최종 글자와 같지 않거나, 말했던 단어를 말한다면
            if (lastWord.charAt(lastWord.length() - 1) != words[i].charAt(0) || usedWords.contains(words[i])) {
                // 현재 인원의 번호와 횟수를 반환
                return new int[]{i % n + 1, i / n + 1};
            }

            // 말한 단어와 최종 글자를 업데이트
            usedWords.add(words[i]);
            lastWord = words[i];
        }

        // 모든 단어를 말했다면 0,0을 반환
        return new int[]{0, 0};
    }
}