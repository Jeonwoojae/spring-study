import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();  // 세로 간격
        int m = sc.nextInt();  // 가로 간격

        // 세로 방향과 가로 방향으로 수용 가능한 인원 계산
        int rows = (h / (n + 1)) + ((h % (n + 1)) > 0 ? 1 : 0);
        int cols = (w / (m + 1)) + ((w % (m + 1)) > 0 ? 1 : 0);

        System.out.println(rows * cols);
    }
}
