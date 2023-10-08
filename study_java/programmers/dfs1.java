class Solution {
    int answer = 0;

    public void dfs(int[] numbers, int target, int depth, int sum){
        // 값들을 모두 썼을 때 원하는 값과 같으면 +1;
        if(depth == numbers.length){
            if(sum == target)
                answer++;
            return;
        }

        // 다음 값을 빼거나 더했을 경우로 호출
        dfs(numbers,target,depth+1,sum+numbers[depth]);
        dfs(numbers,target,depth+1,sum-numbers[depth]);
    }

    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0,0);

        return answer;
    }
}