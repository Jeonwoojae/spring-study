import java.util.*;

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int LIMIT = 5;  // 이동할 수 있는 최대 횟수
    // 이동 방향을 생성하는 함수
    static int[] gen(int k) {
        int[] a = new int[LIMIT];
        for (int i = 0; i < a.length; i++) {
            a[i] = (k&3);
            k >>= 2;
        }
        return a;
    }

    static int check(int[][] a, int[] dirs) {
        int n = a.length;
        int[][] d = new int[n][n];  // 현재 보드 상태를 복사할 배열
        boolean[][] merged = new boolean[n][n];  // 해당 위치의 수가 이미 합쳐졌는지 확인하는 배열
        // 현재 보드의 상태를 복사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = a[i][j];
            }
        }
        // 0~3 : 아래,위,왼쪽,오른쪽
        for (int dir : dirs) {
            boolean ok = false;  // 이동이 발생했는지 타나내는 변수
            // merged 배열을 초기화
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    merged[i][j] = false;
                }
            }

            // 현재 방향에 따라 이동을 시도
            while (true) {
                ok = false;
                // 아래로 이동하는 경우
                if (dir == 0) {
                    // 아래 행부터 위쪽 행 순서로 이동을 시도
                    for (int i=n-2; i>=0; i--) {
                        for (int j=0; j<n; j++) {
                            if (d[i][j] == 0) continue;  // 현재 칸이 비어있으면 이동할 필요가 없어 건너뛴다.
                            // 아래쪽 칸이 비어있는 경우 아래 칸으로 이동한다.
                            if (d[i+1][j] == 0) {
                                d[i+1][j] = d[i][j];
                                merged[i+1][j] = merged[i][j];
                                d[i][j] = 0;
                                ok = true;
                            // 아래 칸의 수와 현재 칸의 수가 같고, 두 수가 아직 합쳐지지 않았다면 두 수를 합친다.
                            } else if (d[i+1][j] ==d[i][j]) {
                                if (merged[i][j] == false && merged[i+1][j] == false) {
                                    d[i+1][j] *= 2;
                                    merged[i+1][j] = true;
                                    d[i][j] = 0;
                                    ok = true;
                                }
                            }
                        }
                    }
                } else if (dir == 1) {
                    for (int i=1; i<n; i++) {
                        for (int j=0; j<n; j++) {
                            if (d[i][j] == 0) continue;
                            if (d[i-1][j] == 0) {
                                d[i-1][j] = d[i][j];
                                merged[i-1][j] = merged[i][j];
                                d[i][j] = 0;
                                ok = true;
                            } else if (d[i-1][j] == d[i][j]) {
                                if (merged[i][j] == false && merged[i-1][j] == false) {
                                    d[i-1][j] *= 2;
                                    merged[i-1][j] = true;
                                    d[i][j] = 0;
                                    ok = true;
                                }
                            }
                        }
                    }
                } else if (dir == 2) {
                    for (int j=1; j<n; j++) {
                        for (int i=0; i<n; i++) {
                            if (d[i][j] == 0) continue;
                            if (d[i][j-1] == 0) {
                                d[i][j-1] = d[i][j];
                                merged[i][j-1] = merged[i][j];
                                d[i][j] = 0;
                                ok = true;
                            } else if (d[i][j-1] == d[i][j]) {
                                if (merged[i][j] == false && merged[i][j-1] == false) {
                                    d[i][j-1] *= 2;
                                    merged[i][j-1] = true;
                                    d[i][j] = 0;
                                    ok = true;
                                }
                            }
                        }
                    }
                } else if (dir == 3) {
                    for (int j=n-2; j>=0; j--) {
                        for (int i=0; i<n; i++) {
                            if (d[i][j] == 0) continue;
                            if (d[i][j+1] == 0) {
                                d[i][j+1] = d[i][j];
                                merged[i][j+1] = merged[i][j];
                                d[i][j] = 0;
                                ok = true;
                            } else if (d[i][j+1] == d[i][j]) {
                                if (merged[i][j] == false && merged[i][j+1] == false) {
                                    d[i][j+1] *= 2;
                                    merged[i][j+1] = true;
                                    d[i][j] = 0;
                                    ok = true;
                                }
                            }
                        }
                    }
                }
                if (ok == false) break;
            }
        }
        // 최대값을 찾는다.
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (ans < d[i][j]) {
                    ans = d[i][j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        int ans = 0;
        for (int k=0; k<(1<<(LIMIT*2)); k++) {
            int[] dir = gen(k);  // 이동 방향 생성
            int cur = check(a, dir);  // 생성된 방향에 따라 실제 이동을 시행
            if (ans < cur) ans = cur;
        }
        System.out.println(ans);
    }
}