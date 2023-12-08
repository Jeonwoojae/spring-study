class Solution {
    public String solution(String s) {
        String answer = "";
        String[] list = s.split(" ");
        for(int i=0;i<list.length;i++) {
            list[i] = list[i].substring(0,1).toUpperCase() + list[i].substring(1).toLowerCase();
            answer += list[i] + " ";
        }
        return answer.trim();
    }
}