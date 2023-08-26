import java.util.*;

/*
* 문제 설명
* N*N의 보드가 있다. 각 칸에는 방향과 이동 칸 수가 적혀있다.
* 이동 중 보드 밖을 나가면 반대쪽의 첫번째 칸으로 이동한다.
* 만약, 말이 이동하다가 방문했던 칸을 지나야 한다면 종료된다.
* 이 외의 경우에는 종료할 때 까지 이동을 반복한다.
* 게임의 점수는 시작한 칸을 포함해, 종료하기까지 말이 방문한 서로 다른 칸의 개수이다.
* 플레이어는 구름이와 플레이어이다.
* 비기는 테스트 케이스는 주어지지 않는다.
* */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        // 구르미와 플레이어의 시작 위치, 방문 지점
        int[] goormPos = {scanner.nextInt() - 1, scanner.nextInt() - 1};
        boolean[][] goormVisited = new boolean[N][N];
        int[] playerPos = {scanner.nextInt() - 1, scanner.nextInt() - 1};
        boolean[][] playerVisited = new boolean[N][N];

        // 캐릭터들이 이동하는 판
        String[][] board = new String[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = scanner.next();
            }
        }

        int goormScore = move(goormPos, goormVisited, 1, board, N);
        int playerScore = move(playerPos, playerVisited, 1, board, N);

        if (goormScore > playerScore) {
            System.out.println("goorm " + goormScore);
        } else if (goormScore < playerScore) {
            System.out.println("player " + playerScore);
        }
        scanner.close();
    }


    // 이동 중 보드 밖으로 나갔을 때 반대쪽 첫번째 칸으로 이동
    public static int set_Pos(int a, int N) {
        if (a == -1) return N - 1;
        if (a == N) return 0;
        return a;
    }

    // 방향이 문자로 주어질 경우 Map으로 방향을 불러올 수 있다.
    static HashMap<String, int[]> directions = new HashMap<String, int[]>() {
        {
            put("U", new int[]{-1, 0});
            put("D", new int[]{1, 0});
            put("L", new int[]{0, -1});
            put("R", new int[]{0, 1});
        }
    };

    public static int move(int[] pos, boolean[][] visited, int score, String[][] board, int N) {
        int x = pos[0];
        int y = pos[1];
        // 방문 위치를 true로 전환
        visited[x][y] = true;
        // flag = 시뮬레이션이 진행될 수 있는지 판단하는 변수
        // true : 가능. false : 종료
        boolean flag = true;

        while (flag) {
            // 현재 위치한 칸의 이동 명령을 분리.
            String command = board[x][y];
            int distance = Integer.parseInt(command.substring(0, command.length() - 1));
            String direction = command.substring(command.length() - 1);

            // distance 칸만큼 direction 방향으로 이동
            for (int i = 0; i < distance; i++) {
                x += directions.get(direction)[0];
                y += directions.get(direction)[1];
                x = set_Pos(x, N);
                y = set_Pos(y, N);

                /*
                * 방문 가능 여부를 판단
                * vistied[x][y]가 false면 시뮬레이션 진행, score+1, visited[x][y]=true로 변경
                * visited[x][y]가 true면 시뮬레이션 flag 종료, flag = false로 변경
                * */
                if (!visited[x][y]) {
                    visited[x][y] = true;
                    score += 1;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return score;
    }

}