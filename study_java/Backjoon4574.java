import java.util.*;
public class Main {
    // 스도쿠판, 체크 배열, 도미노 체크 배열을 선언
    static int[][] a = new int[10][10];
    static boolean[][] c = new boolean[10][10];
    static boolean[][] c2 = new boolean[10][10];
    static boolean[][] c3 = new boolean[10][10];
    static boolean[][] domino = new boolean[10][10];

    static int n = 9;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    // 해당 위치가 속한 3X3 크기의 스도쿠 사각형 번호를 반환하는 함수
    static int square(int x, int y) {
        return (x/3)*3+(y/3);
    }

    // 해당 위치에 주어진 숫자를 놓을 수 있는지 확인하는 함수
    static boolean can(int x, int y, int num) {
        return c[x][num] == false && c2[y][num] == false && c3[square(x, y)][num] == false;
    }

    // 체크 빼열의 상태를 변경하는 함수
    static void check(int x, int y, int num, boolean what) {
        c[x][num] = what;
        c2[y][num] = what;
        c3[square(x, y)][num] = what;
    }
    // 스도쿠 판 위를 벗어났는지 체크하는 함수
    static boolean checkRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    // 스도쿠를 푸는 재귀 함수
    static boolean go(int z) {
        // 모든 칸을 채우면 수도쿠 내용 출력
        if (z == 81) {
            for (int i = 0; i <n;i++) {
                for (int j = 0; j <n; j++) {
                    System.out.print(a[i][j]);
                }
                System.out.println();
            }
            return true;
        }

        // 현재 위치를 계산
        int x = z/n;
        int y = z%n;

        if (a[x][y] != 0) {
            // 이미 숫자가 채워져 있으면 다음 칸을 확인
            return go(z+1);
        } else {
            // 오른쪽, 아래에 대해 도미노를 놓을 수 있는지 확인
            for (int k=0; k<2; k++) {
                int nx = x+dx[k];
                int ny = y+dy[k];

                // 새 위치가 스도쿠 판 내에 없거나 이미 숫자가 있으면 다음 방향을 탐색
                if (!checkRange(nx, ny) || a[nx][ny] != 0) {
                    continue;
                }

                // 1~9까지 모든 도미노를 탐색
                for (int i=1; i<=9; i++) {
                    for (int j=1; j<=9; j++) {
                        if (i == j) continue;  // 같은 숫자의 도미노는 무시
                        if (domino[i][j]) continue;  // 이미 사용한 도미노는 무시
                        // 만약 도미노를 놓을 수 있다면
                        if (can(x,y,i) && can (nx,ny,j)) {
                            // 도미노를 놓고, 체크 배열을 갱신
                            check(x,y,i,true);
                            check(nx,ny,j,true);
                            domino[i][j] = domino[j][i] = true;
                            a[x][y] = i;
                            a[nx][ny] = j;

                            // 다음 칸을 확인
                            if (go(z+1)) {
                                return true;
                            }

                            // 현재 위치에 놓인 도미노를 제거하고, 체크 배열을 되돌린다.
                            check(x,y,i,false);
                            check(nx,ny,j,false);
                            domino[i][j] = domino[j][i] = false;
                            a[x][y] = 0;
                            a[nx][ny] = 0;
                        }
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        while (true) {
            // 배열 초기화
            for (int i = 0; i <10; i++) {
                Arrays.fill(c[i], false);
                Arrays.fill(c2[i], false);
                Arrays.fill(c3[i], false);
                Arrays.fill(domino[i], false);
                Arrays.fill(a[i],0);
            }
            // 도미노 갯수 입력받기
            int m = sc.nextInt();
            if (m == 0) break;

            // 각 도미노와 그 위치를 입력받는다.
            for (int i = 0; i < m; i++) {
                int n1 = sc.nextInt();
                String s1 = sc.next();
                int n2 = sc.nextInt();
                String s2 = sc.next();
                int x1 = s1.charAt(0) - 'A';
                int y1 = s1.charAt(1) - '1';
                int x2 = s2.charAt(0) - 'A';
                int y2 = s2.charAt(1) - '1';
                a[x1][y1] = n1;
                a[x2][y2] = n2;
                domino[n1][n2] = domino[n2][n1] = true;
                check(x1,y1,n1,true);
                check(x2,y2,n2,true);
            }

            // 각 숫자의 위치를 입력받는다.
            for (int i=1;i<=9;i++) {
                String s = sc.next();
                int x = s.charAt(0) - 'A';
                int y = s.charAt(1) - '1';
                a[x][y] = i;
                check(x,y,i,true);
            }
            System.out.println("Puzzle " + tc);
            go(0);
            tc += 1;
        }
    }
}