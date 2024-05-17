import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());  // 고도가 바뀌는 지점의 갯수

        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (weight == 0) {
                res += stack.size();
                stack.clear();
            } else if (!stack.isEmpty()) {
                int peek = stack.peek();
                if (peek < weight) {
                    // 높이가 높아졌다면 stack에 push
                    stack.push(weight);
                } else {
                    // 높이가 낮아지면 그 높이보다 높은 건물들 모두 스택에서 꺼낸다.
                    while (!stack.isEmpty() && stack.peek()>weight) {
                        stack.pop();
                        res++;
                    }
                    // 만약 없던 높이라면 스택에 추가
                    if(!stack.isEmpty() && stack.peek()<weight)
                        stack.push(weight);
                    if(stack.isEmpty())
                        stack.push(weight);
                }
            } else {
                // 스택이 비어있으면 바로 push
                stack.push(weight);
            }
        }

        res += stack.size();  // 스택에 아직 처리되지 않은 건물 추가
        System.out.println(res);
    }
}
