class Solution {
    public int[] solution(String s) {
        int count=0;
        int remove=0;
        while(!s.equals("1")){
            // 변환 횟수 +1
            count++;
            // 0 지우기
            String convert = s.replaceAll("0","");
            // 0 제거한 갯수만큼 +
            remove = remove + s.length() - convert.length();
            // 제거 후 길이를 이진으로 변환
            s = Integer.toBinaryString(convert.length());
        }
        int[] answer = {count, remove};
        return answer;
    }
}