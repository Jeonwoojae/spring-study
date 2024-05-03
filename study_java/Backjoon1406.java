import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기 문자열 입력 받기
        String initialString = br.readLine();

        // 왼쪽 스택 생성 및 초기 문자열 삽입
        Stack<Character> leftStack = new Stack<>();
        for(char c : initialString.toCharArray()) {
            leftStack.push(c);
        }

        // 오른쪽 스택 생성 (초기에는 비어있음)
        Stack<Character> rightStack = new Stack<>();

        // 명령어 개수 입력 받기
        int M = Integer.parseInt(br.readLine());

        // 명령어 수행
        for(int i = 0; i < M; i++) {
            String command = br.readLine();
            char type = command.charAt(0);

            switch(type) {
                case 'L': // 커서를 왼쪽으로 이동
                    if(!leftStack.isEmpty()) rightStack.push(leftStack.pop());
                    break;
                case 'D': // 커서를 오른쪽으로 이동
                    if(!rightStack.isEmpty()) leftStack.push(rightStack.pop());
                    break;
                case 'B': // 왼쪽 문자 삭제
                    if(!leftStack.isEmpty()) leftStack.pop();
                    break;
                case 'P': // 왼쪽에 문자 추가
                    char ch = command.charAt(2);
                    leftStack.push(ch);
                    break;
            }
        }

        // 결과 문자열 생성
        StringBuilder sb = new StringBuilder();
        while(!leftStack.isEmpty()) rightStack.push(leftStack.pop());
        while(!rightStack.isEmpty()) sb.append(rightStack.pop());

        // 결과 출력
        System.out.println(sb.toString());
    }
}
