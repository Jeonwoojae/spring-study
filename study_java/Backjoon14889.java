import java.util.*;
public class Main {
    static boolean nextPermutation(int[] a) {
        int i = a.length-1;
        while (i>0 && a[i-1]>=a[i]) {
            i -= 1;
        }

        // 모든 순열을 탐색했으면 종료
        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
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

        // 사람들 index를 저장할 배열
        int[] b = new int[n];
        // 첫 시작은 0,1이 저장된 두 팀으로 나눈다.
        for (int i = 0; i < n/2; i++) {
            b[i] = 1;
        }
        Arrays.sort(b);
        int ans = Integer.MAX_VALUE;
        do {
            // 팀별로 나뉜 사람의 index 저장
            ArrayList<Integer> first = new ArrayList<Integer>();
            ArrayList<Integer> second = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (b[i] == 0) {
                    first.add(i);
                } else {
                    second.add(i);
                }
            }
            // 두 팀의 점수 계산
            int one = 0;
            int two = 0;
            for (int i=0; i<n/2;i++) {
                for (int j=0; j<n/2; j++) {
                    if (i==j) continue;
                    one += a[first.get(i)][first.get(j)];
                    two += a[second.get(i)][second.get(j)];
                }
            }

            // 점수 차이를 계산하고 최솟값으로 업데이트
            int diff = one - two;
            if (diff < 0) diff = -diff;
            if (ans > diff) ans = diff;
        } while(nextPermutation(b)); // 가능한 모든 순열에 대해 탐색
        System.out.println(ans);
    }
}