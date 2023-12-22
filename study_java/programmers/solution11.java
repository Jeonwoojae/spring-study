class Solution {
    public int[] solution(String[] wallpaper) {
        int minX=51, minY=51;
        int maxX=0, maxY=0;

        // 모든 #을 포함하는 범위를 반환
        for(int currentY=0;currentY<wallpaper.length;currentY++) {
            // 한줄 배열로 변경.
            String[] words = wallpaper[currentY].split("");
            for(int currentX=0;currentX<wallpaper[0].length();currentX++) {
                if(words[currentX].equals("#")) {
                    // 파일을 만나면 위치안에 포함하도록 좌표 변경.
                    minX = Math.min(minX, currentX);
                    minY = Math.min(minY, currentY);
                    maxX = Math.max(maxX, currentX);
                    maxY = Math.max(maxY, currentY);
                }
            }
        }
        int[] answer = {minY,minX,maxY+1,maxX+1};
        return answer;
    }
}