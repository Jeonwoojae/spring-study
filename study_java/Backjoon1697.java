import java.util.*;

public class Main {
    public static int MAX_VALUE = 1000000;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int cur = sc.nextInt();
        int end = sc.nextInt();
        boolean[] check = new boolean[MAX_VALUE];
        int[] dist = new int[MAX_VALUE];
        check[cur] = true;
        dist[cur] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(cur);
        while(!q.isEmpty()) {
            int now = q.remove();
            if(now-1 >= 0) {
                if(check[now-1] == false) {
                    q.add(now-1);
                    check[now-1] = true;
                    dist[now-1] = dist[now] + 1;
                }
            }
            if (now+1 < MAX_VALUE) {
                if (check[now+1] == false) {
                    q.add(now+1);
                    check[now+1] = true;
                    dist[now+1] = dist[now] + 1;
                }
            }
            if (now*2 < MAX_VALUE) {
                if (check[now*2] == false) {
                    q.add(now*2);
                    check[now*2] = true;
                    dist[now*2] = dist[now] + 1;
                }
            }
        }
        System.out.println(dist[end]);
    }
}
