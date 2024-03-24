import java.util.*;

public class Main {
    // 입력 내용 저장

    // 나무 내용 저장
    // 죽은 나무 내용 저장
    // 땅 양분 내용 init. 모든 칸에 5씩

    // K년 만큼 반복

        // 봄
        // 자신의 나의만큼 양분을 먹는다.
        // 만약 여러 개가 있다면, 어린 나무부터 먹는다.
        // 땅에 양분이 부족하면 해당 나무는 즉시 죽는다.

        // 여름
        // 봄에 죽은 나무가 양분으로 변한다.
        // 각각 죽은 나무마다 나이를 2나눈 값이 양분으로 저장된다. 소수점 버리기


        // 가을
        // 나이가 5의 배수인 나무를 찾는다.
        // 해당 나무의 8방향으로 나이가 1인 나무를 추가한다.

        // 겨울
        // A[r][c]의 위치에 해당 값을 양분으로 추가한다.
    static final int[] dx = {-1,-1,-1,0,0,1,1,1};
    static final int[] dy = {-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        int[][] a = new int[n][n];  // 겨울마다 추가되는 양분
        int[][] d = new int[n][n];  // 칸에 저장되어 있는 양분
        ArrayList<Integer>[][] tree = new ArrayList[n][n]; // 심어져 있는 나무(나이)
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                a[i][j] = sc.nextInt();
                d[i][j] = 5; // 가장 처음에 양분은 모든 칸에 5만큼 들어있다.
                tree[i][j] = new ArrayList<>();
            }
        }
        while (m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int age = sc.nextInt();
            tree[x-1][y-1].add(age);
        }
        while (l-- > 0) {
            int[][] p = new int[n][n];
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    Collections.sort(tree[i][j]);  // 나이가 작은 나무부터 양분 먹기위해 정렬
                    int dead = 0;
                    for (int x : tree[i][j]) {
                        if (x <= d[i][j]) {
                            d[i][j] -= x; // 나무가 자신의 나이만큼 양분을 먹고, 나이가 1 증가한다.
                            temp.add(x+1);
                            if ((x+1) % 5 == 0) { // 번식하는 나무는 나이가 5의 배수이어야 하며,
                                for (int k=0; k<8; k++) {
                                    int nx = i+dx[k];
                                    int ny = j+dy[k];
                                    if (0 <= nx && nx < n && 0 <= ny && ny < n) { // 상도의 땅을 벗어나는 칸에는 나무가 생기지 않는다.
                                        p[nx][ny] += 1; // 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
                                    }
                                }
                            }
                        } else { // 만약, 땅에 양분이 부족해 자신의 나이만큼 양분을 먹을 수 없는 나무는 양분을 먹지 못하고 즉시 죽는다.
                            dead += x/2; // 각각의 죽은 나무마다 나이를 2로 나눈 값이 나무가 있던 칸에 양분으로 추가된다.
                        }
                    }
                    tree[i][j] = temp;
                    d[i][j] += dead;
                    d[i][j] += a[i][j]; // 각 칸에 추가되는 양분의 양은 A[r][c]이고, 입력으로 주어진다.
                }
            }
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    for (int k=0; k<p[i][j]; k++) {
                        tree[i][j].add(1); // 인접한 8개의 칸에 나이가 1인 나무가 생긴다.
                    }
                }
            }
        }
        int ans = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                ans += (int)tree[i][j].size();
            }
        }
        System.out.println(ans);
    }
}