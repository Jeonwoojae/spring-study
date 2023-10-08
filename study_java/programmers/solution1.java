import java.util.*;
import java.text.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        List<Integer> result = new ArrayList<>();

        DateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        Date now = format.parse(today);

        // 약관 데이터 저장
        HashMap<String, String> length = new HashMap<>();
        for (String o : terms) {
            String[] strArr = o.split(" ");
            length.put(strArr[0], strArr[1]);
        }

        // 유효기간 만료 확인
        for (int i = 0; i < privacies.length; i++) {
            String[] strArr = privacies[i].split(" ");
            String type = strArr[1];

            Calendar calToday = Calendar.getInstance();
            calToday.setTime(now);

            Calendar calInfoDate = Calendar.getInstance();
            calInfoDate.setTime(format.parse(strArr[0]));

            // 유효기간 추가
            calInfoDate.add(Calendar.MONTH, Integer.valueOf(length.get(type)));
            // System.out.println(Integer.valueOf(length.get(type)));

            // 현재 날짜와 비교
            if (calInfoDate.getTime().compareTo(calToday.getTime()) <= 0) {
                result.add(i + 1);
            }

        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}