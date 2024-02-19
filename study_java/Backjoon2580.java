import java.util.*;

public class Main {
    // 스도쿠의 크기
    public static final int n = 9;
    // 주어진 위치가 속한 3X3 스도쿠 사각형 번호를 반환하는 함수
    public static int square(int x, int y) {
        return (x/3)*3+(y/3);
    }
    // 스도쿠를 푸는 재귀함수
    public static boolean go(int[][] a, boolean[][][] c, int z) {
        // 모든 칸을 채웠을 때 스도쿠 출력
        if (z == 81) {
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    System.out.print(a[i][j] + " ");
                }
                System.out.println();
            }
            return true;
        }

        // 현재 위치 계산
        int x = z/n;
        int y = z%n;

        // 이미 숫자가 채워져 있으면 다음 칸 확인
        if (a[x][y] != 0) {
            return go(a, c, z+1);
        } else {
            // 1~9 칸까지 탐색
            for (int i=1; i<=9; i++) {
                // 해당 숫자 i가 현재 위치에 놓일 수 있는지 확인
                if (!c[0][x][i] && !c[1][y][i] && !c[2][square(x,y)][i]) {
                    // 숫자를 놓고, 체크 배열 갱신
                    c[0][x][i] = c[1][y][i] = c[2][square(x,y)][i] = true;
                    a[x][y] = i;

                    // 다음 칸 확인하기
                    if (go(a, c, z+1)) {
                        return true;
                    }

                    // 현재 위치에 놓인 숫자를 제거, 체크 배열 되돌리기
                    a[x][y] = 0;
                    c[0][x][i] = c[1][y][i] = c[2][square(x,y)][i] = false;
                }
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[][] a = new int[n][n];
        boolean[][][] c = new boolean[3][n][10];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
                // 이미 채워져 있는 칸은 체크 배열에 표시
                if (a[i][j] != 0) {
                    c[0][i][a[i][j]] = true;
                    c[1][j][a[i][j]] = true;
                    c[2][square(i,j)][a[i][j]] = true;
                }
            }
        }
        go(a, c, 0);
    }
}