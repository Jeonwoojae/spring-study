import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 블로그를 시작하고 지난 일수 N
        int X = Integer.parseInt(st.nextToken()); // 관심 있는 기간 X

        int[] visitors = new int[N];
        st = new StringTokenizer(br.readLine());

        // 하루 방문자 수 입력
        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
        }

        // 슬라이딩 윈도우로 X일 동안 방문자 수 최대값 찾기
        int sum = 0;
        for (int i = 0; i < X; i++) {
            sum += visitors[i];
        }

        int maxVisitors = sum;
        int count = 1;

        for (int i = X; i < N; i++) {
            // 앞의 값은 빼고, 뒤의 값을 더하여 윈도우를 이동
            sum += visitors[i] - visitors[i - X];

            if (sum > maxVisitors) {
                maxVisitors = sum;
                count = 1; // 최대 방문자 수 갱신하면 기간 카운트 초기화
            } else if (sum == maxVisitors) {
                count++; // 같은 최대 방문자 수의 기간 카운트 증가
            }
        }

        if (maxVisitors == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(maxVisitors);
            System.out.println(count);
        }
    }
}
