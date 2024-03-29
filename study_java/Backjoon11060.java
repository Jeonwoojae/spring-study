import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            d[i] = -1; // 방문하지 않은 위치를 -1로 초기화
        }

        // 시작점에서 점프는 0
        d[0] = 0;

        // 각 위치에 대해 최소 점프 횟수를 계산
        for (int i=1; i<n; i++) {
            // 현재 위치에 도달할 수 있는 모든 이전 위치를 확인
            for (int j=0; j<i; j++) {
                // j에서 i로 점프할 수 있는지
                // j위치에 도달할 수 있는지 확인
                if (d[j] != -1 && i-j <= a[j]) {
                    // 현재 위치(i)로의 점프가 이전 최소 횟수보다 적은 경우
                    // 또는 아직 점프 방법이 발견되지 않은 경우 최소값으로 업데이트
                    if (d[i] == -1 || d[i] > d[j] + 1) {
                        // i를 아직 방문하지 않았거나,
                        d[i] = d[j] + 1;
                    }
                }
            }
        }
        System.out.println(d[n-1]);
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] d = new int[d];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
            d[i] = -1;
        }
        d[0] = 0;
        for (int i=0; i<n; i++) {
            if (d[i] == -1) continue;  // 현재 위치가 방문할 수 없는 위치면 pass
            for (int j=1; j<=a[i]; j++) {
                // 현재 위치에서 이동할 수 있는 모든 위치에 대해 업데이트
                if (i+j >= n) {
                    // 범위를 넘어선다면 멈춘다.
                    break;
                }
                if (d[i+j] == -1 || d[i+j] > d[i]+1) {
                    // 해당 위치를 방문한 적이 없거나 더 짧은 방법을 찾았다면 업데이트
                    d[i+j] = d[i] + 1;
                }
            }
        }
        System.out.println(d[n-1]);
    }
}