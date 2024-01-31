import java.util.*;

public class Main {
    public static int MAX = 1000_000;
    public static void print(int[] from, int n, int k) {
        if(n != k) {
            print(from, n, from[k]);
        }
        System.out.print(k+" ");
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        boolean[] check = new boolean[MAX];
        int[] dis = new int[MAX];
        int[] from = new int[MAX];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(N);
        dis[N] = 0;
        check[N] = true;
        while(!q.isEmpty()) {
            int cur = q.remove();
            if(cur-1>=0) {
                if(check[cur-1] == false) {
                    q.add(cur-1);
                    dis[cur-1] = dis[cur]+1;
                    check[cur-1] = true;
                    from[cur-1] = cur;
                }
            }
            if(cur+1<MAX) {
                if(check[cur+1] == false) {
                    q.add(cur+1);
                    dis[cur+1] = dis[cur]+1;
                    check[cur+1] = true;
                    from[cur+1] = cur;
                }
            }
            if(cur*2<MAX) {
                if(check[cur*2] == false) {
                    q.add(cur*2);
                    dis[2*cur] = dis[cur]+1;
                    check[cur*2] = true;
                    from[cur*2] = cur;
                }
            }
        }
        System.out.println(dis[K]);
        print(from, N, K);
        System.out.println();
    }
}
