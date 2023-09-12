import java.util.*;

public class Main {
    /*
    * 시뮬레이션에서 무엇을 구현해야 하는가?가 가장 중요하다.
    * 이 문제는 (r,c)좌표에 di값이 추가되면 인접한 칸이 조건에 따라 연결 요소가 K개 이상인지 확인한다.
    * 단, 연결요소가 K개 이상이면 연결요소를 모두 .으로 변경해야하기 때문에 연결요소를 찾을 때 위치를 기록해야한다.
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int Q = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        List<String[]> matrix = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            matrix.add(scanner.nextLine().split(""));
        }

        /*
        * 좌표에 새로운 알파벳을 추가할 때 연결 요소의 크기를 측정하는 탐색을 한다.
        * 중요한 부분은 탐색을 진행할 때마다 path에 연결 요소의 좌표를 저장한다.
        * 만약 path의 길이가 K이상이면 path의 좌표를 matrix에서 . 으로 변환한다.
        * */
        for (int i = 0; i < Q; i++) {
            // 명령어 입력
            int y = scanner.nextInt() - 1;
            int x = scanner.nextInt() - 1;
            String c = scanner.next();

            // 매트릭스 상태 변경
            matrix.get(y)[x] = c;


            // 변경된 위치를 기준으로 탐색
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{y, x});
            boolean[][] visited = new boolean[N][N];
            visited[y][x] = true;

            // 방문한 좌표를 기록할 Path 변수
            List<int[]> path = new ArrayList<>();
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                path.offer(current); // add 를 사용해도 됩니다.
                for (int j = 0; j < 4; j++) {
                    int nextX = current[1] + dx[j];
                    int nextY = current[0] + dy[j];
                    // 범위 탐색
                    if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                        // 조건 방문하지 않으면서, 좌표의 값이 c와 같은 경우
                        if (!visited[nextY][nextX] && matrix.get(nextY)[nextX].equals(c)) {
                            visited[nextY][nextX] = true;
                            queue.offer(new int[]{nextY, nextX});
                        }
                    }
                }
            }
            // Path의 길이가 K 이상이라면 matrix의 값을 . 으로 수정
            if (path.size() >= K) {
                for (int[] coords : path) {
                    matrix.get(coords[0])[coords[1]] = ".";
                }
            }
        }
    }
}