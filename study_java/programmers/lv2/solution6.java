import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int hit = 1;
        int miss = 5;
        int answer = 0;
        List<String> cache = new ArrayList<>();

        for(String city : cities) {
            city = city.toLowerCase();
            if(cache.remove(city)) {
                // 캐시에 저장되어 있는 경우
                answer = answer + hit;
                cache.add(city);
            } else {
                // 캐시에 없던 경우
                answer = answer + miss;
                if(cache.size()>=cacheSize) {
                    // 가장 오래 안쓴것 지우기
                    if(cache.size() == 0) continue;
                    cache.remove(0);
                }
                cache.add(city);
            }
        }

        return answer;
    }
}