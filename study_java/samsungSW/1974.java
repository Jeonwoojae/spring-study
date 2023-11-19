import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static int N = 9;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int ans = solve();
            System.out.println("#" + test_case + " " + ans);
        }
    }

    public static int solve() {
        for (int i = 0; i < N; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < N; j++) {
                set.add(arr[i][j]);
            }
            if (set.size() != N) {
                return 0;
            }
        }

        for (int i = 0; i < N; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < N; j++) {
                set.add(arr[j][i]);
            }
            if (set.size() != N) {
                return 0;
            }
        }

        for (int i = 0; i < N; i += 3) {
            for (int j = 0; j < N; j += 3) {
                HashSet<Integer> set = new HashSet<>();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        set.add(arr[i+k][j+l]);
                    }
                }
                if (set.size() != N) {
                    return 0;
                }
            }
        }

        return 1;
    }
}