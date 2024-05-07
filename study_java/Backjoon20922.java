import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int left = 0;
        int right = 0;
        int cur = 0;
        int[] cnt = new int[100001];
        while (right < n) {
            // 현재 윈도우에서 중복되는 원소의 개수가 k를 초과하지 않는 경우
            if (cnt[a[right]] < k) {
                cnt[a[right]]++;
                right++;
            } else { // 중복되는 원소의 개수가 k를 초과하는 경우
                cnt[a[cur]]--;
                cur++;
            }

            ans = Math.max(ans, right - cur); // 현재 최대 길이 갱신
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
