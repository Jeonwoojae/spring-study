class Solution {
    public int solution(String s) {
        int answer = 0;
        int pointer = 0;
        while (pointer < s.length()) {
            char target = s.charAt(pointer);
            int targetCount = 0;
            int nonTargetCount = 0;
            while (pointer < s.length()) {
                if (s.charAt(pointer) == target) {
                    targetCount++;
                } else {
                    nonTargetCount++;
                }
                pointer++;
                if (targetCount == nonTargetCount) {
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}