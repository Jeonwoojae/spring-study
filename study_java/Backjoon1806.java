import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 주어진 수열의 길이
        int s = sc.nextInt();  // 수열의 합이 s보다 커야함
        int[] a = new int[n+1];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        int i = 0;
        int j = 0;
        int total = a[0];  // 수열의 합
        int ans = n+1;  // 최소 길이
        // 포인터가 수열의 범위 내에 있는 동안 반복
        while (i <= j && j < n) {
            if (total < s) {
                // 목표보다 합이 작다면
                // 오른쪽으로 포인터 한칸 이동
                j += 1;
                total += a[j];
            } else if (total == s) {
                // 목표와 합이 같다면
                ans = Math.min(j-i+1,ans);  // 최소 길이 업데이트
                // 오른쪽으로 포인터 한칸 이동
                j += 1;
                total += a[j];
            } else if (total > s) {
                // 목표보다 합이 크다면
                ans = Math.min(j-i+1,ans);  // 최소 길이 업데이트
                // 왼쪽의 포인터 오른쪽으로 한칸 이동
                total -= a[i];
                i++;
            }
        }
        // 최소 길이가 수열의 길이보다 크면
        if (ans > n) {
            // 0으로 초기화
            ans = 0;
        }
        System.out.println(ans);
    }
}