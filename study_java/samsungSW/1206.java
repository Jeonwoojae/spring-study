import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

class Solution {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // 가로 길이
            int[] building = new int[N];
            for (int i = 0; i < N; i++) {
                building[i] = sc.nextInt();
            }

            int cnt = 0;
            for (int i = 2; i < N - 2; i++) {
                int max = Math.max(building[i - 2], Math.max(building[i - 1], Math.max(building[i + 1], building[i + 2])));
                if (building[i] - max > 0)
                    cnt += building[i] - max;
            }

            System.out.println("#" + tc + " " + cnt);
        } // end of TC
    }
}