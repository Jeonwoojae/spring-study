import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int[][] dist = new int[S+1][S+1];
        Queue<Integer> q = new LinkedList<>();

        // 시도하지 않은 case를 -1로 판단
        for(int i=0;i<=S;i++) {
            Arrays.fill(dist[i],-1);
        }

        // 시작값 저장
        q.add(1);  // 화면
        q.add(0);  // 클립보드
        dist[1][0] = 0;  // 화면과 클립보드 상태에 대한 초

        while (!q.isEmpty()) {
            int s = q.remove();  // 화면
            int c = q.remove();  // 클립보드
            // 화면 내용 모두 클립보드에 저장
            if(dist[s][s] == -1) {
                dist[s][s] = dist[s][c]+1;
                q.add(s);
                q.add(s);
            }
            // 클립보드 내용 붙여넣기
            if(s+c<=S && dist[s+c][c] == -1) {
                dist[s+c][c] = dist[s][c]+1;
                q.add(s+c);
                q.add(c);
            }
            // 화면의 이모티콘 하나 제거
            if(s-1>0 && dist[s-1][c] == -1) {
                dist[s-1][c] = dist[s][c]+1;
                q.add(s-1);
                q.add(c);
            }
        }
        int ans = -1;
        for (int i=0; i<=S; i++) {
            if (dist[S][i] != -1) {
                if (ans == -1 || ans > dist[S][i]) {
                    ans = dist[S][i];
                }
            }
        }
        System.out.println(ans);
    }
}