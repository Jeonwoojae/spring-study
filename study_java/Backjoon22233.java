import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashSet<String> keywords = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 메모장에 적힌 키워드 개수
        int M = Integer.parseInt(st.nextToken()); // 블로그에 쓴 글의 개수

        // 메모장에 있는 키워드를 HashSet에 저장
        for (int i = 0; i < N; i++) {
            keywords.add(br.readLine());
        }

        // 블로그 글 처리
        for (int i = 0; i < M; i++) {
            String[] blogKeywords = br.readLine().split(",");
            for (String keyword : blogKeywords) {
                // 메모장에 있는 키워드라면 삭제
                keywords.remove(keyword);
            }
            // 현재 메모장에 남아있는 키워드 수 출력
            bw.write(keywords.size() + "\n");
        }

        bw.flush(); // 남아있는 데이터를 모두 출력
        br.close();
        bw.close();
    }
}
