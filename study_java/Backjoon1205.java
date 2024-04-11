import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());  // 무작위 점수들
        int taesoo = Integer.parseInt(st.nextToken());  // 태수 점수
        int P = Integer.parseInt(st.nextToken());  // 랭킹에 올라갈 수 있는 수

        int[] score = new int[P];  // 정렬된 점수들
        if(N>0) {
            st = new StringTokenizer(in.readLine());
            for (int i = 0; i < N; i++) score[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(score);

        // 딱 맞게 들어갈 수 있는데, 제일 작은수와 같거나 작다면 랭킹에 들 수 없다.
        if(P==N && score[0]>=taesoo){
            System.out.println(-1);
            return;
        }

        int cnt = 1;
        // 제일 큰 수부터 비교, 배열 범위를 넘지 않을 정도로 탐색
        for(int i=P-1;i>=Math.max(0,P-N-1);i--){
            if(score[i]>taesoo) cnt++;
            else break;
        }
        System.out.println(cnt);
    }
}