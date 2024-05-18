import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
    static int[] arr;
    static int count;
    static int N;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            count = 0;
            N = sc.nextInt();
            // 2차원 배열을 하지 않는 이유는 계산을 빠르게 하기 위함
            arr = new int[N];
            nQueue(0);

            System.out.println("#" + test_case + " " + count);

        }
    }
    static void nQueue(int depth) {
        if(N == depth) {
            // 갯수를 모두 배치했으면 count 증가
            count++;
            return;
        }

        // 현재 행에 퀸을 놓을 수 있는 모든 열에 대해 탐색
        for (int i = 0; i < N; i++) {
            arr[depth] = i;  // 현재 행의 퀸을 i번째 열에 놓음
            if(check(depth)) {
                // 현재 퀸의 위치가 이전 퀸들과 충돌하지 않는지 검사
                nQueue(depth + 1);  // 충돌하지 않으면 다음 행으로 이동하여 재귀호출
            }
        }
    }
    // 퀸의 위치가 유효한지 검사하는 함수
    static boolean check(int depth) {
        // 현재 퀸과 이전 퀸들을 비교하여 충돌 여부 검사
        for (int i = 0; i < depth; i++) {
            // 같은 열에 있는지 확인
            if(arr[depth] == arr[i])
                return false;
                // 대각선 상에 있는지 확인
            else if(Math.abs(depth - i) == Math.abs(arr[depth] - arr[i]))
                return false;
        }
        return true;  // 유효한 퀸의 위치면 true 반환
    }
}