import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());  // 전체 용액 수
        long[] a = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }

        int left = 0;
        int right = n-1;
        long minTotal = Long.MAX_VALUE;
        int minLeft = -1;
        int minRight = -1;
        while(left < right) {
            // 최소값 갱신 시 업데이트
            if (Math.abs(minTotal) > Math.abs(a[left]+a[right])) {
                minTotal = a[left] + a[right];
                minLeft = left;
                minRight = right;
            }

            if (a[left]+a[right] > 0) {
                // 현재 합이 0보다 크면 + 양을 줄인다.
                right--;
            } else if (a[left]+a[right] == 0) {
                break;
            } else {
                // 현재 합이 0보다 작으면 -양을 줄인다
                left++;
            }
        }
        System.out.println(a[minLeft] + " " + a[minRight]);
    }
}