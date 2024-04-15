import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] lamps = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            lamps[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0, high = n;
        while (low < high) {
            int mid = (low + high) / 2;
            if (canIlluminateAll(lamps, mid, n)) {
                high = mid;  // Try a smaller height
            } else {
                low = mid + 1;  // Increase the height
            }
        }
        System.out.println(low);
    }

    // Function to check if a given height H can illuminate the entire range [0, N]
    static boolean canIlluminateAll(int[] lamps, int H, int N) {
        // Check if the start of the tunnel is covered
        if (lamps[0] - H > 0) return false;

        // Check coverage between consecutive lamps
        for (int i = 1; i < lamps.length; i++) {
            if (lamps[i - 1] + H < lamps[i] - H) return false;
        }

        // Check if the end of the tunnel is covered
        if (lamps[lamps.length - 1] + H < N) return false;

        return true;
    }
}
