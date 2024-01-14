import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] cards = new int[N+1];
        for(int i = 1; i <= N; i++) {
            cards[i] = sc.nextInt();
        }
        int[] d = new int[N+1];
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=i; j++) {
                // 카드 i개를 구매하는 방법 = 카드 j개가 들어있는 카드팩을 구매하고
                // 카드 i-j를 구매
                if (d[i] < d[i-j] + cards[j]) {
                    d[i] = d[i-j] + cards[j];
                }
            }
        }
        System.out.println(d[N]);
    }
}