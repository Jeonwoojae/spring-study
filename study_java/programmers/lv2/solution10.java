class Solution {

    /*
    * 1. 기본 재귀 방법으로 구하기
    * 구현이 간편하지만, 수가 커지만 시간이 오래 걸려 케이스를 통과하지 못한다.
    * */
    public int solution(int num) {
        if(num == 0) return 0;
        else if(num == 1) return 1;
        long answer = 0;
        answer = solution(num-1) + solution(num-2);

        return (int) answer % 1234567;
    }
}