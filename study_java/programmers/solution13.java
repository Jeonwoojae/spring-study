import java.util.*;

import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        Map<String, Integer> numMap = new HashMap<>();
        int[] answer = new int[targets.length];

        // 글자를 key, 해당 글자를 위한 횟수를 value로 저장
        for(int i=0;i<keymap.length;i++) {
            String[] keys = keymap[i].split("");
            for(int j=0;j<keys.length;j++) {
                int current = numMap.getOrDefault(keys[j],j);
                if(current >= j){
                    numMap.put(keys[j], j);
                }
            }
        }
        System.out.println(numMap);

        // targets에 대한 누르는 횟수 세기
        for(int i=0;i<targets.length;i++) {
            String[] target = targets[i].split("");
            int count=0;
            for(int j=0;j<target.length;j++) {
                if(numMap.get(target[j])==null){
                    count = -1;
                    break;
                }
                count = count + 1 + numMap.get(target[j]);
            }
            answer[i] = count;
        }

        return answer;
    }
}