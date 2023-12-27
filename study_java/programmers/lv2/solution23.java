import java.util.*;

public class Solution {
    public int solution(int n, int k) {
        String number = convert(n, k);

        int answer = 0;
        // P는 0을 포함하지 않기 때문에 0으로 숫자를 구분한다.
        StringTokenizer st = new StringTokenizer(number, "0");
        while (st.hasMoreTokens()) {
            long num = Long.parseLong(st.nextToken());
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    // k진수로 변환
    private String convert(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, n % k);
            n /= k;
        }
        return sb.toString();
    }

    // 소수인지 검증
    private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        // 2부터 제곱근까지 나눴을 때 나눠지지 않아야 소수
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
