import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String,Integer> points = new HashMap<>();

        for(int i=0;i<name.length;i++) {
            points.put(name[i],yearning[i]);
        }


        for(int i=0;i<photo.length;i++) {
            String[] photoList = photo[i];
            int point = 0;

            for(String s : photoList) {
                point += points.getOrDefault(s, 0);
            }

            answer[i] = point;
        }

        return answer;
    }
}