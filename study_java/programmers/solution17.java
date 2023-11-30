class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int windowSize = p.length();
        Long pValue = Long.parseLong(p);
        for(int i=0;i<t.length()-windowSize+1;i++) {
            Long tValue = Long.parseLong(t.substring(i,i+windowSize));
            if(tValue <= pValue) answer++;
        }
        return answer;
    }
}