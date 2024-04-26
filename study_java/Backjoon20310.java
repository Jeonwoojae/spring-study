import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] lines = br.readLine().toCharArray();
        int[] count = new int[2];  // 0의 갯수, 1의 갯수를 저장.

        for (int i=0; i<lines.length;i++) {
            if (lines[i] == '0') {
                count[0]++;
            }else {
                count[1]++;
            }
        }

        // 복잡도를 줄이기 위해 기존 글자에서 필요한 만큼 지우는 방법
        int delete0 = count[0]/2;
        int delete1 = count[1]/2;

        StringBuilder sb = new StringBuilder();

        // 앞에서부터 순회하며 필요한 만큼의 1을 제거
        for (int i = 0; i < lines.length; i++) {
            if (lines[i] == '1' && delete1 > 0) {
                delete1--;
                continue; // 이번 1은 건너뛰기
            }
            sb.append(lines[i]);
        }

        String result = sb.toString();
        sb = new StringBuilder();

        // 뒤에서부터 순회하며 필요한 만큼의 0을 제거
        for (int i = result.length() - 1; i >= 0; i--) {
            if (result.charAt(i) == '0' && delete0 > 0) {
                delete0--;
                continue; // 이번 0은 건너뛰기
            }
            sb.append(result.charAt(i));
        }

        // 최종 문자열이 뒤집혀 있으므로 다시 뒤집어서 원래 순서로 만듦
        bw.write(sb.reverse().toString());

//        // 각 숫자의 갯수 절반으로 새로운 문자열 생성.
//        // 생성 가능한 문자열 중 사전순으로 빠르려면? -> 0을 먼저 모두 사용하고 1을 사용
//        for (int i=0; i<count[0]/2;i++) {
//            bw.write('0');
//        }
//        for (int i=0; i<count[1]/2;i++) {
//            bw.write('1');
//        }
        bw.flush();
        br.close();
        bw.close();
    }
}