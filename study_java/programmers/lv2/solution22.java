import java.util.*;

class Solution {
    public int[] solution(String s) {
        // {}로 구분된 튜플 분리하기
        s = s.substring(2, s.length()-2).replace("},{", "-");
        String[] arr = s.split("-");
        // 튜플 크기가 작은 순서대로 입력해야하므로 정렬
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        // 각 튜플의 요소를 list에 추가
        List<Integer> list = new ArrayList<>();
        for(String s1 : arr) {
            String[] s2 = s1.split(",");
            for(String s3 : s2) {
                int num = Integer.parseInt(s3);
                if(!list.contains(num)) {
                    list.add(num);
                }
            }
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
