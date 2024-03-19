import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();  // 목표 합
        int[] a = new int[n+1];
        int[] dist = new int[k+1];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        dist[0] = 1;
        // 동전 종류만큼 반복
        for (int i=0; i<n; i++) {
            // 목표 합까지 반복
            for (int j=0; j<=k; j++) {
                if (j-a[i] >= 0) {
                    // 뺄 수 있다면 빼서 기존 합에 더한다.
                    dist[j] += dist[j-a[i]];
                }
            }
        }
        System.out.println(dist[k]);
    }
}