public class Solution {
    // 최소 공배수는 두 수의 곱에 최대공약수를 나누면 구할 수 있다.
    public int solution(int[] arr) {
        int lcm = arr[0];

        for (int i = 1; i < arr.length; i++) {
            lcm = getLcm(lcm, arr[i]);
        }

        return lcm;
    }

    private int getGcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    private int getLcm(int a, int b) {
        return a * b / getGcd(a, b);
    }
}
