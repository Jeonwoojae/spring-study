import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);

        int count = 0;
        int prevEnd = -1;

        for(int[] target : targets) {
            if(target[0] > prevEnd) {
                count++;
                prevEnd = target[1] - 1;
            }
        }

        return count;
    }
}
