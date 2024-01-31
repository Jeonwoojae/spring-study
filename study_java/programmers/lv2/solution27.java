import java.util.*;

class Solution {
    ArrayList<String> list = new ArrayList<>();

    // 완전 탐색
    public int solution(String word) {
        char[] c = {'A', 'E', 'I', 'O', 'U'};
        for(int i=1; i<=5; i++) {
            dfs(c, "", i);
        }
        Collections.sort(list);
        return list.indexOf(word) + 1;
    }

    void dfs(char[] c, String s, int depth) {
        if(s.length() == depth) {
            list.add(s);
            return;
        }
        for(int i=0; i<5; i++) {
            dfs(c, s+c[i], depth);
        }
    }

    // 누적합 방법
    public int solution(String word) {
        int answer = 0;
        int[] value = {781, 156, 31, 6, 1};
        String[] vowels = {"A", "E", "I", "O", "U"};

        for(int i = 0; i < word.length(); i++){
            for(int j = 0; j < 5; j++){
                if(vowels[j].equals(word.substring(i, i+1))){
                    answer += 1 + j * value[i];
                }
            }
        }

        return answer;
    }
}
