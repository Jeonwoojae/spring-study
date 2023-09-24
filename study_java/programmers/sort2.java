import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // int[]를 Integer[]로 변환
        Integer[] numberObjects = Arrays.stream(numbers)
                .boxed()
                .toArray(Integer[]::new);

        // 생각한 규칙 : 일의 자리부터 비교해서 작은 것부터 뒤에 두기
        Arrays.sort(numberObjects, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString();
                String s2 = o2.toString();
                return -(s1 + s2).compareTo(s2 + s1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int number : numberObjects) {
            sb.append(number);
        }

        // 모든 숫자가 0인 경우 "0" 반환
        if (numberObjects[0] == 0) return "0";


        return sb.toString();
    }
}