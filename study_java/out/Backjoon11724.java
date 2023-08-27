import java.util.Scanner;

public class Backjoon11724 {
    /*
    * 슈도 코드
    * n(노드 개수) m(에지 개수)
    * A(그래프 데이터 저장 인접 리스트)
    * visited(방문 기록 저장 배열)
    * for(n의 개수만큼 반복하기) {
    *   A 인접 리스트의 각 ArrayList 초기화하기
    * }
    * for(m의 개수만큼 반복하기) {
    *   A 인접 리스트에 그래프 데이터 저장하기
    * }
    * for(n의 개수만큼 반복하기) {
    *   if(방문하지 않은 노드가 있으면) {
    *     연결 요소 개수++
    *     DFS 실행하기
    *   }
    * }
    * // DFS 구현하기
    * DFS {
    *   if(현재 노드 == 방문 노드) return;
    *   vistied 배열에 현재 노드 방문 기록하기
    *   현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행하기(재귀 함수 형태)
    * */
    public static void main(String[] args) {
        static boolean visited[];
        static ArrayList<Integer>[] A;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.nextLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        A = new ArrayList[n+1];

        for(int i=1; i<n+1; i++){
            A[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.nextLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            A[s].add(e);
            A[e].add(s);
        }
        int count = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    private static void DFS(int v) {
        if(visited[v]){
            return;
        }
        visited[v] = true;
        for(int i: A[v]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }
}