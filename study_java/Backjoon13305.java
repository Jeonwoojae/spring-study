import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 도시의 개수
        int[] dis = new int[n];  // 도로의 길이
        int[] val = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n-1; i++) {
            // dis[0] -> index 0에서 1로 가는 거리
            dis[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            val[i] = Integer.parseInt(st.nextToken());
        }

        // 최소한의 비용으로 끝까지 가려면, 가장 작은 가격으로 최대한 많이 가야한다.
        long minVal = val[0];
        long total = minVal * dis[0];
        for (int i=1; i<n-1; i++) {
            if (val[i] < minVal) {
                // 만약 현재 위치의 주유소 가격이 더 싸면 해당 가격으로 주유한 것으로 하고,
                minVal = val[i];
            }
            // 만약 현재 위치의 주유소 가격이 더 비싸면 이전 최소 비용으로 주유한 것으로 한다.
            total += minVal * dis[i];
        }
        System.out.println(total);
    }
}