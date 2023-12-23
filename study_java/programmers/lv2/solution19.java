import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;

        for(int i=0;i<s.length();i++) {
            s = s.substring(1) + s.charAt(0); // 문자열 왼쪽으로 회전
            if (isValid(s)) answer++; // 올바른 괄호 문자열인지 확인
        }

        return answer;
    }

    // 괄호 문자열의 유효성 검사
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false; // 스택이 비어있는데 닫는 괄호가 나오면 유효하지 않음
                if (c == ')' && stack.peek() != '(') return false;
                if (c == ']' && stack.peek() != '[') return false;
                if (c == '}' && stack.peek() != '{') return false;
                stack.pop(); // 유효한 괄호 쌍이므로 스택에서 제거
            }
        }
        return stack.isEmpty(); // 모든 괄호가 유효하다면 스택이 비어있어야 함
    }
}