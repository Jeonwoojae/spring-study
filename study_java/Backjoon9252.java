import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int n = a.length();
        int m = b.length();
        // 공백 저장하여 index 편하게 맞추기
        a = " " + a;
        b = " " + b;
        int[][] d = new int[n+1][m+1];
        int[][] v = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                // 현재 위치의 글자가 같으면 두 배열의 이전 단계에서 한글자 추가
                if (a.charAt(i) == b.charAt(j)) {
                    d[i][j] = d[i-1][j-1] + 1;
                    // v의 값이 1이면 해당 위치의 값 결과에 추가
                    v[i][j] = 1;
                } else {
                    // 같지 않으면 각 배열의 이전 단계에서 가장 큰 값으로 저장
                    if (d[i-1][j] < d[i][j-1]) {
                        d[i][j] = d[i][j-1];
                        // v의 값이 2이면 j위치 인덱스 감소
                        v[i][j] = 2;
                    } else {
                        d[i][j] = d[i-1][j];
                        // v의 값이 3이면 i위치 인덱스 감소
                        v[i][j] = 3;
                    }
                }
            }
        }
        System.out.println(d[n][m]);
        String ans = "";
        while (n > 0 && m > 0) {
            if (v[n][m] == 1) {
                ans += a.charAt(n);
                n--; m--;
            } else if (v[n][m] == 2) {
                m--;
            } else {
                n--;
            }
        }
        // 결과를 역순으로 출력해야 원래의 순서
        System.out.println(new StringBuilder(ans).reverse().toString());
    }
}

