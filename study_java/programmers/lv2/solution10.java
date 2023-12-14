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

    /*
    * 2. 모듈러 연산 사용하기
    * (A+B) mod n = ((a mod n) + (b mod n)) mod n
    * 해당 방법을 사용하면 오버플로우를 걱정하지 않고 직접 더하여 구할 수 있다.
    * */
    public static int solution(int n) {
        int a = 0;
        int b = 1;

        for (int i = 0; i < n; i++) {
            int temp = (a + b) % 1234567;
            a = b % 1234567;
            b = temp % 1234567;
        }

        return a;
    }
}