import java.util.*;
import java.io.*;

public class Main {
    // 중간에 나오는 수는 모두 0~20
    static long[][] d = new long[100][21];
    // d[i][j] : i까지 만들었을 때 j를 만들 수 있는 조합 수
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) - 1;
        String[] line = br.readLine().split(" ");
        int[] a = new int[line.length];
        for (int i=0; i< line.length; i++) {
            a[i] = Integer.parseInt(line[i]);
        }
        int goal = a[n];
        d[0][a[0]] = 1;
        for (int i=1; i<n; i++) {
            for (int j=0; j<=20; j++) {
                // 해당 값을 빼거나
                if (j-a[i] >= 0) {
                    // 음수가 아니라면
                    d[i][j] += d[i-1][j-a[i]];
                }
                // 해당 값을 더했을 때
                if (j+a[i] <= 20) {
                    // 20보다 작다면
                    d[i][j] += d[i-1][j+a[i]];
                }
            }
        }
        System.out.println(d[n-1][goal]);
    }
}

