import java.util.*;

class Country implements Comparable<Country> {
    int id, gold, silver, bronze;

    public Country(int id, int gold, int silver, int bronze) {
        this.id = id;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    @Override
    public int compareTo(Country other) {
        if (this.gold > other.gold) {
            return 1;
        } else if (this.gold == other.gold) {
            // 금메달 갯수가 같다면 은메달 갯수로 비교
            if (this.silver > other.silver) {
                return 1;
            } else if (this.silver == other.silver) {
                // 은메달 갯수가 같다면 동메달 갯수로 비교
                if (this.bronze > other.bronze) {
                    return 1;
                } else if (this.bronze == other.bronze) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        List<Country> countries = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int id = scanner.nextInt();
            int gold = scanner.nextInt();
            int silver = scanner.nextInt();
            int bronze = scanner.nextInt();
            countries.add(new Country(id, gold, silver, bronze));
        }

        // 정렬
        Collections.sort(countries);

        // 등수 결정
        int rank = 1;
        int sameRank = 1;
        for (int i = 1; i < countries.size(); i++) {
            if (countries.get(i).compareTo(countries.get(i - 1)) != 0) {
                // 이전 등수와 비교해서 같은 등수가 아니면, 같은 등수를 포함하여 등수 증가
                rank += sameRank;
                sameRank = 1;
            } else {
                // 같은 등수면 같은 등수 요소 증가
                sameRank++;
            }
            if (countries.get(i).id == K) {
                // 목표 나라를 찾으면 해당 등수를 출력
                System.out.println(rank);
                return;
            }
        }
        System.out.println(rank); // 첫 번째 나라인 경우
    }
}
