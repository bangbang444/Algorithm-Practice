import java.util.*;
class Solution {
    int N;
    
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    
    public int solution(int[][] board) {
        
        N = board.length;
        
        boolean[][][][] visited = new boolean[N][N][N][N];
        Queue<Robot> queue = new LinkedList<>();
        queue.offer(new Robot(0,0,0,1,0,true));
        
        while(!queue.isEmpty()){
            Robot cur = queue.poll();
            int x1 = cur.x1;
            int y1 = cur.y1;
            int x2 = cur.x2;
            int y2 = cur.y2;
            int count = cur.count;
            boolean isRow = cur.isRow;
            
            if((x1==N-1 && y1 == N-1) || (x2 == N-1 && y2 == N-1)){
                return count;
            }
            
            // 이동
            for(int i = 0; i < 4; i++){
                int newX1 = x1 + dx[i];
                int newY1 = y1 + dy[i];
                int newX2 = x2 + dx[i];
                int newY2 = y2 + dy[i];
                
                if(newX1 >= 0 && newX1 < N && newY1 >= 0 && newY1 < N
                   && newX2 >= 0 && newX2 < N && newY2 >=0 && newY2 < N
                   && board[newX1][newY1] != 1 && board[newX2][newY2] != 1
                    && !visited[newX1][newY1][newX2][newY2]){
                    visited[newX1][newY1][newX2][newY2] = true;
                    queue.offer(new Robot(newX1, newY1, newX2, newY2, count+1, isRow));
                }
            }
            
            // 회전
            if(isRow){ // 가로일 때
                if(x1 + 1 < N && x2 +1 < N){
                    if(board[x1+1][y1] != 1 && board[x2+1][y2] != 1 
                      && !visited[x1][y1][x2+1][y2-1] && !visited[x1+1][y1+1][x2][y2]){ // 아래쪽으로 회전
                        visited[x1][y1][x2+1][y2-1] = true;
                        visited[x1+1][y1+1][x2][y2] = true;
                        
                        queue.offer(new Robot(x1, y1, x2+1, y2-1, count+1, !isRow));
                        queue.offer(new Robot(x1+1, y1+1, x2, y2, count+1, !isRow));
                    }
                }
                if(x1 -1 >= 0 && x2 -1 >= 0){
                    if(board[x1-1][y1] != 1 && board[x2-1][y2] != 1
                      && !visited[x1][y1][x2-1][y2-1] && !visited[x1-1][y1+1][x2][y2]){ // 위쪽으로 회전
                        visited[x1][y1][x2-1][y2-1] = true;
                        visited[x1-1][y1+1][x2][y2] = true;
                        
                        queue.offer(new Robot(x1, y1, x2-1, y2-1, count+1, !isRow));
                        queue.offer(new Robot(x1-1, y1+1, x2, y2, count+1, !isRow));
                    }
                }
            }else{ // 세로일 때
                if(y1 +1 < N && y2 +1 < N){
                    if(board[x1][y1+1] != 1 && board[x2][y2+1] != 1
                      && !visited[x1+1][y1+1][x2][y2] && !visited[x1][y1][x2-1][y2+1]){ // 오른쪽으로 회전
                        visited[x1+1][y1+1][x2][y2] = true;
                        visited[x1][y1][x2-1][y2+1] = true;
                        
                        queue.offer(new Robot(x1+1, y1+1, x2, y2, count+1, !isRow));
                        queue.offer(new Robot(x1, y1, x2-1, y2+1, count+1, !isRow));
                    }
                }
                if(y1 -1 >= 0 && y2 -1 >= 0){
                    if(board[x1][y1-1] != 1 && board[x2][y2-1] != 1
                      && !visited[x1+1][y1-1][x2][y2] && !visited[x1][y1][x2-1][y2-1]){ // 왼쪽으로 회전
                        visited[x1][y1][x2-1][y2-1] = true;
                        visited[x1+1][y1-1][x2][y2] = true;
                        
                        queue.offer(new Robot(x1, y1, x2-1, y2-1, count+1, !isRow));
                        queue.offer(new Robot(x1+1, y1-1, x2, y2, count+1, !isRow));
                    }
                }
            }
        }
        
        
        return -1;
    }
    
    class Robot{
        int x1;
        int y1;
        int x2;
        int y2;
        int count;
        boolean isRow;
        public Robot(int x1, int y1, int x2, int y2, int count, boolean isRow){
            if (x1 > x2 || (x1 == x2 && y1 > y2)) {
                int tx = x1; int ty = y1;
                x1 = x2; y1 = y2;
                x2 = tx; y2 = ty;
            }
            
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.count = count;
            this.isRow = isRow;
        }
    }
}