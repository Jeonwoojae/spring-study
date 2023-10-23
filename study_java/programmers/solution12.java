import java.util.*;

class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int start = 0;

        for (int s : section) {
            if (s > start) {
                start = s + m - 1;
                answer++;
            }
        }

        return answer;
    }
}
