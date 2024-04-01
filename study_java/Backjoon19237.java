import java.util.*;
class Shark implements Comparable<Shark>{
    int number, row, col;
    Shark(int number, int row, int col) {
        this.number = number;
        this.row = row;
        this.col = col;
    }
    // 상어를 번호, 행, 열순서로 정렬
    public int compareTo(Shark that) {
        if (this.number < that.number) {
            return -1;
        } else if (this.number == that.number) {
            if (this.row < that.row) {
                return -1;
            } else if (this.row == that.row) {
                if (this.col < that.col) {
                    return -1;
                } else if (this.col == that.col) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }
}
class Main {
    static final int limit = 1000;
    static final int[] dx = {-1,1,0,0};
    static final int[] dy = {0,0,-1,1};
    static int[][] shark;
    static int[][] sharkNext;
    static int[][] smell;
    static int[][] smellWho;
    static int[] dir;
    static int[][][] priority;
    static int n, m, smellTime;
    // 상어가 1마리만 남았는지 확인하는 함수
    static boolean check() {
        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (shark[i][j] > 0) {
                    cnt += 1;
                }
            }
        }
        return cnt == 1;  // 한마리만 남았으면 true 반환
    }
    static void moveShark() {
        ArrayList<Shark> v = new ArrayList<>();
        // 상어의 현재 위치 생성
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                shark_next[i][j] = 0;  // 다음 상태 초기화
                if (shark[i][j] > 0) {
                    v.add(new Shark(shark[i][j], i, j));
                }
            }
        }
        Collections.sort(v);  // 상어를 번호순 정렬
        // 상어 이동
        for (Shark t : v) {
            int no = t.number;
            int x = t.row;
            int y = t.col;
            int sharkDir = dir[no];
            boolean ok = false;  // 이동 여부 확인
            for (int k=0; k<4; k++) {
                int nx = x+dx[priority[no][sharkDir][k]];
                int ny = y+dy[priority[no][sharkDir][k]];
                // 이동 가능한 칸인지
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    if (smell[nx][ny] == 0) {  // 냄새가 없는 칸으로 이동
                        if (shark_next[nx][ny] == 0) {
                            shark_next[nx][ny] = no;  // 상어 번호
                            dir[no] = priority[no][sharkDir][k];  // 방향 업데이트
                        } else {
                            if (shark_next[nx][ny] > no) {
                                shark_next[nx][ny] = no;
                                dir[no] = priority[no][sharkDir][k];
                            }
                        }
                        ok = true;
                        break;
                    }
                }
                if (ok) break;
            }
            if (!ok) {  // 냄새가 있는 자신의 칸으로 돌아감
                for (int k=0; k<4; k++) {
                    int nx = x+dx[priority[no][sharkDir][k]];
                    int ny = y+dy[priority[no][sharkDir][k]];
                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        if (smell[nx][ny] > 0 && smellWho[nx][ny] == no) {
                            sharkNext[nx][ny] = no;
                            dir[no] = priority[no][sharkDir][k];
                            ok = true;
                            break;
                        }
                    }
                    if (ok) break;
                }
            }
        }
        // 상태 업데이트
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                shark[i][j] = sharkNext[i][j];
                if (smell[i][j] > 0) {
                    smell[i][j] -= 1;  // 냄새 감소
                }
                if (smell[i][j] == 0) {
                    smellWho[i][j] = 0;  // 냄새 제거
                }
                if (shark[i][j] > 0) {
                    smell[i][j] = smellTime;  // 새로운 냄새 추가
                    smellWho[i][j] = shark[i][j];  // 냄새를 남긴 상어 번호 업데이트
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        smellTime = sc.nextInt();
        shark = new int[n][n];
        sharkNext = new int[n][n];
        smell = new int[n][n];
        smellWho = new int[n][n];
        dir = new int[m+1];
        priority = new int[m+1][4][4];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                shark[i][j] = sc.nextInt();  // 상어 번호
                if (shark[i][j] > 0) {
                    smell[i][j] = smellTime;  // 냄새 설정
                    smellWho[i][j] = shark[i][j];  // 냄새를 남긴 상어 번호
                }
            }
        }

        // 상어 방향 및 우선순위 입력
        for (int i=1; i<=m; i++) {
            dir[i] = sc.nextInt() - 1;
        }
        for (int i=1; i<=m; i++) {
            for (int j=0; j<4; j++) {
                for (int k=0; k<4; k++) {
                    priority[i][j][k] = sc.nextInt()-1;
                }
            }
        }
        // 시뮬레이션 실행
        int ans = -1;
        for (int t=1; t<=limit; t++) {
            moveShark();  // 상어 이동
            if (check()) {  // 1번 상어만 남았는지 확인
                ans = t;
                break;
            }
        }
        System.out.println(ans);
    }
}
