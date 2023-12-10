class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // yellow는 최대 가로로 maxLen만큼 배치할 수 있다.
        int maxLen = (int)Math.sqrt(yellow);
        // yellow의 세로 길이
        int col;

        // 완전 탐색 시작
        for(int row = 1;row <= maxLen;row++){
            // yellow가 사각형 모양이 안되는 경우 pass
            if(yellow % row != 0)
                continue;
            col = yellow/row;

            // 만약 현재 yellow 배치 주위에 brown 갯수를 배치할 수 있으면 성공
            if(((row + col)*2 + 4) == brown)
            {
                answer[0] = Math.max(col, row)+2;
                answer[1] = Math.min(col, row)+2;
                break;
            }
        }
        return answer;
    }
}