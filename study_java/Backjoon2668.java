import java.util.*;

public class Main {
    public static int[] a;
    public static boolean[] visited;
    public static ArrayList<Integer> list;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        a = new int[n+1];
        visited = new boolean[n+1];
        list = new ArrayList<>();

        for (int i=1; i<=n;i++) {
            a[i] = sc.nextInt();
        }

        for (int i=1; i<=n; i++) {
            visited[i] = true;
            dfs(i,i); // 탐색해서 다시 돌아오는 사이클을 이루는지 체크
            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (int num : list) {
            System.out.println(num);
        }
    }
    public static void dfs(int start, int target) {
        if (visited[a[start]] == false) {
            visited[a[start]] = true;
            dfs(a[start], target);
            visited[a[start]] = false;
        }
        if (target == a[start]) list.add(target);
    }
}
