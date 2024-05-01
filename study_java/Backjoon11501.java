import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-->0) {
            int d = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[]a = new int[d];
            for (int i=0; i<d; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int max = a[d-1];
            long mount = 0;
            for (int i=d-2; i>=0; i--) {
                if (max < a[i]) {
                    // 이전 최대값 보다 크다면, 해당 날짜에 팔아야한다.
                    max = a[i];
                } else {
                    // 이전 최대값 보다 작다면, 해당 날짜에 구매한다.
                    mount += (long)max-a[i];
                }
            }
            bw.write(Long.toString(mount));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
