class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] words = s.toLowerCase().split("");

        boolean flag = true;

        for(String word : words) {
            answer.append(flag ? word.toUpperCase() : word);
            flag = word.equals(" ") ? true : false;
        }

        return answer.toString();
    }
}
