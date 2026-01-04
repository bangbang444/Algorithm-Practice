import java.util.*;
class Solution {
    public int solution(String dirs) {
        
        Map<Character, int[]> map = new HashMap<>();
        map.put('U', new int[]{1,0});
        map.put('D', new int[]{-1,0});
        map.put('R', new int[]{0,1});
        map.put('L', new int[]{0,-1});
        
        int[] cur = new int[]{0, 0};
    
        int count = 0;
        boolean[][][][] visited = new boolean[11][11][11][11];
        for(char dir : dirs.toCharArray()){
            
            int curX = cur[0]+5;
            int curY = cur[1]+5;
            
            int[] dxy = map.get(dir);
            int newX = curX + dxy[0];
            int newY = curY + dxy[1];
            
            //System.out.println(curX + " " + curY + "->" + newX + " " + newY + ":" + count);
            if(newX >= 0 && newX <= 10 && newY >= 0 && newY <= 10){
               if(!visited[curX][curY][newX][newY]){
                    visited[curX][curY][newX][newY] = true;
                    visited[newX][newY][curX][curY] = true;
                    count++;
               }
                cur[0] = newX - 5;
                cur[1] = newY - 5;   
            }
        }
        
        return count;
    }
    
}