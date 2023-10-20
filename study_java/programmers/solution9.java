import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int startX = 0;
        int startY = 0;

        // 시작 위치 찾기
        for (int i = 0; i < park.length; i++) {
            if (park[i].indexOf('S') != -1) {
                startX = i;
                startY = park[i].indexOf('S');
                break;
            }
        }

        // 방향 설정
        Map<String, int[]> directions = new HashMap<>();
        directions.put("N", new int[]{-1, 0});
        directions.put("S", new int[]{1, 0});
        directions.put("W", new int[]{0, -1});
        directions.put("E", new int[]{0, 1});

        for (String route : routes) {
            String directionKey = route.split(" ")[0];
            int moveCount= Integer.parseInt(route.split(" ")[1]);

            int[] directionVector=directions.get(directionKey);

            for(int j=0;j<moveCount;j++){
                startX+=directionVector[0];
                startY+=directionVector[1];

                if(startX<0 || startX>=park.length || startY<0 || startY>=park[0].length() || park[startX].charAt(startY)=='X'){
                    startX-=directionVector[0];
                    startY-=directionVector[1];
                    break;
                }
            }
        }

        return new int[]{startX ,startY};
    }
}
