import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static List<String> ans;
    static String op[] ={"+","-"," "};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-->0) {
            N = Integer.parseInt(br.readLine());
            ans = new ArrayList<>();
            dfs(1,"1");
            Collections.sort(ans);
            for (String s : ans) {
                System.out.println(s);
            }
            // 결과가 0이 되는 수식들을 출력한다.
            System.out.println();
        }
    }

    static void dfs(int num, String s) {
        if (num == N) {
            // 모든 숫자를 추가했다면 종료
            String express = s.replaceAll(" ","");  // 빈칸을 없애 숫자 붙이기
            if(cal(express)) ans.add(s);  // 합이 0이 되면 답에 추가
            return;
        }

        // 3가지 부호 추가
        for (int i=0;i<3;i++) {
            dfs(num+1, s+op[i]+Integer.toString(num+1));
        }
    }

    static boolean cal(String express) {
        // -나 +로 토큰 구분
        StringTokenizer st = new StringTokenizer(express, "-|+", true);
        int sum = Integer.parseInt(st.nextToken());
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            // s:부호. nextToken():다음 숫자
            if (s.equals("+")) {
                sum += Integer.parseInt(st.nextToken());
            } else {
                sum -= Integer.parseInt(st.nextToken());
            }
        }

        if (sum == 0) {
            return true;
        } else {
            return false;
        }
    }
}
