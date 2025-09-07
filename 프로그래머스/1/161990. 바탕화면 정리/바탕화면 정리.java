class Solution {
    public int[] solution(String[] wallpaper) {
        
        int row = wallpaper.length;
        int col = wallpaper[0].length();
        
        int xMin = 51;
        int yMin = 51;
        int xMax = -1;
        int yMax = -1;
        
        // x최소, x최대 나타는 곳 구하기
        // y최소, y최대 나타는 곳 구하기
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(wallpaper[i].charAt(j) == '#'){
                    if(i < xMin) {xMin = i;}
                    if(j < yMin) {yMin = j;}
                    if(i > xMax) {xMax = i;}
                    if(j > yMax) {yMax = j;}
                }
            }
        }
        // x,y 최소 / x,y좌표 최대        
        return new int[]{xMin, yMin, xMax+1, yMax+1};
    }
}