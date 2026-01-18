import java.util.*;
class Solution {
    
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    
    public int solution(String[] maps) {
        
        int totalTime = 0;
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                char ch = maps[i].charAt(j);
                if(ch == 'S'){
                    start[0] = i;
                    start[1] = j;
                }else if(ch == 'L'){
                    lever[0] = i;
                    lever[1] = j;
                }else if(ch == 'E'){
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }
        
        // 버튼 찾기
        int findLeverTime = findTarget(maps, start, lever);
        if(findLeverTime == -1){
            return -1;
        }
        totalTime += findLeverTime;
        
        // 출구 찾기
        int findExitTime = findTarget(maps, lever, exit);
        if(findExitTime == -1){
            return -1;
        }
        totalTime += findExitTime;
        
        return totalTime;
    }
    
    private int findTarget(String[] maps, int[] start, int[] end){
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1], 0});
        int targetX = end[0];
        int targetY = end[1];
        
        int time = -1;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int t = cur[2];
            
            if(curX == targetX && curY == targetY){
                return t;
            }
            
            for(int i = 0; i < 4; i++){
                int newX = curX + dx[i];
                int newY = curY + dy[i];
                if(newX >= 0 && newX < maps.length && newY >= 0 && newY < maps[0].length() && maps[newX].charAt(newY) != 'X' && !visited[newX][newY]){
                    visited[newX][newY] = true;                        
                    
                    queue.offer(new int[]{newX, newY, t+1});
                }
            }
        }
        
        return time;
    }
}