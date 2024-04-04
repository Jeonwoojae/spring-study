import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val = n % 4;
        if (val == 0 || val == 2) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }
}
