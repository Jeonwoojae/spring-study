import java.util.*;
import java.io.*;

public class Main {
    static int[][][] d = new int[61][61][61];
    static int go(int i, int j, int k) {
        if (i < 0) return go(0,j,k);
        if (j < 0) return go(i,0,k);
        if (k < 0) return go(i,j,0);
        if (i==0 && j==0 && k==0) return 0;
        if (d[i][j][k] != -1) return d[i][j][k];
        int ans = Integer.MAX_VALUE;
        if (ans > go(i-1, j-3, k-9)) {
            ans = go(i-1, j-3, k-9);
        }
        if (ans > go(i-1, j-9, k-3)) {
            ans = go(i-1, j-9, k-3);
        }
        if (ans > go(i-3, j-1, k-9)) {
            ans = go(i-3, j-1, k-9);
        }
        if (ans > go(i-3, j-9, k-1)) {
            ans = go(i-3, j-9, k-1);
        }
        if (ans > go(i-9, j-1, k-3)) {
            ans = go(i-9, j-1, k-3);
        }
        if (ans > go(i-9, j-3, k-1)) {
            ans = go(i-9, j-3, k-1);
        }
        ans += 1;
        d[i][j][k] = ans;
        return d[i][j][k];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[3];  // 남은 체력
        String[] line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }
        for (int i=0; i<=60; i++) {
            for (int j=0; j<=60; j++) {
                for (int k=0; k<=60; k++) {
                    d[i][j][k] = -1;
                }
            }
        }
        System.out.println(go(a[0], a[1], a[2]));
    }
}
