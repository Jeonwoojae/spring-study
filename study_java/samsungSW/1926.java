import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for (int i = 1; i <= num; i++) {
            String strNum = String.valueOf(i); // 숫자를 문자열로 변환
            String result = strNum.replaceAll("[369]", "-"); // '3', '6', '9'를 '-'로 치환
            if (result.contains("-")) {
                result = result.replaceAll("[0-9]", "");
            }

            System.out.print(result + " ");
        }


        bw.flush();
        br.close();
        bw.close();
    }
}