class Solution {
    // 각 열들의 선택에 대해 최고점이 어떻게 계산되는지 동적 프로그래밍을 통해 구할 수 있다.
    int solution(int[][] land) {
        // 행만큼 반복
        for (int i = 1; i < land.length; i++) {
            // 열만큼 반복
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k && land[i-1][k] > max) {
                        // 같은 열이 아니면서 현재 전 열의 최댓값 찾기
                        max = land[i-1][k];
                    }
                }
                // 현재 위치에 최고점 기대치 업데이트
                land[i][j] += max;
            }
        }

        // 맨 끝행의 열들에는 각 선택의 최고점들이 있다.
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (land[land.length - 1][i] > answer) {
                answer = land[land.length - 1][i];
            }
        }

        return answer;
    }
}