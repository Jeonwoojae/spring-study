import java.util.*;

public class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people); // 사람들을 무게 순으로 정렬
        int i = 0, j = people.length - 1; // 가장 가벼운 사람과 가장 무거운 사람의 인덱스
        int count = 0; // 필요한 구명보트의 개수

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                // 가장 가벼운 사람과 가장 무거운 사람을 함께 태울 수 있으면 두 사람을 태움
                i++;
                j--;
            } else {
                // 가장 무거운 사람만 태움
                j--;
            }
            count++; // 구명보트 개수 증가
        }

        return count;
    }
}
