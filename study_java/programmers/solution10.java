class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            char nextChar = c;
            for (int i = 0; i < index; i++) {
                nextChar++;
                if (nextChar > 'z') { // 'z'를 넘어가면 'a'로 돌아감
                    nextChar = 'a';
                }
                if (skip.contains(String.valueOf(nextChar))) { // skip에 포함된 문자면 다시 증가
                    i--;
                }
            }
            sb.append(nextChar);
        }
        return sb.toString();
    }
}
