import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0]-1;
            int end = commands[i][1];
            int k = commands[i][2]-1;

            List<Integer> tempList = new ArrayList<>();

            for (int j = start; j < end; j++) {
                tempList.add(array[j]);
            }
            Collections.sort(tempList);
            answerList.add(tempList.get(k));
        }

        return answerList.stream().mapToInt(i->i).toArray();
    }
}