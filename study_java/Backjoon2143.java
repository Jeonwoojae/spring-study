import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();

        // a에 모든 부분집합의 합을 계산하여 first에 저장
        for (int i=0;i<n;i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                first.add(sum);
            }
        }
        // b에 모든 부분집합의 합을 계산하여 second에 저장
        for (int i=0;i<m;i++) {
            int sum = 0;
            for (int j = i; j < m; j++) {
                sum += b[j];
                second.add(sum);
            }
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        // second에 있는 각 합에 대해 그 합을 key로, 횟수를 value로 하는 map 생성
        for (int x: second) {
            if (map.containsKey(x)) {
                int temp = map.get(x);
                map.put(x, temp+1);
            } else {
                map.put(x, 1);
            }
        }

        // 각 합 num에 대해 key가 t-num인게 있다면 그 횟수를 ans에 더한다.
        long ans = 0;
        for (int num:first) {
            if (map.containsKey(t-num)) {
                ans += map.get(t-num);
            }
        }
        // first에서의 합과 second에서의 합이 t가 되는 경우의 수 출력
        System.out.println(ans);
    }
}