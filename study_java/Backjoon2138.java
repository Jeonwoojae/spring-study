import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 1번 스위치를 누르지 않은 경우
        char[] before = br.readLine().toCharArray();
        char[] after = br.readLine().toCharArray();

        // 1번 스위치를 누른 경우
        char[] before1 = Arrays.copyOf(before, n);
        before1[0] = before1[0]=='0'? '1': '0';
        before1[1] = before1[1]=='0'? '1':'0';

        int ans = solve(n,before,after);
        int ans1 = solve(n,before1,after);
        if (ans1 != -1) ans1++;

        if (ans == -1) {
            System.out.println(ans1);
        } else if (ans1 == -1) {
            System.out.println(ans);
        } else {
            System.out.println(Math.min(ans, ans1));
        }
    }
    public static int solve(int n, char[]a, char[]b) {
        int cnt = 0;

        for (int i=0; i<n-1;i++) {
            if (a[i] != b[i]) {
                // 해당 위치의 값이 다르면 무조건 버튼을 누른다.
                cnt++;
                a[i] = a[i]=='0'? '1':'0';
                a[i+1] = a[i+1]=='0'? '1':'0';
                if (i != n-2) {
                    // 맨 끝자리가 아니면 세번째 수도 변경해야함.
                    a[i+2] = a[i+2]=='0'? '1':'0';
                }
            }
        }

        return a[n-1] != b[n-1] ? -1 : cnt;
    }
}