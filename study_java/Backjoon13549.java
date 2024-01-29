import java.util.*;

public class Main {
    public static int MAX = 1_000_000;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        boolean[] check = new boolean[MAX];
        int[] dis = new int[MAX];
        check[N] = true;
        dis[N] = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> next_queue = new LinkedList<Integer>();
        q.add(N);
        while (!q.isEmpty()) {
            int now = q.remove();
            // 첫번째 큐에서 처리할 수 있는 작업 모두 수행
            for(int next : new int[]{now*2, now-1, now+1}) {
                if(next >= 0 && next < MAX) {
                    if(check[next] == false) {
                        check[next] = true;
                        if(now*2 == next) {
                            q.add(next);
                            dis[next] = dis[now];
                        } else {
                            next_queue.add(next);
                            dis[next] = dis[now] + 1;
                        }
                    }
                }
                if(q.isEmpty()) {
                    // 다음 큐의 작업을 하도록 큐 교체
                    q = next_queue;
                    next_queue = new LinkedList<>();
                }
            }
        }
        System.out.println(dis[K]);
    }
}

/*
* 평소 방법대로 소요 시간을 갱신할 시, 1초에 0초에서 +-한 값, *2한 값들이 생기기 때문에 큐를 두개 사용해야한다.
* */
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] dis = new int[100001];
        boolean[] check = new boolean[100001];
        Arrays.fill(dis, Integer.MAX_VALUE); // 모든 위치에 대한 시간을 최대값으로 초기화
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        dis[N] = 0;
        check[N] = true;
        while(!q.isEmpty()) {
            int cur = q.remove();
            if(cur-1>=0 && !check[cur-1]) {
                dis[cur-1] = dis[cur] + 1;
                q.add(cur-1);
                check[cur-1] = true;
            }
            if(cur+1<=100000 && !check[cur+1]) {
                dis[cur+1] = dis[cur] + 1;
                q.add(cur+1);
                check[cur+1] = true;
            }
            if(cur*2<=100000 && !check[cur*2]) {
                dis[cur*2] = dis[cur];
                q.add(cur*2);
                check[cur*2] = true;
            }
        }
        System.out.println(dis[K]);
    }
}
