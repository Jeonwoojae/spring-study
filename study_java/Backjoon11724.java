import java.util.*;

public class Main {
    public static void dfs(ArrayList<Integer>[] a, boolean[] c, int x) {
        if(c[x]) {
            return;
        }
        c[x] = true;
        for(int y: a[x]) {
            if(c[y] == false) {
                dfs(a,c,y);
            }
        }
    }
    public static ArrayList<Integer> [] a;
    public static boolean [] c;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        a = (ArrayList<Integer>[]) new ArrayList[N+1];

        for(int i = 1;i<=N;i++) {
            a[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i <M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            a[u].add(v);
            a[v].add(u);
        }
        for(int i = 1; i <=N; i++) {
            Collections.sort(a[i]);
        }

        int ans = 0;
        boolean[] check = new boolean[N+1];
        // 방문하지 않은 정점에 대해 탐색.
        for(int i = 1; i <=N; i++) {
            if(check[i] == false) {
                ans++;
                dfs(a,check,i);
            }
        }
        System.out.println(ans);
    }
}