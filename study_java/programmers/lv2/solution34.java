class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];

        // 좌표로 변환
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            boolean[][] check = new boolean[m][n];
            // 우측, 좌측, 대각선이 같은지 확인
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    // 현재 칸이 빈칸이 아니면서, 우측, 좌측, 대각선이 같다면 해당 위치를 true로 변경.
                    if (map[i][j] != ' ' && map[i][j] == map[i][j + 1] && map[i][j] == map[i + 1][j] && map[i][j] == map[i + 1][j + 1]) {
                        check[i][j] = check[i][j + 1] = check[i + 1][j] = check[i + 1][j + 1] = true;
                    }
                }
            }

            // 제거한 블록 갯수 count
            int cnt = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j]) {
                        cnt++;
                        map[i][j] = ' ';  // 해당 위치를 빈칸으로 변경
                    }
                }
            }

            if (cnt == 0) break;  // 2X2를 체크했을 때, 제거할 블록이 없다면 종료
            else answer += cnt;  // 제거한 블록 갯수 덧셈

            // 블록이 제거되면 위에 있는 블록을 아래로 이동
            for (int i = m - 1; i > 0; i--) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == ' ') {
                        // 만약 빈칸을 찾으면
                        for (int k = i - 1; k >= 0; k--) {
                            if (map[k][j] != ' ') {
                                // 빈칸과 그 위에 처음 나오는 글자로 변경
                                map[i][j] = map[k][j];
                                map[k][j] = ' ';
                                break;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}