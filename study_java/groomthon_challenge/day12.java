import java.util.*;

/*
* 문제 설명
* 1. 행렬은 `0`과 `1`로 이루어지며, `1`이면 집이 있는 칸이다.
* 2. 어떤 집에 발전기를 설치해 전력을 공급할 수 있다.
* 3. 어떤 집에 상하좌우로 인접한 집 중 하나가 전력을 공급받고 있으면, 그 집 또한 전력을 공급받는다.
* 4. 문제에서 묻는 것은 설치해야 하는 발전기의 최소 개수이다.
*
* 이 문제를 해결하기 위해서는 어떤 집에 발전기를 설치했을 때 전기를 공급받을 수 있는지를 알아야 한다.
* 공급 받은 집에는 발전기를 설치하지 안하도 되기 때문이다.
*
* 즉, 인접한 집의 집합 개수를 구하는 것이 목적인 문제이다.
* 이것을 찾기 위해 BFS를 사용한다.
*
* */
public class Main {
    /*
    * 1. 어떤 집에 공급되고 있다면 해당 집을 기준으로 접기를 공급할 수 있는 새로운 집을 찾아야 한다.
    * 2. 하나의 발전기로 전기가 공급되는 집을 탐색 한 뒤, 다시 전기가 필요한 집을 탐색해야한다.
    *
    * 우선 이동을 위해 dx/dy 기법을 사용한다.
    * matrix를 사용하여 현재 마을의 상태를 저장한다.
    * vistied 변수를 사용하여 전기가 공급되고 있는 집을 기록한다.
    *
    * 탐색하기
    * 1. matrix[x][y]의 값이 1이면서, visited[x][y]의 값이 0인 x,y를 찾는다
    * 2. 해당 위치를 기준으로 상하좌우에 다른 집이 있는지 확인한다.
    *   2.1. 만약 그 집의 matrix[x][y]의 값이 1이면서, visited[x][y]의 값이 0이라면 다음 탐색 후보에 추가한다.
    * 3. 탐색 후보가 모두 없을 때 까지 탐색을 계속한다.
    * */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 데이터 처리
        int N = scanner.nextInt();
        int count = 0;
        int[][] matrix = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        // dx/dy기법
        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0 ; i < N ; i++){
            for (int j = 0 ; j < N ; j++ ){

                // 탐색의 조건 (i,j) 위치에 1이 있고, 방문한 적이 없을 때
                if (matrix[i][j] == 1 && visited[i][j] == false){

                    // q는 탐색 후보를 관리할 큐
                    // 첫번째 탐색 후보를 추가하고 visited 변수를 갱신한다.
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = true;

                    // 탐색 후보가 없을 때 까지 탐색한다.
                    while (!q.isEmpty()){
                        // 탐색 후보 가져오기
                        int[] current = q.poll();

                        // 현재 위치에서 탐색 시작
                        for (int k = 0 ; k < 4 ; k++){
                            int nextX = current[0] + dx[k];
                            int nextY = current[1] + dy[k];

                            // 마을 안의 좌표인지 확인
                            if (0 <= nextX && nextX < N & 0 <= nextY && nextY < N){
                                // 집이 있으면서, 전기가 공급되고 있다면
                                if (matrix[nextX][nextY] == 1 && visited[nextX][nextY] == false){
                                    // 새롭게 전기가 공급되는 집이기 떄문에 탐색 후보에 추가해야한다.
                                    q.add(new int[]{nextX, nextY});
                                    visited[nextX][nextY] = true;
                                }
                            }
                        }
                    }
                    // 탐색을 시도할 때 마다 발전기의 개수 +1
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}