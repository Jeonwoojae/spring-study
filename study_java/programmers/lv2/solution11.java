import java.util.Stack;

class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();

        // 글자 전체 탐색
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                // 앞과 글자가 같다면 앞의 글자를 삭제
                stack.pop();
            } else {
                // 앞과 글자가 다르다면 or 앞에 글자가 없었다면 글자 넣기
                stack.push(c);
            }
        }

        // 하나라도 남아있다면 모두 지우지 못한 것
        return stack.isEmpty() ? 1 : 0;
    }
}