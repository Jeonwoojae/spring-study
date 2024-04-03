import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = new int[3];
        while (true) {
            for (int i = 0; i < a.length; i++) {
                a[i] = sc.nextInt();
            }
            if (a[0] == 0 && a[1] == 0 && a[2] == 0) System.exit(0);

            Arrays.sort(a);
            if (a[0] + a[1] <= a[2]) {
                System.out.println("Invalid");
            } else if (a[0] == a[1] && a[1] == a[2]) {
                System.out.println("Equilateral");
            } else if (a[0] == a[1] || a[1] == a[2]) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}
