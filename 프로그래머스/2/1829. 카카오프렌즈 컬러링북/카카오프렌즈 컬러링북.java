import java.util.*;
class Solution {
    boolean[][] visited;
    int R, C;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int[] solution(int m, int n, int[][] picture) {
        
        R = picture.length;
        C = picture[0].length;
        visited = new boolean[R][C];
        
        int max = -1; // 최대 넓이
        int count = 0; // 영역 개수
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    int area = findArea(picture, i, j);
                    count+=1;
                    max = Math.max(max, area);
                }
            }
        }

        return new int[]{count, max};
    }
    
    public int findArea(int[][] picture, int sx, int sy){
        int std = picture[sx][sy];
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        
        int area = 1;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            
            for(int i = 0; i < 4; i++){
                int newX = curX + dx[i];
                int newY = curY + dy[i];
                if(newX >= 0 && newX < R && newY >= 0 && newY < C 
                   && picture[newX][newY] == std && !visited[newX][newY]){
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                    area+=1;
                }
            }
        }
        
        return area;
    }
}