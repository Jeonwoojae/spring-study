import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int n = a.length();
        int m = b.length();
        // 1부터 시작하여 직관적으로 위치 일치시키기
        a = " " + a;
        b = " " + b;
        // d[i][j] : a의 i까지와 b의j까지 고려했을 때 LCS의 길이
        int[][] d = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    // 만약 해당 위치의 글자가 같다면 업데이트
                    d[i][j] = d[i-1][j-1] + 1;
                } else {
                    // a의 i번째문자 또는 b의 j번째 문자가 LCS에 포함되지 않는 경우를 고려,
                    // 이전 단계의 최대 LCS 길이 가져오기
                    d[i][j] = Math.max(d[i-1][j], d[i][j-1]);
                }
            }
        }
        System.out.println(d[n][m]);
    }
}

