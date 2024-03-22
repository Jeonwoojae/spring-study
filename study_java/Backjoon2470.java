import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 용액의 개수
        String[] tokens = br.readLine().split(" ");
        long[] a = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = Long.parseLong(tokens[i]);
        }

        Arrays.sort(a); // 용액을 정렬

        int left = 0, right = n - 1;
        long minSum = Long.MAX_VALUE;
        int ansLeft = 0, ansRight = n - 1;

        while (left < right) {
            long sum = a[left] + a[right];

            if (Math.abs(sum) < Math.abs(minSum)) {
                minSum = sum; // 더 작은 합을 찾았다면 업데이트
                ansLeft = left;
                ansRight = right;
            }

            if (sum > 0) {
                right--; // 합이 0보다 크면 오른쪽 포인터를 왼쪽으로
            } else {
                left++; // 합이 0보다 작거나 같으면 왼쪽 포인터를 오른쪽으로
            }
        }

        System.out.println(a[ansLeft] + " " + a[ansRight]);
    }
}