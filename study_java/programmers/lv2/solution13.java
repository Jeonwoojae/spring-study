import java.util.*;

class Solution {
    public static int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            char first = str1.charAt(i);
            char second = str1.charAt(i + 1);

            if (Character.isAlphabetic(first) && Character.isAlphabetic(second)) {
                String key = first + "" + second;
                map1.put(key, map1.getOrDefault(key, 0) + 1);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            char first = str2.charAt(i);
            char second = str2.charAt(i + 1);

            if (Character.isAlphabetic(first) && Character.isAlphabetic(second)) {
                String key = first + "" + second;
                map2.put(key, map2.getOrDefault(key, 0) + 1);
            }
        }

        int inter = 0, union = 0;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                inter += Math.min(map1.get(key), map2.get(key));
                union += Math.max(map1.get(key), map2.get(key));
            } else {
                union += map1.get(key);
            }
        }

        for (String key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                union += map2.get(key);
            }
        }

        if (union == 0) return 65536;
        return (int) ((double) inter / union * 65536);
    }
}