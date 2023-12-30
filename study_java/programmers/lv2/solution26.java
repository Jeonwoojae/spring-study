class Solution {
    /*
    n = 진법
    t = 말해야 하는 최종 숫자
    m = 참가 인원
    p = 나의 순서
    return = 내가 말해야 하는 순서
    */
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String converted = "";
        int number = 0;

        // 대답할 N진수들 모두 변환
        while (converted.length() < m * t) {
            converted += convertNumber(n, number++);
        }

        // 내가 말할 부분 찾기
        for(int i=0; i<t; i++){
            answer += converted.charAt((p-1) + i*m);
        }
        return answer;
    }

    private String convertNumber(int n, int number) {
        StringBuilder sb = new StringBuilder();
        if(number == 0) return "0";
        while (number > 0) {
            int val = number % n;
            if(val >= 10) {
                sb.insert(0, (char)('A'+(val-10)));
            } else {
                sb.insert(0, val);
            }
            number /= n;
        }
        return sb.toString();
    }
}