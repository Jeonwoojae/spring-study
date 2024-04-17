import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // BufferedWriter 추가
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> wordMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            // 길이가 M 이상인 단어만 고려
            if (word.length() >= M) {
                wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
            }
        }

        // Map을 List로 변환
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordMap.entrySet());

        // 정렬: 빈도수 내림차순 -> 길이 내림차순 -> 알파벳 오름차순
        Collections.sort(wordList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // 빈도수 비교
                if (o1.getValue() != o2.getValue()) {
                    return o2.getValue() - o1.getValue();
                } else {
                    // 길이 비교
                    if (o1.getKey().length() != o2.getKey().length()) {
                        return o2.getKey().length() - o1.getKey().length();
                    } else {
                        // 알파벳 순 비교
                        return o1.getKey().compareTo(o2.getKey());
                    }
                }
            }
        });

        // 정렬된 단어 출력
        for (Map.Entry<String, Integer> entry : wordList) {
            bw.write(entry.getKey());
            bw.newLine(); // 줄 바꿈
        }

        bw.flush(); // 버퍼의 내용을 출력
        bw.close(); // BufferedWriter 닫기
        br.close(); // BufferedReader 닫기
    }
}
