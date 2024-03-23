import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 주어진 수열 갯수
        int m = sc.nextInt();  // 목표 값
        int[] a = new int[n+1];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        int left = 0;
        int right = 0;
        int sum = a[0];
        int ans = 0;
        // 왼쪽 포인터와 오른쪽 포인터가 끝까지 탐색하도록 반복
        while (left <= right && right < n) {
            if (sum < m) {
                // 만약 목표값보다 작으면 우측 포인터를 한칸 이동
                right += 1;
                sum += a[right];
            } else if (sum == m) {
                // 만약 목표 값과 같으면 경우의 수를 증가, 우측 포인터를 한칸 이동
                ans += 1;
                right +=1;
                sum += a[right];
            } else if (sum > m) {
                // 만약 목표 값보다 크면 좌측 포인터를 한칸 우측으로 이동
                sum -= a[left];
                left++;
                if (left > right && left < n) {
                    // 만약 좌측 포인터가 우측 포인터를 넘어간다면 우측 포인터를 좌측 포인터 위치로 갱신
                    right = left;
                    sum = a[left];
                }
            }
        }
        System.out.println(ans);
    }
}