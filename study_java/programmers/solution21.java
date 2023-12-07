class Solution {
    public String solution(String s) {
        String[] list = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<list.length;i++) {
            int cur = Integer.parseInt(list[i]);
            if(min > cur) {
                min = cur;
            }
            if(max < cur) {
                max = cur;
            }
        }
        String answer = min+" "+max;
        return answer;
    }
}