import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // d[i] : 크리보드 버튼을 i번 눌러 화면에 출력된 A개수 최대값
        long[] d = new long[n+1];

        for (int i=1; i<=n; i++) {
            // 바로 A를 누른다면 직전에서 횟수+1
            d[i] = d[i-1] + 1;
            for (int j=1; j<=i-3; j++) {  //
                // d[i-j-2] : 복사한 시점의 A문자 갯수
                // j+1 : 복사&붙여넣기를 할 수 있는 횟수
                long cur = d[i-j-2]*(j+1);
                if (cur > d[i]) {
                    d[i] = cur;
                }
            }
        }
        System.out.println(d[n]);
    }
}