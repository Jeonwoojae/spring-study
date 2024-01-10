class Solution {
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