import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 식탁의 길이
        int k = Integer.parseInt(st.nextToken());  // 선택할 수 있는 거리
        char[] line = br.readLine().toCharArray();

        boolean[] burgers = new boolean[n];
        boolean[] humans = new boolean[n];
        int count = 0;  // 먹은 사람 수

        for (int i=0; i<n; i++) {
            if (line[i] == 'H') {
                humans[i] = true;
            }else {
                burgers[i] = true;
            }
        }

        // 최대한 많이 먹기 위해서는 가장 좌측의 햄버거부터 먹는다.
        for (int i=0; i<n; i++) {
            if (humans[i]) {
                // 먹을 수 있는 범위 내에서 가장 좌측부터 가장 우측까지 확인하여 먹기
                for (int j=-k;j<=k;j++) {
                    // 탐색 범위가 배열 안인지 확인
                    if (i+j<0 || i+j>=n) continue;
                    // 먹었다면 햄버거 배열 수정
                    if (burgers[i+j]) {
                        burgers[i+j] = false;
                        // 먹었다면 count 증가
                        count++;
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
