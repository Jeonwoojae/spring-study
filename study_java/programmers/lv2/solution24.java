class Solution {
    int max = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, visited, 0);

        return max;
    }

    private void dfs(int k, int[][] dungeons, boolean[] visited, int count) {
        if (count > max) { // 탐험한 던전의 수가 최대값보다 크면 max 업데이트
            max = count;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && isMoveable(dungeons[i], k)) { // 방문하지 않은 던전 중 탐험 가능한 던전을 찾는다.
                visited[i] = true; // 해당 던전을 방문했다고 표시
                dfs(goDungeon(dungeons[i], k), dungeons, visited, count + 1); // 재귀적으로 dfs 호출
                visited[i] = false; // 백트래킹을 위해 방문 표시를 해제
            }
        }
    }

    private int goDungeon(int[] dungeon, int currentK) {
        if(isMoveable(dungeon, currentK)) {
            return currentK - dungeon[1];
        }
        return currentK;
    }

    private boolean isMoveable(int[] dungeon, int currentK) {
        if(dungeon[0] <= currentK) return true;
        return false;
    }
}
