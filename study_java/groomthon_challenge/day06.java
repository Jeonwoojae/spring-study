import java.util.Scanner;

/*
* 문제 설명
* 길이가 N인 문자열 S를 3개의 문자열로 나눈 후, 주어진 조건에 따라 점수를 계산하는 문제
* 점수는 문자열의 모든 부분 문자열의 순서에 따라서 결정
* 문자열의 길이의 최대 100 정도로 짧기 때문에 가능한 모든 부분 문자열을 확인하는 완전 탐색으로 문제를 해결
* */

public class Main {
    /*
    * 1. 가능한 부분 문자열을 찾고, 정렬하여 점수 판을 만든다.
      2. 완전 탐색으로 문자열을 자를 수 있는 모든 경우의 수를 찾는다.
      3. 점수 판을 이용해서, 모든 경우의 수 중에서 최대 점수를 찾는다.
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine(); // to consume newline left by nextInt()
        String Word = scanner.nextLine();

        // 단어 집합을 저장할 wordList
        List<String[]> wordList = new ArrayList<>();
        // 부분 문자열을 저장할 score
        Set<String> Score = new HashSet<>();

        // 위치를 2개 정하는 모든 조합 구하기
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                String first = Word.substring(0, i);
                String second = Word.substring(i, j);
                String third = Word.substring(j);
                wordList.add(new String[]{first, second, third});
                Score.add(first);
                Score.add(second);
                Score.add(third);
            }
        }

        List<String> tempScoreList = new ArrayList<>(Score);
        Collections.sort(tempScoreList);

        Map<String, Integer> wordScore = new HashMap<>();
        for (int i = 0; i < tempScoreList.size(); i++) {
            wordScore.put(tempScoreList.get(i), i + 1);
        }

        // 최고 점수 찾기
        int maxScore = -1;
        for (String[] words : wordList) {
            int tempScore = 0;
            for (String word : words) {
                tempScore += wordScore.get(word);
            }
            maxScore = Math.max(maxScore, tempScore);
        }

        System.out.println(maxScore);
    }
}