import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreMap = new HashMap<>();
        HashMap<String, List<Integer>> highPlaysGenreIndexMap = new HashMap<>();

        // 각 장르별로 총 재생 수 및 상위 2곡의 인덱스 계산
        for (int i = 0; i < genres.length; i++) {
            // 각 장르별 총 재생 수 계산
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);

            // 각 장르별 상위 2곡의 인덱스 계산
            List<Integer> highPlaysIndexList = highPlaysGenreIndexMap.getOrDefault(genres[i], new ArrayList<>());

            if (highPlaysIndexList.size() < 2) {
                highPlaysIndexList.add(i);
            } else {
                int minIndex = highPlaysIndexList.stream().min(Comparator.comparingInt(index -> plays[index])).get();
                if (plays[minIndex] < plays[i]) {
                    highPlaysIndexList.remove((Integer) minIndex);
                    highPlaysIndexList.add(i);
                }
            }

            Collections.sort(highPlaysIndexList, Comparator.comparingInt(index -> -plays[index]));

            highPlaysGenreIndexMap.put(genres[i], highPlaysIndexList);
        }

        // 결과 배열 생성:
        // - 각장르는 총 플레이 횟수가 많은 순으로 정렬하고,
        // - 같은 플레이 횟수를 가진 경우에는 고유 번호가 낮은 순으로 정렬합니다.

        List<String> sortedGenres = genreMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        List<Integer> answer = new ArrayList<>();

        for (String genre : sortedGenres) {
            answer.addAll(highPlaysGenreIndexMap.get(genre));
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
