import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] arr;
    static ArrayList<Integer> list1 = new ArrayList<>();  // 배열 1의 부분배열 합 저장
    static ArrayList<Integer> list2 = new ArrayList<>();  // 배열 2의 부분배열 합 저장

    public static void dfs(int start, int end, int sum, ArrayList<Integer> list) {
        if (start == end) {
            // 해당 위치까지 탐색
            list.add(sum);
            return;
        }
        // 현재 index를 합에 더할 경우
        dfs(start + 1, end, sum + arr[start], list);
        // 현재 index를 합에 더하지 않을 경우
        dfs(start + 1, end, sum, list);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());  // 정수의 갯수
        S = Integer.parseInt(st.nextToken());  // 목표 합

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 각 배열의 부분배열 합 계산
        dfs(0, N/2, 0, list1);
        dfs(N/2, N, 0, list2);

        // 오름차순 정렬
        Collections.sort(list1);
        Collections.sort(list2);

        int left = 0;
        int right = list2.size() - 1;
        long answer = 0;

        // 두 배열을 다 탐색하도록
        while (left < list1.size() && right >= 0) {
            int lv = list1.get(left);
            int rv = list2.get(right);

            if (lv + rv == S) {
                // 두 원소의 합이 목표와 같다면
                long leftCase = 0;
                while (left < list1.size() && list1.get(left) == lv) {
                    // 같은 값을 가진 list1의 원소를 선택할 경우의 수 count
                    left++;
                    leftCase++;
                }
                long rightCase = 0;
                while (right >= 0 && list2.get(right) == rv) {
                    // 같은 값을 가진 list2의 원소를 선택할 경우의 수 count
                    right--;
                    rightCase++;
                }
                // 두 경우의 수를 곱하여 더한다.
                answer += leftCase * rightCase;
            }

            if (lv + rv > S) {
                // 두 원소의 합이 목표보다 크다면
                right--;
            } else if (lv + rv < S) {
                // 두 원소의 합이 목표보다 작으면
                left++;
            }
        }

        // 목표가 0일때, 아무 원소도 선택하지 않는 경우가 포함되므로 경우의 수를 하나 뺀다.
        if (S == 0) answer--;
        System.out.println(answer);
    }
}
