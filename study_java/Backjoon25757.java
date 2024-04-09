import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        char gameType = firstLine[1].charAt(0);

        // 게임별 필요한 추가 인원 (임스 제외)
        int additionalPlayersNeeded = 0;
        switch (gameType) {
            case 'Y':
                additionalPlayersNeeded = 1; // 윷놀이는 총 2명 필요, 임스 제외하면 1명 추가 필요
                break;
            case 'F':
                additionalPlayersNeeded = 2; // 같은 그림 찾기는 총 3명 필요, 임스 제외하면 2명 추가 필요
                break;
            case 'O':
                additionalPlayersNeeded = 3; // 원카드는 총 4명 필요, 임스 제외하면 3명 추가 필요
                break;
        }

        HashSet<String> uniquePlayers = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String playerName = br.readLine();
            uniquePlayers.add(playerName);
        }

        // 중복되지 않는 사람들의 수를 기반으로 최대 게임 횟수 계산
        // 임스를 포함해야 하므로, 실제로는 필요한 인원보다 하나 적은 수의 인원으로 게임을 할 수 있음
        int maxGames = uniquePlayers.size() / additionalPlayersNeeded;
        System.out.println(maxGames);
    }
}
