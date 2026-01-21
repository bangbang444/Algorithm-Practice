import java.util.*;
class Solution {
    boolean[][] visited;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    public int[] solution(String[] maps) {
        
        int row = maps.length;
        int col = maps[0].length();
        
        visited = new boolean[row][col];
        List<Integer> total = new ArrayList<>();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                char ch = maps[i].charAt(j);
                if(ch != 'X' && !visited[i][j]){
                    visited[i][j] = true;
                    total.add(findPeriod(maps, i, j));
                }
            }
        }
        
        int[] answer = new int[total.size()];
        for(int i = 0; i < total.size(); i++){
            answer[i] = total.get(i);
        }
        Arrays.sort(answer);
        
        return answer.length == 0 ? new int[]{-1} : answer;
    }
    
    public int findPeriod(String[] maps, int sx, int sy){
        int row = maps.length;
        int col = maps[0].length();
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{sx, sy});
        int sum = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            sum += maps[cur[0]].charAt(cur[1]) -'0';
            
            for(int i = 0; i < 4; i++){
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];
                if(newX >= 0 && newX < row && newY >=0 && newY < col 
                   && maps[newX].charAt(newY) != 'X' && !visited[newX][newY]){
                    visited[newX][newY] = true;
                    q.offer(new int[]{newX, newY});    
                }
            }
        }
        
        return sum;
        
    }
}