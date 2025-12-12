import java.util.*;
class Solution {
    
    public int[] solution(String[] park, String[] routes) {
        
        int parkRow = park.length;
        int parkCol = park[0].length();
        
        // 시작점 찾기
        boolean isFind = false;
        int[] pos = new int[2];
        for(int i = 0; i < parkRow; i++){
            for(int j = 0; j < parkCol; j++){
                if(park[i].charAt(j) == 'S'){
                    pos[0] = i;
                    pos[1] = j;
                    isFind = true;
                    break;
                }
            }
            
            if(isFind) break;
        }
        
        //System.out.println(pos[0] + " " + pos[1]);
        
        // 이동 N,W,E,S
        for(int i = 0; i < routes.length; i++){
            char dir = routes[i].charAt(0);
            int mv = routes[i].charAt(2)-48;
            int nextX = -1, nextY = -1;
            boolean isOut = false;
            
            if(dir == 'N'){
                nextX = pos[0] - mv;
                nextY = pos[1];
                
                if(!checkValid(nextX, nextY, parkRow, parkCol)) continue;
                for(int j = pos[0]; j >= nextX; j--){
                    if(park[j].charAt(pos[1]) == 'X'){
                        isOut=true;
                        break;
                    }
                }
            }else if(dir == 'E'){
                nextX = pos[0];
                nextY = pos[1] + mv;
                
                if(!checkValid(nextX, nextY, parkRow, parkCol)) continue;
                for(int j = pos[1]; j <= nextY; j++){
                    if(park[pos[0]].charAt(j) == 'X'){
                        isOut=true;
                        break;
                    }
                }
            }else if(dir == 'W'){
                nextX = pos[0];
                nextY = pos[1] - mv;
                if(!checkValid(nextX, nextY, parkRow, parkCol)) continue;
                for(int j = pos[1]; j >= nextY; j--){
                    if(park[pos[0]].charAt(j) == 'X'){
                        isOut=true;
                        break;
                    }
                }
            }else if(dir == 'S'){
                nextX = pos[0] + mv;
                nextY = pos[1];
                if(!checkValid(nextX, nextY, parkRow, parkCol)) continue;
                for(int j = pos[0]; j <= nextX; j++){
                    if(park[j].charAt(pos[1]) == 'X'){
                        isOut=true;
                        break;
                    }
                }
            }
            
            if(isOut) continue;
            
            pos[0] = nextX;
            pos[1] = nextY;
        } // 이동 for문
        
        return pos;
    }
    
    public boolean checkValid(int nextX, int nextY, int parkRow, int parkCol){
        return nextX >= 0 && nextX < parkRow && nextY >= 0 && nextY < parkCol;
    }
}