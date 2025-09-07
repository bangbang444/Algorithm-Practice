class Solution {
    public int[] solution(String[] wallpaper) {
        
        int row = wallpaper.length;
        int col = wallpaper[0].length();
        
        int[] xMin = {51, 51};
        int[] yMin = {51, 51};
        int[] xMax = {-1, -1};
        int[] yMax = {-1, -1};
        
        // x최소, x최대 나타는 곳 구하기
        // y최소, y최대 나타는 곳 구하기
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(wallpaper[i].charAt(j) == '#'){
                    if(i < xMin[0]) {xMin[0] = i; xMin[1] = j;}
                    if(j < yMin[1]) {yMin[0] = i; yMin[1] = j;}
                    if(i > xMax[0]) {xMax[0] = i; xMax[1] = j;}
                    if(j > yMax[1]) {yMax[0] = i; yMax[1] = j;}
                }
            }
        }
        // x,y 최소 / x,y좌표 최대        
        return new int[]{xMin[0], yMin[1], xMax[0]+1, yMax[1]+1};
    }
}