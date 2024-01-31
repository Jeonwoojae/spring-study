import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[1001];

        // 1<=N<=1000
        // f(1) = 1, f(2) = 2, f(3) = 3
        arr[0] = 1;
        arr[1] = 1;
        // f(n) = f(n-1) + f(n-2)
        for(int i = 2;i<=n;i++) {
            arr[i] = arr[i-1] + arr[i-2];
            arr[i] = arr[i] % 10007;
        }
        System.out.println(arr[n]);
    }
}
