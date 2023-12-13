class Solution {
    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        int nextNum = n + 1;

        while (true) {
            if (Integer.bitCount(nextNum) == cnt) {
                return nextNum;
            }
            nextNum++;
        }
    }
}