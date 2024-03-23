import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();  // 목표 합
        int[] a = new int[n];
        for (int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }
        int[] d= new int[k+1];
        for (int i=0; i<=k; i++) {

            d[i] = -1;
        }
        d[0] = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<=k; j++) {
                if (j-a[i] >= 0 && d[j-a[i]] != -1) {
                    // 뺄 수 있고, 해당 방법이 계산되지 않았어야 함
                    if (d[j] == -1 || d[j] > d[j-a[i]]] + 1) {
                        // 합을 계산할 위치가 아직 계산되지 않았거나 더 작은 방벙을 찾았다면 업데이트
                        d[j] = d[j-a[i]] + 1;
                    }
                }
            }
        }
        System.out.println(d[k]);
    }
}