import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[n+1];

        // d[1] = 1;
        // 1의 조합으로 구성하고, 제곱수로 표현이 되면 해당 방법으로 교체할 수 있다.
        for (int i=1; i<=n; i++) {
            d[i] = i;
            for (int j=1; j*j <= i; j++) {
                d[i] = Math.min(d[i], d[i-j*j]+1);
            }
        }
        System.out.println(d[n]);
    }
}