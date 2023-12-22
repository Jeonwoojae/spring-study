class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int sum = sequence[0];

        int[] result = new int[2];
        int minLength = Integer.MAX_VALUE;

        while (end < sequence.length) {
            if (sum < k) {
                end++;
                if (end < sequence.length) {
                    sum += sequence[end];
                }
            } else if (sum > k) {
                sum -= sequence[start];
                start++;
            } else {
                int length = end - start + 1;
                if (length < minLength) {
                    minLength = length;
                    result[0] = start;
                    result[1] = end;
                }
                sum -= sequence[start];
                start++;
            }
        }

        return result;
    }
}