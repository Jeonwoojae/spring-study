import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[12];
        int t = sc.nextInt();
        // f(0) = 1, f(1) = 1, f(2) = 2, f(3) = 4
        // f(4) = 7, f(5) =
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;
        // f(n) = f(n-1) + f(n-2) + f(n-3)
        for(int i = 3;i<=11;i++) {
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        for(int i=0;i<t;i++) {
            int n = sc.nextInt();
            System.out.println(arr[n]);
        }
    }
}
