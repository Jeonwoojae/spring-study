class Solution
{
    /*
    N = 참가자 수
    A = 참가자 번호
    B = 경쟁자 번호
    return = A와 B가 서로 몇 번째 라운드에서 만나는지
    */
    public int solution(int n, int a, int b) {
        int round = 0;

        // 두 참가자의 번호가 같아지면 종료
        while (a != b) {
            // 다음 번호 계산
            a = (a + 1) / 2;  // 소수점 방지를 위해 +1하여 계산
            b = (b + 1) / 2;
            round++;
        }

        return round;
    }
}