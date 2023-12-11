import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0; i<A.length;i++) {
            // 가장 큰 값과 가장 작은값 곱하기
            answer = answer + A[i]*B[A.length-i-1];
        }

        return answer;
    }
}