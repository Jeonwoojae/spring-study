import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 사람의 수 N을 입력 받습니다.
        int[] people = new int[N]; // 각 사람이 기억하는, 자신보다 키가 큰 사람이 왼쪽에 몇 명 있는지 저장할 배열입니다.
        int[] line = new int[N]; // 최종 줄을 서는 순서를 저장할 배열입니다.

        // 각 사람이 기억하는 정보를 입력 받습니다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        // 사람의 키는 1부터 시작하므로, 키가 i인 사람을 올바른 위치에 배치합니다.
        for (int i = 1; i <= N; i++) {
            int left = people[i - 1]; // 키가 i인 사람의 왼쪽에 몇 명의 키가 큰 사람이 있는지
            int count = 0; // 현재까지 채워진 자리를 세기 위한 변수

            // 올바른 자리를 찾아서 사람을 배치합니다.
            for (int j = 0; j < N; j++) {
                if (line[j] == 0) { // 아직 아무도 서있지 않은 자리라면
                    if (count == left) { // 키가 큰 사람이 왼쪽에 필요한 만큼 있으면
                        line[j] = i; // 해당 위치에 사람을 배치합니다.
                        break;
                    }
                    count++; // 아직 필요한 만큼의 키가 큰 사람이 왼쪽에 없다면, 계속해서 다음 자리를 확인합니다.
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            bw.write(line[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
