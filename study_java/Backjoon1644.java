import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] c = new boolean[n+1];
        List<Integer> p = new ArrayList<>();
        // n 이하의 모든 소수를 찾는다.
        for (int i=2; i<=n; i++) {
            if (!c[i]) {
                p.add(i);
                for (int j=i*2; j<=n; j+=i) {
                    c[j] = true;
                }
            }
        }
        int l = 0;  // 왼쪽 포인터
        int r = 0;  // 오른쪽 포인터
        int sum = p.size() == 0 ? 0 : p.get(0);
        int ans = 0;

        while (l <= r && r < p.size()) {
            if (sum <= n) {
                if (sum == n) {
                    // 합이 목표와 같으면 ans++
                    ans += 1;
                }
                r++;  // 우측 포인터 우측으로 한칸 이동
                if (r < p.size()) {
                    // 끝까지 탐색하지 않았으면 합계에 추가
                    sum += p.get(r);
                }
            } else {
                // 합이 목표보다 크면 왼쪽 포인터를 우측으로 한칸 이동하며 합 갱신
                sum -= p.get(l++);
            }
        }
        System.out.println(ans);
    }
}