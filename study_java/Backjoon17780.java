import java.util.*;

// 말의 정보를 저장하는 클래스: 말 번호와 방향을 저장
class Piece {
    int no;  // 말의 번호
    int dir;  // 말의 이동 방향
    Piece(int no, int dir) {
        this.no = no;
        this.dir = dir;
    }
}

// 위치 정보를 저장하는 클래스: 행과 열 정보를 저장
class Pair {
    int row, col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

public class Main {
    // 방향 벡터: 우, 좌, 상, 하
    static final int[] dx = {0,0,-1,1};
    static final int[] dy = {1,-1,0,0};

    // 주어진 방향의 반대 방향을 반환하는 함수
    static int opposite(int dir) {
        if (dir == 0) return 1;
        if (dir == 1) return 0;
        if (dir == 2) return 3;
        return 2;
    }

    // 말을 이동시키는 함수: (x, y)에서 (nx, ny)로 말을 이동
    static void go(ArrayList<Piece>[][] a, Pair[] where, int x, int y, int nx, int ny) {
        for (Piece p : a[x][y]) {
            a[nx][ny].add(p);  // 이동할 위치에 말 추가
            where[p.no] = new Pair(nx, ny);  // 말의 위치 정보 업데이트
        }
        a[x][y].clear();  // 원래 위치의 말 정보 삭제
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 보드의 크기
        int m = sc.nextInt();  // 말의 개수
        int[][] board = new int[n][n];  // 보드의 상태
        ArrayList<Piece>[][] a = new ArrayList[n][n];  // 각 칸에 있는 말의 정보를 저장하는 2차원 배열

        // 보드와 말 정보 배열 초기화
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = new ArrayList<>();
                board[i][j] = sc.nextInt();
            }
        }

        // 말의 위치 정보를 저장하는 배열
        Pair[] where = new Pair[m];
        // 말 정보 입력 및 초기화
        for (int i=0; i<m; i++) {
            int x = sc.nextInt()-1;
            int y = sc.nextInt()-1;
            int dir = sc.nextInt()-1;
            a[x][y].add(new Piece(i, dir));
            where[i] = new Pair(x, y);
        }

        // 게임 진행
        for (int turn=1; turn<=1000; turn++) {
            for (int k=0; k<m; k++) {
                int x = where[k].row;
                int y = where[k].col;
                // 맨 아래 있는 말만 이동 가능
                if (a[x][y].get(0).no == k) {
                    int dir = a[x][y].get(0).dir;
                    int nx = x+dx[dir];
                    int ny = y+dy[dir];
                    if (0 <= nx && nx < n && 0 <= ny && ny < n) { // in
                        if (board[nx][ny] == 2) {
                            a[x][y].get(0).dir = opposite(dir);
                        }
                    } else {
                        a[x][y].get(0).dir = opposite(dir);
                    }
                    dir = a[x][y].get(0).dir;
                    nx = x+dx[dir];
                    ny = y+dy[dir];
                    if (0 <= nx && nx < n && 0 <= ny && ny < n) { // in
                        if (board[nx][ny] == 0) {
                            go(a, where, x, y, nx, ny);
                        } else if (board[nx][ny] == 1) {
                            Collections.reverse(a[x][y]);
                            go(a, where, x, y, nx, ny);
                        }
                        if (a[nx][ny].size() >= 4) {
                            System.out.println(turn);
                            System.exit(0);
                        }
                    } else { // out
                    }
                }
            }
        }
        System.out.println(-1);
    }
}