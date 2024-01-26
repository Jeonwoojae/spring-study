import java.util.*;

public class Main {
    public static ArrayList<Integer>[] d;
    public static boolean[] b;
    // dfs 탐색하는 함수. d는 연결 정보, color는 그래프 구분 정보, x는 현재 정점, c는 색칠할 색
    public static boolean dfs(ArrayList<Integer>[] d, int[] color, int x, int c) {
        color[x] = c;
        for(int y: d[x]) {
            if(color[y] == 0) {
                if(dfs(d,color,y, 3-c) == false) {
                    // 이분 그래프는 같은 그룹끼리 연결되지 않아야 한다.
                    return false;
                }
            } else if(color[y] == color[x]) {
                // 이분 그래프는 같은 그룹끼리 연결되지 않아야 한다.
                return false;
            }
        }
        return true;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        for(int i=0;i<K;i++) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            d = new ArrayList[V+1];
            for(int j=1;j<=V;j++) {
                d[j] = new ArrayList<>();
            }
            for(int j=0;j<E;j++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                d[u].add(v);
                d[v].add(u);
            }
            int[] color = new int[V+1]; // 색으로 구분. 0:아직 안나뉜 정점 1,2:나눠진 정점
            boolean ok = true;  // 이분 그래프 여부
            for(int j=1;j<=V;j++) {
                if(color[j] == 0) {
                    if(dfs(d,color,j,1) == false) {
                        ok = false;
                    }
                }
            }
            if(ok) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
