import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] d = new int[N];

        for (int i = 0; i < N;i++) {
            arr[i] = sc.nextInt();
            d[i] = arr[i];
            if(i==0) {
                continue;
            }
            d[i] = Math.max(d[i],d[i-1]+arr[i]);
        }

        System.out.println(Arrays.stream(d).max().getAsInt());
    }
}
