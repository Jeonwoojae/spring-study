import java.util.*;

public class Main {
    public static int remove(ArrayList<Integer> a) {
        int n = a.size();
        if (n == 2) return 0;
        int ans = 0;
        // 1. 첫번째와 마지막을 제외한 구슬 중 하나(x) 선택
        for (int i = 1; i < n - 1; i++) {
            // 3. x-1 * x+1의 에너지를 모을 수 있다.
            int energy = a.get(i - 1) * a.get(i + 1);
            ArrayList<Integer> b = new ArrayList<Integer>(a);
            // 2. x번째 에너지 구슬을 제거
            b.remove(i);
            // 4. n을 감소시키고 1번부터 n번까지로 다시 매긴다.
            energy += remove(b);
            // 에너지의 최댓값을 업데이트
            if (ans < energy) {
                ans = energy;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();// 각 위치 구슬의 무게
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }

        // 모을 수 있는 에너지의 최댓값을 구해라
        System.out.println(remove(a));
    }
}