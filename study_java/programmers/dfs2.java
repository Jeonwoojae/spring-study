import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1; // 최단 경로가 없는 경우 -1을 반환하기 위해 초기값을 -1로 설정합니다.

        int[] moveX = {0, 0, -1, 1}; // 상하좌우 이동에 대한 x 좌표 변화량
        int[] moveY = {-1, 1, 0, 0}; // 상하좌우 이동에 대한 y 좌표 변화량

        int endYIndex = maps.length - 1; // 목적지의 y 인덱스
        int endXIndex = maps[0].length - 1; // 목적지의 x 인덱스

        Queue<int[]> queue = new LinkedList<>(); // BFS 탐색을 위한 큐 선언
        boolean[][] visited = new boolean[maps.length][maps[0].length]; // 방문 여부를 저장하는 배열

        queue.offer(new int[]{0, 0}); // 시작 위치인 (0, 0)을 큐에 추가
        visited[0][0] = true; // 시작 위치 방문 처리

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] currentPos= queue.poll();
                int currentYIndex= currentPos[0];
                int currentXIndex= currentPos[1];

                if (currentYIndex == endYIndex && currentXIndex == endXIndex) {
                    return maps[currentYIndex][currentXIndex];
                    // 도착 지점에 도달한 경우 현재까지의 이동 횟수(값) 반환
                }

                for (int j= 0; j<4;j++) {
                    int nextY= currentYIndex+ moveY[j];
                    int nextX= currentXIndex+ moveX[j];

                    if (nextY>= 0 && nextY<=endYIndex && nextX>=0 && nextX<=endXIndex && !visited[nextY][nextX] && maps[nextY][nextX]==1) {
                        queue.offer(new int[]{nextY,nextX});
                        visited[nextY][nextX]= true;
                        maps[nextY][nextX]=maps[currentYIndex][currentXIndex]+1;
                    }
                }
            }
        }


        return answer;
    }
}