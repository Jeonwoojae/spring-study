class Solution {
    public int solution(int number, int limit, int power) {
        // number:기사 번호, limit: 공격력 제한 수치, power:제한수치 초과한 기사가 사용할 무기 공격력
        // return : 무기를 만들기 위한 모든 철의 무게

        // 각 기사는 자신의 번호 약수 개수의 공격력 무기 구매
        // 단, 제한수치보다 큰 공격력을 구매해야 한다면 power의 무기를 구매
        int answer = 0;

        for(int i=1;i<=number;i++) {
            int count = getCount(i);
            if(count <= limit) {
                answer += count;
            } else {
                answer += power;
            }
        }

        return answer;
    }

    public int getCount(int number) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (number / i == i) {
                    count++;
                } else {
                    count = count + 2;
                }
            }
        }
        return count;
    }
}