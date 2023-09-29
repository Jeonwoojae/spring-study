import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        Map<String, Integer> pointHashMap = new HashMap<>(){{
            put("R",0);
            put("T",0);
            put("C",0);
            put("F",0);
            put("J",0);
            put("M",0);
            put("A",0);
            put("N",0);
        }};

        // 각 질문에 대해 점수 매기기
        for(int i = 0;i<survey.length;i++){
            String type1 = survey[i].substring(0,1);
            String type2 = survey[i].substring(1,2);
            int choice = choices[i] - 4;

            if(choice > 0){
                pointHashMap.put(type2, pointHashMap.get(type2)+choice);
            } else {
                pointHashMap.put(type1, pointHashMap.get(type1)-choice);
            }
        }

        // 매긴 점수를 토대로 성격 유형 정하기
        StringBuilder sb = new StringBuilder();
        System.out.print(pointHashMap);
        if(pointHashMap.get("R") < pointHashMap.get("T")) {
            sb.append("T");
        } else{
            sb.append("R");
        }
        if(pointHashMap.get("C") < pointHashMap.get("F")) {
            sb.append("F");
        } else{
            sb.append("C");
        }
        if(pointHashMap.get("J") < pointHashMap.get("M")) {
            sb.append("M");
        } else{
            sb.append("J");
        }
        if(pointHashMap.get("A") < pointHashMap.get("N")) {
            sb.append("N");
        } else{
            sb.append("A");
        }


        return sb.toString();
    }
}