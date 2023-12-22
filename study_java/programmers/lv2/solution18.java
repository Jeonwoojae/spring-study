import java.util.*;

class Solution {
    public static int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        int sum = 0;
        int ans = 0;
        List<Integer> list = new ArrayList<>();
        for (Integer x : map.keySet()) {
            list.add(map.get(x));
        }
        list.sort(Collections.reverseOrder());

        for (Integer x : list) {
            ans++;
            sum += x;
            if (sum >= k) {
                break;
            }
        }

        return ans;
    }

}