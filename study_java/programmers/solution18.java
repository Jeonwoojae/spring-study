import java.util.*;

class Solution {
    public String solution(int[] food) {
        List<Integer> list = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        StringBuilder answer = new StringBuilder();
        for(int i=1; i<food.length; i++) {
            int currentNum = i;
            int count = food[i] / 2;
            for(int j=0; j<count; j++) {
                list.add(currentNum);
                answer.append(currentNum);
            }
            right.addAll(list);
            list.clear();
        }

        list.add(0);
        right.addAll(list);
        Collections.reverse(right);


        for(Integer num : right) {
            answer.append(num);
        }
        return answer.toString();
    }
}
