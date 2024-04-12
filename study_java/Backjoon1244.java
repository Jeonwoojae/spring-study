import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스위치 개수 입력 받기
        int switchCount = Integer.parseInt(br.readLine());
        // 스위치 상태를 저장할 배열 (1-indexed로 접근하기 위해 +1)
        boolean[] switches = new boolean[switchCount + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= switchCount; i++) {
            // 스위치 상태 입력 받아서 저장 (0은 꺼짐, 1은 켜짐)
            switches[i] = "1".equals(st.nextToken());
        }

        // 학생 수 입력 받기
        int studentCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentCount; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());  // 성별
            int number = Integer.parseInt(st.nextToken());  // 받은 수

            if (gender == 1) {  // 남학생의 경우
                for (int j = number; j <= switchCount; j += number) {
                    switches[j] = !switches[j];  // 배수 위치의 스위치 상태를 바꿈
                }
            } else {  // 여학생의 경우
                switches[number] = !switches[number];  // 받은 수 위치의 스위치 상태를 바꿈
                for (int j = 1; j <= switchCount / 2; j++) {
                    // 범위를 벗어나거나 좌우 대칭이 아닐 때까지 반복
                    if (number - j < 1 || number + j > switchCount || switches[number - j] != switches[number + j]) {
                        break;
                    }
                    switches[number - j] = !switches[number - j];
                    switches[number + j] = !switches[number + j];
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= switchCount; i++) {
            System.out.print((switches[i] ? 1 : 0) + " ");
            if (i % 20 == 0) {
                System.out.println();  // 20개씩 출력 후 줄 바꿈
            }
        }
    }
}