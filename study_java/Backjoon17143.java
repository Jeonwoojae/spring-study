import java.util.*;

class Fish {
    int size, speed, direction;
    Fish(int size, int speed, int direction) {
        this.size = size;
        this.speed = speed;
        this.direction = direction;
    }
    Fish(Fish that) {
        this.size = that.size;
        this.speed = that.speed;
        this.direction = that.direction;
    }
}

class Tuple {
    int row, col, direction;
    Tuple(int row, int col, int direction) {
        this.row = row;
        this.col = col;
        this.direction = direction;
    }
}

public class Main {
    static final int[] dx = {-1,1,0,0};
    static final int[] dy = {0,0,1,-1};
    static int n, m; // 격자의 세로(n), 가로(m) 크기
    static Fish[][] fish; // 현재 격자 상태
    static Fish[][] nfish; // 다음 상태의 격자를 임시로 저장할 배열

    // 물고기 이동 경로와 방향을 계산하는 함수
    static Tuple getNext(int x, int y, int speed, int direction) {
        for (int k = 0; k < speed; k++) {
            // 각 방향에 따른 위치 업데이트. 경계를 만나면 방향 전환
            if (direction == 0) { // 상
                if (x == 0) {
                    x = 1;
                    direction = 1;  // 방향 전환
                } else {
                    x -= 1;
                }
            } else if (direction == 1) { // 하
                if (x == n-1) {
                    x = n-2;
                    direction = 0;  // 방향 전환
                } else {
                    x += 1;
                }
            } else if (direction == 2) { // 우
                if (y == m-1) {
                    y = m-2;
                    direction = 3;  // 방향 전환
                } else {
                    y += 1;
                }
            } else if (direction == 3) { // 좌
                if (y == 0) {
                    y = 1;
                    direction = 2;  // 방향 전환
                } else {
                    y -= 1;
                }
            }
        }
        return new Tuple(x, y, direction);  // 계산된 새 위치와 방향 반환
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        fish = new Fish[n][m];
        nfish = new Fish[n][m];
        int mm = sc.nextInt();
        // 격자 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                fish[i][j] = new Fish(0,0,0);
                nfish[i][j] = new Fish(0,0,0);
            }
        }
        // 물고기 정보 입력
        while (mm-- > 0) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            int s = sc.nextInt();
            int d = sc.nextInt() - 1;
            int z = sc.nextInt();
            fish[x][y] = new Fish(z, s, d);
        }
        long ans = 0; // 잡은 물고기 크기 합
        // 모든 열에 대해 실행
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (fish[i][j].size > 0) {
                    ans += fish[i][j].size; // 잡은 물고기의 크기를 ans에 추가
                    fish[i][j].size = 0;  // 물고기를 잡았으므로 크기를 0으로 설정
                    break;  // 한열에 한마리만 잡을 수 있으므로 반복 중단
                }
            }
            // 물고기 이동
            for (int l1 = 0; l1 < n; l1++) {
                for (int l2 = 0; l2 < m; l2++) {
                    if (fish[l1][l2].size == 0) {
                        // 물고기가 없는 칸은 건너뛰기
                        continue;
                    }
                    Fish f = fish[l1][l2];
                    Tuple temp = get_next(l1, l2, f.speed, f.direction); // 물고기의 다음 위치 계산
                    int x = temp.row;
                    int y = temp.col;
                    int direction = temp.direction;
                    // 다음 위치에 있는 물고기와 크기 비교 후, 더 큰 물고기로 업데이트
                    if (nfish[x][y].size == 0 || nfish[x][y].size < f.size) {
                        nfish[x][y] = new Fish(f.size, f.speed, direction);
                    }
                }
            }
            // nfish에서 fish로 상태 업데이트
            for (int l1 = 0; l1 < n; l1++) {
                for (int l2 = 0; l2 < m; l2++) {
                    fish[l1][l2] = new Fish(nfish[l1][l2]);
                    nfish[l1][l2].size = 0; // 다음 이동 초기화
                }
            }
        }
        // 낚시 결과 출력
        System.out.println(ans);
    }
}