import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

// 농작물 수확하기
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        //System.setIn(new FileInputStream("src/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t=1; t<=T; t++) {
            int n = sc.nextInt();
            int[][] map = new int[n][n];
            for (int i=0; i<n; i++) { // 입력
                String str = sc.next();
                int[] line = new int[n];
                for (int j=0; j<n; j++) {
                    line[j] = str.charAt(j)-'0';
                }
                map[i] = line;
            }

            int ans = 0;
            int start = n/2;
            int end = n/2;
            for (int i=0; i<n; i++) {
                for (int j=start; j<=end; j++) { // 각 행마다
                    ans += map[i][j];
                }
                if (i < n/2) { // 행의 절반 전이면
                    start -= 1; // 시작을 줄여주고
                    end += 1; // 끝을 늘려서 열의 범위를 키움
                } else { // 행의 절반이 지나면
                    start += 1; // 시작을 늘리고
                    end -= 1; // 끝을 줄여서 열의 범위를 좁힘
                }
            }
            System.out.printf("#%d %d\n", t, ans);
        }
    }
}