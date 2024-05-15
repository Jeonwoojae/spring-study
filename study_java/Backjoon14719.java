import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int res = 0;
        st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();

        if (w == 1) {
            System.out.println("0");
        }

        int pre = Integer.parseInt(st.nextToken());
        for (int i=1; i<w; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur >= pre) {
                // 이전 위치보다 크거나 같으면 고인 빗물 계산
                while(!stack.isEmpty()) {
                    res += pre - stack.pop();
                }
                pre = cur;
            } else {
                // 이전 위치보다 작으면 스택에 추가
                stack.add(cur);
            }
        }

        // 마지막 위치에 대해서 계산하지 않은 빗물 계산
        if (stack.size() > 1) {
            int end = stack.pop();
            while(!stack.isEmpty()) {
                int cur = stack.pop();
                if (cur > end) {
                    end = cur;
                } else {
                    res += end - cur;
                }
            }
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
        br.close();
    }
}
