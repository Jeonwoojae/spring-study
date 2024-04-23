import java.io.*;
import java.util.*;

class Team implements Comparable<Team> {
    int id, scoreSum = 0, submitCount = 0;
    int lastSubmitTime = 0;

    public Team(int id) {
        this.id = id;
    }

    // 정렬 기준: 점수 합계 > 제출 횟수 > 마지막 제출 시간
    @Override
    public int compareTo(Team o) {
        if (this.scoreSum != o.scoreSum) {
            return o.scoreSum - this.scoreSum;
        } else if (this.submitCount != o.submitCount) {
            return this.submitCount - o.submitCount;
        } else {
            return this.lastSubmitTime - o.lastSubmitTime;
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[n + 1];
            for (int i = 1; i <= n; i++) {
                teams[i] = new Team(i);
            }
            int[][] scores = new int[n + 1][k + 1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int problem = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                if (scores[id][problem] < score) {
                    teams[id].scoreSum += score - scores[id][problem];
                    scores[id][problem] = score;
                }
                teams[id].submitCount++;
                teams[id].lastSubmitTime = i;
            }

            Arrays.sort(teams, 1, n + 1);

            for (int rank = 1; rank <= n; rank++) {
                if (teams[rank].id == t) {
                    System.out.println(rank);
                    break;
                }
            }
        }
    }
}
