import java.util.*;

class Solution {
    // 이동 정보
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static String[] dirStr = {"U","D","R","L"};

    public int solution(String dirs) {
        int answer = 0;
        Set<String> pathSet = new HashSet<>();  // 경로 방문 여부
        int x = 0, y = 0; // 현재 위치

        // 전체 방문 시작
        for(int i=0; i<dirs.length();i++) {
            // 이동 방향 결정
            for(int j=0; j<4; j++) {
                if(dirs.charAt(i) == dirStr[j].charAt(0)) {
                    // 이동 가능한지
                    int newX = x + dir[j][0];
                    int newY = y + dir[j][1];

                    // 예외 : 좌표 평면 밖이면 pass
                    if(newX < -5 || newX > 5 || newY < -5 || newY > 5) {
                        continue;
                    }

                    // 경로 방문 여부 생성
                    String path = makePath(x, y, newX, newY);
                    String reversePath = makePath(newX, newY, x, y);

                    // 경로가 기존에 저장된건지 확인
                    if(!pathSet.contains(path)) {
                        pathSet.add(path);
                        pathSet.add(reversePath);
                        answer++;
                    }

                    // 현재 위치 update
                    x = newX;
                    y = newY;
                    break;  // 다음 이동 글자
                }
            }
        }
        return answer;
    }

    private String makePath(int x1, int y1, int x2, int y2) {
        return x1 + "," + y1 + "," + x2 + "," + y2;
    }
}
