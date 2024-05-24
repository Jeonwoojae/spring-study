import java.util.*;
import java.io.*;


class Pair {

    int X;
    int Y;

    Pair(int X, int Y){
        this.X = X;
        this.Y = Y;
    }
}

public class Main {
    static int R; // 행
    static int C; // 열
    static char[][] maze; // 미로
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static Queue<Pair> fireQ = new LinkedList<>(); // 불
    static Queue<Pair> jQ = new LinkedList<>(); // 지훈

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        maze = new char[R][C];

        for(int i=0; i<R; i++) {
            String s = br.readLine(); // 한 줄에 붙여서 따다닥 적기 때문에 내부 for문에서 한 문자씩 잘라줌
            for(int j=0; j<C; j++) {
                maze[i][j] = s.charAt(j);

                if(maze[i][j] == 'F') {
                    fireQ.add(new Pair(i, j)); // 불 첫 위치
                }
                if(maze[i][j] == 'J') {
                    jQ.add(new Pair(i, j)); // 지훈 첫 위치
                }
            }
        }

        int count = 0;

        while(true) {
            count++;
            int fs = fireQ.size(); // fire 큐 크기

            // 사이즈는 밖에서 크기를 지정하고 들어가기 때문에 현재 들어간 큐 값들만 계산하고 지훈이 위치 이동으로 간다.
            // 큐가 비었는지를 조건으로 넣으면 반복문 안에서 계속 큐 값들을 삽입해서 불만 쭉 움직이기 때문에
            // 불과 지훈이가 같이 움직이지 않는다.
            while(fs>0) {
                fs--;
                Pair pos = fireQ.poll();
                for(int i=0; i<4; i++) {
                    int plusX = pos.X + dx[i];
                    int plusY = pos.Y + dy[i];

                    if(plusX >= 0 && plusX < R && plusY >= 0 && plusY < C) { // 불의 다음 확산 방향이 범위 안에 있다면
                        if(maze[plusX][plusY] == 'J' || maze[plusX][plusY] == '.') { // 다음 활산 방향이 움직일 수 있는 곳이면
                            fireQ.add(new Pair(plusX, plusY));
                            maze[plusX][plusY] = 'F';
                        }
                    }
                }
            }

            int js = jQ.size();
            while(js>0) {
                js--;
                Pair pos = jQ.poll();
                for(int i=0; i<4; i++) {
                    int plusX = pos.X + dx[i];
                    int plusY = pos.Y + dy[i];
                    // 지훈이 탈출 가능하면 종료
                    if(plusX < 0 || plusX >= R || plusY < 0 || plusY >= C) {
                        System.out.println(count);
                        return;
                    }

                    // 만약 갈 수 있는 곳이면 큐에 추가
                    if(maze[plusX][plusY] == '.') {
                        jQ.add(new Pair(plusX, plusY));
                        maze[plusX][plusY] = 'F';
                    }
                }
            }

            // 움직일 공간을 찾지못해 jQ에 값을 넣지 못하게 되면 탈출을 하지 못한다.
            if(jQ.isEmpty()) {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
    }
}