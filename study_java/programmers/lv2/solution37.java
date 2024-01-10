class Solution {

    /*
        짝수, 홀수에 따라 찾는 방법이 다르다.
        - 짝수의 경우
        2를 이진수로 변경하면 10. 가장 낮은 자리의 0을 1로 변경하면 문제의 조건을 만족한다.
        이것을 10진수로 변경하면 3.ㄴ
        - 홀수의 경우
        7을 이진수로 변경하면 0111. 가장 낮은 자리의 0을 1로 변경하고 그 다음 자리의 1을 0으로 변경하면 조건을 만족한다.
        이것을 10진수로 변경하면 11
    */

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                // 짝수인 경우, 가장 낮은 자리의 0을 1로 변경
                // 1을 더하면 변경되는 이유는 짝수면 나누어 떨어져 마지막 자리가 무조건 0이 되기 때문.
                answer[i] = numbers[i] + 1;
            } else {
                // 홀수인 경우, 가장 낮은 자리의 0을 1로 바꾸고 그 다음 자리의 1을 0으로 변경.
                long bit = 0; // 가장 낮은 자리의 0의 위치
                while (((numbers[i] >> bit) & 1) == 1) {
                    // 1과 AND 연산을 통해 bit를 우측 시프트 연산했을 때 0인 위치를 찾기.
                    bit++;
                }

                // 가장 낮은 자리의 0을 1로 바꾸고 그 다음 자리의 1을 0으로 변경.
                // 0인 위치를 찾고 그 전 비트에 1을 더하면 한번에 두 비트 값을 변경 가능.
                answer[i] = numbers[i] + (1L << (bit - 1));
            }
        }

        return answer;
    }

    /*
    * ******************************** 아래는 완전 탐색으로 풀어 시간초과
    * */
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int index = 0;
        for(long val : numbers) {
            // val 값을 2비트로 변환, 숫자별로 쪼개기
            char[] valArr = Long.toBinaryString(val).toCharArray();
            // val에 1을 더한 값을 2비트로 변환, 숫자별로 쪼개기
            long nextVal = val+1;
            char[] nextValArr = Long.toBinaryString(nextVal).toCharArray();
            // 쪼갠 두 값의 비트가 다른 지점이 2개 이하일 때 까지 새로운 값을 찾는 동작 반복
            while(compare(valArr, nextValArr)){
                nextVal++;
                nextValArr = Long.toBinaryString(nextVal).toCharArray();
            }
            // 찾으면 바로 answer에 저장
            answer[index] = nextVal;
            index++;
        }
        return answer;
    }

    // 다른 지점이 2개 이하면 false, 3개부터는 true
    static public boolean compare(char[] origin, char[] compare) {
        int diff = 0;
        if(origin.length != compare.length) {
            // compare를 한칸 넘기고 계산
            diff++;
            for(int i=0;i<origin.length;i++) {
                if(origin[i] != compare[i+1]){
                    diff++;
                }
                if(diff>2) return true;
            }
        } else {
            for(int i=0;i<origin.length;i++) {
                if(origin[i] != compare[i]){
                    diff++;
                }
                if(diff>2) return true;
            }
        }
        return false;
    }
}