import java.util.Arrays;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {

    /*
    정렬 규칙 : HEAD, NUMBER, TAIL로 나누어 정렬.
    HEAD : 파일의 글자. 대소문자 구분없이 사전순 정렬
    NUMBER : HEAD 순서가 같으면 숫자를 비교. 숫자 앞의 0은 무시
    TAIL : HEAD, NUMBER 순서가 같으면 원래 입력에 주어진 순서를 유지
    */
    public static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 숫자가 나오기 전까지 문자열 추출
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];

                // 대소문자 무시
                int result = head1.toLowerCase().compareTo(head2.toLowerCase());

                if (result == 0) {
                    // HEAD로 판별 할 수 없을 경우
                    result = getNumber(o1, head1) - getNumber(o2, head2);
                }

                return result;
            }

            private int getNumber(String file, String head) {
                // file : Head 이후 글자
                file = file.substring(head.length());
                String result = "";
                for (char c : file.toCharArray()) {
                    // 5글자 이하까지만 숫자
                    if (Character.isDigit(c) && result.length() < 5) {
                        result += c;
                    } else {
                        break;
                    }
                }
                // 숫자로 변환
                return Integer.parseInt(result);
            }
        });

        return files;
    }
}