import java.util.*;

public class Main {
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};
    public static int[][] array;  // 입력받은 정보
    public static int[][] group;  // 단지를 나누는 정보

    /*
    * dfs를 수행하는 함수.
    * i,j : 좌표 위치
    * cnt : 단지 번호
    * n : 최대 위치 범위
    * */

    public static void dfs(int i, int j, int cnt, int n) {
        group[i][j] = cnt;
        for(int k = 0; k <4;k++) {
            int nx = i+dx[k];
            int ny = j+dy[k];
            if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if(array[nx][ny] == 1 && group[nx][ny] == 0) {
                    dfs(nx, ny, cnt, n);
                }
            }
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        array = new int[N][N];
        for(int i=0; i<N; i++) {
            String s = sc.nextLine();
            for(int j=0; j<N; j++) {
                array[i][j] = s.charAt(j) - '0';
            }
        }

        int cnt = 0;
        group = new int[N][N]; // 단지를 구분하기 위한 배열
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(array[i][j] == 1 && group[i][j] == 0) {
                    // 아직 구분되지 않은 집들에 대해
                    dfs(i,j,++cnt,N);
                }
            }
        }

        int[] ans = new int[cnt];  // 단지 갯수만큼 배열 생성.
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(group[i][j] != 0) {
                    // 단지별 갯수 count
                    ans[group[i][j]-1]+=1;
                }
            }
        }
        Arrays.sort(ans);
        System.out.println(cnt);
        for(int i=0;i<cnt;i++) {
            System.out.println(ans[i]);
        }
    }
}
