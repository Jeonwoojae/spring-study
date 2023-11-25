class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        for (int x = r1 + 1; x < r2; x++) {
            for (int y = 0; y*y <= x*x - r1*r1 && y*y <= r2*r2 - x*x; y++) {
                answer++;
            }
        }
        return answer * 4;
    }
}
